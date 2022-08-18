package API.Randomuser.models;

import API.Randomuser.pojo.UserPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RandomUsers {
    public static UserPojo getUser(){
        ObjectMapper objectMapper = new ObjectMapper();
        UserPojo users;
        try {
            users =
                    objectMapper.readValue(
                            given()
                                    .contentType(ContentType.JSON)
                                    .when().get("https://randomuser.me/api/")
                                    .then().statusCode(200)
                                    .extract().asString(),
                            UserPojo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static UserPojo getUserWithParameter(String param, String value){
        ObjectMapper objectMapper = new ObjectMapper();
        UserPojo users;
        try {
            users =
                    objectMapper.readValue(
                            given()
                                    .param(param, value)
                                    .contentType(ContentType.JSON)
                                    .when().get("https://randomuser.me/api/")
                                    .then().statusCode(200)
                                    .extract().asString(),
                            UserPojo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
