package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.PetStorePojo;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class PetStoreOrderAPIStepDefi {
    static Faker faker;
    static Random rnd;
    public PetStorePojo expectedData;
    static RequestSpecification spec;
    String postData;
    Response response;
    int getData;
    int deleteData;

    @Given("The user creates a store information that want to register")
    public void theUserCreatesAStoreInformationThatWantToRegister() {
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
        postData = "{\n" +
                "  \"id\": 25,\n" +
                "  \"petId\": 1001,\n" +
                "  \"quantity\": 1,\n" +
                "  \"shipDate\": \"2022-08-31T12:02:34.145Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
    }

    @Then("The User register a new store")
    public void theUserRegisterANewStore() {
        spec.pathParams("first","store","second","order");
        response=given().spec(spec).contentType(ContentType.JSON).when().body(postData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @And("The User verify the actual and expected result for store")
    public void theUserVerifyTheActualAndExpectedResultForStore() {
        response.then().statusCode(200);
    }

    @Given("The User define get request for store section with expected data")
    public void theUserDefineGetRequestForStoreSectionWithExpectedData() {
        getData=25;
        spec.pathParams("first","store","second","order","third",getData);
    }

    @Then("The User records the data with get request for store")
    public void theUserRecordsTheDataWithGetRequestForStore() {
        response=given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}/{third}");
        response.prettyPrint();
    }

    @And("The User compare to expected and actual data for store")
    public void theUserCompareToExpectedAndActualDataForStore() {
        response.then().statusCode(200);
    }

    @Given("The User define delete request for store section with expected data")
    public void theUserDefineDeleteRequestForStoreSectionWithExpectedData() {
        deleteData=25;
        spec.pathParams("first","store","second","order","third",deleteData);
    }

    @Then("The User delete the expected data for store")
    public void theUserDeleteTheExpectedDataForStore() {
        response=given().spec(spec).header("api_key","kdryy").contentType(ContentType.JSON).when().delete("/{first}/{second}/{third}");
        response.prettyPrint();
    }

    @And("The User verify the response for store")
    public void theUserVerifyTheResponseForStore() {
        response.then().statusCode(200);
    }

    @Given("The User define an expected data for negative delete request for store")
    public void theUserDefineAnExpectedDataForNegativeDeleteRequestForStore() {
        deleteData=25;
        spec.pathParams("first","store","second","order","third",deleteData);
    }

    @Then("The User delete data for negative request for store")
    public void theUserDeleteDataForNegativeRequestForStore() {
        response=given().spec(spec).header("api_key","kdryy").contentType(ContentType.JSON).when().delete("/{first}/{second}/{third}");
        response.prettyPrint();
    }

    @And("The User verify the negative response for store")
    public void theUserVerifyTheNegativeResponseForStore() {
        response.then().statusCode(404);
    }
}
