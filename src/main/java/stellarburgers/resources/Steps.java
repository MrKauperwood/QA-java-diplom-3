package stellarburgers.resources;

import io.qameta.allure.Step;

import java.sql.Timestamp;
import java.util.HashMap;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class Steps {

    @Step("Generate data for new user")
    public static HashMap<String, String> generateDataForNewUser() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String name = randomAlphabetic(7) + " " + randomAlphabetic(10);
        String password = randomAlphanumeric(10);
        String email = "Ab" + timestamp.getTime() + "@gmail.com";

        HashMap<String, String> newUserData = new HashMap<>();
        newUserData.put("email", email);
        newUserData.put("password", password);
        newUserData.put("name", name);

        return newUserData;
    }

}
