package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class PersonalCabinetPage {

    // personal cabinet page attribute
    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'В этом разделе вы можете изменить свои персональные данные')]")
    private SelenideElement personalCabinetPageAttribute;

    // logout button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Выход')]")
    private SelenideElement logoutButton;

}
