package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;
import utilities.GMIBankBaseURL;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest07 extends GMIBankBaseURL {

//    http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın
//            “firstName”: “Melva”,
//            “lastName”: “Bernhard”,
//            “email”: “chas.kuhlman@yahoo.com”
//            “zipCode”: “40207"
//            “country.name”: “San Jose”
//            “login”: “delilah.metz”


    @Test
    public void test07() {

        // 1- Url olustur
        spec01.pathParams("1", "tp-customers", "2", 110472);

        //2- Request ve Response
        Response response = given().spec(spec01).headers("Authorization", "Bearer " + generateToken())
                .when().
                get("/{1}/{2}");
        response.prettyPrint();

        //Matcner ile dogrula
        response.then().assertThat().body("firstName", equalTo("Melva"),
                "lastName", equalTo("Bernhard"),
                "email", equalTo("chas.kuhlman@yahoo.com"),
                "zipCode", equalTo("40207"),
                "country.name", equalTo("San Jose"),
                "user.login", equalTo("delilah.metz"));

        //Json Path ile dogrula
        JsonPath json = response.jsonPath();
        assertEquals("Melva",json.getString("firstName"));
        assertEquals("Bernhard",json.getString("lastName"));
        assertEquals("chas.kuhlman@yahoo.com",json.getString("email"));
        assertEquals("40207",json.getString("zipCode"));
        assertEquals("San Jose",json.getString("country.name"));
        assertEquals("delilah.metz",json.getString("user.login"));


    }
}
