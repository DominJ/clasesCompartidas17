package clasesCompartidas;

package Hetesim;
import java.util.*;
import Pair.*;

public abstract class AritmeticaMatrices {
	
	abstract protected HashMap<Integer,ArrayList<Pair<Integer,Double>>> producto_mat(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b);

	abstract protected HashMap<Integer,ArrayList<Pair<Integer,Double>>> producto_normalizado(HashMap<Integer,ArrayList<Pair<Integer,Double>>> a, HashMap<Integer,ArrayList<Pair<Integer,Double>>> b);

	abstract protected void Relacion_Dummy(HashMap<Integer,ArrayList<Pair<Integer,Double>>> M1, HashMap<Integer,ArrayList<Pair<Integer,Double>>> M2, HashMap<Integer,ArrayList<Pair<Integer,Double>>> R);

}

