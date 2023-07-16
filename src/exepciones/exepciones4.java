package exepciones;

import javax.swing.JOptionPane;

public class exepciones4 {

    public static void main(String[] args) {
        try {

            division();
            
        } catch (ArithmeticException e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "no seas pendejo por que divides entre 0 :/");
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "No introduciste un numero entreo");
            JOptionPane.showMessageDialog(null, "Has generado un error de tipo: " + e.getClass().getName());
        }
    }

    static void division(){
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("ingresa un numero"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("ingresa otro numero"));

        JOptionPane.showMessageDialog(null, "El resultado es: " + num1/num2);
    }
}