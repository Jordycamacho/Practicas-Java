package Sokets;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Servidor {
    public static void main(String[] args) {

        MarcoServidor mimarco = new MarcoServidor();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoServidor extends JFrame implements Runnable {

    private JTextArea areaTexto;

    public MarcoServidor() {

        setBounds(800, 250, 500, 350);

        JPanel miLamina = new JPanel();

        miLamina.setLayout(new BorderLayout());

        areaTexto = new JTextArea();

        miLamina.add(areaTexto, BorderLayout.CENTER);

        add(miLamina);

        setVisible(true);

        Thread miHilo = new Thread(this);

        miHilo.start();

    }

    // .
    @Override
    public void run() {
        // 192.168.1.138
        try {

            ServerSocket server = new ServerSocket(9999);

            String nombre, ip, ms;

            ArrayList<String> listaIp = new ArrayList<String>();

            PaqueteEnvio paqueterecivido;

            while (true) {

                Socket miSoket = server.accept();

                ObjectInputStream paquete_datos = new ObjectInputStream(miSoket.getInputStream());

                paqueterecivido = (PaqueteEnvio) paquete_datos.readObject();

                nombre = paqueterecivido.getNombre();

                ip = paqueterecivido.getIp();

                ms = paqueterecivido.getMensaje();

                if (!ms.equals(" online")) {

                    areaTexto.append("\n" + nombre + ": " + ms + "\n" + "para: " + ip);

                    Socket enviaDestino = new Socket(ip, 9090);

                    ObjectOutputStream paqueteRenvio = new ObjectOutputStream(enviaDestino.getOutputStream());

                    paqueteRenvio.writeObject(paqueterecivido);

                    paqueteRenvio.close();

                    enviaDestino.close();

                    miSoket.close();

                } else {
                    // _______DETECTA ONLINE________
                    InetAddress localizacion = miSoket.getInetAddress();

                    String ipRemota = localizacion.getHostAddress();

                    System.out.print("Online " + ipRemota);

                    listaIp.add(ipRemota);

                    paqueterecivido.setIps(listaIp);

                    for (String z : listaIp) {

                        Socket enviaDestino = new Socket(z, 9090);

                        ObjectOutputStream paqueteRenvio = new ObjectOutputStream(enviaDestino.getOutputStream());

                        paqueteRenvio.writeObject(paqueterecivido);

                        paqueteRenvio.close();

                        enviaDestino.close();

                        miSoket.close();

                    }
                    // ___________________________
                }
            }

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }
    }
}