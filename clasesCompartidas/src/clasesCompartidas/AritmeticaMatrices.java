package clasesCompartidas;

import java.util.Vector;
import Pair;

public interface AritmeticaMatrices
{
	public HashMap<Integer,ArrayList<Pair<Integer,Double>>> producto_mat(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b);

	public HashMap<Integer,ArrayList<Pair<Integer,Double>>> producto_normalizado(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b);

	public void Relación_Dummy(HashMap<Integer,ArrayList<Pair<Integer,Double>>> M1, HashMap<Integer,ArrayList<Pair<Integer,Double>>> M2, HashMap<Integer,ArrayList<Pair<Integer,Double>>> R);

}
