package xmlfiles;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class LecturaEmpleadoXml {
	 public static void main(String[] args) {

	  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	  try {	 
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(new File("C:\\ULHI\\DAM\\AD\\AD\\UD2\\src\\xmlfiles\\Empleados.xml"));
	    document.getDocumentElement().normalize();

	    System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
	    //crea una lista con todos los nodos empleado  
	    NodeList empleados = document.getElementsByTagName("empleado");      
	    System.out.printf("Nodos empleado a recorrer: %d %n", empleados.getLength());
	    //recorrer la lista  
	    for (int i = 0; i < empleados.getLength(); i ++) {
	    	Node emple = empleados.item(i); //obtener un nodo empleado
	    	if (emple.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
	    		//obtener los elementos del nodo           
	    		Element elemento = (Element) emple;	
	    		System.out.printf("ID = %s %n",	elemento.getElementsByTagName("id").item(0).getTextContent());
	    		System.out.printf(" * Apellido = %s %n", elemento.getElementsByTagName("apellido").item(0).getTextContent());
	    		System.out.printf(" * Departamento = %s %n", elemento.getElementsByTagName("dep").item(0).getTextContent());
	    		System.out.printf(" * Salario = %s %n", elemento.getElementsByTagName("salario").item(0).getTextContent());
	    	}
	    }
	  } catch (Exception e) 
	    {e.printStackTrace();}

	 }//fin de main 
}//fin de la clase

