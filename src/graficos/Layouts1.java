package graficos;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts1 {
    
    public static void main(String[] args) {
        
        MarcoLayout marco = new MarcoLayout();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.setVisible(true);
    }
}


class MarcoLayout extends JFrame {

    public MarcoLayout (){

        setTitle("layouts 1");
        setBounds(500, 300, 600,300);
        Panel_layout lamina = new Panel_layout();
        
        FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
        lamina.setLayout(disposicion);
        add(lamina);
    }
}

class Panel_layout extends JPanel{

    public Panel_layout (){
        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
        add(new JButton("Azul"));
    }
}