package clasesCompartidas;

import java.util.*;

public class ConjuntoNodos 
{
	private int ID_libre; //tengo que sacar este dato del fichero inicial.
	private Map<Integer, String> nodos;
	private Map<String, Integer> nombres_nodos = new HashMap<String, Integer>();
	
	/*PRE:*/
	/*POST:*/
	public ConjuntoNodos() //constructor por defecto
	{
		nodos = new HashMap<Integer, String>();
		nombres_nodos = new HashMap<String, Integer>();
	}
	
	/*PRE:*/
	/*POST:*/
	public void anadir_nodo(String nombre_nodo)
	{
		if(nombres_nodos.containsKey(nombre_nodo)) //compruebas que no exista POR NOMBRE
		{
			//no se puede añadir, se envia un mensaje diciendo que ya existe.
			System.out.println("Ya existe un nodo con este nombre");
		}
		else //no existe,se añade.
		{
			int id = ID_libre;
			++ID_libre;
			nodos.put(id, nombre_nodo);
			nombres_nodos.put(nombre_nodo, id);
		}
	}
	
	
	/*PRE:*/
	/*POST:*/
	public void eliminar_nodo(int id)
	{
		if(nodos.containsKey(id))//si existe
		{
			nombres_nodos.remove(nodos.get(id)); //lo borro de nombres_nodos
			nodos.remove(id); //lo borro de nodos
		}
		else //no existe
		{
			System.out.println("No existe ningún nodo con este nombre.");
		}

	}

	/*PRE:*/
	/*POST:*/
	private void fijar_id_libre(int id_libre)
	{
		this.ID_libre = id_libre;
	}
	
	/*PRE:*/
	/*POST:*/
	public boolean existe_nombre_nodo(String nombre_nodo)
	{
		boolean existe = false;
		if(nombres_nodos.get(nombre_nodo)!= null) existe = true;
		return existe;
	}
	
	/*PRE:*/
	/*POST:*/
	public void llenar_conjunto(int total, estructuradenodos)
	{
		//presupongo que esa estructura estará ordenada
		for(int i = 0; i < total-1; ++i)
		{
			anadir_nodo(loquetoque);
		}
		int id = iddelultimonodoaañadir;
		fijar_id_libre(id);
		anadir_nodo(ultimo);
		//aqui añadimos también la última de todas, suponiendo que es la ID más alta de todas.
		
		
	}
	
	/*PRE:*/
	/*POST:*/
	public Map<Integer, String> devolver_conjunto()
	{
		return nodos;
	}	
}
