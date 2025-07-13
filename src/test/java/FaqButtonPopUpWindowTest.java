import org.example.pages.HomePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FaqButtonPopUpWindowTest {

    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeClass
    public static void setup() {
        driver = getChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePage = new HomePage(driver);
    }

    @Test
    public void checkWhenFaqButton0IsClickedThenRequiredTextAppears() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", homePage.getFaqButton0());
        homePage.clickFaqButton0();
        String actual = homePage.getTextFromFaqButtonPopUpWindow0();
        assertNotNull("Текст в окне с номером 0 отсутствует", actual);
        assertEquals("Неверный текст в окне с номером 0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", actual);
    }

    @Test
    public void checkWhenFaqButton1IsClickedThenRequiredTextAppears() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", homePage.getFaqButton1());
        homePage.clickFaqButton1();
        String actual = homePage.getTextFromFaqButtonPopUpWindow1();
        assertNotNull("Текст в окне с номером 1 отсутствует", actual);
        assertEquals("Неверный текст в окне с номером 1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", actual);
    }

    @Test
    public void checkWhenFaqButton2IsClickedThenRequiredTextAppears() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", homePage.getFaqButton2());
        homePage.clickFaqButton2();
        String actual = homePage.getTextFromFaqButtonPopUpWindow2();
        assertNotNull("Текст в окне с номером 2 отсутствует", actual);
        assertEquals("Неверный текст в окне с номером 0", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", actual);
    }

    @Test
    public void checkWhenFaqButton3IsClickedThenRequiredTextAppears() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", homePage.getFaqButton3());
        homePage.clickFaqButton3();
        String actual = homePage.getTextFromFaqButtonPopUpWindow3();
        assertNotNull("Текст в окне с номером 3 отсутствует", actual);
        assertEquals("Неверный текст в окне с номером 3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", actual);
    }

    @Test
    public void checkWhenFaqButton4IsClickedThenRequiredTextAppears() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", homePage.getFaqButton4());
        homePage.clickFaqButton4();
        String actual = homePage.getTextFromFaqButtonPopUpWindow4();
        assertNotNull("Текст в окне с номером 4 отсутствует", actual);
        assertEquals("Неверный текст в окне с номером 0", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", actual);
    }

    @Test
    public void checkWhenFaqButton5IsClickedThenRequiredTextAppears() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", homePage.getFaqButton5());
        homePage.clickFaqButton5();
        String actual = homePage.getTextFromFaqButtonPopUpWindow5();
        assertNotNull("Текст в окне с номером 5 отсутствует", actual);
        assertEquals("Неверный текст в окне с номером 5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", actual);
    }

    @Test
    public void checkWhenFaqButton6IsClickedThenRequiredTextAppears() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", homePage.getFaqButton6());
        homePage.clickFaqButton6();
        String actual = homePage.getTextFromFaqButtonPopUpWindow6();
        assertNotNull("Текст в окне с номером 6 отсутствует", actual);
        assertEquals("Неверный текст в окне с номером 6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", actual);
    }

    @Test
    public void checkWhenFaqButton7IsClickedThenRequiredTextAppears() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", homePage.getFaqButton7());
        homePage.clickFaqButton7();
        String actual = homePage.getTextFromFaqButtonPopUpWindow7();
        assertNotNull("Текст в окне с номером 7 отсутствует", actual);
        assertEquals("Неверный текст в окне с номером 7", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", actual);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    // драйвер для браузера Chrome
    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }

}
