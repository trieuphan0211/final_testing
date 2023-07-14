package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPageObject {
    public static WebDriver edriver;
    public static WebDriverWait ewait;

    @FindBy(how = How.XPATH, using = "//span[@class='checkmark']")
    public WebElement typeButton;
    @FindBy(how = How.XPATH, using = "//button[@class='sc-124al1g-0 jCsgpZ']")
    public WebElement addButton ;
//    Add sản phẩm bên trong giỏ hàng
    @FindBy(how = How.XPATH, using = "//button[@class='sc-11uohgb-6 cgtUCJ'][2]")
    public WebElement addItem ;
    @FindBy(how = How.XPATH, using = "//button[@class='sc-1h98xa9-0 gFkyvN']")
    public WebElement closeButton;
    @FindBy(how = How.XPATH, using = "//div[@class='sc-1h98xa9-4 hzlwTK']//button[@class='sc-1h98xa9-11 gnXVNU']")
    public WebElement CheckOut;
    @FindBy(how = How.XPATH, using = "//button[@class='sc-11uohgb-5 gBQuHE']")
    public WebElement DeleteAll;

    public CommonPageObject(WebDriver driver) throws Exception {
        edriver = new ChromeDriver();
        PageFactory.initElements(edriver, this);
        ewait = new WebDriverWait(edriver, Duration.ofSeconds(10));
        edriver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }
}
