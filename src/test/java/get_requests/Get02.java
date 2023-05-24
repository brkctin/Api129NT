package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get02 {

    /*
      Given
           https://restful-booker.herokuapp.com/booking/0
      When
           User send a GET Request to the url
      Then
           HTTP Status code should be 404
      And
           Status Line should be "HTTP/1.1 404 Not Found"                          //BEKLENEN DATA
      And
           Response body contains "Not Found"                                      //NOT FOUND İÇERİYOR MU?
      And
           Response body does not contain "TechProEd"
      And
           Server is "Cowboy"
    */

    @Test
    public void get02() {

        //Set the url
        String url = "https://restful-booker.herokuapp.com/booking/0";

        //Set the expected data -->İleride yapacağız..


        //Send the request and het the response
        Response response = given().get(url);
        response.prettyPrint();


        //Do assertion
        response.then().statusCode(404);
        response.then().statusLine("HTTP/1.1 404 Not Found");


        //Response body contains "Not Found"
        assertTrue(response.asString().contains("Not Found"));


        //Response body does not contain "TechProEd"
        assertTrue(response.asString().contains("TechProEd"));


        //Server is "Cowboy"
        String server = response.header("Server");
        assertEquals("Cowboy",server);


    }
}
