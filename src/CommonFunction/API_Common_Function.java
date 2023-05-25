package CommonFunction;

//import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;


public class API_Common_Function{
	
	public static int res_statusCode(String baseURI,String requestbody,String resource) {
	
	//RestAssured.baseURI=baseURI;
		RestAssured.baseURI=baseURI;
	
	int statusCode= given().header("Content-type","application/json").body(requestbody).when().post(resource).then().extract().response().statusCode();
	
	return statusCode;
	}
	
	
	
	public static String response_body(String baseURI,String requestbody,String resource) {
	
	RestAssured.baseURI=baseURI;
	
	String responsebody=given().header("Content-type","application/json").body(requestbody).when().post(resource).then().extract().response().asString();
	return responsebody;
    }
}

