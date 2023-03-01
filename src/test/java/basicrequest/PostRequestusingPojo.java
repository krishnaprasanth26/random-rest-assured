package basicrequest;


import testdatapart13.complex.Batter;
import testdatapart13.complex.Batters;
import testdatapart13.complex.Example;
import testdatapart13.complex.Topping;
import testdatapart13.complex1.Author;
import testdatapart13.complex1.Editor;
import testdatapart13.googleapi.*;
import testdatapart13.pojo.Address;
import testdatapart13.pojo.Employee;
import testdatapart13.pojo.PhoneNumber;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostRequestusingPojo {

    //Plain Old Java Object.
    //{} --> Class File.
    //[] --> List<Type>.
    //Constructors--> Immutable Objects --> Unchangeable Objects. Using setters we can set mutable objects.


    @Test
    public void pojoTest(){

        PhoneNumber phoneNumber = new PhoneNumber("iPhone","0123-4567-8888");
        PhoneNumber phoneNumber1 = new PhoneNumber("Android Phone", "0123-4567-8910");
        List<PhoneNumber> phoneNumbers = Arrays.asList(phoneNumber,phoneNumber1);

        Address address = new Address("Jain Street","Phoenix","600082");
        Employee employee = new Employee("John","Caeser", 28,address, phoneNumbers);


    given().header("Content-Type", ContentType.JSON).log().all().body(employee).post("http://216.10.245.166/Library/Addbook.php");

    }

    @Test
    public void pojoTestComplex(){
        Batter batter = new Batter("1001","Regular");
        Batter batter1 = new Batter("1002","Chocolate");
        Batter batter2  = new Batter("1003","Blueberry");

        List<Batter> batters = Arrays.asList(batter,batter1,batter2);

        Batters battersClass = new Batters(batters);

        Topping topping = new Topping("5001","Glazed");
        Topping topping1 = new Topping("5002","Sugar");

        List<Topping> toppingList = Arrays.asList(topping,topping1);

        Example example = new Example("0001","donut","c",1,battersClass,toppingList);


        given().header("Content-Type", ContentType.JSON).log().all().body(example).post("http://216.10.245.166/Library/Addbook.php");
    }

    @Test
    public void pojoTestComplex1(){

        Author author = new Author("Jason","Lewis");
        Author author1 = new Author("Donald","Lewis");
        List<Author> authorList = Arrays.asList(author,author1);


        Editor editor = new Editor("Jason","Lewis");
        Editor editor1 = new Editor("Donald","Lewis");
        List<Editor> editorList = Arrays.asList(editor,editor1);

        List<String> categoryList = Arrays.asList("Non-Fiction","Technology");

        testdatapart13.complex1.Example example = new testdatapart13.complex1.Example("123-456-222","The Ultimate Database Study Guide",authorList,editorList,categoryList);


        given().header("Content-Type", ContentType.JSON).log().all().body(example).
                post("http://216.10.245.166/Library/Addbook.php");


    }

    @Test
    public void pojoTestComplex2(){

      List<String> destination_address = Arrays.asList("Washington, DC, USA","Philadelphia, PA, USA","Santa Barbara, CA, USA","Austin, TX, USA");
      List<String> origin_address = Arrays.asList("New York, NY, USA");


      Distance distance = new Distance("227 mi","365468");
      Duration duration = new Duration("3 hours 54 mins","14064");

      Distance distance1 = new Distance("94.6 mi","152193");
      Duration duration1 = new Duration("1 hour 44 mins","6227");



      Elements elements = new Elements(distance,duration,"OK");
      Elements elements1 = new Elements(distance1,duration1,"Ok");

      Rows rows = new Rows(Arrays.asList(elements,elements1));


      Sample sample = new Sample(destination_address,origin_address,rows,"OK");

        given().header("Content-Type", ContentType.JSON).log().all().body(sample).
                post("http://216.10.245.166/Library/Addbook.php");






    }

}


