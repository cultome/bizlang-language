package com.cultome.bizlang.language.interpreter;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cultome.bizlang.dataaccess.WSReader;
import com.cultome.bizlang.language.function.GetFromWsFunction;
import com.cultome.bizlang.language.listener.CodeExtractorListener;
import com.cultomebizlang.language.interpreter.Bindings;
import com.cultomebizlang.language.interpreter.ExecutionFlow;
import com.cultomebizlang.language.interpreter.ExecutionListener;
import com.cultomebizlang.language.interpreter.Interpreter;

/* 
 * RealExamplesTest.java
 *
 * Copyright (c) 2014 FedEx, All rights reserved.
 *
 * @author		Carlos Soria <carlos.soria.osv@fedex.com>
 * @creation	18/02/2014
 */
public class RealExamplesTest extends InterpreterBaseTest {
	
	private ByteArrayOutputStream buffer;

	@Before
	public void setup(){
		ExecutionListener.addExecutionListeners(new CodeExtractorListener());
		
		interpreter = new Interpreter();
		bindings = new Bindings();
		
		buffer = new ByteArrayOutputStream();
		PrintStream logger = new PrintStream(buffer);
		bindings.addBinding("STDOUT", logger);
		
		bindings.addConfig(Bindings.CNFG_NS_WEBSERVICES, GetFromWsFunction.ACCESSOR, WSReader.getInstance());
		/*
		 * test18022014_1457
		 */
		// invoiceType = myObj.shipment.invoice.type
		bindings.addBinding("myObj.shipment.invoice.type", "CREDIT");
		// amount = myObj.shipment.invoice.totalAmount
		bindings.addBinding("myObj.shipment.invoice.totalAmount", new BigDecimal(100.00));
		//invoiceDate = myObj.shipment.invoice.invDate
		bindings.addBinding("myObj.shipment.invoice.invDate", "15/01/2014");
		/*
		 * test19022014_1039
		 */
		bindings.addBinding("resourceName", "token");
		bindings.addBinding("token", "mytoken");
		
		Map<String, Object> tokensWsConfig = new HashMap<String, Object>();
		HashMap<String, String> tokensHeaders = new HashMap<String, String>();
		tokensHeaders.put("BIZLANG_TOKEN", "{token}");
		tokensWsConfig.put(GetFromWsFunction.HEADERS_PROPERTY, tokensHeaders);
		
		tokensWsConfig.put(GetFromWsFunction.ENDPOINT_PROPERTY, "http://localhost:8080/bizlang-ws/{resourceName}s");
		tokensWsConfig.put(GetFromWsFunction.HTTP_METHOD_PROPERTY, "gEt");
//		wsConfig.put(GetFromWsFunction.CONTENT_PROPERTY, null);
		bindings.addConfig(Bindings.CNFG_NS_WEBSERVICES, "tokens", tokensWsConfig);
		
		/*
		 * test19022014_1039
		 */
		Map<String, Object> incasWsConfig = new HashMap<String, Object>();
		HashMap<String, String> incasHeaders = new HashMap<String, String>();
		incasHeaders.put("SOAPAction", "");
		incasWsConfig.put(GetFromWsFunction.HEADERS_PROPERTY, incasHeaders);
		
		incasWsConfig.put(GetFromWsFunction.ENDPOINT_PROPERTY, "http://idlas058.rmtc.fedex.com:7701/CCPEngineWS30/CCPEngineWS30");
		incasWsConfig.put(GetFromWsFunction.HTTP_METHOD_PROPERTY, "POST");
		incasWsConfig.put(GetFromWsFunction.CONTENT_PROPERTY, "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.gcp.international.fedex.com/\"><soapenv:Header/><soapenv:Body><ws:{tagname}/></soapenv:Body></soapenv:Envelope>");
		
		bindings.addConfig(Bindings.CNFG_NS_WEBSERVICES, "countries", incasWsConfig);
		
		/*
		 * test25022014_1108
		 */
		Map<String, Object> licenseWsConfig = new HashMap<String, Object>();
		HashMap<String, String> licenseHeaders = new HashMap<String, String>();
		licenseHeaders.put("SOAPAction", "");
		licenseWsConfig.put(GetFromWsFunction.HEADERS_PROPERTY, licenseHeaders);
		
		licenseWsConfig.put(GetFromWsFunction.ENDPOINT_PROPERTY, "http://idlas058.rmtc.fedex.com:7701/CCPEngineWS30/CCPEngineWS30");
		licenseWsConfig.put(GetFromWsFunction.HTTP_METHOD_PROPERTY, "POST");
		licenseWsConfig.put(GetFromWsFunction.CONTENT_PROPERTY, "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.gcp.international.fedex.com/\"><soapenv:Header/><soapenv:Body><ws:getLicenseByCountryCd><arg0>MX</arg0></ws:getLicenseByCountryCd></soapenv:Body></soapenv:Envelope>");
		
		bindings.addConfig(Bindings.CNFG_NS_WEBSERVICES, "license", licenseWsConfig);
		
	}

	@Test
	public void test18022014_1457() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/18022014_1457.biz");
		assertNotNull(flow);
		interpreter.execute(flow, bindings);
		System.out.println(bindings.getBinding("calculatePercentageIVAFrontier"));
	}
	
	@Test
	public void test19022014_1039() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/19022014_1039.biz");
		interpreter.execute(flow, bindings);
		System.out.println(new String(buffer.toByteArray()));
	}
	
	@Test
	public void test25022014_1108() throws Exception {
		ExecutionFlow flow = getExecutionFlow("src/test/resources/25022014_1108.biz");
		interpreter.execute(flow, bindings);
		System.out.println(new String(buffer.toByteArray()));
	}
}

/*
{
	Envelope={
		Body={
			getLicenseByCountryCdResponse={
				return=[
					{licenseCd=3018, action=0, licensePortList={action=0, licensePortOidNbr=412, clearanceLocationCd=MTY, licenseOidNbr=348}, countryCd=MX, licenseOwnerNm=AA GREGORIO A GIACINTI VALDES, licenseOidNbr=348}, 
					{licensePortList={action=0, licensePortOidNbr=411, clearanceLocationCd=GDL, licenseOidNbr=348}}
					, {licenseCd=3914, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=410, clearanceLocationCd=TLC, licenseOidNbr=348}, licenseOwnerNm=AA NIDIA THELMA HERNANDEZ DIAZ, licenseOidNbr=357}, {licensePortList={action=0, licensePortOidNbr=429, clearanceLocationCd=GDL, licenseOidNbr=357}}, {licensePortList={action=0, licensePortOidNbr=430, clearanceLocationCd=TLC, licenseOidNbr=357}}, {licenseCd=110, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=431, clearanceLocationCd=MTY, licenseOidNbr=357}, licenseOwnerNm=ABC BROKERAGE, licenseOidNbr=2241}, {licensePortList={action=0, licensePortOidNbr=6683, clearanceLocationCd=GDL, licenseOidNbr=2241}}, {licensePortList={action=0, licensePortOidNbr=6684, clearanceLocationCd=TLC, licenseOidNbr=2241}}, {licensePortList={action=0, licensePortOidNbr=6681, clearanceLocationCd=BRA, licenseOidNbr=2241}}, {licenseCd=ABX, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=6682, clearanceLocationCd=CUN, licenseOidNbr=2241}, licenseOwnerNm=ABX LOGISCICS MEXICO, licenseOidNbr=360}, {licensePortList={action=0, licensePortOidNbr=438, clearanceLocationCd=MTY, licenseOidNbr=360}}, {licensePortList={action=0, licensePortOidNbr=436, clearanceLocationCd=TLC, licenseOidNbr=360}}, {licenseCd=3088, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=437, clearanceLocationCd=GDL, licenseOidNbr=360}, licenseOwnerNm=ADRIAN LLAMAS TAPIA, licenseOidNbr=121}, {licenseCd=124, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=181, clearanceLocationCd=GDL, licenseOidNbr=121}, licenseOwnerNm=ADUANA CARLOS VILLALOBOS, licenseOidNbr=390}, {licenseCd=ADV, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=497, clearanceLocationCd=TLC, licenseOidNbr=390}, licenseOwnerNm=ADVIL S.A., licenseOidNbr=2021}, {licensePortList={action=0, licensePortOidNbr=6441, clearanceLocationCd=GDL, licenseOidNbr=2021}}, {licensePortList={action=0, licensePortOidNbr=6443, clearanceLocationCd=TLC, licenseOidNbr=2021}}, {licenseCd=3463, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=6442, clearanceLocationCd=MTY, licenseOidNbr=2021}, licenseOwnerNm=ALBERTO NOGUEIRA GARCIA, licenseOidNbr=354}, {licensePortList={action=0, licensePortOidNbr=425, clearanceLocationCd=MTY, licenseOidNbr=354}}, {licensePortList={action=0, licensePortOidNbr=426, clearanceLocationCd=GDL, licenseOidNbr=354}}, {licenseCd=3579, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=424, clearanceLocationCd=TLC, licenseOidNbr=354}, licenseOwnerNm=ALEJANDRO A. SANCHEZ GARZA, licenseOidNbr=241}, {licensePortList={action=0, licensePortOidNbr=301, clearanceLocationCd=MTY, licenseOidNbr=241}}, {licenseCd=3124, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=302, clearanceLocationCd=TLC, licenseOidNbr=241}, licenseOwnerNm=ALEJANDRO CASTAÑEDA MENDOZA, licenseOidNbr=352}, {licensePortList={action=0, licensePortOidNbr=420, clearanceLocationCd=MTY, licenseOidNbr=352}}, {licensePortList={action=0, licensePortOidNbr=419, clearanceLocationCd=TLC, licenseOidNbr=352}}, {licenseCd=3202, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=421, clearanceLocationCd=GDL, licenseOidNbr=352}, licenseOwnerNm=ALEJANDRO JOSE HINOJOSA, licenseOidNbr=1621}, {licenseCd=9111, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=5961, clearanceLocationCd=MTY, licenseOidNbr=1621}, licenseOwnerNm=ALFONSO LEON BRES PATINO, licenseOidNbr=381}, {licensePortList={action=0, licensePortOidNbr=478, clearanceLocationCd=MTY, licenseOidNbr=381}}, {licensePortList={action=0, licensePortOidNbr=480, clearanceLocationCd=TLC, licenseOidNbr=381}}, {licenseCd=3861, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=479, clearanceLocationCd=GDL, licenseOidNbr=381}, licenseOwnerNm=ALFONSO LEON BRESS PATINO, licenseOidNbr=22}, {licensePortList={action=0, licensePortOidNbr=28, clearanceLocationCd=MTY, licenseOidNbr=22}}, {licensePortList={action=0, licensePortOidNbr=27, clearanceLocationCd=GDL, licenseOidNbr=22}}, {licenseCd=0010, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=329, clearanceLocationCd=TLC, licenseOidNbr=22}, licenseOwnerNm=ALLYSON LANDIVAR, licenseOidNbr=1801}, {licenseCd=3081, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=6161, clearanceLocationCd=GDL, licenseOidNbr=1801}, licenseOwnerNm=ALMA FLORES CASTREJON, licenseOidNbr=350}, {licensePortList={action=0, licensePortOidNbr=417, clearanceLocationCd=GDL, licenseOidNbr=350}}, {licensePortList={action=0, licensePortOidNbr=416, clearanceLocationCd=TLC, licenseOidNbr=350}}, {licenseCd=3438, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=415, clearanceLocationCd=MTY, licenseOidNbr=350}, licenseOwnerNm=ARNOLDO RAFAEL PEÑA, licenseOidNbr=1701}, {licenseCd=6023, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=6041, clearanceLocationCd=MTY, licenseOidNbr=1701}, licenseOwnerNm=AVX GUADALAJARA S.A. DE C.V., licenseOidNbr=359}, {licensePortList={action=0, licensePortOidNbr=434, clearanceLocationCd=MTY, licenseOidNbr=359}}, {licensePortList={action=0, licensePortOidNbr=435, clearanceLocationCd=GDL, licenseOidNbr=359}}, {licenseCd=LAI, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=433, clearanceLocationCd=TLC, licenseOidNbr=359}, licenseOwnerNm=BABY BABY BROKER, licenseOidNbr=2281}, {licensePortList={action=0, licensePortOidNbr=6722, clearanceLocationCd=CUN, licenseOidNbr=2281}}, {licenseCd=3383, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=6721, clearanceLocationCd=BRA, licenseOidNbr=2281}, licenseOwnerNm=BELLIN - DICEX, licenseOidNbr=2501}, {licensePortList={action=0, licensePortOidNbr=6963, clearanceLocationCd=TLC, licenseOidNbr=2501}}, {licensePortList={action=0, licensePortOidNbr=6961, clearanceLocationCd=GDL, licenseOidNbr=2501}}, {licenseCd=1144, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=6962, clearanceLocationCd=MID, licenseOidNbr=2501}, licenseOwnerNm=BELLIN CO, licenseOidNbr=2341}, {licensePortList={action=0, licensePortOidNbr=6783, clearanceLocationCd=MID, licenseOidNbr=2341}}, {licensePortList={action=0, licensePortOidNbr=6781, clearanceLocationCd=CUN, licenseOidNbr=2341}}, {licensePortList={action=0, licensePortOidNbr=6785, clearanceLocationCd=TLC, licenseOidNbr=2341}}, {licensePortList={action=0, licensePortOidNbr=6784, clearanceLocationCd=MTY, licenseOidNbr=2341}}, {licenseCd=3183, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=6782, clearanceLocationCd=GDL, licenseOidNbr=2341}, licenseOwnerNm=BENITO MARTINEZ, licenseOidNbr=1541}, {licenseCd=3162, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=5881, clearanceLocationCd=MTY, licenseOidNbr=1541}, licenseOwnerNm=BERTHA COVARRUBIAS RAMOS DE C., licenseOidNbr=353}, {licensePortList={action=0, licensePortOidNbr=422, clearanceLocationCd=TLC, licenseOidNbr=353}}, {licenseCd=8888, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=423, clearanceLocationCd=MTY, licenseOidNbr=353}, licenseOwnerNm=BOBBY MERCER, licenseOidNbr=370}, {licensePortList={action=0, licensePortOidNbr=459, clearanceLocationCd=CUN, licenseOidNbr=370}}, {licensePortList={action=0, licensePortOidNbr=456, clearanceLocationCd=GDL, licenseOidNbr=370}}, {licensePortList={action=0, licensePortOidNbr=460, clearanceLocationCd=MTY, licenseOidNbr=370}}, {licensePortList={action=0, licensePortOidNbr=458, clearanceLocationCd=TLC, licenseOidNbr=370}}, {licenseCd=BBT, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=457, clearanceLocationCd=MID, licenseOidNbr=370}, licenseOwnerNm=BOMBARDIER TRANSPORTATION, licenseOidNbr=1941}, {licenseCd=5555, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=6341, clearanceLocationCd=GDL, licenseOidNbr=1941}, licenseOwnerNm=BORMOLAINE, licenseOidNbr=1981}, {licensePortList={action=0, licensePortOidNbr=6401, clearanceLocationCd=CUN, licenseOidNbr=1981}}, {licensePortList={action=0, licensePortOidNbr=6402, clearanceLocationCd=GDL, licenseOidNbr=1981}}, {licensePortList={action=0, licensePortOidNbr=6405, clearanceLocationCd=TLC, licenseOidNbr=1981}}, {licensePortList={action=0, licensePortOidNbr=6404, clearanceLocationCd=MTY, licenseOidNbr=1981}}, {licenseCd=3391, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=6403, clearanceLocationCd=MID, licenseOidNbr=1981}, licenseOwnerNm=BRANIFF DESPACHOS ADUANALES S.A. DE C.V., licenseOidNbr=365}, {licenseCd=3482, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=449, clearanceLocationCd=MTY, licenseOidNbr=365}, licenseOwnerNm=CARLOS FRANCISCO CRUZ LARA, licenseOidNbr=355}, {licenseCd=3136, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=427, clearanceLocationCd=GDL, licenseOidNbr=355}, licenseOwnerNm=CARLOS JAVIER GONZALEZ TREVIÑO, licenseOidNbr=1761}, {licenseCd=3152, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=6101, clearanceLocationCd=TLC, licenseOidNbr=1761}, licenseOwnerNm=CENTRAL DE ADUANAS DE MONTERREY S.A., licenseOidNbr=363}, {licenseCd=6986, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=447, clearanceLocationCd=MTY, licenseOidNbr=363}, licenseOwnerNm=CERVERA, licenseOidNbr=376}, {licenseCd=373, action=0, countryCd=MX, licensePortList={action=0, licensePortOidNbr=470, clearanceLocationCd=MID, licenseOidNbr=376}, licenseOwnerNm=CLAUDIO LAZO (TEST), licenseOidNbr=391}, {licensePortList={action=0, licensePortOidNbr=499, clearanceLocationCd=TLC, l...
*/
















