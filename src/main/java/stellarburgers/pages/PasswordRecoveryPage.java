package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

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
        passwordRecoveryPageAttribute.shouldBe(visible, Duration.ofSeconds(30));
    }

    @Step("Click on sign in button on password recovery page")
    public static void clickOnSignInButtonOnPasswordRecoveryPage() {
        signInButton.shouldBe(visible).click();
    }
}
