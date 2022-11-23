import extensions.DriverFactory;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.*;
import setup.SetUp;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginTest extends SetUp {
   // private WebDriver driver;
//    private LoginPage loginPage;
//    private HomePage homePage;

    @Before
    public void setup() {
        chromeDriverSetUp();
     //   driver = DriverFactory.getBrowser();
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     //openHomePage(); //P
        homePage = new HomePage(driver);
        driver.get(homePage.getUrl());
        driver.manage().window().maximize();
        homePage.waitSignIn();
    }

    @After
    public void teardown() {
        closeDriver();
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void shouldLoginFromHomePageAccountButton() {
        loginPage = new LoginPage(driver);
        homePage.clickSignInButton();
        loginPage.waitSignInButton();
        loginPage.sendKeysEmail(EMAIL);
        loginPage.sendKeysPassword(PASSWORD);
        loginPage.clickSignInButton();
        homePage.waitOrder();
        assertEquals(homePage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void shouldLoginFromHomePageLoginButton() {
        loginPage = new LoginPage(driver);
        homePage.clickAccountButton();
        loginPage.waitSignInButton();
        loginPage.sendKeysEmail(EMAIL);
        loginPage.sendKeysPassword(PASSWORD);
        loginPage.clickSignInButton();
        homePage.waitOrder();
        assertEquals(homePage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void shouldLoginFromRegistrationPage() {
        loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.get(registrationPage.getUrl());
        registrationPage.waitRegButton();
        registrationPage.clickSignInLink();
        loginPage.waitSignInButton();
        loginPage.sendKeysEmail(EMAIL);
        loginPage.sendKeysPassword(PASSWORD);
        loginPage.clickSignInButton();
        homePage.waitOrder();
        assertEquals(homePage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void shouldLoginFromPasswordRecoveryPage() {
        loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.get(forgotPasswordPage.getUrl());
        forgotPasswordPage.waitRestorePasswordButton();
        forgotPasswordPage.clickSignInLink();
        loginPage.waitSignInButton();
        loginPage.sendKeysEmail(EMAIL);
        loginPage.sendKeysPassword(PASSWORD);
        loginPage.clickSignInButton();
        homePage.waitOrder();
        assertEquals(homePage.getUrl(), driver.getCurrentUrl());
    }
}