package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class PasswordRecoveryPage {

    // password recovery page attribute
    @FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Восстановление пароля')]")
    private SelenideElement passwordRecoveryPageAttribute;

    // sign in button
    @FindBy(how = How.CSS, using = "a[href='/login']")
    private SelenideElement signInButton;
}
