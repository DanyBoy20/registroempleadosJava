
package entidades;

import datos.Empleados;
import datos.Fechas;

// CLASE HIJA QUE HEREDA ATRIBUTOS Y METODOS DE LA CLASE PADRE
public class EContratado extends Empleados{
    float sueldoBase; // ATRIBUTO EXTRA PARA ESTA CLASE HIJA
    float sueldoNeto; // ATRIBUTO EXTRA PARA ESTA CLASE HIJA
    
    // CONSTRUCTOR - PARA INICIALIZAR LOS DATOS DE LA CLASE EContratado ( MAS LOS DE LA CLASE PADRE )
    public EContratado (float sueldoBase, float sueldoNeto, Fechas fechaActual, int nEmpleado, String nombre, String apellidos, Fechas fechaIngreso){
        super(fechaActual, nEmpleado, nombre, apellidos, fechaIngreso);
        this.sueldoBase = sueldoBase;
        this.sueldoNeto = sueldoNeto;
    }
    
    // METODO PARA OBTENER EL SUELDO BASE
    public float getSueldoBase(){
        return sueldoBase;
    }
    
    // METODO PARA OBTENER EL SUELDO NETO (YA CON LOS PORCENTAJES AGREGADOS
    public float getSueldoNeto() {
       return sueldoNeto;
   }
    
    // LOS METODOS toString() SON LOS METODOS DE IMPRESION POR DEFECTO, ESTOS DOS CAMPOS (Y VALORES) SE SUMARAN AL 
    // METODO toString DE LA CLASE PADRE
    @Override
    public String toString(){
        return super.toString()
                + "\nSueldo Base: " + sueldoBase
                + "\nSueldo Neto: " + sueldoNeto;
    } 
}
