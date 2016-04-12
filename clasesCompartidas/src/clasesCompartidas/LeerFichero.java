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
		int iter = 0;
		String s2 = new String();
		ArrayList<Integer> l = new ArrayList<Integer>();
		while(((cadena = b.readLine())!=null)){
	    	int i = 0;
	    	String copy = cadena;
	    	while(!(Character.isWhitespace(cadena.charAt(i)))) {
	    		++i;
	    	}
	    	
	    	String s = copy.substring(0,i);
	    	//System.out.println(s);
	    	codi = Integer.parseInt(s);
	    	//System.out.println(s);
	    	String s1 = copy.substring(i+1,copy.length());
	    	//System.out.println("string: "+ s1);
	    	codi2 = Integer.parseInt(s1);
	    	//System.out.println("int: "+ s1);
	    	if(primer){
	    		s2 = copy.substring(0,i);
	    		codi_antic = codi;
	    		primer = false;
	    		//System.out.println("codi: \n"+ codi);
	    		//System.out.println("codi_antic: \n"+ codi_antic);
	    	}
	    	if(!(s.equals(s2))){
	    		System.out.println("\niteracio: "+ iter);
	    		System.out.println(" codi: "+ codi + " codi_antic: "+ codi_antic);
	    		m.put(codi_antic, l);
	    		l.clear();
	    		++iter;
	    		 //System.out.println("Fi");
	    	}
	    	l.add(codi2);
	    	codi_antic = codi;
	    	s2 = copy.substring(0,i);
	    	/*System.out.print("\ncodi: ");
	    	System.out.print(codi);
	    	System.out.print("\ncodi antic: ");
	    	System.out.print(codi_antic); */
	    	//System.out.print(m.get(7601));
		}
		m.put(codi_antic, l);
		//Cerramos el buffer
		b.close();
		return m;
	}
	
	
	public static void printArray(ArrayList<Integer> a) throws  IOException {
		Integer list2[] = new Integer[a.size()];
		   list2 = a.toArray(list2);

		   System.out.println("Printing elements of a");

		   // let us print all the elements available in list
		   for (Integer number : list2) {
		   System.out.println("Number = " + number);
		   }
	}
	
	
	public static void main(String [] args) throws IOException {
		HashMap<Integer,ArrayList<Integer>> r = crear_relacion("/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_term.txt");
		ArrayList<Integer> m = new ArrayList<Integer>();
		m = r.get(7601);
		/* System.out.println(r.get(7601).getClass());		
		 System.out.println(r.get(7601).size());
		 System.out.println(m.getClass());		
		 System.out.println(m.size());
		 System.out.println(m);		*/

		 for (Integer number : m) {
			   System.out.println("Number0 = " + number);
		} 
		   
	}

}
