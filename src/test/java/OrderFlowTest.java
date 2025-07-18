import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.Constants;
import org.example.pages.HomePage;
import org.example.pages.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderFlowTest {

    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;

    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String metroStation;
    private final String date;
    private final boolean isTopButton;

    public OrderFlowTest(String name, String surname, String address, String phoneNumber, String metroStation,
                         String date, boolean isTopButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.metroStation = metroStation;
        this.date = date;
        this.isTopButton = isTopButton;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Василий", "Сергеев", "Ул. Пушкина, 4", "89991112233", "Черкизовская", "19.07.2025", true},
                { "Сергей", "Васильев", "Ул. Колотушкина 5", "89123334456", "Сокольники", "17.09.2025", false}
        };
    }

    @Test
    public void checkOrderFlow() {
        if (isTopButton) {
            homePage.clickTopOrderButton();
        } else {
            homePage.clickBottomOrderButton();
        }

        WebElement nameInputField = orderPage.getNameInputField();
        nameInputField.sendKeys(name);
        WebElement surnameInputField = orderPage.getSurnameInputField();
        surnameInputField.sendKeys(surname);
        WebElement addressInputField = orderPage.getAddressInputField();
        addressInputField.sendKeys(address);
        orderPage.getTelephoneField().sendKeys(phoneNumber);
        orderPage.getMetroStationField().sendKeys(metroStation);
        orderPage.clickMetroStation0Button();
        orderPage.waitForLoadButton();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", orderPage.getProceedButton());
        orderPage.clickProceedButton();
        orderPage.getDateInputField().sendKeys(date);
        orderPage.getDateInputField().sendKeys(Keys.ENTER);
        orderPage.getRentalPeriodField().click();
        orderPage.clickDayButton();
        orderPage.clickGreyCheckbox();
        orderPage.clickOrderButton();
        orderPage.clickSecondOrderButton();//на Chrome после клика по кнопке с подтверждением заказа не всплывает окно об успешном завершении
        String actual = orderPage.getTextFromSuccessPopup();
        assertTrue(actual.contains("Номер заказа: "));
    }

    @Before
    public void setup() {
        driver = getChromeDriver();
        driver.get(Constants.url);
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // драйвер для браузера Chrome
    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }

    // драйвер для браузера Firefox
    private static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        return new FirefoxDriver(options);
    }
}
