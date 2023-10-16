package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Cargar_Archivos {

    public static void main (String [] args) throws InterruptedException {
        System.out.println("Inicio de la prueba");
        System.setProperty("webdriver.chrome.driver", "C:\\Cursos\\Selenium\\Drivers\\chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("https://demoqa.com/upload-download");
        System.out.println("Abriendo la página");
        Thread.sleep(5000);
        try{
            WebElement img = chrome.findElement(By.id("uploadFile"));
            img.sendKeys("C:\\Users\\User\\Downloads\\img.jfif");
            Thread.sleep(5000);
            WebElement clic = chrome.findElement(By.id("downloadButton"));
            if (clic.isEnabled() && clic.isDisplayed()){
                clic.click();
                Thread.sleep(5000);
            }
        }catch (Exception e){
            System.out.println("error = " + e);
        }finally {
            chrome.quit();
            System.out.println("Fin de la prueba");
        }

    }
}
