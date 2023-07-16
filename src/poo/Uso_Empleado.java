package poo;

import java.util.*;

public class Uso_Empleado {
    public static void main(String[] args) {

        Jefatura jefe_RRHH = new Jefatura("juan", 55000, 2006, 9, 25);

        jefe_RRHH.estableceIncentivo(2570);

        Empleado[] misEmpleados = new Empleado[6];

        misEmpleados[0] = new Empleado("ana1", 1000, 5000, 06, 05);
        misEmpleados[1] = new Empleado("ana1", 11000, 5000, 06, 05);
        misEmpleados[2] = new Empleado("ana2", 2000, 4000, 05, 04);
        misEmpleados[3] = new Empleado("ana3", 4000, 3000, 04, 03);
        misEmpleados[4] = jefe_RRHH;
        misEmpleados[5] = new Jefatura("ana5", 6000, 1000, 02, 01);
        Jefatura jefa_Finanazas=(Jefatura) misEmpleados[5];
        jefa_Finanazas.estableceIncentivo(55000);

        System.out.println(jefa_Finanazas.tomarDecisiones("darle una nalgada al conserje"));
        System.out.println("El jefe: " + jefa_Finanazas.dameNombre()+ "Tiene un salario total de:   " +jefa_Finanazas.estalece_bonus(200.98));
        System.out.println(misEmpleados[3].dameNombre() + " Tiene un bonus: " + misEmpleados[3].estalece_bonus(200));
        for (Empleado e : misEmpleados) {
            e.sobreSueldo(5);
        }

        Arrays.sort(misEmpleados, 0, 0);

        for (Empleado e : misEmpleados) {
            System.out.println("Nombre: " + e.dameNombre() + " Sueldo: " + e.dameSueldo() + " Fecha alta: "
                    + e.DameFechaContrato());
        }

    }
}

class Empleado implements Trabajadores {
    public Empleado(String nom, double sue, int agno, int mes, int dia) {
        nombre = nom;
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
        altaContrato = calendario.getTime();
        ++IdSiguiente;
        Id = IdSiguiente;
    }
    public double estalece_bonus(double gratificacion){
        return Trabajadores.bonus_base + gratificacion;
    }

    public Empleado(String nom) {
        this(nom, 30000, 2000, 01, 01);
    }

    public String dameNombre() {
        return nombre + " Id: " + Id;
    }

    public Double dameSueldo() {
        return sueldo;
    }

    public Date DameFechaContrato() {
        return altaContrato;
    }

    public void sobreSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }

    public int compareTo(Object miObjeto) {
        Empleado otroempleado = (Empleado) miObjeto;

        if (this.Id < otroempleado.Id) {
            return -1;
        }

        if (this.Id > otroempleado.Id) {
            return 1;
        }

        return 0;
    }

    private String nombre;
    private double sueldo;
    private Date altaContrato;
    private static int IdSiguiente;
    private int Id;

}

class Jefatura extends Empleado implements Jefes {
    public Jefatura(String nom, double sue, int agno, int mes, int dia) {
        super(nom, sue, agno, mes, dia);
    }
    public double estalece_bonus(double gratificacion){
        double prima = 2000;
        return Trabajadores.bonus_base + prima + gratificacion;
    }

    public void estableceIncentivo(double b) {
        incentivo = b;
    }

    public Double dameSueldo() {
        double sueldoJefe = super.dameSueldo();
        return sueldoJefe + incentivo;
    }

    private double incentivo;

    public String tomarDecisiones(String decision) {
        return "Un miembro de la direccion a tomado la decision de: " + decision;
    }
}
