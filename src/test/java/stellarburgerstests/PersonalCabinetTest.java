package stellarburgerstests;

import org.junit.After;
import org.junit.Test;
import stellarburgers.apiresources.responses.FullUserInformation;
import stellarburgers.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static stellarburgers.apiresources.UserSteps.*;
import static stellarburgers.pages.LoginPage.*;
import static stellarburgers.pages.MainConstructorPage.*;
import static stellarburgers.pages.PersonalCabinetPage.checkPersonalCabinetPageIsOpened;
import static stellarburgers.pages.PersonalCabinetPage.clickOnLogoutButton;
import static stellarburgers.resources.Constants.LOGIN_PAGE_URL;
import static stellarburgers.resources.RegistrationFormFields.EMAIL;
import static stellarburgers.resources.RegistrationFormFields.PASSWORD;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class PersonalCabinetTest {

    boolean isUserDataRegister = false;
    FullUserInformation fullUserInformation = null;

    @After
    public void setDown() {
        if (fullUserInformation != null && isUserDataRegister) {
            String token = getTokenFromClass(fullUserInformation.getUserData());
            deleteUser(token);
        }
    }

    @Test
    public void checkLogoutWorksFromPersonalCabinet() {
        fullUserInformation = registerNewUser();

        open(LOGIN_PAGE_URL, LoginPage.class);
        checkLoginPageIsOpened();

        isUserDataRegister = true;
        fillInTheAuthorizationField(EMAIL, fullUserInformation.getUserData().getEmail());
        fillInTheAuthorizationField(PASSWORD, fullUserInformation.getUserData().getPassword());

        clickOnSignInButtonOnLoginPage();

        checkConstructorPageIsOpened();
        checkConfirmOrderButtonIsDisplayed();

        clickOnPersonalCabinetButtonAfterAuthorization();
        checkPersonalCabinetPageIsOpened();

        clickOnLogoutButton();
        checkLoginPageIsOpened();
    }
}
