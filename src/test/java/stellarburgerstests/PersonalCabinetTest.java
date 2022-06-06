package stellarburgerstests;

import org.junit.After;
import org.junit.Test;
import stellarburgers.apiresources.responses.FullUserInformation;

import static stellarburgers.apiresources.UserSteps.*;
import static stellarburgers.pages.LoginPage.*;
import static stellarburgers.pages.MainConstructorPage.*;
import static stellarburgers.pages.PersonalCabinetPage.clickOnLogoutButton;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class PersonalCabinetTest {

    boolean isUserDataRegister = false;
    FullUserInformation fullUserInformation = null;

    @After
    public void tearDown() {
        cleanDataAfterTest();
    }

    @Test
    public void checkLogoutWorksFromPersonalCabinet() {
        prepareData();
        openLoginPage();

        fillAllDataInLoginFormAndConfirm(
                fullUserInformation.getUserData().getEmail(),
                fullUserInformation.getUserData().getPassword());
        openPersonalCabinetPage();

        clickOnLogoutButton();
        checkLoginPageIsOpened();
    }

    public void cleanDataAfterTest() {
        if (fullUserInformation != null && isUserDataRegister) {
            String token = getTokenFromClass(fullUserInformation.getUserData());
            deleteUser(token);
        }
    }

    private void prepareData() {
        fullUserInformation = registerNewUser();
        isUserDataRegister = true;
    }
}
