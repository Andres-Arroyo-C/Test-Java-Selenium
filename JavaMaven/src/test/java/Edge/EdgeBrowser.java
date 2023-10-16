package Edge;

import Fotografias.FotoRobot;
import Fotografias.FotoTekeScreen;
import Impresion.UtilizaFile;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class EdgeBrowser {

    public static void main(String[] args)  {
        System.out.println("Inicio de la prueba");
        System.setProperty("webdriver.edge.driver", "C:\\Cursos\\Selenium\\Drivers\\msedgedriver.exe");
        WebDriver edge = new EdgeDriver();
        edge.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) edge;
        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(10));
        ATUTestRecorder grabarVideo = null;
        UtilizaFile imprimeEvidencia = new UtilizaFile();


        try {
            grabarVideo = new ATUTestRecorder("target/src/videos/", "demoqa", false);
            grabarVideo.start();
            imprimeEvidencia.InicializaFile();
            edge.get("https://demoqa.com/");
            System.out.println("Abriendo la página Web");
            FotoRobot.TomarFotos("1-Abriendo-pagina");
            FotoTekeScreen.TomarFotos("1-Abriendo-pagina", edge);
            imprimeEvidencia.pasoScript(1, "Abriendo-pagina" );

            //div[@class="category-cards"]/child::div[6]
            WebElement BookStore = edge.findElement(By.xpath("//div[@class=\"category-cards\"]/child::div[6]"));
            js.executeScript("arguments[0].scrollIntoView();", BookStore);
            if (BookStore.isDisplayed() && BookStore.isEnabled()) {
                BookStore.click();
                System.out.println("Haciendo click en BookStore = " + BookStore);
            } else {
                System.out.println("No se encontro BookStore");
            }
            FotoRobot.TomarFotos("2-Pagina-BookStore");
            FotoTekeScreen.TomarFotos("2-Pagina-BookStore", edge);
            imprimeEvidencia.pasoScript(2, "Pagina-BookStore" );

            WebElement Login = edge.findElement(By.xpath("//div[@class=\"element-list collapse show\"]/descendant::li[1]"));
            js.executeScript("arguments[0].scrollIntoView();", Login);
            if (Login.isDisplayed() && Login.isEnabled()) {
                Login.click();
                System.out.println("Haciendo click en Login = " + Login);
            } else {
                System.out.println("No se encontro Login");
            }
            FotoRobot.TomarFotos("3-log-in");
            FotoTekeScreen.TomarFotos("3-log-in", edge);
            imprimeEvidencia.pasoScript(3, "Pagina-log-in" );

            WebElement User = edge.findElement(By.id("userName"));
            js.executeScript("arguments[0].scrollIntoView();", User);
            if (User.isEnabled() && User.isDisplayed()) {
                System.out.println("Ingresando Usuario");
                User.sendKeys("aarroyoc");
            } else {
                System.out.println("No se pudo Ingresando Usuario");
            }
            FotoRobot.TomarFotos("4-Ingreso-user");
            FotoTekeScreen.TomarFotos("4-Ingreso-user", edge);
            imprimeEvidencia.pasoScript(4, "Ingreso-user" );

            WebElement Password = edge.findElement(By.id("password"));
            js.executeScript("arguments[0].scrollIntoView();", Password);
            if (Password.isDisplayed() && Password.isEnabled()) {
                System.out.println("Ingresando Contrasena");
                Password.sendKeys("@Aaac_1999");
            } else {
                System.out.println("No se pudo Ingresando Contrasena");
            }
            FotoRobot.TomarFotos("5-Ingreso-password");
            FotoTekeScreen.TomarFotos("5-Ingreso-password", edge);
            imprimeEvidencia.pasoScript(5, "Ingreso-password" );

            WebElement BtnLogin = edge.findElement(By.id("login"));
            js.executeScript("arguments[0].scrollIntoView();", BtnLogin);
            if (BtnLogin.isEnabled() && BtnLogin.isDisplayed()) {
                BtnLogin.click();
                System.out.println("Login Exitoso!");
            }
            FotoRobot.TomarFotos("6-Pagina-login");
            FotoTekeScreen.TomarFotos("6-Pagina-login", edge);
            imprimeEvidencia.pasoScript(6, "Pagina-Inicio" );

            Thread.sleep(5000);
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        } finally{
            if (edge != null) {
                edge.quit();
            }
            if (grabarVideo != null){
                try {
                    grabarVideo.stop();
                } catch (ATUTestRecorderException e) {
                    System.out.println("Error al detener la grabación de video: " + e.getMessage());
                }
            }

            System.out.println("Fin de la prueba");
            try {
                imprimeEvidencia.Generaword("Login-DemoQA.docx");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
