package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasicPages {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    // локатор для кнопки 'Зарегистрироваться'
    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement completeRegistrationButton;

    // локатор для поля 'Имя'
    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement nameInputField;

    // локатор для поля 'Email'
    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement emailInput;

    // локатор для поля 'Пароль'
    @FindBy(xpath = ".//fieldset[3]//input")
    private WebElement passwordInput;

    // локатор для ошибки 'Некорректный пароль'
    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement passwordError;

    // локатор для ссылки 'Войти'
    @FindBy(linkText = "Войти")
    private WebElement signInLink;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение URL страницы")
    public String getUrl() {
        return URL;
    }

    @Step("Ждем отображения на странице кнопки Регистрация")
    public void waitRegButton() {
        waitForElement(completeRegistrationButton);
    }

    @Step("Ввод данных в поле Имя")
    public void sendKeysName(String name) {
        nameInputField.sendKeys(name);
    }

    @Step("Ввод данных в поле Email")
    public void sendKeysEmail(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Ввод данных в поле Пароль")
    public void sendKeysPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Жмем кнопку Регистрация")
    public void clickRegButton() {
        completeRegistrationButton.click();
    }

    @Step("Ждем появления элемента \"Некорректный пароль\"")
    public void waitError() {
        waitForElement(passwordError);
    }

    @Step("Получаем текст сообщения \"Некорректный пароль\"")
    public String getError() {
        return passwordError.getText();
    }

    @Step("Жмем кнопку \"Войти\"")
    public void clickSignInLink() {
        signInLink.click();
    }

    @Step("Регистрация аккаунта с данными")
    public void registerUser(String name, String email, String password) {
        sendKeysName(name);
        sendKeysEmail(email);
        sendKeysPassword(password);
        clickRegButton();
    }
}
