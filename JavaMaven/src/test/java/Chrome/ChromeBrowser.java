package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChromeBrowser {
    public static void main(String[] args) {
        System.out.println("Inicio de la prueba");
        System.setProperty("webdriver.chrome.driver", "C:\\Cursos\\Selenium\\Drivers\\chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) chrome;
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10)); // Espera explícita con tiempo límite de 10 segundos


        chrome.get("https://demoqa.com/");
        System.out.println("Abriendo la página");

        try {

            WebElement Elements = chrome.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div"));
            js.executeScript("arguments[0].scrollIntoView();", Elements);
            if (Elements.isEnabled()){
                System.out.println("Haciendo clic en Elements");
                Elements.click();
            }else {
                System.out.println("No se pudo dar cclic en Elements");
            }



            WebElement ClosedElements = chrome.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div/div[2]/div[2]"));
            js.executeScript("arguments[0].scrollIntoView();", ClosedElements);
            if (ClosedElements.isEnabled()){
                System.out.println("Cerrando Elemento 1");
                ClosedElements.click();
            }else {
                System.out.println("No se pudo cerrar el elemento 1");
            }

            WebElement BookStore = chrome.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[6]/span/div/div[1]"));
            js.executeScript("arguments[0].scrollIntoView();", BookStore);
            if(BookStore.isEnabled()){
                System.out.println("Abriendo Book Store");
                BookStore.click();
            } else{
                System.out.println("No se pudo abrir Book Store");
            }

           //Thread.sleep(5000);
            WebElement ElLogin = chrome.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
            WebElement Login = wait.until(ExpectedConditions.elementToBeClickable(ElLogin));
           //WebElement Profile = chrome.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
            js.executeScript("arguments[0].scrollIntoView();", Login);
            if (Login.isEnabled() && Login.isDisplayed()){
                System.out.println("Abriendo el Profile");
                Login.click();
            }else {
                System.out.println("No se pudo abrir el Profile");
            }

            WebElement User = chrome.findElement(By.id("userName"));
            js.executeScript("arguments[0].scrollIntoView();", User);
            if (User.isEnabled() && User.isDisplayed()){
                System.out.println("Ingresando Usuario");
                User.sendKeys("aarroyoc");
            }else {
                System.out.println("No se pudo Ingresando Usuario");
            }

            WebElement Password = chrome.findElement(By.id("password"));
            js.executeScript("arguments[0].scrollIntoView();", Password);
            if(Password.isDisplayed() && Password.isEnabled()){
                System.out.println("Ingresando Contrasena");
                Password.sendKeys("@Aaac_1999");
            }else {
                System.out.println("No se pudo Ingresando Contrasena");
            }

            WebElement BtnLogin = chrome.findElement(By.id("login"));
            js.executeScript("arguments[0].scrollIntoView();", BtnLogin);
            if (BtnLogin.isEnabled() && BtnLogin.isDisplayed()){
                BtnLogin.click();
                System.out.println("Login Exitoso!");
            }
            Thread.sleep(5000);



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se produjo un error durante la prueba");
        } finally {
            chrome.quit();
            System.out.println("Fin de la prueba");
        }
    }
}
