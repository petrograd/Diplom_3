import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;
import setup.SetUp;

import static org.junit.Assert.assertEquals;

public class LoginTest extends SetUp {

    @Before
    public void setup() {
        chromeDriverSetUp();
        homePage = new HomePage(driver);
        driver.get(homePage.getUrl());
        driver.manage().window().maximize();
        homePage.waitSignIn();
    }

    @After
    public void tearDown() {
        closeDriver();
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void shouldLoginFromHomePageAccountButton() {
        loginPage = new LoginPage(driver);
        homePage.clickSignInButton();
        loginPage.signIn(EMAIL, PASSWORD);
        homePage.waitOrder();
        assertEquals(homePage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void shouldLoginFromHomePageLoginButton() {
        loginPage = new LoginPage(driver);
        homePage.clickAccountButton();
        loginPage.signIn(EMAIL, PASSWORD);
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
        loginPage.signIn(EMAIL, PASSWORD);
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
        loginPage.signIn(EMAIL, PASSWORD);
        homePage.waitOrder();
        assertEquals(homePage.getUrl(), driver.getCurrentUrl());
    }
}