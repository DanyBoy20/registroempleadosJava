
package datos;

// CLASE PADRE: EMPLEADOS. CONTENDRA LOS DATOS COMUNES ENTRE EL EMPLEADO CONTRATADO Y EL EMPLEADO POR HONORARIOS
public class Empleados{
    public Fechas fechaActual; // PARA GUARDAR LA FECHA ACTUAL, ES DECIR, LA FECHA DE REGISTRO
    int nEmpleado; // PARA GUARDAR EL NMERO DE EMPLEADO
    String nombre; // PARA GUARDAR EL NOMBRE DEL EMPLEADO
    String apellidos;  // PARA GUARDAR LOS APELLIDOS DEL EMPLEADO
    public Fechas fechaIngreso; // PARA GUARDAR LA FECHA EN QUE INGRESO AL TRABAJO
    
    // CONSTRUCTOR - PARA INICIALIZAR LOS DATOS PRIMARIOS DE LOS EMPLEADOS (DATOS COMUNES ENTRE CONTRATADOS Y HONORARIOS)
    public Empleados(Fechas fechaActual, int nEmpleado, String nombre, String apellidos, Fechas fechaIngreso){
        this.fechaActual = fechaActual;
        this.nEmpleado = nEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        
    }
    
    // LOS METODOS toString() SON LOS METODOS DE IMPRESION POR DEFECTO, AQUI MOSTRARAN LOS DATOS COMUNES
    // DE LOS EMPLEADOS
    @Override
    public String toString(){
        return "\nFecha registro en sistema: " + fechaActual
                + "\nIdentificador: " + nEmpleado
                + "\nNombre: " + nombre
                + "\nApellidos: " + apellidos
                + "\nFecha de ingreso: " + fechaIngreso;
    }
    
}
