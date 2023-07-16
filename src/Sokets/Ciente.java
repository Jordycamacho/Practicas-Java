package Sokets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ciente {
    public static void main(String[] args) {

        Marcocliente mimarco = new Marcocliente();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

// .
class Marcocliente extends JFrame {
    public Marcocliente() {

        setBounds(200, 200, 300, 320);

        LaminaMarcoCliente miLamina = new LaminaMarcoCliente();

        add(miLamina);

        setVisible(true);

        addWindowListener(new EnviOnline());

    }
}

// _____________Envio señal online________________.
class EnviOnline extends WindowAdapter {

    public void WindowOpened(WindowEvent e) {

        try {

            Socket miSocket = new Socket("192.168.1.27", 9999);

            PaqueteEnvio datos = new PaqueteEnvio();

            datos.setMensaje(" online");

            ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

            paqueteDatos.writeObject(datos);

            miSocket.close();

        } catch (Exception e2) {

            System.out.println(e2.getMessage());

        }
    }
}

class LaminaMarcoCliente extends JPanel implements Runnable {

    public LaminaMarcoCliente() {

        String nick_user = JOptionPane.showInputDialog("Introduce tu nombre: ");

        JLabel n_nick = new JLabel("Nombre: ");

        add(n_nick);

        nick = new JLabel();

        nick.setText(nick_user);

        add(nick);

        JLabel texto = new JLabel("Online: ");

        add(texto);

        ip = new JComboBox();
        /*
         * ip.addItem("Usuario 1");
         * ip.addItem("Usuario 2");
         * ip.addItem("Usuario 3");
         * ---
         * ip.addItem("192.168.1.27");
         * ip.addItem("192.168.1.27");
         */

        add(ip);

        campoChat = new JTextArea(12, 23);

        add(campoChat);

        campo1 = new JTextField(23);

        add(campo1);

        miBoton = new JButton("Enviar");

        EnviaTexto enviar = new EnviaTexto();

        miBoton.addActionListener(enviar);

        add(miBoton);

        Thread mihilo = new Thread(this);

        mihilo.start();
    }

    private class EnviaTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            campoChat.append("\n" + campo1.getText());

            try {

                Socket miSocket = new Socket("192.168.1.27", 9999);

                PaqueteEnvio datos = new PaqueteEnvio();

                datos.setNombre(nick.getText());

                datos.setIp(ip.getSelectedItem().toString());

                datos.setMensaje(campo1.getText());

                ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());

                paqueteDatos.writeObject(datos);

                miSocket.close();

            } catch (UnknownHostException e1) {

                e1.printStackTrace();

            } catch (IOException e1) {

                System.out.println(e1.getMessage());

            }
        }
    }

    private JTextField campo1;

    private JComboBox ip;

    private JLabel nick;

    private JTextArea campoChat;

    private JButton miBoton;

    @Override
    public void run() {

        try {

            ServerSocket serverCliente = new ServerSocket(9090);

            Socket cliente;

            PaqueteEnvio paqueteRecivido;

            while (true) {

                cliente = serverCliente.accept();

                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

                paqueteRecivido = (PaqueteEnvio) flujoEntrada.readObject();

                if (!paqueteRecivido.getMensaje().equals(" online")) {

                    campoChat.append("\n" + paqueteRecivido.getNombre() + ": " + paqueteRecivido.getMensaje());

                } else {

                    ArrayList<String> ipsMenu = new ArrayList<String>();

                    ipsMenu = paqueteRecivido.getIps();

                    ip.removeAllItems();
                    
                    for (String z : ipsMenu) {

                        ip.addItem(z);

                    }

                }

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }
}

class PaqueteEnvio implements Serializable {

    private String nombre, ip, mensaje;

    private ArrayList<String> ips;

    public ArrayList<String> getIps() {
        return ips;
    }

    public void setIps(ArrayList<String> ips) {
        this.ips = ips;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
