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

    private final By nameInputField = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");

    private final By surnameInputField = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input");

    private final By addressInputField = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input");

    private final By telephoneInputField = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");

    private final By metroStationField = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input");

    private final By metroStation0Button = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button");

    private final By proceedButton = By.xpath("/html/body/div/div/div[2]/div[3]/button");

    private final By dateInputField = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input");

    private final By rentalPeriodField = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[1]");

    private final By dayButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]");

    private final By greyCheckbox = By.className("Checkbox_Input__14A2w");

    private final By orderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    private final By secondOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    private final By successPopup = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]");

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
