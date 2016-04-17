package clasesCompartidas;

import java.util.Vector;

public class CtrlHetesim 
{
	int nodo1;
	int nodo2;
	String path;
	double result;
	
	public CtrlHetesim()
	{
		//constructura por defecto
	}
	
	public Vector<Vector<Integer>> producto_mat(Vector<Vector<Integer>> a, Vector<Vector<Integer>> b)
	{
		return a;
	}
	
	public Vector<Vector<Integer>> producto_norm_mat(Vector<Vector<Integer>> a, Vector<Vector<Integer>> b)
	{
		return a;
	}
	
	
	/*
	  Pre:	Aplicar este método para todo camino de longitud par
	 	M1 contiene el producto matricial de la parte izquierda del camino (UA1A2 · · ·UAmid−1M)
	  	M2 contiene el producto matricial de la parte derecha del camino (UAl+1Al · · ·UAmid+1M)
	  	R es la matriz de adyacencia entre los nodos centrales del camino (Amid -1 y Amid +1); Rf ordenada por filas, y Rc por columnas
	  Body: Se ha insertado el elemento E en la posicion Amid del camino, separando la matriz R en dos matrices;
		RL (Amid -1 y E ), y RR (Amid +1 y E)
	  Post : M1=M1* RL, M2= M2 * RR; (Producto matricial)
	*/
	public void Relación_Dummy(HashMap<int,ArrayList<Pair<int,double>>> M1, HashMap<int,ArrayList<Pair<int,double>>> M2, HashMap<int,ArrayList<pair<int,double>>> Rf, HashMap<int,ArrayList<pair<int,double>>> Rc)
	{
		HashMap<int,ArrayList<Pair<int,double>>> RL = new HashMap<int,ArrayList<Pair<int,double>>>();
		HashMap<int,ArrayList<Pair<int,double>>> RR = new HashMap<int,ArrayList<Pair<int,double>>>();
		//Obtencion de la matriz RL
		int etiqueta=0;
		for (int id: Rf.keySet()){ 
			ArrayList<Pair<int,double>> Rfila = Rf.getV(id); //fila[id] de R
			ArrayList<Pair<int,double>> RLfila = new ArrayList(); //futura fila[id] de RL
			for (int j=0; j< Rfila.size(); ++j) {
				Pair<int,double> Rval = Rfila.get(j); //valor[id][j] de R
				Pair<int,double> RLval = new Pair(); // futuro valor[id][etiqueta] de RL
				RLval.setFirst(etiqueta); 
				RLval.setSecond(1);
				RLfila.add(RLval);
				++etiqueta;
			}
			RL.put(id, RLfila);
		}
		//Obtencion de la matriz RR
		etiqueta=0;
		for (int id: Rc.keySet()){ 
			ArrayList<Pair<int,double>> Rcol = Rc.getV(id); //columna[id] de R
			ArrayList<Pair<int,double>> RRcol = new ArrayList(); //futura columna[id] de RR
			for (int i=0; i< Rcol.size(); ++i) {
				Pair<int,double> Rval = Rcol.get(i); //valor[i][id] de R
				Pair<int,double> RRval = new Pair(); // futuro valor[id][etiqueta] de RR
				RRval.setFirst(etiqueta); 
				RRval.setSecond(1);
				RRcol.add(RRval);
				++etiqueta;
			}
			RR.put(id, RRcol);
		}
		//Multiplicamos
		M1=producto_mat(M1, RL);
		M2=prodcuto_mat(M2, RR);
	
	}
}
