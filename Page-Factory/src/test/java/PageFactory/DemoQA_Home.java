package PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQA_Home {

    private JavascriptExecutor js;

    @FindBy(xpath = "//div[@class='category-cards']/child::div[6]")
    private WebElement BTN_bookStore;

    @FindBy(xpath = "//div[@class='element-list collapse show']/descendant::li[1]")
    private WebElement BTN_login;

    public DemoQA_Home(WebDriver driver) {
        //this.driver = driver;
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    public void IrBookStore() {
        js.executeScript("arguments[0].scrollIntoView()", BTN_bookStore);
        BTN_bookStore.click();
    }

    public void IrLogin() {
        js.executeScript("arguments[0].scrollIntoView()", BTN_login);
        BTN_login.click();
    }
}

