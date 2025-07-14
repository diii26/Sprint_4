import org.example.pages.Constants;
import org.example.pages.HomePage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqButtonPopUpWindowTest {

    private WebDriver driver;
    private HomePage homePage;

    private final int buttonNumber;
    private final String windowText;

    public FaqButtonPopUpWindowTest(int buttonNumber, String windowText) {
        this.buttonNumber = buttonNumber;
        this.windowText = windowText;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                { 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Before
    public void setup() {
        driver = getChromeDriver();
        driver.get(Constants.url);
        homePage = new HomePage(driver);
    }

    @Test
    public void checkWhenFaqButtonIsClickedThenRequiredTextAppears() {
        WebElement faqButton = homePage.getFaqButton(buttonNumber);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", faqButton);
        faqButton.click();
        String actual = homePage.getTextFromFaqButtonPopUpWindow(buttonNumber);
        assertEquals("Неверный текст в окне с номером " + buttonNumber, windowText, actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // драйвер для браузера Chrome
    private static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }

    // драйвер для браузера Firefox
    private static WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        return new FirefoxDriver(options);
    }

}
