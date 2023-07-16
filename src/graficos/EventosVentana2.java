package graficos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class EventosVentana2 {

    public static void main(String[] args) {

        Marcoventana mimarco = new Marcoventana();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class Marcoventana extends JFrame {

    public Marcoventana() {

        setVisible(true);

        setBounds(300, 300, 500, 350);

        addWindowStateListener(new CambioEstados());
    }
}

class CambioEstados implements WindowStateListener{

    public void windowStateChanged(WindowEvent e) {

        System.out.println("La ventana a cambiado de estado");

        if(e.getNewState() == Frame.MAXIMIZED_BOTH){
            System.out.println("La ventana esta a pantalla completa");
        }else if(e.getNewState() == Frame.NORMAL){
            System.out.println("La ventana esta normal");
        }
    } 

}