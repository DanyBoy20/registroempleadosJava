
package presentacion;
import datos.Fechas;
import entidades.EContratado;
import entidades.EHonorarios;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Aplicacion {
    // ARREGLO DE TIPO STRING QUE GUARDA LAS OPCIONES DEL MENU
    String numeroMenu[] = {"(1) Registrar empleados contratados.",
                           "(2) Registrar empleados por honorarios.",
                           "(3) Mostrar empleados ordenados por salario.",
                           "(4) Cerrar aplicación."};      
    
    // ARREGLO DEL TIPO ARRAYLIST - LO OCUPE POR SU FACILIDAD DE USO, ORDEN Y EFICIENCIA EN CODIGO
    ArrayList<EContratado> Contratados = new ArrayList(); // PARA GUARDAR LA LISTA DE EMPLEADO CONTRATADOS
    ArrayList<EHonorarios> Honorarios = new ArrayList(); // PARA GUARDAR LA LISTA DE EMPLEADO POR HONORARIOS
    
    // PORCENTAJES PARA LOS EMPLEADOS DE TIPO CONTRATADO
    public static final float PORCENTAJE1 = (float) .05;
    public static final float PORCENTAJE2 = (float) .10;
    public static final float PORCENTAJE3 = (float) .15;
    public static final float PORCENTAJE4 = (float) .20;
    
    // CONSTANTE QUE GUARDARA LA COMISION POR CADA CLIENTE EN EMPLEADOS POR HONORARIOS
    public static final int COMISION = 20;
    
    // CONSTANTES QUE INDICARAN LA SELECCION DEL EMPELADO A GUARDAR
    final int CONTRATADO = 1;
    final int HONORARIO = 2;     
    
    // FUNCION PARA MOSTRAR EL MENU PRINCIPAL
    public int MenuPrincipal(){
    System.out.println("------------------EMPRESA XYZ------------------"); // TITULO
    System.out.println("----------------MENU PRINCIPAL----------------"); // TITULO
        for(int i = 0; i < numeroMenu.length; i++){ // ciclo para mostrar el menu, una opcion por cada vuelta
            System.out.println(numeroMenu[i]); // muestro el menu
        }
    System.out.println("----------------------------------------------"); // separador, es solo para presentacion y puede quitarse
    return Integer.parseInt( Capturar.guarda("\n --- SELECCIONE UNA OPCION DEL MENU ---")); // titulo
    }
    
    // FUNCION PARA GUARDAR / REGISTRAR A LOS EMPLEADOS POR CONTRATO Y POR HONORARIOS
    public void Registros(int registro){ 
        
        // DIVIDO LA FECHA ACTUAL EN ENTEROS PARA GUARDARLO EN VARIABLE FECHAACTUAL
        Date fecha = new Date(); // instancia de la clase fecha ( previamente importada en el inicio de esta clase )
        // en la siguiente linea obtengo la fecha actual ( la clase fue importada al inicio de esta clase )
        LocalDate fechaLocal = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int anioActual  = fechaLocal.getYear(); // obtengo el año de la fecha obtenida y la guardo en la variable
        int mesActual = fechaLocal.getMonthValue(); // obtengo el mes de la fecha obtenida y la guardo en la variable
        int diaActual   = fechaLocal.getDayOfMonth(); // obtengo el dia de la fecha obtenida y la guardo en la variable
        // LEEMOS Y GUARDAMOS EN VARIABLES LOS DATOS PRIMARIOS DEL EMPLEADO 
        Fechas fechaActual = new Fechas(diaActual, mesActual, anioActual); // variable para guardar la fecha actual
        // en la clase captura se creo una instancia de scanner, aqui solo la mando llamar en cada dato a guardar
        int nEmpleado = Integer.parseInt(Capturar.guarda("Numero de empleado")); // guarda numero de empleado
        String nombre = Capturar.guarda("Nombre del empleado"); // guarda nombre
        String apellidos = Capturar.guarda("Apellidos del empleado"); // guarda apellidos
        System.out.println("Fecha de ingreso - formato numerico: 00 / 00 / 0000"); // mensaje
        int diaIngreso = Integer.parseInt( Capturar.guarda("Dia") ); // guarda dia
        int mesIngreso = Integer.parseInt( Capturar.guarda("Mes") ); // guarda mes
        int anioIngreso = Integer.parseInt( Capturar.guarda("Año") ); // guarda año
        Fechas fechaIngreso = new Fechas(diaIngreso, mesIngreso, anioIngreso); // aqui guardo ya la fecha completa
        
        // VERIFICAR LA ELECCION DEL USUARIO (registro empleado contratado o por honorarios)
        switch(registro){
            // SI EL USUARIO ELIGIO REALIZAR REGISTROS DE EMPLEADOS POR CONTRATO 
            case CONTRATADO:         
                float sueldoBase = Float.parseFloat(Capturar.guarda("Sueldo base")); // guardo el sueldo base
                float sueldoNeto = CalcularSueldoNeto(sueldoBase, anioActual, anioIngreso); // guardo el sueldo neto
                // mediante el constructor de la clase EContratado, añado a la lista COntratados (ArrayList)
                // los datos que previamente almacene en las variables
                Contratados.add(new EContratado(sueldoBase, sueldoNeto, fechaActual, nEmpleado, nombre, apellidos, fechaIngreso));
                System.out.print("\n"); // salto de linea, es solo presentacion, no pasa nada si se quita
                break; // break, para salir de esa opcion y del switch
            // SI EL USUARIO ELIGIO REALIZAR REGISTROS DE EMPLEADOS POR HONORARIOS
            case HONORARIO: 
                int numeroClientes = Integer.parseInt(Capturar.guarda("Numero de clientes")); // guardo numero de clientes
                float honorarioNeto = CalcularHonorarioNeto(numeroClientes); // guardo el pago honorario neto
                // mediante el constructor de la clase EHonorario, añado a la lista COntratados (ArrayList)
                // los datos que previamente almacene en las variables
                Honorarios.add(new EHonorarios(numeroClientes, honorarioNeto, fechaActual, nEmpleado, nombre, apellidos, fechaIngreso));
                System.out.print("\n"); // salto de linea, es solo presentacion, no pasa nada si se quita
                break; // break, para salir de esa opcion y del switch
        }
        
    }
    
    // metodo que se inicia segun la opcion del menu elegida
    public void iniciar(){
        
        int opcionElegida; // variable para guardar la opcion elegida
        
        do{ // ciclo do - el codigo por lo menos se ejecuta una vez, mientras se cumpla la condicion al final de este bucle
            opcionElegida = MenuPrincipal(); // a la variable le asigno el valor obtenido del metodo MenuPrincipal
            switch(opcionElegida){ // verifico que opcion eligio el usuario
                case 1: // en el caso 1: registro de empleados por conrato
                    System.out.println("\n -- REGISTRAR EMPLEADO POR CONTRATO --"); // mensaje
                    Registros(CONTRATADO); // ejecuto la funcion registros, y de acuerdo al parametro es lo que hara
                    break; // salir de esta opcion y del switch
                case 2:// en el caso 2: registro de empleados por honorarios
                    System.out.println("\n -- REGISTRAR EMPLEADO POR HONORARIO --"); // mensaje
                    Registros(HONORARIO); // ejecuto la funcion registros, y de acuerdo al parametro es lo que hara
                    break; // salir de esta opcion y del switch
                case 3: // en el caso 3: ordenar empleados por contrato y empleados por honorarios en orden descendente sueldo
                   // MOSTRAR EMPLEADOS CONTRATADOS EN ORDEN DESCENDENTE SEGUN SUELDO NETO 
                    // collections.sort se utiliza para ordenar los elementos que se le pasen por parametros
                    // en orden ascendente, los parametros son la lista contratados y que se ordenen de acuerdo
                    // al valor obtenido del metodo ( ordenaSueldo() ) que se implemento de la interface comparator
                    Collections.sort(Contratados, new ordenaSueldo());
                    System.out.println("\n -- LISTA DE EMPLEADOS CONTRATADOS ORDENADOS POR SUELDO NETO: "); // titulo
                    for(EContratado listarC:Contratados){ // por cada objeto EContratado (se guardara en (listarC) en el arraylist COntratados
                        System.out.println(listarC); // muestro la lista ordenada
                        System.out.println("------------------------------------\n"); // separador
                    }     
                    // MOSTRAR EMPLEADOS POR HONORARIOS EN ORDEN DESCENDENTE SEGUN HONORARIOS NETO
                    // collections.sort se utiliza para ordenar los elementos que se le pasen por parametros
                    // en orden ascendente, los parametros son la lista Honorarios y que se ordenen de acuerdo
                    // al valor obtenido del metodo ( ordenaSueldo2() ) que se implemento de la interface comparator
                    Collections.sort(Honorarios, new ordenaSueldo2());
                    System.out.println("\n -- LISTA DE EMPLEADOS CONTRATADOS ORDENADOS POR HONORARIOS: "); // titulo
                    for(EHonorarios listarH:Honorarios){// por cada objeto EHonorarios (se guaradar en listarH) en el arraylist Honorarios
                        System.out.println(listarH); // muestro la lista ordenada
                        System.out.println("------------------------------------\n"); // separador
                    }   
                    break;
                   // FIN DE BUSQUEDA
                case 4: // si la opcion elegida fue la 4
                    System.out.println(" -- GRACIAS POR USAR EL PROGRAMA --"); // mensaje
                    break; // salir de esta opcion y del switch
                default: // si no eligio ninguna de las anteriores
                    System.out.println("¡ERROR! ... DEBE ELEGIR UNA OPCION VALIDA"); // mensaje
                    break;  // salir de esta opcion y del switch              
            }
        }while(opcionElegida != 4);        
    }
    
    // FUNCION PARA CALCULAR EL SUELDO NETO DEL EMPLEADO CONTRATADO ( YA CON LOS PORCENTAJES SEGUN LOS AÑOS LABORADOS)
    public float CalcularSueldoNeto(float base, int anio1, int anio2) { //parametros: sueldo base, año actual y año registro
        int cantidad = anio1 - anio2; // saco los años laborados
        float sueldoN; // variable para guardar el sueldo neto
        if (cantidad > 0 && cantidad <= 3){ // si los años son mayores a 0 y menores o iguales a 3
            sueldoN = base + (PORCENTAJE1 * base); // asigno el valor resultante a variable
        }else if(cantidad > 3 && cantidad <= 7){ // si los años son mayores a 3 y menores o iguales a 7
            sueldoN = base + (PORCENTAJE2 * base); // asigno el valor resultante a variable
        }else if(cantidad > 7 && cantidad <= 15){ // si los años son mayores a 7 y menores o iguales a 15
            sueldoN = base + (PORCENTAJE3 * base); // asigno el valor resultante a variable
        }else{ // SI NO SE CUMPLE LAS ANTERIORES
            sueldoN = base + (PORCENTAJE4 * base); // asigno el valor resultante a variable
        }
        return sueldoN; // REGRESO EL VALOR DE SUELDO NETO
    }
    
    // FUNCION PARA CALCULAR EL PAGO HONORARIO TOTAL AL EMPLEADO POR HONORARIO
    public float CalcularHonorarioNeto(int numClientes){ // parametro: numero de clientes
        float honorarioFinal; // variable para almacenar valor de honorario neto a pagar
        honorarioFinal = numClientes * COMISION; // asigno a variable el resultado de multiplicar la comison X numero de cliente
        return honorarioFinal; // regreso el valor de honorario final 
    }
    
    // INTERFACE IMPORTADA "COMPARATOR" PARA COMPARAR EL SUELDO NETO DEL CONTRATADO Y SACAR DEL MAYOR A MENOR
    // se crea una clase llamada ordenaSueldo que implementa a la interface Comparator, entre los simbolos de <> va el 
    // objeto que se va a comparar (en este caso el objeto EContratado)
    class ordenaSueldo implements Comparator<EContratado>{
        // al ser un metodo implementado de una interface, se requiere la palabra reservada Override indicando que se 
        // va a sobreescribir el metodo de la clase padre, en este caso de la interface implementada
        @Override 
        public int compare(EContratado sueldo1, EContratado sueldo2) {
            // Comparamos dos atributos del objeto para el orden - el valor que se obtiene con el metodo getSueldoNeto
            if(sueldo1.getSueldoNeto() < sueldo2.getSueldoNeto()){ // si el primer parametro es menor que el segundo
                return 1; // devuelve 1 positivo
            } else {
                return -1; // devuelve -1
            }
        }
    }
    
    // INTERFACE IMPORTADA "COMPARATOR" PARA COMPARAR EL HONORARIO NETO DEL EMPLEADO POR HONORARIO Y SACAR DEL MAYOR A MENOR
    // se crea una clase llamada ordenaSueldo que implementa a la interface Comparator, entre los simbolos de <> va el 
    // objeto que se va a comparar (en este caso el objeto EHonorarios)
    class ordenaSueldo2 implements Comparator<EHonorarios>{ 
        // al ser un metodo implementado de una interface, se requiere la palabra reservada Override indicando que se 
        // va a sobreescribir el metodo de la clase padre, en este caso de la interface implementada
        @Override
        public int compare(EHonorarios honorario1, EHonorarios honorario2) {
            // Comparamos dos atributos del objeto para el orden - el valor que se obtiene con el metodo getHonorarioNeto
            if(honorario1.getHonorarioNeto() < honorario2.getHonorarioNeto()){ // si el primer parametro es menor que el segundo
                return 1; // devuelve 1 positivo
            } else {
                return -1; // devuelve -1
            }
        }
    }
    
}
