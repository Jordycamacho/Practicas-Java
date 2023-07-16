package graficos;
import javax.swing.*;

public class CreandoMarcos {
    public static void main(String[] args) {
        miMarco marco1 = new miMarco();

        marco1.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}


class miMarco extends JFrame{
    public miMarco() {
        //setSize(500, 600);
        
        setBounds(500,300,550,250);

        // Si es false no permite minimizar ni maximizar
        //setResizable(false);
    
        //Muesta la ventana en pantalla completa
        //setExtendedState(Frame.MAXIMIZED_BOTH);

        setTitle("Mi ventana");
    }
}