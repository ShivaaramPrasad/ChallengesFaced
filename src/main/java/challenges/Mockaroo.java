package challenges;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class Mockaroo {
	
	private static JsonPath response;

    private static String firstName;
	private static String email;
	private static String gender;
	private static String phone;
	private static String zip;
	private static String state;
	private static String city;
	private static String dob;
	private static String address;
	private static String remark;
	private static String fullName;
	private static String nickName;
	private static String country;
	private static String accountNum;

	public static void init()
	{
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/environment.properties")));
		} catch (IOException e) {
		}	
		RestAssured.baseURI = prop.getProperty("mackrooURI");	
		response = RestAssured.given().queryParam("key", prop.getProperty("key"))
				.when().get().jsonPath();
		response.prettyPrint();
	}
	
	public static String getFullName() {
		try {
			firstName = "Shivaa";
			fullName = response.get("full_name").toString();
		} catch (Exception e) {
		}
		if(fullName == null) // set default value
			firstName = "Shivaa";
		return firstName;
	}

	public static String getFirstName() {
		try {
			firstName = "Shivaa";
			firstName = response.get("first_name").toString();
		} catch (Exception e) {
		}
		if(firstName == null) // set default value
			firstName = "Shivaa";
		return firstName;
	}
	
	public static String getNickName() {
		nickName = response.get("nick_name");
		if(nickName == null) // set default value
			nickName = "Ram";
		return nickName;
	}
		
	public static String getDob() {
		dob = response.get("date_dob");
		if(dob == null) // set default value
			dob = "03/31/1990";
		return dob;

	}

	public static String getGender() {
		gender = response.get("gender");
		if(gender == null) // set default value
			gender = "Male";
		return gender;
	}
		
	public static String getEmail() {
		email = response.get("email");
		if(email == null) // set default value
			email = "test@gmail.com";
		return email;

	}
	public static String getAddress() {
		address = response.get("street_address");
		if(address == null) // set default value
			address = "Address";
		return address;

	}

	public static String getCity() {
		city = response.get("city");
		if(city == null) // set default value
			city = "Columbia";
		return city;

	}
	
	public static String getZip() {
		zip = response.get("zip");
		if(zip == null) // set default value
			zip = "29223";
		return zip;

	}
	public static String getState() {
		state = response.get("state");
		if(state == null) // set default value
			state = "South Carolina";
		return state;
	}
	public static String getcountry() {
		country = response.get("country");
		if(country == null) // set default value
			country = "India";
		return country;
	}

	/*
	public static String getMiddleName() {
		return ""+(char)(new Random().nextInt(26) + 'A');

	}*/

		public static String getPhone() {
		phone = response.get("phone_number");
		if(phone == null) // set default value
			phone = "9181234567";
		return phone;
	}
	
	public static String getRemark() {
		remark = response.get("remark");
		if(remark == null) // set default value
			remark = "default description";
		return remark;
		
	}
	
	public static String getAccountNum() {
		accountNum = response.get("account_num");
		if(accountNum == null) // set default value
			accountNum = "9181234567123";
		return accountNum;
	}
	
	}
