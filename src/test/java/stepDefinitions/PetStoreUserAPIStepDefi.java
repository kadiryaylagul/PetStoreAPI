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

import java.util.*;

import static io.restassured.RestAssured.*;

public class PetStoreUserAPIStepDefi {
    static Faker faker;
    static Random rnd;
    //protected RequestSpecification spec;
    public PetStorePojo expectedData;
    static RequestSpecification spec;
    String postData;
    Response response;
    String getData;
    String deleteData;

    @Given("Kullanici kayit etmek istedigi kullanicinin bilgilerini olusturur")
    public void kullanici_kayit_etmek_istedigi_kullanicinin_bilgilerini_olusturur() {

        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
        postData = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"username\": \"kdryy\",\n" +
                "    \"firstName\": \"kadir\",\n" +
                "    \"lastName\": \"yay\",\n" +
                "    \"email\": \"kdryy@gmail.com\",\n" +
                "    \"password\": \"Y123456789\",\n" +
                "    \"phone\": \"5055554789\",\n" +
                "    \"userStatus\": 1\n" +
                "  }\n" +
                "]";

    }
    @Given("Kullanici API ile post request olusturarak yeni bir kullanici kayit eder")
    public void kullanici_api_ile_post_request_olusturarak_yeni_bir_kullanici_kayit_eder() {
    spec.pathParams("first","user","second","createWithList");
    response=given().spec(spec).contentType(ContentType.JSON).when().body(postData).post("/{first}/{second}");
    response.prettyPrint();



    }
    @Then("Kullanici API ile gelen cevabi kaydeder ve alinan cevap ile beklenen cevabi karsilastirir")
    public void kullanici_api_ile_gelen_cevabi_kaydeder_ve_alinan_cevap_ile_beklenen_cevabi_karsilastirir() {
    response.then().statusCode(200);


    }

    @Given("Kullanici get request icin expected data belirler")
    public void kullaniciGetRequestIcinExpectedDataBelirler() {
    getData="kdryy";
    spec.pathParams("first","user","second",getData);

    }

    @Then("Kullanici user bolumu API ile actual datayı get request ile kaydeder")
    public void kullaniciuserbolumuAPIIleActualDatayıGetRequestIleKaydeder() {
    response=given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
    response.prettyPrint();
    }

    @And("Kullanici API ile gelen cevap ile beklenen cevabi karsilastirir")
    public void kullaniciAPIIleGelenCevapileBeklenenCevabiKarsilastirir() {
    response.then().statusCode(200);

    }

    @Given("Kullanici delete request icin expected data belirler")
    public void kullaniciDeleteRequestIcinExpectedDataBelirler() {
    deleteData="kdryy";
    spec.pathParams("first","user","second",deleteData);
    }

    @Then("Kullanici API ile expected datayı delete yapar")
    public void kullaniciAPIIleExpectedDatayıDeleteYapar() {
    response=given().spec(spec).header("api_key","kdryy").contentType(ContentType.JSON).when().delete("/{first}/{second}");
    response.prettyPrint();
    }

    @And("Kullanici API ile gelen cevabi dogrular")
    public void kullaniciAPIIleGelenCevabiDogrular() {
    response.then().statusCode(200);
    }

    @Given("Kullanici User bolumu negative delete request icin expected data belirler")
    public void kullaniciUserBolumuNegativeDeleteRequestIcinExpectedDataBelirler() {
    deleteData="kdryy";
    spec.pathParams("first","user","second",deleteData);
    }

    @Then("Kullanici User bolumu API ile negative delete yapar")
    public void kullaniciUserBolumuAPIIleNegativeDeleteYapar() {
    response=given().spec(spec).header("api_key","kdryy").contentType(ContentType.JSON).when().delete("/{first}/{second}");
    response.prettyPrint();
    }

    @And("Kullanici User bolumu API ile negative gelen cevabi dogrular")
    public void kullaniciUserBolumuAPIIleNegativeGelenCevabiDogrular() {
    response.then().statusCode(404);
    }

    @Given("The user creates a user information that want to register")
    public void theUserCreatesAUserInformationThatWantToRegister() {
    }

    @Then("The User register a new user")
    public void theUserRegisterANewUser() {
    }

    @And("The User verify the actual and expected result for user")
    public void theUserVerifyTheActualAndExpectedResultForUser() {
    }

    @Given("The User define get request for for User section with expected data")
    public void theUserDefineGetRequestForForUserSectionWithExpectedData() {
    }

    @Then("The User records the data with get request for user")
    public void theUserRecordsTheDataWithGetRequestForUser() {
    }

    @And("The User compare to expected and actual data for user")
    public void theUserCompareToExpectedAndActualDataForUser() {
    }

    @Given("The User define delete request for user section with expected data")
    public void theUserDefineDeleteRequestForUserSectionWithExpectedData() {
    }

    @Then("The User delete the expected data for user")
    public void theUserDeleteTheExpectedDataForUser() {
    }

    @And("The User verify the response for user")
    public void theUserVerifyTheResponseForUser() {
    }

    @Given("The User define an expected data for negative delete request for user")
    public void theUserDefineAnExpectedDataForNegativeDeleteRequestForUser() {
    }

    @Then("The User delete data for negative request for user")
    public void theUserDeleteDataForNegativeRequestForUser() {
    }

    @And("The User verify the negative response for user")
    public void theUserVerifyTheNegativeResponseForUser() {
    }
}
