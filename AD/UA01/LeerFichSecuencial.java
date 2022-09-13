import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichSecuencial {

	public static void main(String[] args) throws IOException {
		File fichero=new File("fichero1.txt");
		FileReader fic=new FileReader(fichero);
		int i;
		char[] letras=new char[(int) fichero.length()];
		while ((i = fic.read(letras,0,2)) != -1) { //se va leyendo un carácter hasta que lea -1
			System.out.println(letras); //cast a char
		}

		fic.close(); //cerrar fichero  
	}

}
