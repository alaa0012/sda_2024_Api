package Homework.day04;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.createUserHwDay04;
import static io.restassured.RestAssured.given;

public class updateUser extends petStore {
    @Test
    public void updateUser() throws JsonProcessingException {
        spec.pathParams("first", "v2",
                "second", "user",
                "third", "xiad3");

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
        createUserHwDay04 payload = objectMapper.readValue(expectedStr, createUserHwDay04.class);

        Response response = given(spec).body(payload).put("{first}/{second}/{third}");
        response.prettyPrint();

        Assert.assertEquals(200, response.statusCode());

        JsonPath json = response.jsonPath();
        String message = json.getString("message");
        System.out.println("message = " + message);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(message, "11");


    }
}