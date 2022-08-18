package API.Randomuser;

import API.Randomuser.models.RandomUsers;
import API.Randomuser.pojo.Info;
import API.Randomuser.pojo.Login;
import API.Randomuser.pojo.ResultsItem;
import API.Randomuser.pojo.UserPojo;

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

//    @Test
//    public void withParameterPasswordsSpecial() {
//        UserPojo users = RandomUsers.getUserWithParameter("passwords", "special,32");
//        assertThat(users.getResults().get(0).getLogin()).extracting(Login::getPassword).isEqualTo();
//    }
//
//    @Test
//    public void withParameterPasswordsSpecial() {
//        UserPojo users = RandomUsers.getUserWithParameter("passwords", "special,32");
//        assertThat(users.getResults().get(0).getLogin()).extracting(Login::getPassword).isEqualTo();
//    }
//
//    @Test
//    public void withParameterPasswordsSpecial() {
//        UserPojo users = RandomUsers.getUserWithParameter("passwords", "special,32");
//        assertThat(users.getResults().get(0).getLogin()).extracting(Login::getPassword).isEqualTo();
//    }

    @Test
    public void withParameterSeeds() {
        UserPojo user1 = RandomUsers.getUserWithParameter("seed", "test");
        UserPojo user2 = RandomUsers.getUserWithParameter("seed", "test");

        assertThat(user1.getInfo()).extracting(Info::getSeed).isEqualTo(user2.getInfo().getSeed());
    }

}
