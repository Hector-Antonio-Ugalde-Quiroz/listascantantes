/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class jueves {
    
    private File archivo;
    private BufferedReader br;
    private FileReader fr;
    private String arreglo[];
    
    public void leer(String _path) {
        try {
            arreglo = new String[5];
            archivo = new File(_path);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String texto = "";
            int aux = 0;
            while ((texto = br.readLine()) != null) {
                arreglo[aux] = texto;
                aux++;
            }
            reemplazar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Alerta!!!", 1);
        }
    }
    
    private void reemplazar() {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            cadena = arreglo[i];
            if (cadena.contains("?")) {
                Scanner r = new Scanner(System.in);
                arreglo[i] = r.nextLine();
                        
            } else if (cadena.contains("#")) {
                Date fecha = new Date();
                arreglo[i]=fecha.toString();
            }
        } imprimir();
    }

    private void imprimir() {
        for (int i = 0; i < arreglo.length; i++) {
            System.err.println(arreglo[i]);
        }

    }
   
}
