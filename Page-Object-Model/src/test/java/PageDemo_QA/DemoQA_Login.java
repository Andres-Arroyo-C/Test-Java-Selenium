package PageDemo_QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQA_Login {
    private WebDriver driver;
    private By TXT_userName = By.id("userName");
    private By TXT_password = By.id("password");
    private By BTN_login = By.id("login");
    private By TXT_Title = By.xpath("//div[text()=\"Profile\"]");

    public  DemoQA_Login(WebDriver driver){
        this.driver = driver;
    }
    public void IngresarUsuario(String user){
        driver.findElement(TXT_userName).sendKeys(user);
    }

    public void IngresaPassword(String password){
        driver.findElement(TXT_password).sendKeys(password);
    }

    public void Login(){
        driver.findElement(BTN_login).click();
    }

    public By getTitle(){
        return  TXT_Title;
    }
}
