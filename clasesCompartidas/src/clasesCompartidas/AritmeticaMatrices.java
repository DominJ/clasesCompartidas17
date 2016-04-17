package clasesCompartidas;

import java.util.Vector;
import Pair;

public interface AritmeticaMatrices
{
	public HashMap<int,ArrayList<Pair<int,double>>> producto_mat(HashMap<int,ArrayList<Pair<int,double>>> a, HashMap<int,ArrayList<Pair<int,double>>> b);

	public HashMap<int,ArrayList<Pair<int,double>>> producto_norm_mat(HashMap<int,ArrayList<Pair<int,double>>> a, HashMap<int,ArrayList<Pair<int,double>>> b);

	public void Relación_Dummy(HashMap<int,ArrayList<Pair<int,double>>> M1, HashMap<int,ArrayList<Pair<int,double>>> M2, HashMap<int,ArrayList<pair<int,double>>> R);

}
