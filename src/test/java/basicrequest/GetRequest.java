package basicrequest;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class GetRequest {

    @Test
    public void getTest() {
        Response response = given().get("http://216.10.245.166/Library/GetBook.php?AuthorName=Investment Account");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getContentType());
        response.prettyPrint();

        //Iterating the Headers method
        Headers headers = response.headers();
        for(Header header:headers)
        {
            System.out.println(header.getName()+" : "+header.getValue());
        }

        response.getTimeIn(TimeUnit.SECONDS);
    }
}
