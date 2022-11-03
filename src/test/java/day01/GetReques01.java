package day01;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetReques01 {
    @Test
    public void test01() {

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response = given().when().get(url);
        //given().when().get(url) --> end point'e göndermek icin request olusturmus olduk
        //Response response --> api tarafindan bana donen response (cevap)

        //Response response -->given().auth().basic("username","password").when().get(url)
        //.asic auth ile request gondermek icin

        // response.prettyPrint() //response'taki body'i yazdirir.

         response.prettyPeek(); // response'taki herseyi gosterir.

        //  response.peek();  //response'taki body'i tek satirda string yazdirir

        //response.print(); //[{"bookingid":1215},{"bookingid":844},{"bookingid":87},{"bookingid":747}...

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        //--> JUnit Assertleri ile API testi yapabiliriz.
        //Assert.assertEquals("status kod hatali",200,response.statusCode());
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8",response.contentType());

        // 2) assertthat ile ;
        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");
    }
}
