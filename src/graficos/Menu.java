package graficos;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu {

    public static void main(String[] args) {

        MenisLamina menu = new MenisLamina();

        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MenisLamina extends JFrame {

    public MenisLamina() {

        setTitle("meniu");
        setBounds(500, 300, 550, 400);

        MenuLamina miLamina = new MenuLamina();

        add(miLamina);

        setVisible(true);
    }
}

class MenuLamina extends JPanel {
    public MenuLamina() {

        JMenuBar mibarra = new JMenuBar();

        JMenu archivo = new JMenu("archivo");
        JMenu edicion = new JMenu("edicion");
        JMenu herramientas = new JMenu("herramientas");
        JMenu opciones = new JMenu("Opciones");

        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardar_como = new JMenuItem("Guardar como");

        JMenuItem cortar = new JMenuItem("Cortar");
        JMenuItem copiar = new JMenuItem("Copiar");
        JMenuItem pegar = new JMenuItem("pegar");


        JMenuItem generales = new JMenuItem("generales");

        JMenuItem opcion1 = new JMenuItem("opcion 1");
        JMenuItem opcion2 = new JMenuItem("opcion 2");
        
        archivo.add(guardar);
        archivo.add(guardar_como);

        edicion.add(cortar);
        edicion.add(copiar);
        edicion.add(pegar);
        edicion.addSeparator();
        edicion.add(opciones);

        herramientas.add(generales);

        opciones.add(opcion1);
        opciones.add(opcion2);


        mibarra.add(archivo);
        mibarra.add(edicion);
        mibarra.add(herramientas);

        add(mibarra);

    }
}
