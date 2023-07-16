package graficos;

import javax.swing.JFrame;
import java.awt.event.*;

public class EventosMouse {

    public static void main(String[] args) {
        MarcoConMouse miMarco = new MarcoConMouse();

        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoConMouse extends JFrame {

    public MarcoConMouse() {

        setTitle("Eventos teclado");

        setVisible(true);
        
        setBounds(500, 200, 600, 400);

        EventosDeRaton rata = new EventosDeRaton();

        addMouseListener(rata);

    }
}

class EventosDeRaton extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
    }


}