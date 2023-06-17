import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import vista.InterfazPorConsola;

import java.util.Scanner;

/**
 *
 * @author Sergio Dorantes Godino
 **/
public class JuegoFunciones {

    public void estructuracionDelJuego() {

        int vidas = 6;

        InterfazPorConsola muestra = new InterfazPorConsola();

        Scanner scanner = new Scanner(System.in);

        String palabra = this.palabraAleatoria();

        boolean juegoTerminado = false;

        StringBuilder palabraOculta = new StringBuilder();

        for (int i = 0; i < palabra.length(); i++) {

            palabraOculta.append("_");
            if (i != palabra.length() - 1) {
                palabraOculta.append(" ");
            }
        }

        muestra.mostrar("Bienvenido a Hangman");
        muestra.mostrar("""
                            
                            La palabra a adivinar es...
                        
                                """ + palabraOculta + """
                            
                            
                        """);
        // muestra.mostrar("La palabra tiene " + palabra.length() + " letras.");

        do {

            System.out.print("\nIngresa una letra: ");
            char letra = scanner.nextLine().charAt(0);

            boolean letraDescubierta = false;
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    palabraOculta.setCharAt((i * 2), letra);
                    letraDescubierta = true;
                }
            }

            //hace que si no descubres la letra tengas un intento menos. n
            if (!letraDescubierta) {
                vidas--;
                muestra.mostrar("""
                            Incorrecto! 
                            """ + palabraOculta + """
                """);
                muestra.mostrar(" Te quedan " + vidas + " vidas");
            } else {
                muestra.mostrar("""
                            Correcto! El estado actual del juego es: 
                            """ + palabraOculta + """
                """);
            }

            if (vidas == 0) {
                muestra.mostrar("Fin del juego. La palabra secreta era: " + palabra);
                juegoTerminado = true;
            }

            if (palabraOculta.toString().replaceAll(" ", "").equals(palabra)) {
                muestra.mostrar("¡Felicidades! ¡Ganaste!");
                juegoTerminado = true;
            }
        } while (!juegoTerminado);
        scanner.close();
        
    }
    
    //Falta por añadir el array con las letras incorrectas
    

    //FEste método escoge una palabra del diccionario que luego aparecerá en el juego
    private String palabraAleatoria() {
        String palabra = "";
        try {
            List<String> palabras = Files.readAllLines(Paths.get("Hangman_Sergio_Dorantes/files/resources/spanish.txt"));
            palabra = palabras.get(new Random().nextInt(palabras.size()));
        } catch (IOException ioe) {
            System.out.println("ERROR DE LECTURA DE FICHERO");
        }
        return palabra;
    }
    

}
/*
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import vista.InterfazPorConsola;

public class JuegoFunciones {

    private static final int MAX_VIDAS = 5;

    private String jugador;
    private String palabraAdivinar;
    private StringBuilder palabraMostrada;
    private List<Character> letrasIncorrectas;
    private int vidas;

    public JuegoFunciones(String jugador) {
        this.jugador = jugador;
    }

    private void inicializarPartida() {
        palabraAdivinar = "rubio".toUpperCase();
        palabraMostrada = new StringBuilder();
        letrasIncorrectas = new ArrayList<>();
        vidas = MAX_VIDAS;

        for (int i = 0; i < palabraAdivinar.length(); i++) {
            palabraMostrada.append("_ ");
        }
    }

    private void mostrarEstadoPartida() {

        InterfazPorConsola muestra = new InterfazPorConsola();

        muestra.mostrar("\n¡Bienvenido a Hangman! [" + jugador + " ]");
        muestra.mostrar("La palabra a adivinar es... [" + palabraMostrada + "]");
        muestra.mostrar("Vidas restantes: " + vidas);
        System.out.println("Letras incorrectas: " + letrasIncorrectas);
    }

    private void comprobarLetra(char letra) {
        boolean letraEncontrada = false;

        for (int i = 0; i < palabraAdivinar.length(); i++) {
            if (palabraAdivinar.charAt(i) == letra) {
                palabraMostrada.setCharAt(i * 2, letra);
                letraEncontrada = true;
            }
        }

        if (!letraEncontrada) {
            letrasIncorrectas.add(letra);
            vidas--;
        }
    }

    private boolean haTerminado() {
        if (vidas <= 0) {
            return true;
        }

        for (int i = 0; i < palabraMostrada.length(); i++) {
            if (palabraMostrada.charAt(i) == '_') {
                return false;
            }
        }

        return true;
    }

    public void jugarPartida() {
        Scanner scanner = new Scanner(System.in);
        inicializarPartida();

        while (true) {
            mostrarEstadoPartida();
            System.out.print("Escriba una letra: ");
            char letra = scanner.nextLine().toUpperCase().charAt(0);
            comprobarLetra(letra);

            if (haTerminado()) {
                mostrarEstadoPartida();

                if (vidas > 0) {
                    System.out.println("¡Felicidades! Has adivinado la palabra.");
                } else {
                    System.out.println("¡Oh no! Has agotado tus vidas. La palabra era: " + palabraAdivinar);
                }

                break;
            }
        }
    }
}

*/