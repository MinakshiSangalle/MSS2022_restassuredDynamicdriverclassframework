package testClass;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;

import CommonFunction.API_Common_Function;
import CommonFunction.Utility_common_Function;
import io.restassured.path.json.JsonPath;
import requestRepository.Post_req_repository;

    public class Post_TC_3 {
	  public static void execute() throws IOException {
	 	for(int i=0; i<5; i++)
		{
		
		 int statusCode=API_Common_Function.res_statusCode(Post_req_repository.base_URI(),
    		                     Post_req_repository.Post_req_tc3(),Post_req_repository.post_resource());
  
           if(statusCode == 201)
           {
    	
                String responsebody=API_Common_Function.response_body(Post_req_repository.base_URI(),
        		                  Post_req_repository.Post_req_tc3(),Post_req_repository.post_resource());
                Post_TC_3.validator(responsebody,statusCode);
                Utility_common_Function.evidencefilecreator("Post_TC_3", Post_req_repository.Post_req_tc3(), responsebody);
                break;
        
           }
           else
           {
    	     System.out.println("correct status code is not found hence retrying the API");
           }
	
	     }	
	}
			
    public static void validator(String responsebody,int statusCode) throws IOException {
		    	//Parse response body and its parameters
				JsonPath jspres=new JsonPath(responsebody);
				String res_name=jspres.getString("name");
				String res_job=jspres.getString("job");
				String res_id=jspres.getString("id");
				String res_createdAt=jspres.getString("createdAt");
				System.out.println(res_name);
				System.out.println(res_job);
				System.out.println(res_id);
				System.out.println(res_createdAt);
				
				String trim_date=res_createdAt.substring(0,10);
				
				//generate date
			   LocalDateTime date=LocalDateTime.now();
			   String exp_date=date.toString().substring(0,10);
			   
			   
			  //parse request body and its parameters
			   JsonPath jspreq=new JsonPath (Post_req_repository.Post_req_tc3());
				String req_name=jspreq.getString("name");
				String req_job=jspreq.getString("job");
			
		    	//Validate the response
			   
			   Assert.assertEquals(statusCode,201);
			   Assert.assertEquals(req_name, res_name);
			   Assert.assertEquals(req_job, res_job);
			   Assert.assertNotNull(res_id);
			   Assert.assertEquals(trim_date, exp_date);
			   
			
			}

		}
