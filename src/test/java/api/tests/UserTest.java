package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	
	void setUpData() {
		
		
		faker= new Faker();
		userPayload = new User();
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setUsername(faker.name().username());
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
//		System.out.println(userPayload.getEmail());
//		System.out.println(userPayload.getFirstName());
//		System.out.println(userPayload.getLastName());
//		System.out.println(userPayload.getUsername());
//		System.out.println(userPayload.getPhone());
		Response res=UserEndPoints.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3)
	public void tetsGetUser() {
		
		Response res=UserEndPoints.getUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2)
	public void tetsUpdateUser() {
		
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setUsername(faker.name().username());
		
		Response res=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority = 4)
	public void tetsDeleteUser() {
		
		Response res=UserEndPoints.deleteUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}

}
