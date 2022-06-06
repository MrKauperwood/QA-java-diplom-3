package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class MainConstructorPage {

    // constructor page attribute
    @FindBy(how = How.XPATH, using = "//h1[contains(text(), 'Соберите бургер')]")
    private SelenideElement constructorPageAttribute;

    // sign in button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Войти в аккаунт')]")
    private SelenideElement signInButton;

    // confirm order button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Оформить заказ')]")
    private SelenideElement confirmOrderButton;

    // bun tab button
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Булки')]")
    private SelenideElement bunTabButton;

    // selected bun tab button
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span[contains(text(), 'Булки')]")
    private SelenideElement selectedBunTabButton;

    // sauce tab button
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Соусы')]")
    private SelenideElement sauceTabButton;

    // selected sauce tab button
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span[contains(text(), 'Соусы')]")
    private SelenideElement selectedSauceTabButton;


    // filling tab button
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Начинки')]")
    private SelenideElement fillingTabButton;

    // selected filling tab button
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span[contains(text(), 'Начинки')]")
    private SelenideElement selectedFillingTabButton;
}
