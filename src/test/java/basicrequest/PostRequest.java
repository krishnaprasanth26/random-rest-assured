package basicrequest;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static io.restassured.RestAssured.*;

public class PostRequest {

    //1. Passing json body as String --> Not recommended.
    //** Not recommended to write code this way for larger Json

    @Test
    public void postTest(){

        String reqBody = "{\\n\" +\n" +
                "                \"\\\"name\\\":\\\"Test Automation Guide\\\",\\n\" +\n" +
                "                \"\\\"isbn\\\":\\\"650456\\\",\\n\" +\n" +
                "                \"\\\"aisle\\\":\\\"HDFC Bank Account\\\",\\n\" +\n" +
                "                \"\\\"author\\\":\\\"Rawther\\\"\\n\" +\n" +
                "                \"}";

        Response response = given().header("Content-Type","application/json").
                body(reqBody).log().all().post("http://216.10.245.166/Library/Addbook.php");

        response.prettyPrint();
        System.out.println("****************************************************");

    }

    //2. Pass it from external file.
    //** You cannot get the request content from the file and print it in the console.
    //** Use this only for Static data, accessing the file everytime is difficult.

    @Test
    public void postTestSecondType(){
       Response response = given().header("Content-Type", ContentType.JSON).
                log().all().body(new File(System.getProperty("user.dir")+"/test.json")).
                post("http://216.10.245.166/Library/Addbook.php");

       response.prettyPrint();

        System.out.println("******************************************************");

    }

    //3. Read req body from an external file and convert to String.
    //** Logs the req body into the console.
    //** Change few parameters in the request.
    //** Not suitable for request having lot of dynamic parameters.

    @Test
    public void postTestThirdType() throws IOException {
        String reqBody = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/test.json")));
        String replace = reqBody.replace("650456",String.valueOf(new Faker().number().numberBetween(100,250)));
        Response response = given().header("Content-Type",ContentType.JSON).log().all().body(replace).post("http://216.10.245.166/Library/Addbook.php");
        response.prettyPrint();
        System.out.println("******************************************************");
    }

    @Test
    public void postTestFourthType() {
        //Using map and list from Java
        // {} --> Map Interface.
        // [] --> List.
        // serializers --> converts your language objects --> byte stream -->JSON
        // @35:00 @Refer Lecture Part 12 | Different ways of constructing POST request | Important Topic | Rest Assured |
        //Disadvantages : Verbose, difficult for bigger JSON files.
        //Generic type needs to be mentioned.

        Map<String,Object> obj = new HashMap<>(); // Inorder to maintain the insertion order use LinkedHashMap<>();
        obj.put("name","Test Automation Broke");
        obj.put("isbn","255026");
        obj.put("aisle","Kotak Mahindra Bank");
        obj.put("author","Rawther");
        Response response = given().header("Content-Type",ContentType.JSON).log().all().body(obj).
        post("http://216.10.245.166/Library/Addbook.php");
        response.prettyPrint();




    }

    @Test
    public void postTestFourType2() {
        //Using map and list from Java
        // {} --> Map Interface.
        // [] --> List.
        // serializers --> converts your language objects --> byte stream -->JSON
        // @35:00 @Refer Lecture Part 12 | Different ways of constructing POST request | Important Topic | Rest Assured |
        //Disadvantages : Verbose, difficult for bigger JSON files.
        //Generic type needs to be mentioned.

        Map<String,Object> obj = new LinkedHashMap<>(); // Inorder to maintain the insertion order use LinkedHashMap<>();
        obj.put("firstName","Nisha");
        obj.put("lastName","Thuppaki");
        obj.put("age","34");

        Map<String,Object> obj1 = new LinkedHashMap<>();
        obj1.put("streetAddress","124, 3rd cross");
        obj1.put("city","Phoenix");
        obj1.put("postalCode","85001");

        obj.put("address",obj1);

        List<Object> list = new ArrayList<>();
        Map<String,Object> obj2 = new LinkedHashMap<>();
        obj2.put("type","iPhone");
        obj2.put("number","0123-4567-8888");

        Map<String,Object> obj3 = new LinkedHashMap<>();
        obj3.put("type","OnePlus");
        obj3.put("number","0123-4468-9999");

        list.add(obj2);
        list.add(obj3);

        obj.put("phoneNumbers",list);


        Response response = given().header("Content-Type",ContentType.JSON).log().all().body(obj).
                post("http://216.10.245.166/Library/Addbook.php");
        response.prettyPrint();
    }

    @Test
    public void postTestFifth() {
        //Using external json library.
        //having some collections that can solve the problems we had while using the map and list.
        //{} --> JsonObject.
        //[] --> JsonArray.

        JSONObject obj = new JSONObject();
        obj.put("firstName","Sherin");
        obj.put("lastName","Albert");
        obj.put("age","29");


        JSONObject obj1 = new JSONObject();
        obj1.put("streetAddress","Nonsense Street");
        obj1.put("city","Nara");
        obj1.put("postalCode","630-0192");
        obj.put("address",obj1);

        JSONArray phoneNumbers = new JSONArray();

        JSONObject obj2 = new JSONObject();
        obj2.put("type","iphone");
        obj2.put("number","0123-4567-8888");

        JSONObject obj3 = new JSONObject();
        obj3.put("type","Android");
        obj3.put("number","0123-4567-8910");

        phoneNumbers.put(obj2);
        phoneNumbers.put(obj3);

        obj.put("phoneNumbers",phoneNumbers);



        Response response = given().header("Content-Type",ContentType.JSON).log().all().body(obj.toMap()).
                post("http://216.10.245.166/Library/Addbook.php");
        response.prettyPrint();


    }


}
