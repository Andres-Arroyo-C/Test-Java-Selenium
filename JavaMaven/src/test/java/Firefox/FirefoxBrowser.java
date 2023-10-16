package Firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class  FirefoxBrowser {
    @Test
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicio de la prueba");
        System.setProperty("webdriver.firefox.driver", "C:\\Cursos\\Selenium\\Drivers\\geckodriver.exe");
        WebDriver firefox = new FirefoxDriver();
        firefox.manage().window().maximize();
        firefox.get("https://demoqa.com/");
        System.out.println("Abriendo la página");
        WebDriverWait wait = new WebDriverWait(firefox, Duration.ofSeconds(10));
        JavascriptExecutor js =  (JavascriptExecutor) firefox;

        try {

            //div[@class="category-cards"]/child::div[6]
            WebElement BookStore = firefox.findElement(By.xpath("//div[@class=\"category-cards\"]/child::div[6]"));
            js.executeScript("arguments[0].scrollIntoView();", BookStore);
            if (BookStore.isDisplayed() && BookStore.isEnabled()) {
                BookStore.click();
                System.out.println("Haciendo click en BookStore = " + BookStore);
            } else {
                System.out.println("No se encontro BookStore");
            }

            WebElement TextoObtenido1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Understanding ECMAScript 6\"]")));
            js.executeScript("arguments[0].scrollIntoView();", TextoObtenido1);
            String TextoDeseado1 = "Understanding ECMAScript 6";
           // Assert.assertEquals(TextoObtenido1.getText(), TextoDeseado1);
            if (TextoObtenido1.getText().equals(TextoDeseado1)){
                System.out.println("Los textos: " + "'" +TextoObtenido1.getText() + "'" +" y " + "'" +TextoDeseado1 + "'" + " Son iguales!");
            }

            Thread.sleep(5000);



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se produjo un error durante la prueba");
        } finally {
            firefox.quit();
            System.out.println("Fin de la prueba");
        }
    }
}
