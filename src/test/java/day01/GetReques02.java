package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetReques02 {

    @Test
    public void test02() {

        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);
        //given().when().get(url) --> request

        // Header Test
        response.then().assertThat()
                .statusLine("HTTP/1.1 200 OK")
                .statusCode(200)
                .contentType(ContentType.JSON);


        //Body testi
       /* id'si 1 olanin datalarinin asagidaki gibi oldugunu test ediniz
        "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
        */


        // 3) Matcher Class ile
        response.then().body("data[0].email", equalTo("george.bluth@reqres.in")
                ,"data[0].first_name", equalTo("George")
                , "data[0].last_name", equalTo("Bluth"));








    }
}
