package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import testData.TestDataBuild;
import utilities.Utils;

public class StepDefinitions extends Utils {

	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();

	@Given("Add Place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		res = given().spec(requestSpecification()).body(data.addPlaceData(name, language, address));
	}

	@When("User call {string} with post request")
	public void user_call_with_post_request(String string) {
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response = res.when().post("/maps/api/place/add/json").then().spec(resSpec).extract().response();
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer statusCode) {

		assertEquals(response.getStatusCode(), statusCode.intValue());
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		JsonPath js = new JsonPath(response.asString());
		Assert.assertEquals(js.get(key), value);
	}

}
