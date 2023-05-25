package requestRepository;

import java.io.IOException;
import java.util.ArrayList;

import CommonFunction.Utility_common_Function;

public class Post_req_repository {
	
	public static String base_URI( ) {
	String baseURI="https://reqres.in/";
			return baseURI;
	}
	
	public static String post_resource() {
		String resource="api/users";
		return resource;
	}
	
	public static String Post_req_tc1( ) throws IOException {
	ArrayList<String> data=Utility_common_Function.readdataexcel("Post_Test_Data","Post_TC_1");
	String req_name=data.get(1);
	String req_job=data.get(2);
	
		String requestbody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestbody;
	}
	
	public static String Post_req_tc2( ) throws IOException {
		ArrayList<String> data=Utility_common_Function.readdataexcel("Post_Test_Data","Post_TC_2");
		String req_name=data.get(1);
		String req_job=data.get(2);
		
			String requestbody="{\r\n"
					+ "    \"name\": \""+req_name+"\",\r\n"
					+ "    \"job\": \""+req_job+"\"\r\n"
					+ "}";
			
			return requestbody;
		}
	
	public static String Post_req_tc3( ) throws IOException {
		ArrayList<String> data=Utility_common_Function.readdataexcel("Post_Test_Data","Post_TC_3");
		String req_name=data.get(1);
		String req_job=data.get(2);
		
			String requestbody="{\r\n"
					+ "    \"name\": \""+req_name+"\",\r\n"
					+ "    \"job\": \""+req_job+"\"\r\n"
					+ "}";
			
			return requestbody;
		}



}
