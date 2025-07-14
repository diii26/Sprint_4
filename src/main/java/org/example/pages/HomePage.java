package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    //локатор 0ой кнопки вопросов о важном
    private final By faqButton0 = By.id("accordion__heading-0");

    //локатор 1ой кнопки вопросов о важном
    private final By faqButton1 = By.id("accordion__heading-1");

    //локатор 2ой кнопки вопросов о важном
    private final By faqButton2 = By.id("accordion__heading-2");

    //локатор 3ой кнопки вопросов о важном
    private final By faqButton3 = By.id("accordion__heading-3");

    //локатор 4ой кнопки вопросов о важном
    private final By faqButton4 = By.id("accordion__heading-4");

    //локатор 5ой кнопки вопросов о важном
    private final By faqButton5 = By.id("accordion__heading-5");

    //локатор 6ой кнопки вопросов о важном
    private final By faqButton6 = By.id("accordion__heading-6");

    //локатор 7ой кнопки вопросов о важном
    private final By faqButton7 = By.id("accordion__heading-7");

    //локатор поля всплывающего окна для 0ой кнопки вопросов о важном
    private final By faqButtonPopUpWindow0 = By.id("accordion__panel-0");

    //локатор поля всплывающего окна для 1ой кнопки вопросов о важном
    private final By faqButtonPopUpWindow1 = By.id("accordion__panel-1");

    //локатор поля всплывающего окна для 2ой кнопки вопросов о важном
    private final By faqButtonPopUpWindow2 = By.id("accordion__panel-2");

    //локатор поля всплывающего окна для 3ой кнопки вопросов о важном
    private final By faqButtonPopUpWindow3 = By.id("accordion__panel-3");

    //локатор поля всплывающего окна для 4ой кнопки вопросов о важном
    private final By faqButtonPopUpWindow4 = By.id("accordion__panel-4");

    //локатор поля всплывающего окна для 5ой кнопки вопросов о важном
    private final By faqButtonPopUpWindow5 = By.id("accordion__panel-5");

    //локатор поля всплывающего окна для 6ой кнопки вопросов о важном
    private final By faqButtonPopUpWindow6 = By.id("accordion__panel-6");

    //локатор поля всплывающего окна для 7ой кнопки вопросов о важном
    private final By faqButtonPopUpWindow7 = By.id("accordion__panel-7");

    private final By topOrderButton = By.className("Button_Button__ra12g");

    private final By bottomOrderButton = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFaqButton(int buttonNumber) {
        switch(buttonNumber) {
            case 0:
                return getFaqButton0();
            case 1:
                return getFaqButton1();
            case 2:
                return getFaqButton2();
            case 3:
                return getFaqButton3();
            case 4:
                return getFaqButton4();
            case 5:
                return getFaqButton5();
            case 6:
                return getFaqButton6();
            case 7:
                return getFaqButton7();
        }
        return null;
    }

    public WebElement getFaqButton0() {
        return driver.findElement(faqButton0);
    }

    public WebElement getFaqButton1() {
        return driver.findElement(faqButton1);
    }

    public WebElement getFaqButton2() {
        return driver.findElement(faqButton2);
    }

    public WebElement getFaqButton3() {
        return driver.findElement(faqButton3);
    }

    public WebElement getFaqButton4() {
        return driver.findElement(faqButton4);
    }

    public WebElement getFaqButton5() {
        return driver.findElement(faqButton5);
    }

    public WebElement getFaqButton6() {
        return driver.findElement(faqButton6);
    }

    public WebElement getFaqButton7() {
        return driver.findElement(faqButton7);
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    public String getTextFromFaqButtonPopUpWindow(int buttonNumber) {
        switch(buttonNumber) {
            case 0:
                return getTextFromFaqButtonPopUpWindow0();
            case 1:
                return getTextFromFaqButtonPopUpWindow1();
            case 2:
                return getTextFromFaqButtonPopUpWindow2();
            case 3:
                return getTextFromFaqButtonPopUpWindow3();
            case 4:
                return getTextFromFaqButtonPopUpWindow4();
            case 5:
                return getTextFromFaqButtonPopUpWindow5();
            case 6:
                return getTextFromFaqButtonPopUpWindow6();
            case 7:
                return getTextFromFaqButtonPopUpWindow7();
        }
        return null;
    }

    public String getTextFromFaqButtonPopUpWindow0() {
        return driver.findElement(faqButtonPopUpWindow0).getText();
    }

    public String getTextFromFaqButtonPopUpWindow1() {
        return driver.findElement(faqButtonPopUpWindow1).getText();
    }

    public String getTextFromFaqButtonPopUpWindow2() {
        return driver.findElement(faqButtonPopUpWindow2).getText();
    }

    public String getTextFromFaqButtonPopUpWindow3() {
        return driver.findElement(faqButtonPopUpWindow3).getText();
    }

    public String getTextFromFaqButtonPopUpWindow4() {
        return driver.findElement(faqButtonPopUpWindow4).getText();
    }

    public String getTextFromFaqButtonPopUpWindow5() {
        return driver.findElement(faqButtonPopUpWindow5).getText();
    }

    public String getTextFromFaqButtonPopUpWindow6() {
        return driver.findElement(faqButtonPopUpWindow6).getText();
    }

    public String getTextFromFaqButtonPopUpWindow7() {
        return driver.findElement(faqButtonPopUpWindow7).getText();
    }

}
