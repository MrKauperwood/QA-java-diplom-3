package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class RegisterNewUserPage {

    // Register new user page attribute
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Регистрация')]")
    private SelenideElement registerNewUserPageAttribute;

    // name input field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Имя')]/parent::div/input")
    private SelenideElement nameInputField;

    // email input field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Email')]/parent::div/input")
    private SelenideElement emailInputField;

    // password input field
    @FindBy(how = How.CSS, using = "input[type='password']")
    private SelenideElement registerNewUserButton;

    // register button
    @FindBy(how = How.CSS, using = ".Auth_form__3qKeq button")
    private SelenideElement registerButton;

    // incorrect password error message
    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'Некорректный пароль')]")
    private SelenideElement incorrectPasswordErrorMessage;

    // sign in button
    @FindBy(how = How.CSS, using = "a[href='/login']")
    private SelenideElement signInButton;

}
