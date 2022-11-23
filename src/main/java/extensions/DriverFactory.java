package extensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getBrowser() {
        String browserName;
        try {
            browserName = System.getProperty("browser");
        } catch (RuntimeException e) {
            browserName = "chrome";
        }

        if (browserName == null) browserName = "chrome";

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "yandex":
                WebDriverManager.chromedriver().driverVersion("107.0.5304.107").setup();
                return new ChromeDriver(new ChromeOptions().setBinary("C:\\Users\\Petr\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"));
            default: throw new RuntimeException("Для тестов используем только браузер chrome или yandex\n" +
                    "mvn clean test -Dbrowser=chrome");
        }
    }
}
