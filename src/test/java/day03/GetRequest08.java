package day03;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.GMIBankBaseURL;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest08 extends GMIBankBaseURL {
//    http://www.gmibank.com/api/tp-customers/43703
//            “firstName”: “Alda”,
//            “lastName”: “Monahan”,
//            “middleInitial”: “Nichelle Hermann Kohler”,
//            “email”: “com.github.javafaker.Name@7c011174@gmail.com”,
//            “mobilePhoneNumber”: “909-162-8114”,
//            “city”: “St Louis”,
//            “ssn”: “108-53-6655"
//            1) MATCHERS CLASS
//          2) JSON PATH
//          3) De-Serialization


    @Test
    public void get08() {

        //Set The Url
        spec01.pathParams("1","tp-customers","2","43703");

        //Set The ExpectedData
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("firstName","Alda");
        expectedData.put("lastName","Monahan");
        expectedData.put("middleInitial","Nichelle Hermann Kohler");
        expectedData.put("mobilePhoneNumber","909-162-8114");
        expectedData.put("city","St Louis");
        expectedData.put("ssn","108-53-6655");

        //Response Request
        Response response = given().spec(spec01).headers("Authorization", "Bearer " + generateToken())
                .when().
                get("/{1}/{2}");
        response.prettyPrint();




    }
}
