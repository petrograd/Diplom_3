
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;
import setup.SetUp;

import static org.junit.Assert.assertTrue;

@DisplayName("Переходы по страницам")
public class PagesNavigationAndExitTest extends SetUp {

    @Before
    public void setup() {
        chromeDriverSetUp();
        homePage = new HomePage(driver);
        driver.get(homePage.getUrl());
        driver.manage().window().maximize();
        homePage.waitSignIn();
        homePage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(EMAIL, PASSWORD);
        homePage.waitOrder();
    }

    @After
    public void tearDown() {
        closeDriver();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void shouldGoToProfile() {
        assertTrue(
                homePage
                        .goToProfilePage()
                        .profileDisplayed()
        );
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void shouldGoToConstructor() {
        assertTrue(
                homePage
                        .goToProfilePage()
                        .goHomeByClickingConstructorLogo()
                        .orderButtonAvailable()
        );
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void shouldGoToHomePage() {
        assertTrue(
                homePage
                        .goToProfilePage()
                        .goHomeByClickingBurgerLogo()
                        .orderButtonAvailable()
        );
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void shouldExit() {
        assertTrue(
                homePage
                        .goToProfilePage()
                        .clickOnExitButton()
                        .loginPageDisplayed()
        );
    }
}
