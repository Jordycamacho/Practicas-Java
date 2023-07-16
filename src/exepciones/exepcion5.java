package exepciones;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class exepcion5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Elige una opcion \n1: Cuadrado \n2: Rectangulo \n3: Triangulo \n4: Circulo");

        try {
            figura = sc.nextInt();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "por que introduces texto si pide numero? :)");
        } finally {
            // Finally sirve para ejecutar siempre un comando ya sea si va bien el codigo o
            // mal
            sc.close();

        }

        switch (figura) {
            case 1:
                int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
                JOptionPane.showInputDialog(Math.pow(lado, 2));
                break;

            case 2:
                int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
                int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
                JOptionPane.showInputDialog("El area del rectangulo es de " + base * altura);
                break;

            case 3:
                base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
                altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
                JOptionPane.showInputDialog("El area del triangulo es de " + (base * altura) / 2);

            case 4:
                int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
                JOptionPane.showInputDialog("El area del circulo es de " + Math.PI * (Math.pow(radio, 2)));

                break;

            default:
                JOptionPane.showMessageDialog(null, "La opcion es incorrecta");
                break;
        }

        int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm"));
        JOptionPane.showMessageDialog(null, "Si eres hombre tu peso ideal es: " + (altura - 110) + "Kg");
        JOptionPane.showMessageDialog(null, "Si eres mujer tu peso ideal es: " + (altura - 120) + "Kg");

    }

    static int figura;
}
