package com.cultome.bizlang.language.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.cultomebizlang.language.interpreter.Bindings;

public class UtilsTest {

	@Test
	public void testAreEquivalentNumbersDecimals() {
		assertTrue(Utils.areEquivalentNumbers("1.9", "1.90"));
		assertFalse(Utils.areEquivalentNumbers("10000.99", "10000.9"));
	}
	
	@Test
	public void testAreEquivalentNumbersIntegers() {
		assertTrue(Utils.areEquivalentNumbers("1", "1"));
		assertFalse(Utils.areEquivalentNumbers("10000", "10001"));
	}
	
	@Test
	public void testAreEquivalentNumbersMixed() {
		assertTrue(Utils.areEquivalentNumbers("1.0", "1"));
		assertFalse(Utils.areEquivalentNumbers("1.0", "1.01"));
		assertFalse(Utils.areEquivalentNumbers("10", "10.001"));
		assertTrue(Utils.areEquivalentNumbers("10", "10.00"));
	}
	
	@Test
	public void testAreAnyOfThisTypes() {
		List<Object> objects = new ArrayList<Object>(); 
		objects.add(new String(""));
		objects.add(new Integer(1));
		assertTrue(Utils.areAnyOfThisTypes(objects, "String"));
		assertTrue(Utils.areAnyOfThisTypes(objects, "Integer"));
		assertFalse(Utils.areAnyOfThisTypes(objects, "Date"));
	}
	
	@Test
	public void testAreAllOfThisTypes() {
		List<Object> objects = new ArrayList<Object>(); 
		objects.add(new String(""));
		objects.add(new Integer(1));
		assertTrue(Utils.areAllOfThisTypes(objects, "String", "Integer"));
		assertFalse(Utils.areAllOfThisTypes(objects, "Integer"));
		assertFalse(Utils.areAllOfThisTypes(objects, "Date"));
	}

	@Test
	public void testReplacePlaceholders() {
		Bindings bindings = new Bindings();
		bindings.addBinding("myVar", "\"my variable\"");
		bindings.addBinding("dos", "2");
		assertEquals("var = \"my variable\"", Utils.replacePlaceholders("var = {myVar}", bindings));
		assertEquals("{\"uno\":\"2\"}", Utils.replacePlaceholders("{\"uno\":\"{dos}\"}", bindings));
	}

	@Test
	public void testAddToTreeOneLevel() {
		Map<String, Object> tree = new HashMap<String, Object>();
		Utils.addToTree(tree, "uno", "1");
		assertEquals("1", tree.get("uno"));
	}
	
	@Test
	public void testAddToTreeTwoLevels() {
		Map<String, Object> tree = new HashMap<String, Object>();
		Utils.addToTree(tree, "uno.dos", "2");
		assertNotNull(tree.get("uno"));
		assertEquals("2", ((Map<?, ?>) tree.get("uno")).get("dos"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAddToTreeAnArray() {
		Map<String, Object> tree = new HashMap<String, Object>();
		Utils.addToTree(tree, "uno.dos", "2");
		Utils.addToTree(tree, "uno.dos", "3");
		assertNotNull(tree.get("uno"));
		Map<?, ?> map = (Map<?, ?>) tree.get("uno");
		List<Map<?, ?>> list = (List<Map<?, ?>>) map.get("dos");
		assertNotNull(list);
		assertEquals("2", list.get(0));
		assertEquals("3", list.get(1));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAddToTreeANestedArray() {
		Map<String, Object> tree = new HashMap<String, Object>();
		Utils.addToTree(tree, "uno.dos.tres", "2");
		Utils.addToTree(tree, "uno.dos.tres", "3");
		Utils.addToTree(tree, "uno.dos.tres", "4");
		Utils.addToTree(tree, "uno.dos.cuatro", "5");
		assertNotNull(tree.get("uno"));
		Map<?, ?> map = (Map<?, ?>) tree.get("uno");
		Map<?, ?> map2 = (Map<?, ?>) map.get("dos");
		List<Map<?, ?>> list = (List<Map<?, ?>>) map2.get("tres");
		assertNotNull(list);
		assertEquals("2", list.get(0));
		assertEquals("3", list.get(1));
		assertEquals("4", list.get(2));
		assertEquals("5", map2.get("cuatro"));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testAddToTreeDeclaredArray() {
		Map<String, Object> tree = new HashMap<String, Object>();
		Utils.addToTree(tree, "uno.dos[0].tres", "1");
		Utils.addToTree(tree, "uno.dos[0].cuatro", "2");
		Utils.addToTree(tree, "uno.dos[1].tres", "3");
		Utils.addToTree(tree, "uno.dos[1].cuatro", "4");
		Utils.addToTree(tree, "uno.dos[4].cuatro", "5");
		
		List<Map<?, ?>> cuatros = (List<Map<?, ?>>) Utils.getPropertyFrom(tree, "uno.dos");
		assertEquals(5, cuatros.size());
		assertEquals("1", ((Map) cuatros.get(0)).get("tres") );
		assertEquals("2", ((Map) cuatros.get(0)).get("cuatro") );
		assertEquals("3", ((Map) cuatros.get(1)).get("tres") );
		assertEquals("4", ((Map) cuatros.get(1)).get("cuatro") );
		assertEquals("5", ((Map) cuatros.get(4)).get("cuatro") );
		assertNull(cuatros.get(2));
		assertNull(cuatros.get(3));
	}
	
	@SuppressWarnings("rawtypes" )
	@Test
	public void testAddToTreeMultipleDeclaredArray() {
		Map<String, Object> tree = new HashMap<String, Object>();
		Utils.addToTree(tree, "uno.dos[0].tres[0].cuatro", "1");
		Utils.addToTree(tree, "uno.dos[0].tres[0].cinco", "2");
		
		Utils.addToTree(tree, "uno.dos[1].tres[0].cinco", "3");
		
		Utils.addToTree(tree, "uno.dos[2].cuatro.cinco[0].seis", "4");
		Utils.addToTree(tree, "uno.dos[2].cuatro.cinco[0].siete", "5");
		
		Utils.addToTree(tree, "uno.dos[2].cuatro.cinco[1].ocho", "6");
		
		Utils.addToTree(tree, "dos[0].tres", "7");
		Utils.addToTree(tree, "dos[0].cuatro", "8");
		
		//{
		//	uno={
		//		dos=[
		//		     {tres=[{cuatro=1, cinco=2}]}, 
		//		     {tres=[{cinco=3}]}, 
		//		     {cuatro={
		//				cinco=[
		//				       {seis=4, siente=5}, 
		//					   {ocho=6}
		//				]}
		//			 }
		//		 ]
		//	}, 
		//	dos=[
		//	     {cuatro=8, tres=7}
		//	]
		//}
		
		List doces = (List) Utils.getPropertyFrom(tree, "uno.dos");
		assertEquals(3, doces.size());
		List treces = (List) ((Map) doces.get(0)).get("tres");
		List trecesDos = (List) ((Map) doces.get(1)).get("tres");
		List cincos = (List) ((Map) ((Map) doces.get(2)).get("cuatro")).get("cinco");
		
		assertEquals("1",  ((Map) treces.get(0)).get("cuatro"));
		assertEquals("2",  ((Map) treces.get(0)).get("cinco"));
		assertEquals("3",  ((Map) trecesDos.get(0)).get("cinco"));
		assertEquals("4",  ((Map) cincos.get(0)).get("seis"));
		assertEquals("5",  ((Map) cincos.get(0)).get("siete"));
		assertEquals("6",  ((Map) cincos.get(1)).get("ocho"));
	}
	
	@Test
	public void testAddToTreeThreeLevels() {
		Map<String, Object> tree = new HashMap<String, Object>();
		Utils.addToTree(tree, "uno.dos.tres", "3");
		assertNotNull(tree.get("uno"));
		assertNotNull(((Map<?, ?>) tree.get("uno")).get("dos"));
		assertEquals("3", ((Map<?, ?>) ((Map<?, ?>) tree.get("uno")).get("dos")).get("tres"));
	}
	
	@Test
	public void testAddToTreeFourLevels() {
		Map<String, Object> tree = new HashMap<String, Object>();
		HashMap<String, Object> existing = new HashMap<String, Object>();
		existing.put("another", "value");
		tree.put("uno", existing);
		Utils.addToTree(tree, "uno.dos.tres.cuatro", "4");
		assertNotNull(tree.get("uno"));
		assertNotNull(((Map<?, ?>) tree.get("uno")).get("dos"));
		assertEquals("value", ((Map<?, ?>) tree.get("uno")).get("another"));
		assertNotNull(((Map<?, ?>) ((Map<?, ?>) tree.get("uno")).get("dos")).get("tres"));
		assertEquals("4", ((Map<?, ?>) ((Map<?, ?>) ((Map<?, ?>) tree.get("uno")).get("dos")).get("tres")).get("cuatro"));
	}
	
	@Test
	public void testGetNestedProperty() {
		Map<String, Object> tree = new HashMap<String, Object>();
		Utils.addToTree(tree, "uno.dos.tres", "2");
		Utils.addToTree(tree, "uno.dos.tres", "3");
		Utils.addToTree(tree, "uno.dos.tres", "4");
		Utils.addToTree(tree, "uno.dos.cuatro", "5");
		List<?> list = (List<?>) Utils.getPropertyFrom(tree, "uno.dos.tres");
		assertEquals("2", list.get(0));
		assertEquals("3", list.get(1));
		assertEquals("4", list.get(2));
	}
	
	@Test
	public void testGetIndexedProperty() {
		Map<String, Object> tree = new HashMap<String, Object>();
		Utils.addToTree(tree, "uno.dos.tres", "2");
		Utils.addToTree(tree, "uno.dos.tres", "3");
		Utils.addToTree(tree, "uno.dos.tres", "4");
		Utils.addToTree(tree, "uno.dos.tres", "cinco");
		Utils.addToTree(tree, "uno.dos.cuatro", "5");
		Utils.addToTree(tree, "dos", "6");
		Utils.addToTree(tree, "dos", "7");
		
		BigDecimal valueBd = (BigDecimal) Utils.getPropertyFrom(tree, "uno.dos.tres[2]");
		assertEquals(new BigDecimal(4), valueBd);
		String valueStr = (String) Utils.getPropertyFrom(tree, "uno.dos.tres[3]");
		assertEquals("cinco", valueStr);
		assertNull(Utils.getPropertyFrom(tree, "uno.dos.tres[4]"));
		BigDecimal value2Bd = (BigDecimal) Utils.getPropertyFrom(tree, "dos[1]");
		assertEquals(new BigDecimal(7), value2Bd);
	}

}
