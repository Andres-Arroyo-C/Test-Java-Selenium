package _4_Pruebas;

import _3_Tareas.Submit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CasoPrueba_EnvioFormulario {
    public static void main(String args[]){
        //Variables
        WebDriver edge;
        String TYPE_DRIVER = "WebDriver.edge.driver";
        String PATH_DRIVER = "../../../../../../Drivers/msedgedriver.exe";
        String URL = "https://demoqa.com/automation-practice-form";
        System.setProperty(TYPE_DRIVER, PATH_DRIVER );
        edge = new EdgeDriver();
        edge.get(URL);
        edge.manage().window().maximize();

        try{
            Submit.EnviarFormulario(edge, "Andrés Anthony", "Arroyo C",
                    "aarroyoc@prueba.com", "0985634201",
                    "Esta es una prueba de Screenplay utilizando el patron de diseño" +
                    "Page Object Model");
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println("error al enviar formulario! = " + e.getMessage());
        }finally {
            edge.quit();
        }




    }
}
