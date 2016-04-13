package clasesCompartidas;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LeerFichero {
	
	//La string archivo hay que escribirla con las barras no invertidas, sino te salta error
	public static HashMap<Integer,ArrayList<Integer>> crear_relacion(String archivo) throws IOException {
		String cadena;
		//Este metodo lee el archivo
		FileReader f = new FileReader(archivo); 
		//Esto metodo crea un buffer que va leyendo cadenas de caracteres
		BufferedReader b = new BufferedReader(f); 
		
		HashMap<Integer,ArrayList<Integer>> m = new HashMap<Integer,ArrayList<Integer>>();
		Integer codi,codi2,codi_antic;
		codi = codi2 = codi_antic = 0;
		Boolean primer = true;
		String s2 = new String();
		ArrayList<Integer> l = new ArrayList<Integer>();
		while(((cadena = b.readLine())!=null)){
	    	int i = 0;
	    	String copy = cadena;
	    	while(!(Character.isWhitespace(cadena.charAt(i)))) {
	    		++i;
	    	}
	    	
	    	String s = copy.substring(0,i);
	    	codi = Integer.parseInt(s);
	    	String s1 = copy.substring(i+1,copy.length());
	    	codi2 = Integer.parseInt(s1);
	    	if(primer){
	    		s2 = copy.substring(0,i);
	    		codi_antic = codi;
	    		primer = false;
	    	}
	    	if(!(s.equals(s2))){
	    		m.put(codi_antic, l);
	    		l = new ArrayList<Integer>();
	    	}
	    	l.add(codi2);
	    	codi_antic = codi;
	    	s2 = copy.substring(0,i);
	
		}
		m.put(codi_antic, l);
		//Cerramos el buffer
		b.close();
		return m;
	}
	
	
	public static void main(String [] args) throws IOException {
		HashMap<Integer,ArrayList<Integer>> r = crear_relacion("/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_term.txt");
		ArrayList<Integer> m = new ArrayList<Integer>();
		m = r.get(7604);
		for (Integer number : m) {
			 System.out.println("Number0 = " + number);
		} 
		   
	}

}
