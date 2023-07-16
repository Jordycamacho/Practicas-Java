package graficos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class EventosVentana {

    public static void main(String[] args) {
        MarcoVentana marco = new MarcoVentana();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MarcoVentana marco2 = new MarcoVentana();

        marco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        marco.setTitle("Ventana1");

        marco2.setTitle("Ventana2");

        marco.setBounds(300, 300, 500, 350);

        marco2.setBounds(900, 300, 500, 350);

    }
}

class MarcoVentana extends JFrame {

    public MarcoVentana() {

        //setTitle("evento ventana");
        
        //setBounds(300, 300, 500, 350);
        
        setVisible(true);

        /*  
        M_Ventana oyenteVentana = new M_Ventana();
        
        addWindowListener(oyenteVentana);
        */

        addWindowListener(new M_Ventana());

    }

}

class M_Ventana extends WindowAdapter{
    
    

    

    public void windowIconified (WindowEvent e){

        System.out.println("Ventana minimizada");
    
    }

}
