package clasesCompartidas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;



public class Relaciones 
{
	private HashMap<Integer, ArrayList<Pair<Integer,Double>>> paperOther;
	private HashMap<Integer, ArrayList<Pair<Integer,Double>>> otherPaper;
	
	public Relaciones()
	{
		//contructor por defecto
		paperOther = new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
		otherPaper = new HashMap<Integer, ArrayList<Pair<Integer,Double>>>();
	}
	
	//CONSULTORAS
	public HashMap<Integer, ArrayList<Pair<Integer,Double>>> consultar_PaperOther() {
		return paperOther;
	}
	
	public HashMap<Integer, ArrayList<Pair<Integer,Double>>> consultar_OtherPaper() {
		return otherPaper;
	}
	
	//PRE: i != NULL, i es un id de Paper
	//POST: Devuelve ArrayList con los "Others" relacionados con el Paper con id = i
	public ArrayList<Pair<Integer, Double>> consultar_RelacionPaper(Integer i) {
		if (paperOther.containsKey(i)) return paperOther.get(i);
		else return null;
	}
	
	//PRE: i != NULL, i es un id de Other
	//POST: Devuelve ArrayList con los Papers relacionados con el Other con id = i
	public ArrayList<Pair<Integer,Double>> consultar_RelacionOther(Integer i) {
		if (paperOther.containsKey(i)) return otherPaper.get(i);
		else return null;
	}
	
	//ANADIR
	//PRE: a -> id Paper, b -> id Other
	public void anadir_PaperOther(int a, int b)
	{
		if (!this.paperOther.containsKey(a)){ //si no existe, creamos entrada iniciando arrayList
			this.paperOther.put(a, new ArrayList<Pair<Integer,Double>>());
		}
		//Añadir ordenadamente
		Pair<Integer,Double> p = new Pair(b,0.0);
		this.paperOther.get(a).add(p);
		anadir_OtherPaper(b,a);
	}

	//Funcion privada, es llamada por anadir_PaperOther()
	//PRE: a -> id Other, b -> id Paper
	private void anadir_OtherPaper(int a, int b)
	{
		if (!this.otherPaper.containsKey(a)){ //si no existe, creamos entrada iniciando arrayList
			this.otherPaper.put(b, new ArrayList<Pair<Integer,Double>>());
		}
		Pair<Integer,Double> p = new Pair(b,0.0);
		this.otherPaper.get(a).add(p);
	}

  	//ELIMINAR
	//PRE: a -> id Paper, b -> id Other
	public void eliminar_PaperOther(int a, int b)
	{
		if (this.paperOther.containsKey(a)){ //borramos relación
			paperOther.get(a).remove(b);
			if (this.paperOther.get(a).isEmpty()){ //si no quedan más relaciones, lo borramos todo
				this.paperOther.remove(a);
			}
		}
		eliminar_OtherPaper(b,a);
	}

	//Funcion privada, es llamada por eliminar_PaperOther()
	//PRE: a -> id Paper, b -> id Other
	private void eliminar_OtherPaper(int a, int b)
	{
		if (this.otherPaper.containsKey(a)){ //borramos relación
			otherPaper.get(a).remove(b);
			if (this.otherPaper.get(a).isEmpty()){ //si no quedan más relaciones, lo borramos todo
				this.otherPaper.remove(a);
			}
		}
	}
	
	public void volcar_datos(HashMap<Integer, ArrayList<Pair<Integer,Double>>> datos) {
		
		for(Entry<Integer, ArrayList<Pair<Integer, Double>>> entry : datos.entrySet()){
		    ArrayList<Pair<Integer,Double>> oth = entry.getValue();
			for (int i = 0; i < oth.size(); ++i) {
				anadir_PaperOther(entry.getKey(), oth.get(i).getFirst());
			}
		}
	}
}
