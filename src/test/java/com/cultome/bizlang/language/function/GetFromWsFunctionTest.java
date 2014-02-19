package com.cultome.bizlang.language.function;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cultome.bizlang.dataaccess.WSReader;
import com.cultome.bizlang.language.BizlangException;
import com.cultome.bizlang.language.BizlangValue;
import com.cultome.bizlang.language.parser.BizlangLexer;
import com.cultome.bizlang.language.util.Utils;
import com.cultomebizlang.language.interpreter.Bindings;

public class GetFromWsFunctionTest {
	
	private GetFromWsFunction function;
	private Bindings bindings;

	@Before
	public void setUp() throws Exception {
		function = new GetFromWsFunction();
		bindings = new Bindings();
		bindings.addBinding("resourceName", "token");
		bindings.addBinding("token", "mytoken");
		
		Map<String, Object> wsConfig = new HashMap<String, Object>();
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("BIZLANG_TOKEN", "{token}");
		
		wsConfig.put(GetFromWsFunction.ENDPOINT_PROPERTY, "http://localhost:8080/bizlang-ws/{resourceName}s");
		wsConfig.put(GetFromWsFunction.HTTP_METHOD_PROPERTY, "gEt");
//		wsConfig.put(GetFromWsFunction.CONTENT_PROPERTY, null);
		wsConfig.put(GetFromWsFunction.HEADERS_PROPERTY, headers);
		
		bindings.addConfig(Bindings.CNFG_NS_WEBSERVICES, GetFromWsFunction.ACCESSOR, WSReader.getInstance());
		bindings.addConfig(Bindings.CNFG_NS_WEBSERVICES, "myWs", wsConfig);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testExecute() throws BizlangException {
		Map<String, Object> r = (Map<String, Object>) function.execute(bindings, new BizlangValue(BizlangLexer.STR, "myWs", 1));
		assertNotNull(r);
		assertEquals(new BigDecimal(1), (BigDecimal) Utils.getPropertyFrom(r, "tokens.token.id[0]"));
	}

}
