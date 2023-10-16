package IEBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser {

    public static void main (String [] args) throws InterruptedException {
        System.out.println("Inicio de la prueba");
        System.setProperty("webdriver.ie.driver", "C:\\Cursos\\Selenium\\Drivers\\IEDriverServer.exe");
        WebDriver IExplorer = new InternetExplorerDriver();
        IExplorer.manage().window().maximize();
        IExplorer.get("https://google.com/");
        System.out.println("Abriendo la página");
        Thread.sleep(5000);
        IExplorer.quit();
        System.out.println("Fin de la prueba");
    }
}
