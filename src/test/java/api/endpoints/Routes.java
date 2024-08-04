package api.endpoints;

public class Routes {

	public static String BASE_URL = "https://petstore.swagger.io/v2";

	// User module

	public static String POST_URL = BASE_URL + "/user";
	public static String GET_URL = BASE_URL + "/user/{username}";
	public static String UPDATE_URL = BASE_URL + "/user/{username}";
	public static String DELETE_URL = BASE_URL + "/user/{username}";

}
