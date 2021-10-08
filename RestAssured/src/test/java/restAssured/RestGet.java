package restAssured;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestGet 
{
	

	@Test
	public void testCase1()
	{
		String url = "https://generator.swagger.io/api/gen/clients";
		given().get(url)
		.then()
		.statusCode(200);
		String s = RestAssured.get(url).body().asString();
		s = s.replace("[", "").replace("]","");
		String[] sarr = s.split(",");
		System.out.println(sarr.length);
		for(String s1 : sarr)
		{
			System.out.println(s1);
		}
	
	}
	
	@Test
	public void testCase2()
	{
		String url = "https://generator.swagger.io/api/gen/clients/android";
		given().get(url)
		.then().statusCode(200);
		
		String opt = given().get(url).then().extract().path("modelPackage.opt").toString();
		String desription = given().get(url).then().extract().path("modelPackage.description").toString();
		String type = given().get(url).then().extract().path("modelPackage.type").toString();
		System.out.println("modelPackage.opt : "+opt);
		System.out.println("modelPackage.description : "+desription);
		System.out.println("modelPackage.type : "+type);
	}

}
