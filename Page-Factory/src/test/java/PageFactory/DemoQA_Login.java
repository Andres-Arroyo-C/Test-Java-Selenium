package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DemoQA_Login {
    //private By TXT_userName = By.id("userName");
    //private By TXT_password = By.id("password");
    //private By BTN_login = By.id("login");
    //private By TXT_Title = By.xpath("//div[text()=\"Profile\"]");

    @FindBy(how = How.ID, using = "userName")
    private WebElement TXT_userName;
    @FindBy(how = How.ID, using = "password") private WebElement TXT_password;
    @FindBy(how = How.ID, using = "login") private WebElement BTN_login;
    @FindBy(how = How.XPATH, using = "//div[text()='Profile']") private WebElement TXT_Title;
    @FindBy(id = "name") private  WebElement mensajeError;

    public  DemoQA_Login(WebDriver driver){
       // this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void IngresarUsuario(String user){
        TXT_userName.sendKeys(user);
    }

    public void IngresaPassword(String password){
        TXT_password.sendKeys(password);
    }

    public void Login(){
        BTN_login.click();
    }

    public WebElement getTitle(){
        return  TXT_Title;
    }

    public WebElement getMensajeError(){
        return mensajeError;
    }
}
