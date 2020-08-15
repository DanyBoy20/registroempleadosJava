
package entidades;

import datos.Empleados;
import datos.Fechas;

// CLASE HIJA QUE HEREDA ATRIBUTOS Y METODOS DE LA CLASE PADRE
public class EHonorarios extends Empleados{
   int numeroClientes; // variable que guardara el numero de clientes
   float honorarioNeto; // variable que guardara el resultado del calculo a pagar por honorarios
   
   // CONSTRUCTOR - PARA INICIALIZAR LOS DATOS DE LA CLASE EHonorarios ( MAS LOS DE LA CLASE PADRE )
   public EHonorarios(int numeroClientes, float honorarioNeto, Fechas fechaActual, int nEmpleado, String nombre, String apellidos, Fechas fechaIngreso){
        super(fechaActual, nEmpleado, nombre, apellidos, fechaIngreso);
        this.numeroClientes = numeroClientes;
        this.honorarioNeto = honorarioNeto;
       
   }
   
    // METODO PARA OBTENER EL PAGO TOTAL DEL HONORARIO
    public float getHonorarioNeto(){
        return honorarioNeto;
    }
    
    
    // LOS METODOS toString() SON LOS METODOS DE IMPRESION POR DEFECTO, ESTOS DOS CAMPOS (Y VALORES) SE SUMARAN AL 
    // METODO toString DE LA CLASE PADRE
    @Override
    public String toString(){
        return super.toString()
                + "\nSueldo: "+ honorarioNeto;
    }
}
