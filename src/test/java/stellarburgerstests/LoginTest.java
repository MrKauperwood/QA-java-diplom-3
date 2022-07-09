package stellarburgerstests;

import org.junit.Test;

import static stellarburgers.pages.LoginPage.checkLoginPageIsOpened;
import static stellarburgers.pages.MainConstructorPage.*;
import static stellarburgers.pages.PasswordRecoveryPage.clickOnSignInButtonOnPasswordRecoveryPage;
import static stellarburgers.pages.PasswordRecoveryPage.openPasswordRecoveryPage;
import static stellarburgers.pages.RegisterNewUserPage.*;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class LoginTest {

    @Test
    public void checkLoginPageOpensAfterClickOnPersonalCabinetButton() {
        openMainConstructorPage();
        clickOnPersonalCabinetButton();
        checkLoginPageIsOpened();
    }

    @Test
    public void checkLoginPageOpensAfterClickOnLogInFromRegistrationPage() {
        openRegisterNewUserPage();
        clickOnSignInButtonOnRegistrationPage();
        checkLoginPageIsOpened();
    }

    @Test
    public void checkLoginPageOpensAfterClickOnLogInFromPasswordRecoveryPage() {
        openPasswordRecoveryPage();
        clickOnSignInButtonOnPasswordRecoveryPage();
        checkLoginPageIsOpened();
    }
}
