package clasesCompartidas;

import java.util.Queue;
import java.util.ArrayList;

public class ConjuntoNodos 
{
	private int ID_nodo_libre; //tengo que sacar este dato del fichero inicial.
	private Queue<Integer> ID_nodos_vacios;
	private ArrayList<Nodo> nodos;
	private ArrayList<String> nombres_nodos;
	
	
	public ConjuntoNodos() //constructor por defecto
	{
		nodos = new ArrayList<Nodo>();
		nombres_nodos = new ArrayList<String>();
		//ID_nodos_vacios = new Queue<Integer>();
	}
	
	public void anadir_nodo(Nodo nodo)
	{
		String nombre_nodo = nodo.consultar_nombre();
		
		if(existe_nodo(nombre_nodo) != -1) //compruebas que no exista POR NOMBRE
		{
			//no se puede a�adir, se envia un mensaje diciendo que ya existe.
			System.out.println("Ya existe un nodo con este nombre");
		}
		else //no existe,se a�ade.
		{
			int id_adjudicada = consultar_id_libre(); //se busca la id disponible
			if(id_adjudicada == ID_nodo_libre) ++ID_nodo_libre; //si se ha usado el nodo libre m�s alto, se incrementa en 1 para el proximo nodo a a�adir.
			nodo.anadir_id(id_adjudicada); //se le a�ade la id al nodo.
			int posicion = colocacion(id_adjudicada); //se calcula en qu� posicion se a�adir� el nodo para mantener la lista ordenada.
			nodos.add(posicion,nodo);//se a�ade el nodo a la lista de nodos.
			int posicion2 = colocacion_nombre(nombre_nodo);// se calcula en qu� posici�n se a�adir� el nombre del nodo para mantener la lista ordenada.
			nombres_nodos.add(posicion2, nombre_nodo); //se a�ade el nombre del nodo a la lista de nombres de nodos.
					
		}
	}
	
	public void eliminar_nodo(Nodo nodo)
	{
		int id_nodo = nodo.consultar_id();
		if(existe_nodo(id_nodo)!= -1)
		{
			nombres_nodos.remove(nodo.consultar_nombre());
			nodos.remove(nodo);
			ID_nodos_vacios.add(id_nodo);
		}
		else
		{
			System.out.println("No existe ning�n nodo con este nombre.");
		}

	}
		
	public String consultar_nombre_nodo(Nodo nodo)
	{
		String nombre = nodo.consultar_nombre();
		return nombre;
	}
	
	private int existe_nodo(int id_nodo)
	{
		int posicion = busqueda_binaria(id_nodo);
		return posicion;
	}
	
	private int existe_nodo(String nombre_nodo)
	{
		int posicion = busqueda_binaria_nombre(nombre_nodo);
		return posicion;//analogamente a su versi�n de enteros, pero ordenado por nombre.
	}
	
	public int consultar_id_libre()
	{
		/*if(cola no est� vac�a)
		 * return posicion de la cola;
		 * else*/
		return ID_nodo_libre; //pongo esto solo para que eclipse no me lance errores
	}
	
	/*b�squeda binaria, nos sirve para saber si est� o no el id en el conjunto de nodos.*/
	private int busqueda_binaria(int id_nodo)
	{
		 int inicio = 0;
		 int fin = nodos.size()-1;
		 int posicion;
		 while(inicio <= fin)
		 {
		     posicion = (inicio+fin)/2;		    
		     if(nodos.get(posicion).consultar_id() == id_nodo) return posicion; //"nodos.get(posicion)" equivale a "nodos[posicion]".
		     else if(nodos.get(posicion).consultar_id() < id_nodo) inicio = posicion+1;
		     else fin = posicion-1;     
		 }
		 return -1;
	}
	
	private int busqueda_binaria_nombre(String nombre_nodo)
	{
		//analogamente a su versi�n con entero, pero con string.
		int inicio = 0;
		int fin = nombres_nodos.size()-1;
		int posicion;
		while(inicio <= fin)
		{
		    posicion = (inicio+fin)/2;		    
		    if(nombres_nodos.get(posicion).equals(nombre_nodo)) return posicion; //"nodos.get(posicion)" equivale a "nodos[posicion]".
		    else if(nombres_nodos.get(posicion).compareTo(nombre_nodo) < 0) inicio = posicion+1;
		    else fin = posicion-1;     
		}
		return -1;
	}
	
	private int colocacion(int id_nodo)
	{
		int posicion;
		//lleva a cabo una b�squeda binaria para saber d�nde se debe colocar el id en cuestion.
		return posicion;
	}
	
	private int colocacion_nombre(String nombre_nodo)
	{
		int posicion;
		//lleva a cabo una b�squeda binaria para saber d�nde se debe colocar el nombre en cuestion.
		return posicion;
	}
	
	
}
