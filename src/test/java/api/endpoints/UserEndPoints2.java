package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints2 {

	
	static Properties getURL() throws IOException {
		
		FileReader f= new FileReader("C:\\Users\\dell\\eclipse-workspace\\PetStoreAPIAutomation\\routes.properties");
		Properties prop= new Properties();
		prop.load(f);
		return prop;
		
	}
	
	public static Response createUser(User payload) throws IOException
	{
		Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
		.when().post(getURL().getProperty("post_url"));
		
		return response;
		
	}
	
	public static Response getUser(String userName) throws IOException
	{
		Response response=given().pathParam("username",userName)
		.when().get(getURL().getProperty("get_url"));
		
		return response;
		
	}
	public static Response updateUser(String userName,User payload) throws IOException
	{
		Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username",userName).body(payload)
		.when().put(getURL().getProperty("put_url"));
		
		return response;
		
	}
	public static Response deleteUser(String userName) throws IOException
	{
		Response response=given().pathParam("username",userName)
		.when().get(getURL().getProperty("delete_url"));
		
		return response;
		
	}
}
