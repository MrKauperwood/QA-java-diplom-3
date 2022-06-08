package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellarburgers.resources.RegistrationFormFields;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static stellarburgers.pages.MainConstructorPage.checkConstructorPageIsOpenedAfterLogin;
import static stellarburgers.pages.RegisterNewUserPage.checkRegisterNewUserPageIsOpened;
import static stellarburgers.resources.Constants.LOGIN_PAGE_URL;
import static stellarburgers.resources.Constants.WAITING_TIME;
import static stellarburgers.resources.RegistrationFormFields.EMAIL;
import static stellarburgers.resources.RegistrationFormFields.PASSWORD;

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
        loginPageAttribute.shouldBe(visible, Duration.ofSeconds(WAITING_TIME));
    }

    @Step("Click on register new user button")
    public static RegisterNewUserPage clickOnRegisterNewUserButton() {
        registerNewUserButton.shouldBe(visible, Duration.ofSeconds(WAITING_TIME)).click();
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

    public static MainConstructorPage clickOnSignInButtonOnLoginPage() {
        logInButton.shouldBe(visible).click();
        return page(MainConstructorPage.class);
    }

    @Step("Fill all data in login form")
    public static void fillDataInLoginForm(String email, String password) {
        fillInTheAuthorizationField(EMAIL, email);
        fillInTheAuthorizationField(PASSWORD, password);
    }

    @Step("Fill all data in login form and confirm")
    public static void fillAllDataInLoginFormAndConfirm(String email, String password) {
        fillDataInLoginForm(email, password);
        clickOnSignInButtonOnLoginPage();
        checkConstructorPageIsOpenedAfterLogin();
    }

    @Step("Open login page with confirmation")
    public static LoginPage openLoginPage() {
        open(LOGIN_PAGE_URL, LoginPage.class);
        checkLoginPageIsOpened();
        return page(LoginPage.class);
    }

    @Step("Open register page from login page")
    public static RegisterNewUserPage openRegisterPageFromLoginPage() {
        clickOnRegisterNewUserButton();
        checkRegisterNewUserPageIsOpened();
        return page(RegisterNewUserPage.class);
    }

}
