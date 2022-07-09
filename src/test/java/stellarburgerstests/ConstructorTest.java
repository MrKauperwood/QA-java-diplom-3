package stellarburgerstests;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Test;
import stellarburgers.apiresources.responses.FullUserInformation;
import stellarburgers.resources.BurgerComponentsField;

import static stellarburgers.apiresources.UserSteps.*;
import static stellarburgers.pages.LoginPage.*;
import static stellarburgers.pages.MainConstructorPage.*;
import static stellarburgers.resources.BurgerComponentsField.*;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class ConstructorTest {

    boolean isUserDataRegister = false;
    FullUserInformation fullUserInformation = null;

    @After
    public void tearDown() {
        cleanDataAfterTest();
    }

    @Test
    public void checkConstructorPageOpensAfterClickOnLogoButtonFromPersonalCabinet() {
        prepareData();
        openLoginPage();
        fillAllDataInLoginFormAndConfirm(
                fullUserInformation.getUserData().getEmail(),
                fullUserInformation.getUserData().getPassword());
        openPersonalCabinetAfterLogin();

        clickOnLogoButton();

        checkConstructorPageIsOpened();
    }

    @Test
    public void checkConstructorPageOpensAfterClickOnConstructorButtonFromPersonalCabinet() {
        prepareData();
        openLoginPage();
        fillAllDataInLoginFormAndConfirm(
                fullUserInformation.getUserData().getEmail(),
                fullUserInformation.getUserData().getPassword());
        openPersonalCabinetAfterLogin();

        clickOnConstructorButton();

        checkConstructorPageIsOpened();
    }

    @Test
    public void checkSwitchingBetweenSectionsIsWork() {
        openMainConstructorPage();

        checkComponentIsSelected(BUN);
        checkSwitchingForTabIsWork(SAUCES);
        checkSwitchingForTabIsWork(FILLING);
        checkSwitchingForTabIsWork(BUN);
    }

    @Step("Prepare data for test")
    private void prepareData() {
        fullUserInformation = registerNewUser();
        isUserDataRegister = true;
    }

    @Step("Check switching is work for tab")
    private void checkSwitchingForTabIsWork(BurgerComponentsField field) {
        clickOnComponentField(field);
        checkComponentIsSelected(field);
    }

    @Step("Clean data after test")
    private void cleanDataAfterTest() {
        if (fullUserInformation != null && isUserDataRegister) {
            String token = getTokenFromClass(fullUserInformation.getUserData());
            deleteUser(token);
        }
    }

}
