package vista;

/**
 *
 * @author Sergio Dorantes Godino
 */
public class InterfazPorConsola {

    public void mostrarPorConsola() {

        System.out.println("""
                                   
                                          BIENVENIDO A HANGMAN
                                    
                         -------------------------------------------------------
                                   
                                             Elige una opcion:                    
                                                                              
                           A.Login/Regitro   
                                          
                           B.Establecer la longitud de palabra(dificultad)  
                                   
                           C.Establecer el numero de intentos(vidas)
                                   
                           D.Jugar
                                   
                           E.Guardar la ultima partida jugada
                                   
                           F.Estadisticas
                                   
                           G.Salir
                         
                         -------------------------------------------------------
                           
                           """);

    }

    public void visualizarRegistro() {

        System.out.println("""
                           
                                       Eliga la opción que desee:
                           
                           ----------------------------------------------
                           
                           1.Registrate
                               
                           2.Acceder sin usuario  
                           
                           3.Volver al menu
                           
                           ---------------------------------------------
                           
                           
                           """);

    }

    //metodo generico para pasar datos de tipo String 
    public void mostrar(String s) {

        System.out.println(s);

    }

    public void seleccionarDificultad() {

        System.out.println("""
                           
                           Selecciona la dificultad que mas desee:
                           
                    -------------------------------------------------------
                           
                           1.Facil
               
                           2.Medio
                                                                         
                           3.Dificil
                    
                           5.Volver al menu
                           
                    -------------------------------------------------------
                           
                           
                           """);

    }

  

}
