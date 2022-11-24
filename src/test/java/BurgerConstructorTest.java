import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;
import setup.SetUp;

import static org.junit.Assert.assertEquals;

@DisplayName("Раздел Конструктор")
public class BurgerConstructorTest extends SetUp {

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
    @DisplayName("Проверяем, что работает переход к разделу «Булки»")
    public void shouldSwitchToBunsTab() {
        homePage.clickBuns();
        assertEquals("Булки", homePage.getTextActiveTab());
    }

    @Test
    @DisplayName("Проверяем, что работает переход к разделу «Соусы»")
    public void shouldSwitchToSaucesTab() {
        homePage.clickSauces();
        assertEquals("Соусы", homePage.getTextActiveTab());
    }

    @Test
    @DisplayName("Проверяем, что работает переход к разделу «Начинки»")
    public void shouldSwitchToFillingsTab() {
        homePage.clickFillings();
        assertEquals("Начинки", homePage.getTextActiveTab());
    }
}
