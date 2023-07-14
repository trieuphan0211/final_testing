package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.CommonPageObject;

import java.time.Duration;
import java.util.List;

public class testCase extends CommonPageObject {

    public WebDriver  edriver;
    public WebDriverWait ewait;

    public testCase() throws Exception {
        super(CommonPageObject.edriver);
        edriver = CommonPageObject.edriver;
        ewait = CommonPageObject.ewait;
    }


    @Test
    public void test() throws Exception {

//        Test case 1
        Thread.sleep(2000);
        // Chọn size S
        clickButton(typeButton,2);
        waitUntilInvisibilityOfElementLocated();
        waitUntilElementVisible(addButton);
        waitUntilElementClickable(addButton);
        Thread.sleep(1000);
        // Add sản phẩm đầu tiên
        clickButton(addButton,1);

        Thread.sleep(3000);
        waitUntilElementVisible(CheckOut);
        waitUntilElementClickable(CheckOut);
        clickButton(CheckOut,1);

        Thread.sleep(2000);
        // accepting javascript alert
        Alert alert = edriver.switchTo().alert();
        alert.accept();

        Thread.sleep(2000);
        // Ẩn giỏ hàng
        waitUntilElementVisible(closeButton);
        waitUntilElementClickable(closeButton);
        clickButton(closeButton,1);
    }

    @After
    public void tearDown() throws InterruptedException {
    }

    public void clickButton(WebElement element,int number){
        for(var i = 0; i< number;i++){
            element.click();
        }
    }

    public void waitUntilElementVisible(WebElement element) {
        int tryTimes = 0;
        while (tryTimes < 2) {
            try {
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (StaleElementReferenceException se) {
                tryTimes++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }
    public List<WebElement> lists(String XPATH){
        return edriver.findElements(By.xpath(XPATH));
    }

    public void waitUntilElementClickable(WebElement element) throws Exception {
        int tryTimes = 0;
        while (tryTimes < 2) {
            try {
                ewait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            } catch (StaleElementReferenceException se) {
                tryTimes++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }

    public void waitUntilInvisibilityOfElementLocated( ) throws Exception {
        int tryTimes = 0;
        while (tryTimes < 2) {
            try {
                ewait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='sc-5z440p-0 ruYEp']")));
                break;
            } catch (StaleElementReferenceException se) {
                tryTimes++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }


}

