package Homework.day04;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.createUserHwDay04;
import static io.restassured.RestAssured.given;

public class CreateUser extends petStore {
    //Write an automation test that will create a 'user' then read, update and delete the created user using the "https://petstore.swagger.io/" document. (Create a classes for each request.)


    @Test
    public void createUser() throws JsonProcessingException {
        spec.pathParams("first","v2",
                "second","user");

        String expectedStr = """
                {
                  "id": 11,
                  "username": "alaa0012",      
                  "firstName": "alaa",
                  "lastName": "ibrahim",
                  "email": "a@gotmail.com",
                  "password": "23456",
                  "phone": "123456",
                  "userStatus": 0
                }""";
        ObjectMapper objectMapper = new ObjectMapper();
        createUserHwDay04 payLoad = objectMapper.readValue(expectedStr, createUserHwDay04.class);

        Response response = given(spec).body(payLoad).when().post("{first}/{second}");
        response.prettyPrint();


        JsonPath json = response.jsonPath();
        String message = json.getString("message");
        System.out.println("message = " + message);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(message,"11");

    }
}
