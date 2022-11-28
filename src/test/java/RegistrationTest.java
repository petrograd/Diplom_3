
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pageobject.*;
import setup.SetUp;

import static org.junit.Assert.assertEquals;

@DisplayName("Раздел «Регистрация пользователя»")
public class RegistrationTest extends SetUp {
    private RegistrationPage registrationPage;
    private String email, password;

    @Before
    public void setup() {
        chromeDriverSetUp();
        registrationPage = new RegistrationPage(driver);
        driver.get(registrationPage.getUrl());
        driver.manage().window().maximize();
        registrationPage.waitRegButton();
    }

    @After
    public void tearDown() {
        closeDriver();
    }

    @Test
    @DisplayName("Успешная регистрация нового юзера")
    public void SuccessRegistrationShowsOk() {
        LoginPage loginPage = new LoginPage(driver);
        email = RandomStringUtils.randomAlphanumeric(16)+"@ya.ru";
        password = RandomStringUtils.randomAlphanumeric(10);
        registrationPage.registerUser(NAME, email, password);
        loginPage.waitSignInButton();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Неудачная регистрация нового юзера. Пароль меньше 6 символов")
    public void shortPasswordRegistrationShowsError() {
        email = RandomStringUtils.randomAlphanumeric(16)+"@ya.ru";
        password = RandomStringUtils.randomAlphanumeric(5);
        registrationPage.registerUser(NAME, email, password);
        registrationPage.waitError();
        assertEquals("Некорректный пароль", registrationPage.getError());
    }
}
