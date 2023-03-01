package part14;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import testdatapart14.jacksonannotation.Batter;
import testdatapart14.jacksonannotation.Batters;
import testdatapart14.jacksonannotation.JsonRequest;
import testdatapart14.jacksonannotation.Topping;


import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class JacksonAnnotationSchemaValidationAssertions {

    @Test
    public void jacksonAnnotation(){
        Batter batter = new Batter("1001","idly");
        Batter batter1 = new Batter("1002","Dosa");
        Batter batter2 = new Batter("1003","Idiyappam");

        List<Batter> batterList = Arrays.asList(batter,batter1,batter2);

        Batters batters = new Batters(batterList);

        Topping topping = new Topping("1001","Podi");
        Topping topping1 = new Topping("1002","Oil");

        List<Topping> toppingList = Arrays.asList(topping,topping1);

        JsonRequest jsonRequest = new JsonRequest("1001","Batter","Idly Items","0.05",batters,toppingList);

        given().header("Content-Type", ContentType.JSON).log().all().body(jsonRequest).
                post("http://216.10.245.166/Library/Addbook.php");
}
}
