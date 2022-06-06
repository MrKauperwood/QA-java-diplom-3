package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class AuthorizationPage {

    // authorization page attribute
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Вход')]")
    private SelenideElement authorizationPageAttribute;

    // register new user button
    @FindBy(how = How.CSS, using = "a[href='/register']")
    private SelenideElement registerNewUserButton;

    // forgot password button
    @FindBy(how = How.CSS, using = "a[href='/forgot-password']")
    private SelenideElement forgotPasswordButton;
}
