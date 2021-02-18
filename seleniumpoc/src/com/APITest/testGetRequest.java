package	com.APITest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
 
public class testGetRequest {
 SoftAssert	softAssert=new	SoftAssert();
 @Test(dataProvider="RestData")
 	public void GetTypiCodeResponse(int	PassedID,String	Expectedtitle)
 	{   
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "http://jsonplaceholder.typicode.com/posts";
	 RequestSpecification httpRequest = RestAssured.given();
 
 
	 // This will return the Response from the server. Store the response in a variable.
	 Response response = httpRequest.request(Method.GET, "/"+PassedID);
 
	 //First get the JsonPath object instance from the Response interface
	 JsonPath jsonPathEvaluator = response.jsonPath();


	 int actualid = jsonPathEvaluator.get("id");
	 String	Actualtitle=jsonPathEvaluator.get("title");

	 System.out.println(response.getStatusCode());
	 System.out.println(response.getStatusLine());
	 System.out.println("id received from Response " + actualid);

	 // Validate the response
	 softAssert.assertEquals(response.getStatusCode(), 200);
	 softAssert.assertEquals(response.getStatusLine().contains("OK"),true);
	 softAssert.assertEquals(actualid, PassedID, "Correct id not received in the Response"+actualid);
	 softAssert.assertEquals(Actualtitle, Expectedtitle, "Correct title not received in the Response"+Actualtitle);
	 softAssert.assertAll();
 	}
 	@DataProvider(name="RestData")
 		public Object[][] getDataFromDataprovider(){
     
 		return new Object[][] {
     	{1,"sunt aut facere repellat provident occaecati excepturi optio reprehenderit"},
     	{2,"qui est esse"},
     	{3,"ea molestias quasi exercitationem repellat qui ipsa sit aut"},
     	{4,"eum et est occaecati"},
     	{5,"nesciunt quas odio"},
     	{6,"dolorem eum magni eos aperiam quia"}
     	
     };}
}