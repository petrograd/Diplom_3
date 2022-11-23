package pageobject;


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
    public String getUrl() {
        return URL;
    }

    public void waitRegButton() {

        waitForElement(completeRegistrationButton);

    }

    public void sendKeysName(String name) {
        nameInputField.sendKeys(name);
    }

    public void sendKeysEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void sendKeysPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickRegButton() {
        completeRegistrationButton.click();
    }

    public void waitError() {
        waitForElement(passwordError);
    }


    public String getError() {
        return passwordError.getText();
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public void registerUser(String name, String email, String password) {
        sendKeysName(name);
        sendKeysEmail(email);
        sendKeysPassword(password);
        clickRegButton();
    }
}
