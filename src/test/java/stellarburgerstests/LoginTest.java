package stellarburgerstests;

import org.junit.Test;
import stellarburgers.pages.MainConstructorPage;
import stellarburgers.pages.PasswordRecoveryPage;
import stellarburgers.pages.RegisterNewUserPage;

import static com.codeborne.selenide.Selenide.open;

import static stellarburgers.pages.LoginPage.checkLoginPageIsOpened;
import static stellarburgers.pages.MainConstructorPage.checkConstructorPageIsOpened;
import static stellarburgers.pages.MainConstructorPage.clickOnPersonalCabinetButton;
import static stellarburgers.pages.PasswordRecoveryPage.checkPasswordRecoveryPageIsOpened;
import static stellarburgers.pages.PasswordRecoveryPage.clickOnSignInButtonOnPasswordRecoveryPage;
import static stellarburgers.pages.RegisterNewUserPage.*;
import static stellarburgers.resources.Constants.*;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class LoginTest {

    @Test
    public void checkLoginPageOpensAfterClickOnPersonalCabinetButton() {
        open(MAIN_PAGE_URL, MainConstructorPage.class);
        checkConstructorPageIsOpened();

        clickOnPersonalCabinetButton();
        checkLoginPageIsOpened();
    }

    @Test
    public void checkLoginPageOpensAfterClickOnLogInFromRegistrationPage() {
        open(REGISTRATION_PAGE_URL, RegisterNewUserPage.class);
        checkRegisterNewUserPageIsOpened();

        clickOnSignInButtonOnRegistrationPage();
        checkLoginPageIsOpened();
    }

    @Test
    public void checkLoginPageOpensAfterClickOnLogInFromPasswordRecoveryPage() {
        open(PASSWORD_RECOVERY_PAGE_URL, PasswordRecoveryPage.class);
        checkPasswordRecoveryPageIsOpened();

        clickOnSignInButtonOnPasswordRecoveryPage();
        checkLoginPageIsOpened();
    }
}
