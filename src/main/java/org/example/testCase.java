package org.example;

import org.junit.After;
import org.junit.Assert;
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
import pageObject.DataField;

import java.time.Duration;
import java.util.List;

public class testCase extends CommonPageObject {

    public WebDriver  edriver;
    public WebDriverWait ewait;
    DataField dataField;

    public testCase() throws Exception {
        super(CommonPageObject.edriver);
        edriver = CommonPageObject.edriver;
        ewait = CommonPageObject.ewait;
        dataField = new DataField("src/main/resources/data.xlsx");
    }


    @Test
    public void test() throws Exception {

//        Test case 1
        Thread.sleep(2000);
        // Chọn size S
        clickButton(typeButton,1);
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

//        Test case 4
        Thread.sleep(2000);
//        close size XL
//        clickButton(typeButton,1);
//        waitUntilInvisibilityOfElementLocated();
        edriver.navigate().refresh();
        waitUntilInvisibilityOfElementLocated();
//        Chọn Size L
        Thread.sleep(3000);
        waitUntilElementVisible(typeButtons.get(4));
        waitUntilElementClickable(typeButtons.get(4));
        clickButton(typeButtons.get(4),1);
        waitUntilInvisibilityOfElementLocated();
//        add 2 product
        waitUntilElementVisible(addProducts.get(0));
        waitUntilElementClickable(addProducts.get(0));
        clickButton(addProducts.get(0),1);
        waitUntilElementVisible(addProducts.get(1));
        waitUntilElementClickable(addProducts.get(1));
        clickButton(addProducts.get(1),1);
        checkcartSubtotal(subTotal,coin,numberCoin,2);
        clickButton(typeButtons.get(4),1);
        waitUntilInvisibilityOfElementLocated();
//        Test case 5

        Thread.sleep(2000);
//        choise all size
        System.out.println(numberProduct.getText());
        for (int i = 0; i<typeButtons.toArray().length;i++){
            waitUntilElementVisible(typeButtons.get(i));
            waitUntilElementClickable(typeButtons.get(i));
            clickButton(typeButtons.get(i),1);
            waitUntilInvisibilityOfElementLocated();
        }


        System.out.println("Số lượng sản phẩm cần check: "+dataField.getData(0,1));
        System.out.println(1*1.12);
        System.out.println("Số lượng sản phẩm sau khi chọn tất cả size: "+numberProduct.getText());
        try {
            Assert.assertEquals(dataField.getData(0,1),numberProduct.getText());
            System.out.println("Đúng, số lượng sản phẩm đúng khi chọn tất cả các size");
        }catch(Exception err) {
            System.out.println("Sai, số lượng sản phẩm không đúng khi chọn tất cả các size");
        }





    }

    @After
    public void tearDown() throws InterruptedException {
    }




}

