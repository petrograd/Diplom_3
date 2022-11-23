package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasicPages{
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";
    // локатор для кнопки 'Войти'
    @FindBy(xpath = ".//button[text()='Войти']")
    private WebElement logInButton;
    public final By signInButton = By.xpath(".//button[text()='Войти']");
    // локатор для поля 'Email'
    private final By emailInput = By.xpath(".//fieldset[1]//input");
    // локатор для поля 'Пароль'
    private final By passwordInput = By.xpath(".//fieldset[2]//input");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return URL;
    }
    public void waitSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(signInButton));
    }

    public void sendKeysEmail(String email) {
        WebElement element = driver.findElement(emailInput);
        element.sendKeys(email);
    }

    public void sendKeysPassword(String password) {
        WebElement element = driver.findElement(passwordInput);
        element.sendKeys(password);
    }
    public void clickSignInButton() {
        WebElement element = driver.findElement(signInButton);
        element.click();
    }

    //P
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
