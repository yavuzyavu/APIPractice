package day02;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest06 extends Authentication {
    @Test
    public void test06() {
        String url="https://www.gmibank.com/api/tp-customers/114351";

        Response response=given().headers("Authorization","Bearer "+generateToken()).when().get(url);
        response.prettyPrint();

        //Matcher class ile musteri bilgilerini dogrula
        response.then().assertThat().body("firstName",equalTo("Della"),
                "lastName",equalTo("Heaney"),"email",
                equalTo("ricardo.larkin@yahoo.com"),"mobilePhoneNumber",
                equalTo("123-456-7893"),"accounts[0].balance",equalTo(11190),
                "accounts[0].accountType",equalTo("CHECKING"));

        // JsonPath ile musteri bilgilerini dogrula
        JsonPath json=response.jsonPath();
        Assert.assertEquals("Della",json.getString("firstName"));
        Assert.assertEquals("Heaney",json.getString("lastName"));
        Assert.assertEquals("ricardo.larkin@yahoo.com",json.getString("email"));





    }
}