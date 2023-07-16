package poo;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;


public class PruebaTemporizador {
      public static void main(String[] args) {
        
        DameLaHora oyente = new DameLaHora();
        
        Timer miTemporizador = new Timer(5000, oyente);
        
        miTemporizador.start();

        JOptionPane.showMessageDialog(null, "pulsa para detener");

    }
}

class DameLaHora implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        
        Date ahora = new Date();

        System.out.println("a las: " + ahora + " me cogi a tu madre");

        Toolkit.getDefaultToolkit().beep();
    }
}
