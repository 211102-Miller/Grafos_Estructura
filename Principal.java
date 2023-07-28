import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int respuesta;
        Grafo grafo = null;
        do{
            System.out.println("1.- Crear grafo");
            System.out.println("2.- Mostrar grafo");
            System.out.println("3.- Mostrar la cantidad de nodos en el grafo");
            System.out.println("4.- Recorrido en profundidad");
            System.out.println("5.- Busqueda del nodo");
            System.out.println("6.- Salir");

            respuesta = scan.nextInt();

            switch (respuesta){
                case 1:
                    grafo = crearGrafo();
                    break;
                case 2:
                    System.out.println(grafo.toString());
                    break;
                case 3:
                    System.out.println("Cantidad de nodos" + grafo.getCantidadNodos());
                    break;
                case 4:  
                    //ArrayList<Nodo> listaNodos = new ArrayList<>();
                    //listaNodos = recorridoProProfundiad(Grafo);
                    //for(int i =0; i < listaNodos.size(); i++){
                        //System.out.println("Posicion "+ i +" Nodo"+ listaNodos.get(i));
                    //}
                    break;
                case 5:
                    System.out.println("INgresa el valor del nodo");
                    String buscar = scan.next();
                    if(busquedaNodo(grafo, buscar) == -1){
                        System.out.println("Nodo no existe");
            
                    }    
                    else{
                        System.out.println("La posicion del nodo en el grafo es "+ buscar);
                    }
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
    
            }

         }while(respuesta != 6);


    }
    public static Grafo crearGrafo(){
        ArrayList<Nodo> listaNodos = new ArrayList<Nodo>();
        int cantidad, opcion;
        String valorNodo;

        System.out.println("INgresar la cantidad de nodos agregados");
        cantidad = scan.nextInt();

        for(int i =1; i <= cantidad;i++ ){
            System.out.println("Indica el valor del nodo");
            valorNodo = scan.next();
            Nodo nodo = new Nodo(valorNodo);
            listaNodos.add(nodo);

        }
        System.out.println(" \n2.- Lista de adyacencia");

        do{
            System.out.println("Crear conecion? \n1. SI\t2. NO");
            opcion = scan.nextInt();
            if(opcion == 1){
                crearConexion(listaNodos, cantidad);

            }

        }while(opcion == 1);

        Grafo grafo = new Grafo();
        for(int i = 0;i < listaNodos.size();i++){
            Nodo temp = listaNodos.get(i);
            grafo.agregarNodo(temp);
        }
        return grafo;
    }

    public static void crearConexion(ArrayList<Nodo> listNodos, int CantidadNodos){
        String valorNodo,nodoFinTemp;
        Nodo nodoInicio, nodoFin;
        boolean bandera = false;
        do{
            System.out.println("Dijite el nodo de inicio");
            valorNodo = scan.next();
            nodoInicio = busqueda(listNodos, valorNodo);
            if(nodoInicio == null){
                System.out.println("Valor NO encontrado. \n");
            }
            else{
                do{
                    System.out.println("\n Ingrese el valor del nodo que esta conectado");
                    nodoFinTemp = scan.next();
                    nodoFin = busqueda(listNodos, nodoFinTemp);
                    if(nodoFin == null){
                        System.out.println("Valor no encontrado \n");


                    }
                    else{
                        System.out.println("Ingrese el valor del peso");
                        nodoInicio.setAristas(new Arista(nodoInicio, nodoFin, scan.nextDouble()));
                        System.out.println("Conexcion establecida");
                        bandera = true;
                    }
                }while(nodoFin == null);
            }

        }while(bandera == false);
    }
    public static Nodo busqueda(ArrayList<Nodo> listaNodos, String valorBuscado){
        Nodo nodoInicio = null;
        for(int i = 0; i < listaNodos.size();i++){
            Nodo temporal = listaNodos.get(i); 
            if(temporal.getDato().equals(valorBuscado) ){
                nodoInicio = temporal;
                return nodoInicio;
            }

        }
        return null;

    }

    public static int busquedaNodo(Grafo grafo, String valorBuscado){
        int posicion = -1;
        List<Nodo> listaNodos = grafo.getNodos();

        for(int i = 0; i < listaNodos.size(); i++){
            Nodo nodoTemp = listaNodos.get(i);
            if(nodoTemp.getDato().equals(valorBuscado)){
                posicion = i;
            
            }
        }
        return posicion;
    }
}
