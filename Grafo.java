import java.util.ArrayList;
import java.util.*;
public class Grafo {
    private List<Nodo> listaNodos;

    public void agregarNodo(Nodo nodo){
        if (listaNodos == null){
            listaNodos = new ArrayList<>();
        }
        listaNodos.add(nodo);
    }

    public List<Nodo> getNodos(){
        return listaNodos;
    }

    public int getCantidadNodos(){
        return listaNodos.size();
    }

    @Override
    public String toString(){
        return "Grafo[Nodos="+ listaNodos +"\n]";
    }
}
