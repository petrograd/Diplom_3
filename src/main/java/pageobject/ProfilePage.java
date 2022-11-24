package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasicPages {
    public static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    // локатор для ссылки 'Профиль'
    @FindBy(linkText = "Профиль")
    private WebElement profileLink;

    @FindBy(className = "AppHeader_header__logo__2D0X2")
    private WebElement burgerLogo;

    @FindBy(linkText = "Конструктор")
    private WebElement constructorLogo;

    // локатор для кнопки 'Выход'
    @FindBy(xpath = ".//button[text()='Выход']")
    private WebElement exitButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return URL;
    }

    public void waitProfileLink() {
        waitForElement(profileLink);
    }

    public boolean profileDisplayed() {
        waitForElement(profileLink);
        return profileLink.isDisplayed();
    }

    public LoginPage clickOnExitButton() {
        waitForElement(exitButton);
        exitButton.click();
        return new LoginPage(driver);
    }

    public HomePage goHomeByClickingBurgerLogo() {
        waitForElement(burgerLogo);
        burgerLogo.click();
        return new HomePage(driver);
    }

    public HomePage goHomeByClickingConstructorLogo() {
        waitForElement(constructorLogo);
        constructorLogo.click();
        return new HomePage(driver);
    }
}
