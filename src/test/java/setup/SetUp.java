package setup;

import extensions.DriverFactory;
import org.openqa.selenium.WebDriver;
import pageobject.*;

import java.time.Duration;

//all tests extend this
public class SetUp {

    protected final String EMAIL = "merkuryev@mail.ru";
    protected final String PASSWORD = "ynossony";
    protected final String NAME = "petr";

    public static final String HOME_PAGE_LINK = "https://stellarburgers.nomoreparties.site/";

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;

    public void chromeDriverSetUp() {
        driver = DriverFactory.getBrowser();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void openHomePage() {
        driver.get(HOME_PAGE_LINK);
    }

    public void closeDriver() {
        driver.quit();
    }

}
