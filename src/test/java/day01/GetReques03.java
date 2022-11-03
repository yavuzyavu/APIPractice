package day01;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetReques03 {
    @Test
    public void test03() {


    /* Matchers ile dataları doğrulayınız
             "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
     */

        String url = "https://reqres.in/img/faces/5-image.jpg";
        Response response = given().when().get(url);
        System.out.println(response.getStatusLine());

        


    }
}
