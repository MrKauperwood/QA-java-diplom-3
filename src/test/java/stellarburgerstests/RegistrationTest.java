package stellarburgerstests;

import org.junit.After;
import org.junit.Test;
import stellarburgers.pages.MainConstructorPage;
import stellarburgers.pages.RegisterNewUserPage;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;
import static stellarburgers.apiresources.UserSteps.deleteUser;
import static stellarburgers.apiresources.UserSteps.getToken;
import static stellarburgers.pages.LoginPage.*;
import static stellarburgers.pages.MainConstructorPage.*;
import static stellarburgers.pages.MainConstructorPage.checkConstructorPageIsOpened;
import static stellarburgers.pages.RegisterNewUserPage.*;
import static stellarburgers.resources.Constants.*;
import static stellarburgers.resources.RegistrationFormFields.*;
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
        if (newUserData != null && isUserDataRegister) {
            String token = getToken(newUserData);
            deleteUser(token);
        }
    }

    @Test
    public void checkSuccessfulUserRegistration() {
        open(MAIN_PAGE_URL, MainConstructorPage.class);
        checkConstructorPageIsOpened();

        clickOnSignInButton();
        checkLoginPageIsOpened();

        clickOnRegisterNewUserButton();
        checkRegisterNewUserPageIsOpened();

        newUserData = generateDataForNewUser();
        fillInTheRegistrationField(NAME, newUserData.get("name"));
        fillInTheRegistrationField(PASSWORD, newUserData.get("password"));
        fillInTheRegistrationField(EMAIL, newUserData.get("email"));

        clickOnRegisterButton();
        checkLoginPageIsOpened();

        isUserDataRegister = true;
        fillInTheAuthorizationField(EMAIL, newUserData.get("email"));
        fillInTheAuthorizationField(PASSWORD, newUserData.get("password"));

        clickOnSignInButtonOnLoginPage();

        checkConstructorPageIsOpened();
        checkConfirmOrderButtonIsDisplayed();
    }

    @Test
    public void checkRegistrationWithIncorrectPassword() {
        open(REGISTRATION_PAGE_URL, RegisterNewUserPage.class);
        checkRegisterNewUserPageIsOpened();

        HashMap<String, String> newUserData = generateDataForNewUser();
        fillInTheRegistrationField(NAME, newUserData.get("name"));
        fillInTheRegistrationField(PASSWORD, "123");
        fillInTheRegistrationField(EMAIL, newUserData.get("email"));

        clickOnRegisterButton();

        checkRegisterNewUserPageIsOpened();
        checkIncorrectPasswordErrorMessageIsDisplayed();

    }
}
