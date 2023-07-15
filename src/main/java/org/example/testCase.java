package org.example;

import org.apache.poi.poifs.filesystem.NDocumentInputStream;
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

        //Testcase2
        //Delete XL
        clickButton(DeleteXl,1);
        System.out.println("Delete XL");
        waitUntilInvisibilityOfElementLocated();

        //ADDML
        clickButton(typeButtons.get(3), 1);
        System.out.println("Add ML");
        waitUntilInvisibilityOfElementLocated();

        // ADD áo ML
        clickButton(AddML, 1);
        System.out.println("Add ao ML");
        waitUntilInvisibilityOfElementLocated();
        Thread.sleep(2000);
        // add số lượng
        waitUntilElementVisible(typeButtonAdds.get(3));
        waitUntilElementClickable(typeButtonAdds.get(3));
        clickButton(typeButtonAdds.get(3),1);
        System.out.println("Add So luong");

        //lay so luong
        System.out.println("kiem tra tong tien");
        checkGiatri(Tongsp, soluong, Giatri);




    }

    @After
    public void tearDown() throws InterruptedException {
    }




}

