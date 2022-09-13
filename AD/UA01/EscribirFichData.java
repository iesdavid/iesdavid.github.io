package streamsBinarios;


import java.io.*;
public class EscribirFichData {
  public static void main(String[] args) throws IOException {   
 	  File fichero = new File("fichData.dat");
	  DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(fichero));
 
	  String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés"};
					   
	  int edades[] = {14,15,13,15,16,12};
	
	  for (int i=0;i<edades.length; i++){
		  dataOS.writeUTF(nombres[i]); //inserta nombre
		  dataOS.writeInt(edades[i]);  //inserta edad
   }     
   dataOS.close();  //cerrar stream 
  }
}
