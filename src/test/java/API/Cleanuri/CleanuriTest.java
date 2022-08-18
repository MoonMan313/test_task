package API.Cleanuri;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CleanuriTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/CleanuriValidData.csv")
    public void CheckForValidURL(String longLink, String shortLink){
        JSONObject request = new JSONObject();
        request.put("url", longLink);

        given()
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("https://cleanuri.com/api/v1/shorten")
                .then().statusCode(200)
                .body("result_url", equalTo(shortLink));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CleanuriInvalidData.csv")
    public void CheckForInvalidURL(String longLink, String error){
        JSONObject request = new JSONObject();
        request.put("url", longLink);

        given()
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("https://cleanuri.com/api/v1/shorten")
                .then().statusCode(400)
                .body("error", equalTo(error));
    }

}
