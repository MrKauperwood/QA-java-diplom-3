package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class PersonalCabinetPage {

    // personal cabinet page attribute
    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'В этом разделе вы можете изменить свои персональные данные')]")
    private static SelenideElement personalCabinetPageAttribute;

    // logout button
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Выход')]")
    private static SelenideElement logoutButton;

    @Step("Check that personal cabinet is opened")
    public static void checkPersonalCabinetPageIsOpened() {
        personalCabinetPageAttribute.shouldBe(visible, Duration.ofSeconds(30));
    }

    @Step("Click on logout button")
    public static LoginPage clickOnLogoutButton() {
        logoutButton.shouldBe(visible).click();
        return page(LoginPage.class);
    }

}
