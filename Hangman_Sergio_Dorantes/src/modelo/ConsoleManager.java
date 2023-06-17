package modelo;

import java.util.Scanner;
import java.util.regex.Pattern;

import vista.InterfazPorConsola;

/**
 *
 * @author Sergio Dorantes Godino
 */
public class ConsoleManager {

    public void menuConsola() {

        Scanner sc = new Scanner(System.in);

        String opcion = "";
        InterfazPorConsola ipc = new InterfazPorConsola();
        Pattern opcionesValidas = Pattern.compile("[A-Ga-g]");
        do {
            ipc.mostrarPorConsola();
            opcion = sc.nextLine();
        } while (!opcionesValidas.matcher(opcion).matches());
        switch (opcion) {

            case "A":
            case "a":

                InterfazPorConsola muestra = new InterfazPorConsola();

                muestra.visualizarRegistro();

                MetodosMenu login = new MetodosMenu();

                login.registroLogin();

                break;

            case "B":
            case "b":

                break;

            case "C":
            case "c":

                break;

            case "D":
            case "d":

                InterfazPorConsola interfaz = new InterfazPorConsola();

                String jugador = "default";
                JuegoFunciones juego = new JuegoFunciones(jugador);
                juego.jugarPartida();

                //JuegoFunciones juegoFunciones = new JuegoFunciones();
                //juegoFunciones.estructuracionDelJuego();
                break;

            case "E":
            case "e":

                break;

            case "F":
            case "f":

                break;

            case "G":
            case "g":

                break;

            default:

                System.out.println(Constantes.OPCION_INCORRECTA);
                //opcion = sc.nextLine();
                break;

        }

        sc.close();

    }

}
