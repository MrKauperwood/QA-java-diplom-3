package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static stellarburgers.resources.Constants.PASSWORD_RECOVERY_PAGE_URL;
import static stellarburgers.resources.Constants.WAITING_TIME;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class PasswordRecoveryPage {

    // password recovery page attribute
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Восстановление пароля')]")
    private static SelenideElement passwordRecoveryPageAttribute;

    // sign in button
    @FindBy(how = How.CSS, using = "a[href='/login']")
    private static SelenideElement signInButton;

    @Step("Check password recovery page is opened")
    public static void checkPasswordRecoveryPageIsOpened() {
        passwordRecoveryPageAttribute.shouldBe(visible, Duration.ofSeconds(WAITING_TIME));
    }

    @Step("Click on sign in button on password recovery page")
    public static LoginPage clickOnSignInButtonOnPasswordRecoveryPage() {
        signInButton.shouldBe(visible).click();
        return page(LoginPage.class);
    }

    @Step("Open password recovery page")
    public static void openPasswordRecoveryPage() {
        open(PASSWORD_RECOVERY_PAGE_URL, PasswordRecoveryPage.class);
        checkPasswordRecoveryPageIsOpened();
    }
}
