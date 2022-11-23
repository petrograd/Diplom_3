package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasicPages {
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    // локатор для кнопки 'Восстановить'
    @FindBy(xpath = ".//button[text()='Восстановить']")
    private WebElement restorePasswordButton;

    // локатор для ссылки 'Войти'
    @FindBy(linkText = "Войти")
    private WebElement loginLink;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return URL;
    }

    public void waitRestorePasswordButton() {
        waitForElement(restorePasswordButton);
    }

    public void clickSignInLink() {
        loginLink.click();
    }
}
