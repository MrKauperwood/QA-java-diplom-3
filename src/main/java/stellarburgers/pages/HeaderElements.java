package stellarburgers.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class HeaderElements {

    // personal cabinet button
    @FindBy(how = How.CSS, using = "a[href='/account']")
    private SelenideElement personalCabinetButton;

    // logo button
    @FindBy(how = How.CSS, using = ".AppHeader_header__logo__2D0X2")
    private SelenideElement logoButton;

    // constructor button
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;

}
