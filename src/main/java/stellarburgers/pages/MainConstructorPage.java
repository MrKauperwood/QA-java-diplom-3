package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellarburgers.resources.BurgerComponentsField;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static stellarburgers.pages.LoginPage.checkLoginPageIsOpened;
import static stellarburgers.pages.PersonalCabinetPage.checkPersonalCabinetPageIsOpened;
import static stellarburgers.resources.Constants.*;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class MainConstructorPage {

    // constructor page attribute
    @FindBy(how = How.XPATH, using = "//h1[contains(text(), 'Соберите бургер')]")
    private static SelenideElement constructorPageAttribute;

    // sign in button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Войти в аккаунт')]")
    private static SelenideElement signInButton;

    // confirm order button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Оформить заказ')]")
    private static SelenideElement confirmOrderButton;

    // bun tab button
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Булки')]")
    private static SelenideElement bunTabButton;

    // selected bun tab button
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span[contains(text(), 'Булки')]/parent::div")
    private static SelenideElement selectedBunTabButton;

    // sauce tab button
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Соусы')]")
    private static SelenideElement sauceTabButton;

    // selected sauce tab button
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span[contains(text(), 'Соусы')]/parent::div")
    private static SelenideElement selectedSauceTabButton;

    // filling tab button
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Начинки')]")
    private static SelenideElement fillingTabButton;

    // selected filling tab button
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span[contains(text(), 'Начинки')]/parent::div")
    private static SelenideElement selectedFillingTabButton;

    // personal cabinet button
    @FindBy(how = How.CSS, using = "a[href='/account']")
    private static SelenideElement personalCabinetButton;

    // logo button
    @FindBy(how = How.CSS, using = ".AppHeader_header__logo__2D0X2")
    private static SelenideElement logoButton;

    // constructor button
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Конструктор')]")
    private static SelenideElement constructorButton;


    @Step("Click on personal cabinet button")
    public static LoginPage clickOnPersonalCabinetButton() {
        personalCabinetButton.shouldBe(visible).click();
        return page(LoginPage.class);
    }

    @Step("Click on personal cabinet button after authorization")
    public static PersonalCabinetPage clickOnPersonalCabinetButtonAfterAuthorization() {
        personalCabinetButton.shouldBe(visible).click();
        return page(PersonalCabinetPage.class);
    }

    @Step("Check constructor page is opened")
    public static void checkConstructorPageIsOpened() {
        constructorPageAttribute.shouldBe(visible, Duration.ofSeconds(WAITING_TIME));
    }

    @Step("Check confirm order button is displayed")
    public static void checkConfirmOrderButtonIsDisplayed() {
        confirmOrderButton.shouldBe(visible);
    }

    @Step("Click on Sign In button")
    public static LoginPage clickOnSignInButton() {
        signInButton.shouldBe(visible).click();
        return page(LoginPage.class);
    }

    @Step("Click on logo button")
    public static MainConstructorPage clickOnLogoButton() {
        logoButton.shouldBe(visible).click();
        return page(MainConstructorPage.class);
    }

    @Step("Click on constructor button")
    public static MainConstructorPage clickOnConstructorButton() {
        constructorButton.shouldBe(visible).click();
        return page(MainConstructorPage.class);
    }

    public static void clickOnComponentField(BurgerComponentsField component) {
        switch (component) {
            case BUN -> bunTabButton.shouldBe(visible, Duration.ofSeconds(SMALL_WAITING_TIME)).click();
            case SAUCES -> sauceTabButton.shouldBe(visible, Duration.ofSeconds(SMALL_WAITING_TIME)).click();
            case FILLING -> fillingTabButton.shouldBe(visible, Duration.ofSeconds(SMALL_WAITING_TIME)).click();
            default -> System.out.println("Incorrect parameter");
        }
    }

    @Step("Check component is selected")
    public static void checkComponentIsSelected(BurgerComponentsField component) {
        switch (component) {
            case BUN -> selectedBunTabButton.shouldBe(visible, Duration.ofSeconds(SMALL_WAITING_TIME));
            case SAUCES -> selectedSauceTabButton.shouldBe(visible, Duration.ofSeconds(SMALL_WAITING_TIME));
            case FILLING -> selectedFillingTabButton.shouldBe(visible, Duration.ofSeconds(SMALL_WAITING_TIME));
            default -> System.out.println("Incorrect parameter");
        }
    }

    @Step("Check constructor page is opened after login")
    public static void checkConstructorPageIsOpenedAfterLogin() {
        checkConstructorPageIsOpened();
        checkConfirmOrderButtonIsDisplayed();
    }

    @Step("Open personal cabinet after login")
    public static void openPersonalCabinetAfterLogin() {
        clickOnPersonalCabinetButtonAfterAuthorization();
        checkPersonalCabinetPageIsOpened();
    }

    @Step("Open constructor page with confirmation")
    public static void openMainConstructorPage() {
        open(MAIN_PAGE_URL, MainConstructorPage.class);
        checkConstructorPageIsOpened();
    }

    public static void openPersonalCabinetPage() {
        clickOnPersonalCabinetButtonAfterAuthorization();
        checkPersonalCabinetPageIsOpened();
    }

    public static void openLoginPageViaSignInButton() {
        clickOnSignInButton();
        checkLoginPageIsOpened();
    }
}
