package PageObject.Test;

import Impresion.UtilizaFile;
import PageObject.Page.DemoQA_Login;
import atu.testrecorder.ATUTestRecorder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test_Login {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver", "C:\\Cursos\\Selenium\\Drivers\\msedgedriver.exe");
        WebDriver edge = null;

        try {
            edge = new EdgeDriver();
            edge.manage().window().maximize();

            // Crear una instancia de DemoQA_Login y realizar las acciones de prueba
            DemoQA_Login dmLogin = new DemoQA_Login();
            dmLogin.IniciarPrueba(edge);
            edge.get("https://demoqa.com/");
            dmLogin.SeleccionaBookStore();
            dmLogin.SeleccionaLogin();
            dmLogin.IngresaUSer("aarroyoc");
            dmLogin.IngresaPassword("@Aaac_1999");
            dmLogin.PageLogin();
        } catch (Exception e) {
            System.err.println("Error en la prueba: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Asegurarse de cerrar el navegador al final de la prueba
            try {
                Thread.sleep(5000);

                if (edge != null) {
                    edge.close();
                }
            }catch (Exception e){
                System.out.println("e = " + e);
            }
        }
    }
}
