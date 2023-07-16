package defecto;

import java.util.Scanner;

public class Uso_tallas {
/*un tipo enumerado consiste en que dentro de una variable solo se pueda guardar un tipo de dato 
 * no puede declararse dentro de una clase un tipo enumerado
*/
  //enum Talla {MINI, MEDIANO, GRANDE, MUY_GRANDE };

  enum Talla {
    MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");
      
    private  Talla(String abreviatura) {
          this.abreviatura = abreviatura;
        }
        public String dameAbreviatura(){
            return  abreviatura;
        }
        private String abreviatura;
  }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe una talla: MINI, MEDIANO, GRANDE, MUY GRANDE");
        String entrada_datos = sc.next().toUpperCase();
        Talla la_talla = Enum.valueOf(Talla.class, entrada_datos);
        System.out.println("Talla: " + la_talla + " y " + "Abreviatura: " + la_talla.dameAbreviatura());
        sc.close();
    }
}
