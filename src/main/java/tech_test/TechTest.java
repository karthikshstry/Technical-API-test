package tech_test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.get;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class TechTest {

    //Verify response data
    @Test
    public static void verify_response_data_schema() {
        {
            //Rest API's URL
            String restAPIUrl = "https://swapi.dev/api/planets/3/";
            System.out.println(restAPIUrl);

            //Building request by using requestSpecBuilder
            RequestSpecBuilder builder = new RequestSpecBuilder();

            //Setting content type as application/json
            builder.setContentType("application/json; charset=UTF-8");

            RequestSpecification requestSpec = builder.build();

            //Making get request with authentication or leave blank if you don't have credentials like: basic("","")
            Response response = given().spec(requestSpec).when().get(restAPIUrl);

            int statusCode = response.getStatusCode();
            String ResBody = response.getBody().asString();
            System.out.println(statusCode);
            System.out.println(ResBody);

            //Verify the JSON schema and response data
            JsonPath jsonPathEvaluator = response.jsonPath();
            //Get values from response tag
            String name = jsonPathEvaluator.getJsonObject("name");
            String rotation_period = jsonPathEvaluator.getJsonObject("rotation_period").toString();
            String orbital_period = jsonPathEvaluator.getJsonObject("orbital_period").toString();
            String diameter = jsonPathEvaluator.getJsonObject("diameter").toString();
            String climate = jsonPathEvaluator.getJsonObject("climate");
            String gravity = jsonPathEvaluator.getJsonObject("gravity");
            String terrain = jsonPathEvaluator.getJsonObject("terrain");
            String surface_water = jsonPathEvaluator.getJsonObject("surface_water").toString();
            String population = jsonPathEvaluator.getJsonObject("population").toString();
            String residents = jsonPathEvaluator.getJsonObject("residents").toString();
            String films = jsonPathEvaluator.getJsonObject("films[0]");
            String created = jsonPathEvaluator.getJsonObject("created");
            String edited = jsonPathEvaluator.getJsonObject("edited");
            String url = jsonPathEvaluator.getJsonObject("url");

            //Validate response
            Assert.assertEquals(statusCode, 200);
            Assert.assertEquals(name, "Yavin IV");
            Assert.assertEquals(rotation_period, "24");
            Assert.assertEquals(orbital_period, "4818");
            Assert.assertEquals(diameter, "10200");
            Assert.assertEquals(climate, "temperate, tropical");
            Assert.assertEquals(gravity, "1 standard");
            Assert.assertEquals(terrain, "jungle, rainforests");
            Assert.assertEquals(surface_water, "8");
            Assert.assertEquals(population, "1000");
            Assert.assertEquals(residents, "[]");
            Assert.assertEquals(films, "https://swapi.dev/api/films/1/");
            Assert.assertEquals(created, "2014-12-10T11:37:19.144000Z");
            Assert.assertEquals(edited, "2014-12-20T20:58:18.421000Z");
            Assert.assertEquals(url, "https://swapi.dev/api/planets/3/");
        }
        }

    //Verify response header
    @Test
    public static void verify_response_header() {
        {
            //Rest API's URL
            String restAPIUrl = "https://swapi.dev/api/planets/3/";
            System.out.println(restAPIUrl);

            //Building request by using requestSpecBuilder
            RequestSpecBuilder builder = new RequestSpecBuilder();

            //Setting content type as application/json
            builder.setContentType("application/json; charset=UTF-8");

            RequestSpecification requestSpec = builder.build();

            //Making get request with authentication or leave blank if you don't have credentials like: basic("","")
            Response response = given().spec(requestSpec).when().get(restAPIUrl);

            int statusCode = response.getStatusCode();
            String ResBody = response.getBody().asString();
            System.out.println(statusCode);
            System.out.println(ResBody);

            //Verify response headers
            //Header named Server
            String serverType = response.header("Server");
            System.out.println("Server value: " + serverType);

            //Header named Date
            String date = response.header("Date");
            System.out.println("Date value: " + date);

            //Header named Content-Type
            String contentType = response.header("Content-Type");
            System.out.println("Content-Type value: " + contentType);

            //Header named Transfer-Encoding
            String transfer_encoding = response.header("Transfer-Encoding");
            System.out.println("Transfer-Encoding value: " + transfer_encoding);

            //Header named Connection
            String connection = response.header("Connection");
            System.out.println("Connection value: " + connection);

            //Header named Vary
            String vary = response.header("Vary");
            System.out.println("Vary value: " + vary);

            //Header named X-Frame-Options
            String xframe_options = response.header("X-Frame-Options");
            System.out.println("X-Frame-Options value: " + xframe_options);

            //Header named ETag
            String etag = response.header("ETag");
            System.out.println("ETag value: " + etag);
        }
    }

    //Verify response time
    @Test
    public static void verify_response_time() {
        {
            //Rest API's URL
            String restAPIUrl = "https://swapi.dev/api/planets/3/";
            System.out.println(restAPIUrl);
            get(restAPIUrl).then().time(lessThan(3L));
        }
    }

    //Verify mocks out the response and returns a different value for the name object
    @Test
    public static void verify_response_mockup() {
        {
            // Generate random digits in endpoint url
            int number = (int)(Math.random() * 10);
            System.out.println(number);
            String baseUri = "https://swapi.dev/api/planets/";
            int basePath = number;
            String restAPIUrl = baseUri + basePath;
            System.out.println(restAPIUrl);

            //Building request by using requestSpecBuilder
            RequestSpecBuilder builder = new RequestSpecBuilder();

            //Setting content type as application/json
            builder.setContentType("application/json; charset=UTF-8");

            RequestSpecification requestSpec = builder.build();

            //Making get request with authentication or leave blank if you don't have credentials like: basic("","")
            Response response = given().spec(requestSpec).when().get(restAPIUrl);

            int statusCode = response.getStatusCode();
            String ResBody = response.getBody().asString();
            System.out.println(statusCode);
            System.out.println(ResBody);

            //Verify the JSON schema and response data
            JsonPath jsonPathEvaluator = response.jsonPath();
            //Get values from response tag
            String name = jsonPathEvaluator.getJsonObject("name");
            System.out.println(name);

            //Validate response
            Assert.assertEquals(statusCode, 200);
            Assert.assertEquals(name, name);
        }
    }

    //Negative testing
    @Test
    public static void verify_post_request() {
        {
            //Rest API's URL
            String restAPIUrl = "https://swapi.dev/api/planets/3/";
            System.out.println(restAPIUrl);

            //API Body
            String body = "{\"name\":\"Automated testing\",\"Completed\":\"true\"}";
            System.out.println(body);

            //Building request by using requestSpecBuilder
            RequestSpecBuilder builder = new RequestSpecBuilder();

            //Set API's Body
            builder.setBody(body);

            //Setting content type as application/json
            builder.setContentType("application/json; charset=UTF-8");

            RequestSpecification requestSpec = builder.build();

            //Making post request with authentication or leave blank if you don't have credentials like: basic("","")
            Response response = given().spec(requestSpec).when().post(restAPIUrl);

            int statusCode = response.getStatusCode();
            String ResBody = response.getBody().asString();
            System.out.println(statusCode);
            System.out.println(ResBody);

            //Verify the JSON schema and response data
            JsonPath jsonPathEvaluator = response.jsonPath();
            //Get values from response tag
            String detail = jsonPathEvaluator.getJsonObject("detail");

            //Validate response
            Assert.assertEquals(statusCode, 405);
            Assert.assertEquals(detail, "Method 'POST' not allowed.");
        }
    }
        }