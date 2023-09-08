package mandatoryHomeWork.api;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class restfulBookerAutomation {
    private String baseURI = "https://restful-booker.herokuapp.com";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseURI;
    }

    @Test
    public void testApiDocumentationAvailability() {
        // Send a GET request to the API documentation page
        Response response = RestAssured.get("/apidoc/index.html");

        // Assertions
        response.then().statusCode(200); // Assuming 200 is the expected status code for success
        // Add more assertions as needed
    }

    @Test
    public void testCreateBooking() {
        // Define the request body as JSON
        String requestBody = "{\n" +
                "    \"firstname\" : \"John\",\n" +
                "    \"lastname\" : \"Doe\",\n" +
                "    \"totalprice\" : 200,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2023-09-10\",\n" +
                "        \"checkout\" : \"2023-09-15\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        // Send a POST request to create a booking
        Response postResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/booking");

        // Assertions for POST request
        postResponse.then().statusCode(200); // Assuming 200 is the expected status code for success
        // Add more assertions as needed

        // Get the booking ID from the POST response
        int bookingId = postResponse.jsonPath().getInt("bookingid");

        // Send a GET request to retrieve the booking details
        Response getResponse = RestAssured.get("/booking/" + bookingId);

        // Assertions for GET request
        getResponse.then().statusCode(200); // Assuming 200 is the expected status code for success
        // Add more assertions as needed
    }
}
