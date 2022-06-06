package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellarburgers.resources.RegistrationFormFields;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class RegisterNewUserPage {

    // Register new user page attribute
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Регистрация')]")
    private static SelenideElement registerNewUserPageAttribute;

    // name input field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Имя')]/parent::div/input")
    private static SelenideElement nameRegInputField;

    // email input field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Email')]/parent::div/input")
    private static SelenideElement emailRegInputField;

    // password input field
    @FindBy(how = How.CSS, using = "input[type='password']")
    private static SelenideElement passwordRegInputField;

    // register button
    @FindBy(how = How.CSS, using = ".Auth_form__3qKeq button")
    private static SelenideElement registerButton;

    // incorrect password error message
    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'Некорректный пароль')]")
    private static SelenideElement incorrectPasswordErrorMessage;

    // sign in button
    @FindBy(how = How.CSS, using = "a[href='/login']")
    private static SelenideElement signInButton;


    @Step("Check that registerNewUserPage is opened")
    public static void checkRegisterNewUserPageIsOpened() {
        registerNewUserPageAttribute.shouldBe(visible);
    }

    @Step("Check that incorrectPasswordErrorMessage is displayed")
    public static void checkIncorrectPasswordErrorMessageIsDisplayed() {
        incorrectPasswordErrorMessage.shouldBe(visible);
    }

    @Step("Fill value in the registration field")
    public static void fillInTheRegistrationField(RegistrationFormFields fieldName, String value) {
        switch (fieldName) {
            case NAME -> nameRegInputField.setValue(value).pressEnter();
            case EMAIL -> emailRegInputField.setValue(value).pressEnter();
            case PASSWORD -> passwordRegInputField.setValue(value).pressEnter();
            default -> System.out.println("Incorrect parameter");
        }
    }

    @Step("Click on register button")
    public static void clickOnRegisterButton() {
        registerButton.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    @Step("Click on sign in button on registration page")
    public static void clickOnSignInButtonOnRegistrationPage() {
        signInButton.shouldBe(visible).click();
    }
}
