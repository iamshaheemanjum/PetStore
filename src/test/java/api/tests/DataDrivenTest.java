package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String id, String username, String fName, String lName, String phone, String email,
			String pwd) {

		User userPayload = new User();
		userPayload.setEmail(email);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setUsername(username);
		userPayload.setId(Integer.parseInt(id));
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		Response res= UserEndPoints.createUser(userPayload);
		Assert.assertEquals(res.getStatusCode(), 200);

	}
	
	
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	
	public void testDeleteUser(String username) {
		
		UserEndPoints.deleteUser(username).then().log().all();
		
	}

}
