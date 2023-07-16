package exepciones;

import javax.swing.JOptionPane;

// Crear tus propias exeptions
public class exepciones3 {
    public static void main(String[] args) {
        String email = JOptionPane.showInputDialog("El email es muy corto");

        try {
            Examina_mail(email);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "La direccion email no es correcta");
            e.printStackTrace();

        }
    }

    public static void Examina_mail(String mail) throws Longitud_mailError {

        int arroba = 0;
        boolean punto = false;

        if (mail.length() <= 3) {

            throw new Longitud_mailError("El email es del tamaño de tu pito");

        } else {
            for (int i = 0; i < mail.length(); i++) {
                if (mail.charAt(i) == '@') {
                    arroba++;
                }
                if (mail.charAt(i) == '.') {
                    punto = true;
                }
            }

            if (arroba == 1 && punto == true) {
                JOptionPane.showMessageDialog(null, "Es correcto");
            } else {
                JOptionPane.showMessageDialog(null, "Es incorrecto");
            }

        }

    }
}

class Longitud_mailError extends Exception{

    public Longitud_mailError (){

    }

    public Longitud_mailError(String msj_error){

        super(msj_error);
    }
}
