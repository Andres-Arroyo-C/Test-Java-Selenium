package PageObject.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.net.SocketException;

public class DemoQA_Login {

    By BookStore = By.xpath("//div[@class=\"category-cards\"]/child::div[6]");
    By Login = By.xpath("//div[@class=\"element-list collapse show\"]/descendant::li[1]");
    By User = By.id("userName");
    By Password = By.id("password");
    By Page_Login = By.id("login");

    WebDriver driver;
    JavascriptExecutor js;
    public void IniciarPrueba(WebDriver driver){
        System.out.println("Inicio de la prueba");
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;

    }
    public void FinalizarPrueba() {
        try {
            System.out.println("Finalizar prueba 1");
            this.driver.close();
            System.out.println("Finalizar prueba 2");
        } catch (Exception e) {
            System.err.println("Excepción capturada: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void SeleccionaBookStore() throws InterruptedException {
        Thread.sleep(5000);

        if (driver.findElement(BookStore).isDisplayed() && driver.findElement(BookStore).isEnabled()) {
            System.out.println("Haciendo click en BookStore");
            this.js.executeScript("arguments[0].scrollIntoView();",driver.findElement(BookStore));
            driver.findElement(BookStore).click();
        } else {
            System.out.println("No se encontro BookStore");
        }
    }

    public void SeleccionaLogin()throws InterruptedException {
        Thread.sleep(5000);
        if (driver.findElement(Login).isDisplayed() && driver.findElement(Login).isEnabled()) {
            System.out.println("Haciendo click en Login");
            this.js.executeScript("arguments[0].scrollIntoView();",driver.findElement(Login));
            driver.findElement(Login).click();
        } else {
            System.out.println("No se encontro Login");
        }
    }

    public void IngresaUSer(String user)throws InterruptedException {
        Thread.sleep(5000);
        if (driver.findElement(User).isDisplayed() && driver.findElement(User).isEnabled()) {
            System.out.println("Haciendo click en User");
            this.js.executeScript("arguments[0].scrollIntoView();", driver.findElement(User));
            driver.findElement(User).sendKeys(user);
        } else {
            System.out.println("No se encontro User");
        }
    }

    public void IngresaPassword(String pass)throws InterruptedException {
        Thread.sleep(5000);
        if (driver.findElement(Password).isDisplayed() && driver.findElement(Password).isEnabled()) {
            System.out.println("Haciendo click en Password");
            this.js.executeScript("arguments[0].scrollIntoView();", driver.findElement(Password));
            driver.findElement(Password).sendKeys(pass);
        } else {
            System.out.println("No se encontro Password");
        }
    }
    public void PageLogin()throws InterruptedException {
        Thread.sleep(5000);
        if (driver.findElement(Page_Login).isDisplayed() && driver.findElement(Page_Login).isEnabled()) {
            System.out.println("Haciendo click en Page_Login");
            this.js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(Page_Login));
            driver.findElement(Page_Login).click();
        } else {
            System.out.println("No se encontro Page_Login");
        }
    }





}
