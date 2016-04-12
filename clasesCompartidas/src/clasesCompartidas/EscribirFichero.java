package test;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//Aquesta classe simplement li passes un HashMap<Integer,<ArrayList<Integer>>> i et reescriu el document de relacions

public class EscribirFichero {
	
	public static void ReescribirFichero(HashMap<Integer,ArrayList<Integer>> n){
		try{
			FileWriter fw = new FileWriter("/Users/USUARIO/Downloads/PROP/DBLP_four_area/prova.txt",false);
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

	
	public static void main(String[] args){
		HashMap<Integer,ArrayList<Integer>> n = new HashMap<Integer,ArrayList<Integer>>();
		ArrayList<Integer> r = new ArrayList<Integer>();
		ArrayList<Integer> m = new ArrayList<Integer>();
		r.add(234);
		r.add(111);
		r.add(892);
		int s = 90;
		n.put(s, r);
		m.add(999);
		m.add(231);
		int c = 80;
		n.put(c, r); 
		ReescribirFichero(n);
	}
}

