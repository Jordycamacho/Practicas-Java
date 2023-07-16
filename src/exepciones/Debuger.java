package exepciones;

import javax.swing.JOptionPane;

public class Debuger {
    public static void main(String[] args) {
        
        int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce los elementos de la matriz"));

        int array[] = new int[elementos]; 

        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*100);
        }

        for (int elem : array) {
            System.out.println(elem);
        }
    }
}
