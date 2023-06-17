
package controlador;

import modelo.ConsoleManager;
import vista.InterfazPorConsola;

/**
 *
 * @author Sergio Dorantes Godino
 */
public class Main {
    
     
    public static void main(String[] args) {
        
        
        //insertamos el mensaje de bienvenida
        
       // InterfazPorConsola mostrar  = new InterfazPorConsola();
        
       // mostrar.mostrarPorConsola();
        
        //insertamos el método para elegir la opción que queremos del menuA
        
        ConsoleManager menu = new ConsoleManager();
        
        menu.menuConsola();
        
        
    }
    
    
}