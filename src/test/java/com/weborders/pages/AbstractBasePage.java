package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will be extended by page classes
 * Ant common webelements/locators can be stored here
 * its meant to be extended
 */
public abstract class AbstractBasePage {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,20);
    //we use protected coz this class meant to be extended and we will use it in sub classes

    @FindBy(tagName = "h1")
    protected WebElement pageLogo;

    public String getPageLogoText(){

        return pageLogo.getText();

    }

    public AbstractBasePage(){

        PageFactory.initElements(driver,this);
        //to locate annotations

    }

    /**
     * Specify component name as a parameter, like --> View all products or Order
     * @param component
     */
    public void navigateTo(String component){

        String locator = "//a[text()='"+component+"']";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();

    }
}
