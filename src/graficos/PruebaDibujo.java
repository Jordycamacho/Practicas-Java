package graficos;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class PruebaDibujo {
    public static void main(String[] args) {
        MarcoDibijos marcoD = new MarcoDibijos();
        marcoD.setVisible(true);
        marcoD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoDibijos extends JFrame{
    public MarcoDibijos() {
        setTitle("Pruea dibujo");
        setBounds(400, 200, 600, 400);
        LaminasFiguras laminas = new LaminasFiguras();
        add(laminas);

        laminas.setBackground(new Color(132,35,13));
    }
}

class LaminasFiguras extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        Rectangle2D rect = new Rectangle2D.Double(100,100,200,200);
        g2.setPaint(Color.GREEN);
        g2.draw(rect);

        g2.setPaint(Color.BLUE);
        g2.fill(rect);

        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rect);
        // brighter() da brillo al color que escogas darker da oscuridad al color qu escogas 
        Color micolor = new Color(0,140,255).brighter();
        g2.setPaint(micolor);
        g2.fill(elipse);

        /* 
        dibija linea
        g2.draw(new Line2D.Double(100,100,300,300));

        variables para centrarlo 

        double centroX = rect.getCenterX();
        double centroy = rect.getCenterY();
        double radio = 200;

        dibuja un circulo re rodea todo centrado
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(centroX, centroy,centroX+radio,centroy+radio);
        g2.draw(circulo);
        */
        /*
        g.drawRect(50, 50, 200, 200);
        g.drawLine(100, 100, 300, 200);
        g.drawArc(50, 100, 222, 222, 213, 213);
        */
    }
}
