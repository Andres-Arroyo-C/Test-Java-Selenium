package Fotografias;


import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class FotoTekeScreen {
    public static void TomarFotos(String nombreFoto, WebDriver driver) {

        try {
            Thread.sleep(2000);
            String formato = ".png";
            String Path = "target/src/fotos/TakeScreenShot/";
            String Archivo = Path + nombreFoto + formato;

            File screenShot;
            screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(Archivo));
            System.out.println("Fotografía tomada FotoTekeScreen");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Se produjo una excepción general: " + exception.getMessage());
        }
    }
}
