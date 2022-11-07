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

public class PetStorePetAPIStepDefi {
    static Faker faker;
    static Random rnd;
    public PetStorePojo expectedData;
    static RequestSpecification spec;
    String postData;
    Response response;
    int getData;
    int deleteData;
    @Given("The user creates a pet information that want to register")
    public void theUserCreatesAPetInformationThatWantToRegister() {
    spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
    postData = "{\n" +
            "  \"id\": 25,\n" +
            "  \"category\": {\n" +
            "    \"id\": 1001,\n" +
            "    \"name\": \"Kangal\"\n" +
            "  },\n" +
            "  \"name\": \"Sivas\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"http://www.sivas.gov.tr/kurumlar/sivas.gov.tr/Sehir_Etiketleri/Kangal-Coban-Kopegi/img0.jpg\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 58,\n" +
            "      \"name\": \"Sivas\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";
    }
    @Then("The User register a new pet")
    public void theUserRegisterANewPet() {
    spec.pathParam("first","pet");
    response=given().spec(spec).contentType(ContentType.JSON).when().body(postData).post("/{first}");
    response.prettyPrint();
    }
    @And("The User verify the actual and expected result for pet")
    public void theUserVerifyTheActualAndExpectedResultForPet() {
    response.then().statusCode(200);
    }
    @Given("The User define get request for a pet with expected data")
    public void theUserDefineGetRequestForAPetWithExpectedData() {
    getData=25;
    spec.pathParams("first","pet","second",getData);
    }
    @Then("The User records the data with get request for pet")
    public void theUserRecordsTheDataWithGetRequestForPet(){
    response=given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
    response.prettyPrint();
    }
    @And("The User compare to expected and actual data for pet")
    public void theUserCompareToExpectedAndActualDataForPet() {
    response.then().statusCode(200);
    }
    @Given("The User define delete request for a pet with expected data")
    public void theUserDefineDeleteRequestForAPetWithExpectedData()  {
    deleteData=25;
    spec.pathParams("first","pet","second",deleteData);
    }
    @Then("The User delete the expected data for pet")
    public void theUserDeleteTheExpectedDataForPet(){
    response=given().spec(spec).header("api_key","kdryy").contentType(ContentType.JSON).when().delete("/{first}/{second}");
    response.prettyPrint();
    }
    @And("The User verify the response for pet")
    public void theUserVerifyTheResponseForPet(){
    response.then().statusCode(200);
    }
    @Given("The User define an expected data for negative delete request for pet")
    public void theUserDefineAnExpectedDataForNegativeDeleteRequestForPet()  {
    deleteData=25;
    spec.pathParams("first","pet","second",deleteData);
    }
    @Then("The User delete data for negative request for pet")
    public void theUserDeleteDataForNegativeRequestForPet() {
    response=given().spec(spec).header("api_key","kdryy").contentType(ContentType.JSON).when().delete("/{first}/{second}");
    response.prettyPrint();
    }
    @And("The User verify the negative response for pet")
    public void theUserVerifyTheNegativeResponseForPet() {
    response.then().statusCode(404);
    }
}
