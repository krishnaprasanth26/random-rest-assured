package part15;

import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class WriteContentExternalFile {

    @Test
    public void writeDataToExternalFile() throws IOException {
        Response response = given().queryParam("page","2").log().all().get("https://reqres.in/api/users");
        response.prettyPrint();

        Files.write(Paths.get(System.getProperty("user.dir")+"/response.json"),response.asByteArray());

    }
}
