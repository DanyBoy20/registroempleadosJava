
package datos;

// CLASE FECHAS - PARA LOS TIPOS DE FECHAS (DIA MES Y AÑO : 00/00/0000)
public class Fechas {
   int dia;
   int mes;
   int anio;
   
   // CONSTRUCTOR DE LA FECHA
   public Fechas(int d, int m, int a){
    dia = d; mes = m; anio = a;
   }
   
   // OBTENER DIA (YA QUE HAYA SIDO AGREGADA LA FECHA - IGUAL PARA MES Y AÑO EN METODOS GET)
   public int getDia(){
        return dia;
   }
   
   // OBTENER MES
   public int getMes(){
        return mes;
   }
   
   // OBTENER AÑO
   public int getAnio(){
        return anio;
   }
   
   // MOSTRAR LA FECHA EN FORMATO 00/00/0000
   @Override
   public String toString(){
        // REGRESA LA FECHA: OPERADOR TERNARIO ?: 
        // ES UN OPERADOR CONDICIONAL DE UNA SOLA LINEA
        // si dia es menor o igual a 9 (un digito) se agrega el cero y si no, no se agrega nada, lo mismo con el siguiente operador
        return (dia <= 9 ? "0" : "") + dia + "/" + (mes <= 9 ? "0" : "") + mes + "/" + anio;
   }
    
}
