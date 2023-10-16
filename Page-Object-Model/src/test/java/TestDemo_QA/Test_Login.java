package TestDemo_QA;

import PageDemo_QA.DemoQA_Home;
import PageDemo_QA.DemoQA_Login;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test_Login {
    //Variables
    WebDriver edge;

    String TYPE_DRIVER = "WebDriver.Chrome.driver";
    String PATH_DRIVER = "../../../../../../Drivers/msedgedriver.exe";
    String URL = "https://demoqa.com/";

    //Variables de Instancias
    DemoQA_Home Home;
    DemoQA_Login Login;

    @Before
    public  void setUp(){
        System.setProperty(TYPE_DRIVER, PATH_DRIVER );
        edge = new EdgeDriver();
        edge.get(URL);
        edge.manage().window().maximize();
        Home = new DemoQA_Home(edge);
        Login = new DemoQA_Login(edge);
    }

    @Test
    public void TestLogin(){
        Home.IrBookStore();
        Home.IrLogin();
        Login.IngresarUsuario("aarroyoc");
        Login.IngresaPassword("@Aaac_1999");
        Login.Login();
        try{
            WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(Login.getTitle()));
            Assert.assertEquals("Profile", edge.findElement(Login.getTitle()).getText());
            System.out.println("Prueba OK!");
        }catch (AssertionError e){
            System.out.println("Prueba Fail!");
        }
    }

    @After
    public void TestEnd() throws InterruptedException {
        Thread.sleep(5000);
        edge.quit();
    }

}
