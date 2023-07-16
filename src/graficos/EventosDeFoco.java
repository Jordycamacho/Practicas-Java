package graficos;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventosDeFoco {

    public static void main(String[] args) {
        MarcoConFoco miMarco = new MarcoConFoco();

        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoConFoco extends JFrame {

    public MarcoConFoco() {

        setTitle("Eventos teclado");

        setVisible(true);

        setBounds(500, 200, 600, 400);

        add(new LaminaFoco());

    }
}

class LaminaFoco extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setLayout(null);

        cuadro1 = new JTextField();
        cuadro2 = new JTextField();

        cuadro1.setBounds(120, 10, 150, 20);
        cuadro2.setBounds(120, 50, 150, 20);

        add(cuadro1);
        add(cuadro2);

        Focos elFoco = new Focos();

        cuadro1.addFocusListener(elFoco);
    }

    JTextField cuadro1;
    JTextField cuadro2;

    private  class Focos implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            
            String email = cuadro1.getText();

            boolean comprobar = false;

            for (int i = 0; i < email.length(); i++) {
                
                if(email.charAt(i)== '@'){
                    comprobar = true;
                }
            }

            if(comprobar){
                System.out.println("El email es correcto");
            }else{
                System.out.println("El email es incorrecto");
            }
        }

    }
}
