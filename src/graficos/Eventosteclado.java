package graficos;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Eventosteclado {

    public static void main(String[] args) {
        MarcoConTeclas miMarco = new MarcoConTeclas();

        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoConTeclas extends JFrame {

    public MarcoConTeclas() {

        setTitle("Eventos teclado");

        setVisible(true);
        
        setBounds(700, 500, 400, 300);

        EventoDeTeclado tecla = new EventoDeTeclado();

        addKeyListener(tecla);
    }
}


class EventoDeTeclado implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        char letra = e.getKeyChar();

            System.out.println(letra);
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //int codigo = e.getKeyCode();
        //System.out.println(codigo);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }


    

}
