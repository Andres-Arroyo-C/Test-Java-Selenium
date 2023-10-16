package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Switch_TO {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicio de la prueba");
        System.setProperty("webdriver.chrome.driver", "C:\\Cursos\\Selenium\\Drivers\\chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) chrome;
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10)); // Espera explícita con tiempo límite de 10 segundos


        chrome.get("https://demoqa.com/");
        System.out.println("Abriendo la página");

        try {

            //div[@class="category-cards"]/child::div[6]
            WebElement Frame = chrome.findElement(By.xpath("//div[@class=\"category-cards\"]/child::div[3]"));
            js.executeScript("arguments[0].scrollIntoView();", Frame);
            if (Frame.isDisplayed() && Frame.isEnabled()) {
                Frame.click();
                System.out.println("Haciendo click en Frame = " + Frame);
            } else {
                System.out.println("No se encontro Frame");
            }

            WebElement Browser_windows = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[ @class=\"menu-list\"]/descendant::span[text()=\"Browser Windows\"]")));
            js.executeScript("arguments[0].scrollIntoView();", Browser_windows);
            if (Browser_windows.isEnabled() && Browser_windows.isDisplayed()){
                Browser_windows.click();
                System.out.println("Haciendo click en Browser_windows = " + Browser_windows);
            } else {
                System.out.println("No se encontro Browser_windows");
            }

            WebElement NewTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("tabButton")));
            NewTab.click();
            ArrayList<String> NameWindows = new ArrayList<String> (chrome.getWindowHandles());

            chrome.switchTo().window(NameWindows.get(1));
            System.out.println("NameWindows.get(1) = " + NameWindows.get(1));
            WebElement sampleHeading = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sampleHeading")));
            System.out.println("sampleHeading.getText() = " + sampleHeading.getText());
            Thread.sleep(5000);
            chrome.close();

            chrome.switchTo().window(NameWindows.get(0));
            System.out.println("NameWindows.get(0) = " + NameWindows.get(0));
            WebElement Modal_Dialogs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[ @class=\"menu-list\"]/descendant::span[text()=\"Modal Dialogs\"]")));
            js.executeScript("arguments[0].scrollIntoView();", Modal_Dialogs);
            if (Modal_Dialogs.isEnabled() && Modal_Dialogs.isDisplayed()){
                Modal_Dialogs.click();
                System.out.println("Haciendo click en Modal_Dialogs = " + Modal_Dialogs);
            } else {
                System.out.println("No se encontro Modal_Dialogs");
            }

            WebElement showLargeModal = wait.until(ExpectedConditions.elementToBeClickable(By.id("showLargeModal")));
            showLargeModal.click();
            Thread.sleep(5000);
            WebElement closeLargeModal = wait.until(ExpectedConditions.elementToBeClickable(By.id("closeLargeModal")));
            closeLargeModal.click();

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
