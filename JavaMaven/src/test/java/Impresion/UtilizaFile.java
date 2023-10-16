package Impresion;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.awt.*;
import java.io.IOException;

public class UtilizaFile {
    GeneraEvidencias imprimir;
    public void InicializaFile() throws IOException, InvalidFormatException, AWTException {
        imprimir.defineVariables();
    }

    public void pasoScript(int i, String descripcionPaso) throws IOException, InvalidFormatException, AWTException {
        imprimir.OpenFile(i, descripcionPaso );
        imprimir.screenshoot();
    }

    public void Generaword(String NombreArchivo) throws IOException {
        imprimir.CloseFile(NombreArchivo);
    }

}
