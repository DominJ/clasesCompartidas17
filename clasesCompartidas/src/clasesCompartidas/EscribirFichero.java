package clasesCompartidas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//Aquesta classe simplement li passes un HashMap i et reescriu el document. Segons el HashMap que sigui te l'escriurà al document
//que li pertoqui

public class EscribirFichero {
	
	//Segons el valor del Tipus (0 = PA, 1 = PC, 2 = PT), l'escriurem a un o altre document
	// La funció no retorna res i se li ha de passar un HashMap corresponent
	public static void ReescribirFicheroRelaciones(HashMap<Integer,ArrayList<Integer>> n, int Tipus){
		try{
			FileWriter fw;
			if (Tipus == 0) fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_author.txt",false);
			else if (Tipus == 1) fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_conf.txt",false);
			else  fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_term.txt",false);
		    Iterator<Entry<Integer, ArrayList<Integer>>> it = n.entrySet().iterator();
		    while (it.hasNext()) {
				Map.Entry<Integer, ArrayList<Integer>> e = it.next();
				ArrayList<Integer> b = new ArrayList<Integer>();
				int a = e.getKey();
				b = e.getValue();
				for (int j = 0; j < b.size(); j++){
					fw.write(a + "\t"+ b.get(j) + "\r\n");
				}
			}
			fw.close();
		}catch(IOException e){
			System.out.println("Error de:"+e);
		}
	}
	
	//Segons el valor del Tipus (0 = P, 1 = A, 2 = C, 3 = T), l'escriurem a un o altre document
	// La funció no retorna res i se li ha de passar un HashMap corresponent
	public static void ReescribirFicheroNodos(HashMap<Integer,String> n, int Tipus){
		try{
			FileWriter fw;
			if (Tipus == 0) fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/paper.txt",false);
			else if (Tipus == 1) fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/author.txt",false);
			else if (Tipus == 2)  fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/conf.txt",false);
			else fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/term.txt",false);
		    Iterator<Entry<Integer,String>> it = n.entrySet().iterator();
		    while (it.hasNext()) {
				Map.Entry<Integer, String> e = it.next();
				String b = new String();
				int a = e.getKey();
				b = e.getValue();
				fw.write(a + "\t"+ b + "\r\n");
			}
			fw.close();
		}catch(IOException e){
			System.out.println("Error de:"+e);
		}
	}
	
	
	//El main és un mètode per fer proves
	public static void main(String[] args){
		HashMap<Integer,ArrayList<Integer>> r = new HashMap<Integer,ArrayList<Integer>>();
		ReescribirFicheroRelaciones(r,2);
	}
}

