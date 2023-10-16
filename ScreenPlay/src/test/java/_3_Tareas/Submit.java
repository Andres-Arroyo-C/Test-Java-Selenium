package _3_Tareas;

import _1_Objatos.PO_StudentRegistration_DemoQA;
import _2_Acciones.Button;
import _2_Acciones.Escribir;
import org.openqa.selenium.WebDriver;

public class Submit {
    public static  void EnviarFormulario(WebDriver driver, String name, String lastname, String email, String number, String current) throws InterruptedException {
        Escribir.EscribirSobre(driver, PO_StudentRegistration_DemoQA.name, name);
        Escribir.EscribirSobre(driver, PO_StudentRegistration_DemoQA.lastName, lastname);
        Escribir.EscribirSobre(driver, PO_StudentRegistration_DemoQA.email, email);
        Escribir.EscribirSobre(driver, PO_StudentRegistration_DemoQA.number, number);
        Escribir.EscribirSobre(driver, PO_StudentRegistration_DemoQA.currentAddress, current);
        Button.ClickSobre(driver, PO_StudentRegistration_DemoQA.gender1);
        Button.ClickSobre(driver, PO_StudentRegistration_DemoQA.submit);
        Button.ClickSobre(driver,PO_StudentRegistration_DemoQA.modal);

    }
}
