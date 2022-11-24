package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasicPages {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    // локатор для выбраного раздела
    private final By activeTab = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    // локатор для кнопки 'Войти в аккаунт'
    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private WebElement signInButton;
    // локатор для кнопки 'Оформить заказ'
    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    private WebElement orderButton;
    // локатор для ссылки 'Личный кабинет'
    @FindBy(linkText = "Личный Кабинет")
    private WebElement profileButton;
    // локатор для раздела 'Булки'
    @FindBy(xpath = ".//div/span[text()='Булки']")
    private WebElement bunsTab;
    // локатор для раздела 'Соусы'
    @FindBy(xpath = ".//div/span[text()='Соусы']")
    private WebElement saucesTab;
    // локатор для раздела 'Начинки'
    @FindBy(xpath = ".//div/span[text()='Начинки']")
    private WebElement fillingsTab;
    @FindBy(linkText = "Конструктор")
    private WebElement constructorLink;

    public HomePage(WebDriver driver) {
        super(driver);//
    }

    public String getUrl() {
        return URL;
    }

    public void waitSignIn() {
        waitForElement(signInButton);
    }

    public void waitOrder() {
        waitForElement(orderButton);
    }

    public void clickConstructorLink() {
        constructorLink.click();
    }

    public void clickLogo() {
        constructorLink.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickAccountButton() {
        profileButton.click();
    }

    public String getTextActiveTab() {
        WebElement element = driver.findElement(activeTab);
        return element.getText();
    }

    public void clickBuns() {
        bunsTab.isDisplayed();
    }

    public void clickSauces() {
        saucesTab.click();
    }

    public void clickFillings() {
        fillingsTab.click();
    }

    public ProfilePage goToProfilePage() {
        waitForElement(profileButton);
        profileButton.click();
        return new ProfilePage(driver);
    }

    public boolean orderButtonAvailable() {
        waitForElement(orderButton);
        return orderButton.isDisplayed();
    }
}
