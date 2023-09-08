package mandatoryHomeWork.api;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class reqresAutomation {
    private String baseURI = "https://reqres.in";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseURI;
    }

    @Test
    public void testListUsers() {
        // GET Request to list users
        RequestSpecification request = RestAssured.given();
        Response response = request.get("/api/users?page=1");

        // Assertions
        response.then().statusCode(200); // Assuming 200 is the expected status code
        // Add more assertions as needed
    }

    @Test
    public void testCreateUser() {
        // POST Request to create a user
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        String requestBody = "{ \"name\": \"John\", \"job\": \"Engineer\" }";
        request.body(requestBody);

        Response response = request.post("/api/users");

        // Assertions
        response.then().statusCode(201); // Assuming 201 is the expected status code for successful creation
        // Add more assertions as needed
    }
}

