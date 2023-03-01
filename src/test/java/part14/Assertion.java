package part14;

import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdatapart14.jacksonannotation.JsonRequest;
import testdatapart14.jacksonannotationresponse.JacksonResponse;

import java.sql.SQLOutput;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Assertion {

    @Test
    public void getCallAssertion(){

        Response response = given().queryParam("page","2").log().all().get("https://reqres.in/api/users");
        response.prettyPrint();
        //StatusCode.
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        //ContentCode.
        System.out.println("response.getContentType() = " + response.getContentType());
        //Access the content using JSONpath.
        System.out.println("response.jsonPath().getString() = " + response.jsonPath().getString("total"));
        //Access the String Array using JSONpath.
        List<String> responseJSON = response.jsonPath().getList("data");
        System.out.println("responseJSON = " + responseJSON);

        //Assert the response.
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("Response JSON = " + response.jsonPath().getString("data[2].email"));

        Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");

        // Deserialization of the Response Body.
        JacksonResponse jacksonResponse = response.as(JacksonResponse.class);
        System.out.println("jacksonResponse.getPer_page() = " + jacksonResponse.getPer_page());
        System.out.println("jacksonResponse.getTotal() = " + jacksonResponse.getTotal());

        System.out.println("jacksonResponse.getData().get(1).getEmail() = " + jacksonResponse.getData().get(1).getEmail());


    }
}
