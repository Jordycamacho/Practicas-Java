package exepciones;

import javax.swing.JOptionPane;

public class exepciones1 {
    
    public static void main(String[] args) {
        int [] array = new int[5];

        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        for (int i = 0; i < array.length; i++) {
            System.out.println("Posicion " + i + " = " + array[i] );
        }
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));

        JOptionPane.showMessageDialog(null, "Hola " + nombre + "Tienes " + edad + " años");
    }

}
