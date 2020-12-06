package main;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import Utility.GeneralUtilities;
/**
 * 
 * @author Pooja Khanna
 * @version 1.0
 * @since 15/02/2019 /* Change History
 *        *********************************************************************************
 *        Version Date Defect/Task ID changed by Description
 ***********************************************************************************
 * 
 ***********************************************************************************
 */
@SuppressWarnings("unused")  
public class ConstantData {
	
	GeneralUtilities utils = new GeneralUtilities();
	//URI and Resources
	protected String BaseURI = "http://api-aws-eu-qa-1.auto1-test.com";
	protected String HTTPSBaseURI = "https://api-aws-eu-qa-1.auto1-test.com";
	protected String Resource1 = "/v1/car-types/manufacturer";
	protected String Resource2 = "/v1/car-types/main-types";
	protected String Resource3 = "/v1/car-types/built-dates";
	protected String API1URI=BaseURI+Resource1;
	protected String API2URI=BaseURI+Resource2;
	protected String API3URI=BaseURI+Resource3;
	protected String API4URI=HTTPSBaseURI+Resource1;
	protected String API5URI=HTTPSBaseURI+Resource2;
	protected String API6URI=HTTPSBaseURI+Resource3;
	
	//Parameters and Values
	
	protected String Param1 = "locale";
	protected String Param2 = "wa_key";
	protected String Param3 = "manufacturer";
	protected String Param4 = "main-type";
	protected String Param1_val = "en";
	protected String Param2_val = "coding-puzzle-client-449cc9d";
	protected String Param5=utils.random();
	protected String Param6=utils.random3digit();
	protected String Param7=utils.random2digit();
	protected String Param8=utils.random4digit();
	protected String Param9=utils.random5digit();
	//status codes
	protected int statusCode_OK = 200;
	protected int statusCode_Bad_Request = 400;
	protected int statusCode_Unauthorized = 401;
	protected int statusCode_Forbidden = 403;
	protected int statusCode_Not_Found = 404;
	protected int statusCode_Method_Not_Allowed = 405;
	
	//status lines
	protected String statusLine_200 = "HTTP/1.1 200 OK";
	protected String statusLine_400 = "HTTP/1.1 400 Bad Request";;
	protected String statusLine_401 = "HTTP/1.1 401 Unauthorized";
	protected String statusLine_403 = "HTTP/1.1 403 Forbidden";
	protected String statusLine_404 = "HTTP/1.1 404 Not Found";
	protected String statusLine_405 = "HTTP/1.1 405 Method Not Allowed";
	//content type
	protected String contentType_expected = "application/json;charset=UTF-8";
	
	//Errors and Exceptions under 400 Bad Request
	protected String error_400 = "Bad Request";
	protected String message_400_manufacturer = "Required String parameter 'manufacturer' is not present";
	protected String message_400_mainType = "Required String parameter 'main-type' is not present";
	protected String exception_400 = "org.springframework.web.bind.MissingServletRequestParameterException";
	
	//page details
	protected int page_expected = 0;
	protected int pageSize_expected = 2147483647;
	protected int totalPageCount_expected = 1;
	protected int totalPageCount_invalid_expected = 0;
	protected String URI = BaseURI+Resource2;
	protected String fileName_Maintypes= "MainTypes.xlsx";
	protected String fileName_BuiltDates= "BuiltDates.xlsx";
	
	//api-body
	
	protected String APIBody = "{\"locale\":\"en\",\"wa_key\":\"coding-puzzle-client-449cc9d\"}";
	
	//mandfacturer details
	protected Map<String, String> manufacturers;
	protected Map<String, String> models ;
	

}
