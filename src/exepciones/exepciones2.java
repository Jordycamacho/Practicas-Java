package exepciones;

import java.io.IOException;
import java.util.Scanner;

public class exepciones2 {
    public static void main(String[] args) {
        System.out.println("¿Que deseas hacer?");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");

        Scanner entrada = new Scanner(System.in);

        int desicion = entrada.nextInt();
        if (desicion == 1) {

            try {
                pedirDatos();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("No seas retrasado introduce un numero en la edad");
            }
        } else if (desicion == 2) {
            System.out.println("Adios");
            System.exit(0);
        } else {
            System.out.println("No has ingresado una opcion valida pendejo");
        }

        entrada.close();
    }

    static void pedirDatos() throws IOException{
        //try {
            Scanner entrada = new Scanner(System.in);

            System.out.println("Ingresa tu nombre");

            String nom_Usuario = entrada.nextLine();

            System.out.println("Ingresa tu edad");

            int edad = entrada.nextInt();

            System.out.println("Hola " + nom_Usuario + " el año que viene tendras  " + (edad + 1) + " años viejo");

            entrada.close();

        //} catch (Exception e) {
            // TODO: handle exception

            System.out.println("No seas retrasado introduce un numero en la edad");
        //}

        System.out.println("Terminamos");
    }
}
