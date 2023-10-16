package PageDemo_QA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class DemoQA_Home {

    private WebDriver driver;
    JavascriptExecutor js;
    private By BTN_bookStore = By.xpath("//div[@class=\"category-cards\"]/child::div[6]");
    private By BTN_login = By.xpath("//div[@class=\"element-list collapse show\"]/descendant::li[1]");

    public  DemoQA_Home(WebDriver driver){
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void IrBookStore(){
        this.js.executeScript("arguments[0].scrollIntoView()", driver.findElement(BTN_bookStore));
        driver.findElement(BTN_bookStore).click();

    }

    public void IrLogin(){
        this.js.executeScript("arguments[0].scrollIntoView()", driver.findElement(BTN_login));
        driver.findElement(BTN_login).click();
    }
}
