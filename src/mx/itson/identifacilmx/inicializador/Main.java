
package mx.itson.identifacilmx.inicializador;

import mx.itson.identifacilmx.ui.Ventana;
/**
 * Inicia la aplicación.
 * 
 * @author Jesús Armando Arce Baldenebro
 * @version v1.0
 */
public class Main {
    /**
     * Punto de entrada del programa.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Ventana principal=new Ventana();
        // Centra la ventana en la pantalla.
        principal.setLocationRelativeTo(null);
        // Asigna un título a la ventana.
        principal.setTitle("IdentiFacilMx");
        // Hace visible la ventana.
        principal.setVisible(true);
    }
}
