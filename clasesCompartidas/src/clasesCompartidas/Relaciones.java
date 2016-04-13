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
	
	public void anadir_PaperOther(int a, int b)
	{
		if (!this.paperOther.containsKey(a)){ //si no existe, creamos entrada iniciando arrayList
			this.paperOther.put(a, new ArrayList<Integer>());
		}		
		this.paperOther.get(a).add(b);
	}
	
	public void anadir_OtherPaper(int a, int b)
	{
		if (!this.otherPaper.containsKey(a)){ //si no existe, creamos entrada iniciando arrayList
			this.otherPaper.put(a, new ArrayList<Integer>());
		}		
		this.otherPaper.get(a).add(b);
	}
	
	public void eliminar_PaperOther(int a, int b)
	{
		if (this.paperOther.containsKey(a)){ //borramos relación
			paperOther.get(a).remove(b);
			if (this.paperOther.get(a).isEmpty()){ //si no quedan más relaciones, lo borramos todo
				this.paperOther.remove(a);				
			}
		}
	}
	
	public void eliminar_OtherPaper(int a, int b)
	{
		if (this.otherPaper.containsKey(a)){ //borramos relación
			otherPaper.get(a).remove(b);
			if (this.otherPaper.get(a).isEmpty()){ //si no quedan más relaciones, lo borramos todo
				this.otherPaper.remove(a);				
			}
		}
	}
	
	public int busquedaBinaria(int a, int b, int c) // HASMAP TÉ MÈTODE GET. NO LA NECESSITEM
	{
		return 0; //lo pongo para que eclipse no se queje
	}
}
