package Fotografias;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FotoRobot {

    public  static void TomarFotos(String nombreFoto)  {

        try {
            Thread.sleep(2000);
            String formato = ".png";
            String Path = "target/src/fotos/Robot/";
            String Archivo = Path + nombreFoto + formato;

           // Robot robot = new Robot();
            BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(img, "png", new File(Archivo));
            System.out.println("Fotografía tomada Robot");
        } catch (AWTException awtException) {
            awtException.printStackTrace();
            System.out.println("Se produjo una excepción AWTException: " + awtException.getMessage());
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("Se produjo una excepción IOException: " + ioException.getMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Se produjo una excepción general: " + exception.getMessage());
        }
    }


}
