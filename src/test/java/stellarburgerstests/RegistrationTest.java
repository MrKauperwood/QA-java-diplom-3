package stellarburgerstests;

import org.junit.After;
import org.junit.Test;

import java.util.HashMap;

import static stellarburgers.apiresources.UserSteps.*;
import static stellarburgers.pages.LoginPage.*;
import static stellarburgers.pages.MainConstructorPage.*;
import static stellarburgers.pages.RegisterNewUserPage.*;
import static stellarburgers.resources.Steps.generateDataForNewUser;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class RegistrationTest {

    private HashMap<String, String> newUserData;
    boolean isUserDataRegister = false;

    @After
    public void setDown() {
        cleanDataAfterTest();
    }

    @Test
    public void checkSuccessfulUserRegistration() {
        openMainConstructorPage();
        openLoginPageViaSignInButton();
        openRegisterPageFromLoginPage();
        newUserData = generateDataForNewUser();
        fillAllDataInRegistrationFormAndConfirm(
                newUserData.get("name"),
                newUserData.get("password"),
                newUserData.get("email"));
        isUserDataRegister = true;
        fillAllDataInLoginFormAndConfirm(
                newUserData.get("email"),
                newUserData.get("password"));

        checkConstructorPageIsOpenedAfterLogin();
    }

    @Test
    public void checkRegistrationWithIncorrectPassword() {
        openRegisterNewUserPage();
        newUserData = generateDataForNewUser();
        fillAllDataInRegistrationFormAndConfirmForIncorrectData(
                newUserData.get("name"),
                "123",
                newUserData.get("email"));

        checkIncorrectPasswordErrorMessageIsDisplayed();
    }

    public void cleanDataAfterTest() {
        if (newUserData != null && isUserDataRegister) {
            String token = getToken(newUserData);
            deleteUser(token);
        }
    }
}
