package modelo;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


import java.util.regex.Pattern;
import javax.xml.validation.Validator;
import vista.InterfazPorConsola;

/**
 *
 * @author Sergio Dorantes Godino
 */
public class MetodosMenu {
    
    
    private String usuario;
    private int vidas;
    
    public MetodosMenu(){
        
        usuario = " ";
    }

    public MetodosMenu(String usuario) {
        this.usuario = usuario;
    }
    
    


    public void registroLogin() {

        /* Login / Registro.
        Se puede jugar sin crear un usuario-contraseña, en ese caso, el usuario será
        “anónimo”. También se puede optar por registrarse. En este caso, se pide
        nombre de usuario, contraseña y confirmación de contraseña. El nombre de
        usuario y la contraseña deberán cumplir con un patrón: empezar por carácter,
        tener al menos cuatro caracteres y contener letras y números.
        El nombre de usuario( registrado o no) se mostrará en todas las pantallas del
        jue go.*/
        //Vamos a empezar creando las 2 opciones posibles tanto la de login como la de registro
        Scanner sc = new Scanner(System.in);

        boolean isValid = Boolean.FALSE;
        int opcion;
        InterfazPorConsola ipc = new InterfazPorConsola();

        while (!isValid) {
            try {
                opcion = sc.nextInt();
                isValid = opcion > 0 && opcion <= 3;
                switch (opcion) {
                    case 1:
                        //Registro
                        registrarUsuario(sc);

                        break;

                    case 2:
                        //Anonimo
                        ipc.mostrar(Constantes.ANONIMO);
                        //TODO: guardar nombre anonimo
                        break;

                    case 3:
                        //Salir
                        InterfazPorConsola mostrar = new InterfazPorConsola();
                        mostrar.mostrarPorConsola();

                        ConsoleManager menu = new ConsoleManager();
                        menu.menuConsola();
                        break;
                    default:
                        ipc.mostrar(Constantes.OPCION_INCORRECTA);
                        break;
                }
            } catch (InputMismatchException e) {
                ipc.mostrar(Constantes.OPCION_INCORRECTA);
                sc.nextLine();
                opcion = sc.nextInt();
            }
        }

        sc.close();
    }

    private void registrarUsuario(Scanner sc) {
        boolean usuarioValido = Boolean.FALSE;
        boolean salir = false;
        String usuario = "";
        String contrasena = "";
        InterfazPorConsola ipc = new InterfazPorConsola();
        do {

            String escribir = "";

            ipc.mostrar(Constantes.SOLICITAR_NOMBRE);
            sc.nextLine();
            escribir = sc.nextLine();
            usuarioValido = Validador.validarNombre(escribir);

            ipc.mostrar(Constantes.SOLICITAR_CONTRASENA);
            escribir = sc.nextLine();
            usuarioValido = usuarioValido && Validador.validarNombre(escribir);

            if (!usuarioValido) {
                ipc.mostrar(Constantes.USUARIO_NO_VALIDO);
            }
        } while (usuarioValido || salir);
        if (usuarioValido) {
            //TODO: registrar al usuario
            //coger los datos del usuario y guardarlos, quiero pensar que en un fichero que se usara de forma temporal y borraremos al final de cada partida una vez volcados los datos en el fichero de guardados
            //esto conllevaria en cada paso tener que leer, cuando podriamos tener un objeto Partida que tenga dentro un String usuario e ir rellenando ese objeto para luego guardarlo, este objeto partida lo podremos 
            //usar como memoria ram antes de persistirlo en el fichero de guardados
        }
    }

    public class Validador {

        public static boolean validarNombre(String entrada) {
            //Patron que combina que tenga que tener un numero obligatoriamente y que sea alfanumerico y empiece por letra
            Pattern patron = Pattern.compile("^(?=.*[0-9])(?=[a-zA-Z])[a-zA-Z0-9]{4}$");
            return patron.matcher(entrada).matches();
        }
    }

    //por defecto la palabra a escoger sera entre 3 y 5 letras y las vidas seran 7 
    public void establecerDificultad() {

    }

   public void establecerNumeroVidas() {
    Scanner scanner = new Scanner(System.in);
 
    do {
        System.out.print("Elige el número de vidas (entre 1 y 10): ");
        vidas = scanner.nextInt();
    } while (vidas < 1 || vidas > 10);

    this.vidas = vidas;
}

    public void registrarDatosPartida() {
        
        

    }
    
    public void guardarPartida(){
        
        
        
        
    }

}
