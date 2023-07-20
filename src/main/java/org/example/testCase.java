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

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

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
        // Chọn size XS
        clickButton(typeButton,1);
        waitUntilInvisibilityOfElementLocated();
        waitUntilElementVisible(addButton);
        waitUntilElementClickable(addButton);
        System.out.println("Add XS");
        Thread.sleep(1000);
        // Add sản phẩm đầu tiên
        clickButton(addButton,1);
        System.out.println("Add áo XS");

        Thread.sleep(3000);
        waitUntilElementVisible(CheckOut);
        waitUntilElementClickable(CheckOut);
        clickButton(CheckOut,1);
        System.out.println("Check out");


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

        // Add ML
        clickButton(typeButtons.get(3), 1);
        System.out.println("Add ML");
        waitUntilInvisibilityOfElementLocated();

        // Add áo ML
        clickButton(AddML, 1);
        System.out.println("Add ao ML");
        waitUntilInvisibilityOfElementLocated();
        Thread.sleep(2000);
        // Add số lượng
        waitUntilElementVisible(typeButtonAdds.get(3));
        waitUntilElementClickable(typeButtonAdds.get(3));
        clickButton(typeButtonAdds.get(3),1);
        System.out.println("Add So luong");

        // Lấy số lượng
        System.out.println("Kiem tra tong tien");
        checkGiaTri(Tongsp, soluong, Giatri);

//        Test case 3
        //  Xóa tất cả sản phẩm bên trong giỏ hàng
        Thread.sleep(1000);
        waitUntilElementVisible(DeleteAll);
        waitUntilElementClickable(DeleteAll);
        Thread.sleep(1000);
        clickButton(DeleteAll,2);

        // Check out khi không có sản phẩm
        Thread.sleep(3000);
        waitUntilElementVisible(CheckOut);
        waitUntilElementClickable(CheckOut);
        clickButton(CheckOut,1);
        System.out.println("Check out");

        Thread.sleep(2000);
        // accepting javascript alert
        Alert alert2 = edriver.switchTo().alert();
        alert2.accept();

        // Check total = 0
        System.out.println("Số tiền cần kiểm tra: "+dataField.getData(1,1));
        // System.out.println(1*1.12);
        System.out.println("Số tiền kiểm tra: "+Total.getText());
        try{
            Assert.assertEquals(dataField.getData(1,1).trim(),Total.getText().trim());
            System.out.println("Đúng, số tiền cần kiểm tra bằng với số tiền kiểm tra");

        }catch (Exception err) {
            System.out.println("Sai, số tiền cần kiểm tra khác với số tiên kiểm tra");
        }

        edriver.navigate().refresh();
        waitUntilInvisibilityOfElementLocated();

//        Test case 4
        Thread.sleep(2000);
        // Chọn Size L
        Thread.sleep(3000);
        System.out.println("Chọn Size L");
        waitUntilElementVisible(typeButtons.get(4));
        waitUntilElementClickable(typeButtons.get(4));
        clickButton(typeButtons.get(4),1);
        waitUntilInvisibilityOfElementLocated();
        // Add 2 products
        waitUntilElementVisible(addProducts.get(0));
        waitUntilElementClickable(addProducts.get(0));
        clickButton(addProducts.get(0),1);
        waitUntilElementVisible(addProducts.get(1));
        waitUntilElementClickable(addProducts.get(1));
        clickButton(addProducts.get(1),1);
        checkCartSubTotal(subTotal,coin,numberCoin,2);
        clickButton(typeButtons.get(4),1);
        waitUntilInvisibilityOfElementLocated();
//        Test case 5

        Thread.sleep(2000);
        // Choice all size
        System.out.println(numberProduct.getText());
        for (int i = 0; i<typeButtons.toArray().length;i++){
            waitUntilElementVisible(typeButtons.get(i));
            waitUntilElementClickable(typeButtons.get(i));
            clickButton(typeButtons.get(i),1);
            waitUntilInvisibilityOfElementLocated();
        }

        System.out.println("Số lượng sản phẩm cần check: "+dataField.getData(0,1));
        // System.out.println(1*1.12);
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

