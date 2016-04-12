package clasesCompartidas;

import java.util.ArrayList;

public class ConjuntoNodos 
{
	private int ID_nodo_libre;
	private ArrayList<Nodo> ID_nodos_vacios;
	private ArrayList<Nodo> nodos;
	
	public ConjuntoNodos() //constructor por defecto
	{
		
	}
	
	public void anadir_nodo(int id_nodo)
	{
		/*compruebas que no exista
		 * le das nombre
		 * lo a�ades
		 * comprobar si el id es el de ID_disponible
		 * en ese caso, hacer un ++ del atributo*/
	}
	
	public void eliminar_nodo(int id_nodo)
	{
		/*compruebas que exista
		 * le das nombre
		 * lo eliminas*/
	}
	
	public void modificar_nodo(int id_nodo)
	{
		/*llama a funciones de la clase nodo*/
	}
	
	public String consultar_nombre_nodo(int id_nodo)
	{
		/*llama a funciones de la clase nodo*/
		return "result"; //pongo esto solo para que eclipse no me lance errores
	}
	
	public int existe_nodo(int id_nodo)
	{
		int posicion = busqueda_binaria(id_nodo);
		return posicion;//pongo esto solo para que eclipse no me lance errores
	}
	
	public int consultar_nodo_libre()
	{
		/*if(cola no est� vac�a)
		 * return posicion de la cola;
		 * else*/
		return ID_nodo_libre; //pongo esto solo para que eclipse no me lance errores
	}
	
	public void liberar_nodo(int id_nodo)
	{
		/*a�adir el ID a la cola de disponibles
		 * borrar nodo*/
	}
	
	/*b�squeda binaria, nos sirve para saber si est� o no el id en el conjunto de nodos.*/
	private int busqueda_binaria(int id_nodo)
	{
		//acceder al nodo con un .getID() o algo as�.
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
}
