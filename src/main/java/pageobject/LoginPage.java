package pageobject;

import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasicPages{
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    // локатор для кнопки 'Войти'
    @FindBy(xpath = ".//button[text()='Войти']")
    private WebElement logInButton;

    // локатор для поля 'Email'
    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement emailInputField;

    // локатор для поля 'Пароль'
    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement passwordInputField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return URL;
    }
    public void waitSignInButton() {
        waitForElement(logInButton); //P
     }

    public void sendKeysEmail(String email) {
        emailInputField.sendKeys(email);
    }

    public void sendKeysPassword(String password) {
        passwordInputField.sendKeys(password);
    }
    public void clickSignInButton() {
        logInButton.click();
    }

    @Step("Ожидание загрузки страницы")
    public LoginPage waitForPage() {
        waitForElement(logInButton);
        return this;
    }

    public void signIn(String email, String password) {
        waitSignInButton();
        sendKeysEmail(email);
        sendKeysPassword(password);
        clickSignInButton();
    }
}
