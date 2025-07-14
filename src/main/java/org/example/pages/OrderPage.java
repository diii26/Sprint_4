package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameInputField = By.cssSelector("input[type='text'][class='Input_Input__1iN_Z Input_Responsible__1jDKN'][placeholder='* Имя']");

    private final By surnameInputField = By.cssSelector("input[type='text'][class='Input_Input__1iN_Z Input_Responsible__1jDKN'][placeholder='* Фамилия']");

    private final By addressInputField = By.cssSelector("input[type='text'][class='Input_Input__1iN_Z Input_Responsible__1jDKN'][placeholder='* Адрес: куда привезти заказ']");

    private final By telephoneInputField = By.cssSelector("input[type='text'][class='Input_Input__1iN_Z Input_Responsible__1jDKN'][placeholder='* Телефон: на него позвонит курьер']");

    private final By metroStationField = By.cssSelector("input[tabindex='0'][class='select-search__input'][placeholder='* Станция метро']");

    private final By metroStation0Button = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button");

    private final By proceedButton = By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']");

    private final By dateInputField = By.cssSelector("input[type='text'][placeholder='* Когда привезти самокат']");

    private final By rentalPeriodField = By.cssSelector("div[class='Dropdown-placeholder']");

    private final By dayButton = By.cssSelector("div[class='Dropdown-option'][role='option']");

    private final By greyCheckbox = By.className("Checkbox_Input__14A2w");

    private final By orderButton = By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']");

    private final By secondOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    private final By successPopup = By.cssSelector("div[class='Order_Text__2broi']");
    //

    public WebElement getNameInputField() {
        return driver.findElement(nameInputField);
    }

    public WebElement getSurnameInputField() {
        return driver.findElement(surnameInputField);
    }

    public WebElement getAddressInputField() {
        return driver.findElement(addressInputField);
    }

    public WebElement getTelephoneField() {
        return driver.findElement(telephoneInputField);
    }

    public WebElement getMetroStationField() {
        return driver.findElement(metroStationField);
    }

    public void clickMetroStation0Button() {
        driver.findElement(metroStation0Button).click();
    }

    public void clickProceedButton() {
        driver.findElement(proceedButton).click();
    }

    public WebElement getProceedButton() {
        return driver.findElement(proceedButton);
    }

    public WebElement getDateInputField() {
        return driver.findElement(dateInputField);
    }

    public WebElement getRentalPeriodField() {
        return driver.findElement(rentalPeriodField);
    }

    public void clickDayButton() {
        driver.findElement(dayButton).click();
    }

    public void clickGreyCheckbox() {
        driver.findElement(greyCheckbox).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickSecondOrderButton() {
        driver.findElement(secondOrderButton).click();
    }

    public String getTextFromSuccessPopup() {
        return driver.findElement(successPopup).getText();
    }

    // метод ожидания прогрузки кнопки
    public void waitForLoadButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(proceedButton));
    }
}
