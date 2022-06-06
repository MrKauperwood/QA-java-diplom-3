package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellarburgers.resources.RegistrationFormFields;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class LoginPage {

    // login page attribute
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Вход')]")
    private static SelenideElement loginPageAttribute;

    // register new user button
    @FindBy(how = How.CSS, using = "a[href='/register']")
    private static SelenideElement registerNewUserButton;

    // forgot password button
    @FindBy(how = How.CSS, using = "a[href='/forgot-password']")
    private static SelenideElement forgotPasswordButton;

    // email input field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Email')]/parent::div/input")
    private static SelenideElement emailLoginInputField;

    // password input field
    @FindBy(how = How.CSS, using = "input[type='password']")
    private static SelenideElement passwordLoginInputField;

    // log in button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Войти')]")
    private static SelenideElement logInButton;


    @Step("Check login page is opened")
    public static void checkLoginPageIsOpened() {
        loginPageAttribute.shouldBe(visible, Duration.ofSeconds(30));
    }

    @Step("Click on register new user button")
    public static RegisterNewUserPage clickOnRegisterNewUserButton() {
        registerNewUserButton.shouldBe(visible).click();
        return page(RegisterNewUserPage.class);
    }

    @Step("Fill value in the login field")
    public static void fillInTheAuthorizationField(RegistrationFormFields fieldName, String value) {
        switch (fieldName) {
            case EMAIL -> emailLoginInputField.setValue(value);
            case PASSWORD -> passwordLoginInputField.setValue(value);
            default -> System.out.println("Incorrect parameter");
        }
    }

    @Step("Click on log in button on Login page")
    public static MainConstructorPage clickOnSignInButtonOnLoginPage() {
        logInButton.shouldBe(visible).click();
        return page(MainConstructorPage.class);
    }

}
