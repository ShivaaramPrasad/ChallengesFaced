package challenges;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class MakarooTest {
	
	@Test()
	public void getRandomData() {

    Mockaroo.init();
	System.out.println("First Name: "+Mockaroo.getFirstName());
	System.out.println("Last Name: "+ Mockaroo.getNickName());
	System.out.println("AcountNumber: "+Mockaroo.getAccountNum());
	System.out.println("Addres: "+Mockaroo.getAddress());
	System.out.println("Email: "+Mockaroo.getEmail());
	System.out.println("phone Number: "+Mockaroo.getPhone());
	System.out.println("Zip Code: "+Mockaroo.getZip());
	System.out.println("Address: "+Mockaroo.getAddress());

	}
	

}
