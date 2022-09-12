package accesoAleatorio;

import java.io.*;
public class EscribirFichAleatorio {
  public static void main(String[] args) throws IOException {      
   File fichero = new File ("AleatorioEmple.dat");
   //declara el fichero de acceso aleatorio
   RandomAccessFile file = new RandomAccessFile(fichero, "rw");
   //arrays con los datos
   String apellido[] = {"FERNANDEZ","GIL","LOPEZ","RAMOS",
                        "SEVILLA","CASILLA", "REY"};//apellidos 
   int dep[] = {10, 20, 10, 10, 30, 30, 20};       //departamentos
   Double salario[]={1000.45, 2400.60, 3000.0, 1500.56, 
                     2200.0, 1435.87, 2000.0};//salarios
   
   StringBuffer buffer = null;//buffer para almacenar apellido
   int n=apellido.length;//numero de elementos del array
   
   for (int i=0;i<n; i++){ //recorro los arrays          	  
	 file.writeInt(i+1); //uso i+1 para identificar empleado
     buffer = new StringBuffer( apellido[i] );      
     buffer.setLength(10); //10 caracteres para el apellido
     file.writeChars(buffer.toString());//insertar apellido
	 file.writeInt(dep[i]);       //insertar departamento
	 file.writeDouble(salario[i]);//insertar salario
   }     
   file.close();  //cerrar fichero 
   }
}
