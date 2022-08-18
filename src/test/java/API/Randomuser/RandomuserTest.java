package API.Randomuser;

import API.Randomuser.models.RandomUsers;
import API.Randomuser.pojo.Info;
import API.Randomuser.pojo.ResultsItem;
import API.Randomuser.pojo.UserPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomuserTest {

    @Test
    public void withoutParameters()  {
        UserPojo user = RandomUsers.getUser();
        assertThat(user.getInfo()).extracting(Info::getResults).isEqualTo(1).isEqualTo(user.getResults().size());
    }

    @Test
    public void withParameterResults() {
        UserPojo users = RandomUsers.getUserWithParameter("results", "5");
        assertThat(users.getInfo()).extracting(Info::getResults).isEqualTo(5).isEqualTo(users.getResults().size());
    }

    @Test
    public void withParameterGenderFemale() {
        UserPojo users = RandomUsers.getUserWithParameter("gender", "female");
        assertThat(users.getResults().get(0)).extracting(ResultsItem::getGender).isEqualTo("female");
    }

    @Test
    public void withParameterGenderMale() {
        UserPojo users = RandomUsers.getUserWithParameter("gender", "male");
        assertThat(users.getResults().get(0)).extracting(ResultsItem::getGender).isEqualTo("male");
    }

    @Test
    public void withParameterSeeds() {
        UserPojo user1 = RandomUsers.getUserWithParameter("seed", "test");
        UserPojo user2 = RandomUsers.getUserWithParameter("seed", "test");

        assertThat(user1.getInfo()).extracting(Info::getSeed).isEqualTo(user2.getInfo().getSeed());
    }

    @Test
    public void withParameterFormat() {
        given()
                .param("format", "XML")
                .contentType(ContentType.JSON)
                .when().get("https://randomuser.me/api/")
                .then().statusCode(200)
                .contentType(ContentType.XML);
    }

    @Test
    public void withParameterNat() {
        UserPojo users = RandomUsers.getUserWithParameter("nat", "FI");
        assertThat(users.getResults().get(0)).extracting(ResultsItem::getNat).isEqualTo("FI");
    }

    @Test
    public void withMultipleParameters() {
        ObjectMapper objectMapper = new ObjectMapper();
        UserPojo users;
        try {
            users =
                    objectMapper.readValue(
                            given()
                                    .param("gender", "female")
                                    .param("results", "3")
                                    .param("nat", "FI")
                                    .contentType(ContentType.JSON)
                                    .when().get("https://randomuser.me/api/")
                                    .then().statusCode(200)
                                    .extract().asString(),
                            UserPojo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        assertThat(users.getResults().stream().count()).isEqualTo(3);
        users.getResults().stream().map(ResultsItem::getGender).forEach(i -> assertThat(i).isEqualTo("female"));
        users.getResults().stream().map(ResultsItem::getNat).forEach(i -> assertThat(i).isEqualTo("FI"));
    }

    @Test
    public void parameterException() {
        UserPojo users = RandomUsers.getUserWithParameter("exc", "login");
        assertThat(users.getResults().get(0)).extracting(ResultsItem::getLogin).isNull();
    }

    @Test
    public void withSpecialParameters(){
        ObjectMapper objectMapper = new ObjectMapper();
        UserPojo users;
        try {
            users =
                    objectMapper.readValue(
                            given()
                                    .param("gender", "female")
                                    .param("name", "Evelina")
                                    .param("nat", "FI")
                                    .contentType(ContentType.JSON)
                                    .when().get("https://randomuser.me/api/")
                                    .then().statusCode(200)
                                    .extract().asString(),
                            UserPojo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        assertThat(users.getResults().get(0)).extracting(ResultsItem::getGender).isNotNull();
        assertThat(users.getResults().get(0)).extracting(ResultsItem::getName).isNotNull();
        assertThat(users.getResults().get(0)).extracting(ResultsItem::getNat).isNotNull();
    }

    @Test
    public void withInvalidParametersInc(){
        UserPojo users = RandomUsers.getUserWithParameter("inc", "0");
        assertThat(users).extracting(UserPojo::getResults).isNull();
    }

    @Test
    public void withInvalidParametersNat(){
        UserPojo users = RandomUsers.getUserWithParameter("nat", "аб");
        assertThat(users.getResults().get(0)).extracting(ResultsItem::getLogin).isNull();
    }

    @Test
    public void withInvalidParametersGender(){
        UserPojo users = RandomUsers.getUserWithParameter("gender", "10");
        assertThat(users.getResults().get(0)).extracting(ResultsItem::getLogin).isNull();
    }


}
