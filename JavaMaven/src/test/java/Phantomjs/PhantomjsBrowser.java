package Phantomjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomjsBrowser {
    public static void main(String[] args) throws InterruptedException {
        //cambiar la version de selenium para ejecutar

        System.out.println("Inicio de la prueba");
        System.setProperty("phantomjs.binary.path", "C:\\Cursos\\Selenium\\Drivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        WebDriver phantomjs =  new PhantomJSDriver();
        phantomjs.manage().window().maximize();
        phantomjs.get("http://demoqa.com");
        System.out.println("Abriendo página");
        Thread.sleep(5000);
        phantomjs.quit();
        System.out.println("Fin de la prueba");



    }
}
