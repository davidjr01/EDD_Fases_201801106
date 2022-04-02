
package edd_fase2;

public class Lista_Capa {
    private Nodo cabecera;
    private int tamanio=0;
    
    public class Nodo{
        public int valor;
        public Nodo siguiente = null;
        public Nodo(int valor){
            this.valor = valor;
        }
    }
    public Lista_Capa(){
        this.tamanio=0;
    }
    public void InsertarFinal(int valor){ //inserta al final de la lista
        Nodo nodonuevo = new Nodo(valor);
        if(cabecera == null){
            cabecera = nodonuevo;
        }
        else{
            Nodo aux = cabecera;
            while(aux.siguiente != null){
                aux=aux.siguiente;
            }
            aux.siguiente = nodonuevo;
        }
        
    }
    
    public int MostrarCapas(int x){
        Nodo aux = cabecera;
        int c=0;
        int capas=0;
        while(aux != null){
            c+=1;
            if(c==x){
                capas=aux.valor;  
                aux=null;
            }
            else{
            aux = aux.siguiente;
            }
        }
        return capas;     
    }
    
    public void Mostrar(){
        if(cabecera == null){
            System.err.print("La lista se encuentra vacia");
        }
        else{
            Nodo aux = cabecera;
            int c=0;
            while(aux != null){
                System.out.println(aux.valor);
                aux = aux.siguiente;
            }
        }
    }
      
    
}
