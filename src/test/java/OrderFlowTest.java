import org.example.pages.HomePage;
import org.example.pages.OrderPage;
import org.junit.*;
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

import static org.junit.Assert.assertNotNull;
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

    public OrderFlowTest(String name, String surname, String address, String phoneNumber, String metroStation, String date) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.metroStation = metroStation;
        this.date = date;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Василий", "Сергеев", "Ул. Пушкина, 4", "89991112233", "Черкизовская", "19.07.2025"},
                { "Сергей", "Васильев", "Ул. Колотушкина 5", "89123334456", "Сокольники", "17.09.2025"}
        };
    }

    @Test
    public void checkOrderFlowThroughTopButton() {
        homePage.clickTopOrderButton();
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
        assertNotNull(actual);
        assertTrue(actual.contains("Заказ оформлен"));
        assertTrue(actual.contains("Номер заказа: "));
    }

    @Test
    public void checkOrderFlowThroughBottomButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", homePage.getBottomOrderButton());
        homePage.clickBottomOrderButton();
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
        assertNotNull(actual);
        assertTrue(actual.contains("Заказ оформлен"));
        assertTrue(actual.contains("Номер заказа: "));
    }

    @Before
    public void setup() {
        driver = getChromeDriver();
        //driver = getFirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // драйвер для браузера Chrome
    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }

    // драйвер для браузера Firefox
    private static WebDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        return new FirefoxDriver(options);
    }
}
