package streamsTexto;

import java.io.*;

public class LeerFichTexto {
  public static void main(String[] args) throws IOException {
    File fichero = new File("C:\\ULHI\\DAM\\AD\\AD\\UD2\\src\\streamsTexto\\fichero1.txt"); //declarar fichero
    FileReader fic = new FileReader(fichero); //crear el flujo de entrada  
        
    int i;
    while ((i = fic.read()) != -1) //se va leyendo un carácter hasta que lea -1
    	System.out.print((char) i); //cast a char
    	
    //para leer de 20 en 20 utilizamos el metodo read pasándole el buffer de caracteres
    /*	char b[] = new char [20];
    	while ((i = fic.read(b)) != -1) 
    		System.out.println(b);*/
    	
    	//System.out.println( (char) i + "==>"+ i);
        
    fic.close(); //cerrar fichero  
    
  }
}
