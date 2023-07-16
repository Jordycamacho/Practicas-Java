package graficos;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.*;

public class CreandoMarcoCentral {
    public static void main(String[] args) {

        MarcoCentrado centrado = new MarcoCentrado();

        centrado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centrado.setVisible(true);

    }
}

class MarcoCentrado extends JFrame {

    public MarcoCentrado() {

        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = mipantalla.getScreenSize();

        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;

        setSize(anchoPantalla / 2, alturaPantalla / 2);
        setLocation(anchoPantalla / 4, alturaPantalla / 4);

        setTitle("ventana centrada");
        /*
         * para cambiar el icono de la ventana pero puta que pereza
         * para poner una ruta es "src/nose/icono.gif"
         */
        Image miIcono = mipantalla.getImage("icono.gif");
        setIconImage(miIcono);
        LaminaConImg miLaminaConImg = new LaminaConImg();
        add(miLaminaConImg);
    }
}

class LaminaConImg extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        File miImagen = new File("src\\img\\punto.png");

        try {
            imagen = ImageIO.read(miImagen);
        } catch (IOException e) {
            System.out.println("no se encuentra tu imagen");
        }

        g.drawImage(imagen, 0, 0,null);

        int anchuraImagen = imagen.getWidth(this);
        int alturaImagen = imagen.getHeight(this);

        for(int i= 0; i<300; i++){

            for(int j =0; j<200; i++){
                
                g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*j);
            }
        }

    }

    private Image imagen;
}
