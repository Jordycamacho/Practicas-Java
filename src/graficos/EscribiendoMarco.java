package graficos;
import javax.swing.*;
import java.awt.*;

public class EscribiendoMarco {
    public static void main(String[] args) {
        
        MarcoTexto marco = new MarcoTexto();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   

}

class MarcoTexto extends JFrame{
    public MarcoTexto() {
        
        setVisible(true);
        setSize(600, 450);
        setLocation(400, 200);
        setTitle("ni puta idea");

        Lamina miLamina = new Lamina();
        add(miLamina);
    }
}

class Lamina extends JPanel {
    public void PainComponent(Graphics g) {
        //llama a todos sus caracteristicas por defecto
        super.paintComponent(g);
        //ademas agrega esto
        g.drawString("yo no se mañana si estaremos juntos si se acaba el mundo", 100, 100);
    }
}
