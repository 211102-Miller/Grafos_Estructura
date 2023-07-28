import java.util.*;

public class Arista {
    private Nodo inicio;
    private Nodo fin;
    private double peso;

    public Arista (Nodo origen, Nodo destino,double valor){
        inicio=origen;
        fin=destino;
        peso=valor;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public double getPeso() {
        return peso;
    }
    public void setInicio(Nodo origen){
        inicio=origen;
    }
        public void setFin(Nodo destino){
        fin=destino;
    }
        public void setPeso(double valor){
        peso=valor;
    }
    @Override
    public String toString(){
        return "[Nodo de inicio ="+inicio.getDato()+", NodoFin =" + fin.getDato()+ " , peso = "+peso+"]";
    }

}
