package clasesCompartidas;

import java.util.ArrayList;
import java.util.HashMap;

public class Relaciones 
{
	private HashMap<Integer,ArrayList<Integer>> paperOther;
	private HashMap<Integer,ArrayList<Integer>> otherPaper;
	
	public Relaciones()
	{
		//contructor por defecto
		paperOther = new HashMap<Integer,ArrayList<Integer>>();
		otherPaper = new HashMap<Integer,ArrayList<Integer>>();
	}
	
	//CONSULTORAS
	public HashMap<Integer,ArrayList<Integer>> consultar_PaperOther() {
		return paperOther;
	}
	
	public HashMap<Integer,ArrayList<Integer>> consultar_OtherPaper() {
		return otherPaper;
	}
	
	//PRE: i != NULL, i es un id de Paper
	//POST: Devuelve ArrayList con los "Others" relacionados con el Paper con id = i
	public ArrayList<Integer> consultar_RelacionPaper(Integer i) {
		if (paperOther.containsKey(i)) return paperOther.get(i);
		//else throw exeption Key no existe 
	}
	
	//PRE: i != NULL, i es un id de Other
	//POST: Devuelve ArrayList con los Papers relacionados con el Other con id = i
	public ArrayList<Integer> consultar_RelacionOther(Integer i) {
		if (paperOther.containsKey(i)) return otherPaper.get(i);
		//else throw exeption Key no existe
	}
	
	//ANADIR
	//PRE: a -> id Paper, b -> id Other
	public void anadir_PaperOther(int a, int b)
	{
		if (!this.paperOther.containsKey(a)){ //si no existe, creamos entrada iniciando arrayList
			this.paperOther.put(a, new ArrayList<Integer>());
		}
		this.paperOther.get(a).add(b);
		anadir_OtherPaper(b,a);
	}

	//Funcion privada, es llamada por anadir_PaperOther()
	//PRE: a -> id Other, b -> id Paper
	private void anadir_OtherPaper(int a, int b)
	{
		if (!this.otherPaper.containsKey(a)){ //si no existe, creamos entrada iniciando arrayList
			this.otherPaper.put(b, new ArrayList<Integer>());
		}
		this.otherPaper.get(a).add(b);
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
}
