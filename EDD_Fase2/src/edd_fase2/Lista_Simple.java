
package edd_fase2;

public class Lista_Simple {
    private Nodo cabecera;
    private int tamanio=0;
    
    public class Nodo{
        public int valor;
        public Nodo siguiente = null;
        public Nodo(int valor){
            this.valor = valor;
        }
    }
    
    public void InsertarIn(int valor){ //agregar al inicio
        Nodo nuevo=new Nodo(valor);
        if (cabecera== null){
            cabecera=nuevo;
        }else{
            nuevo.siguiente=cabecera;
            cabecera=nuevo;
        }
    
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
    
    public void shift(){ // elimina el primer dato de la lista
        if (cabecera==null){
    
        }else{
            Nodo eliminado=cabecera;
            cabecera=eliminado.siguiente;
            eliminado.siguiente=null;
            
            
        }
        
    }
    
    public void pop(){ // elimina el ultimo
        if (cabecera==null){
    
        }else{
            Nodo actual=cabecera;
            Nodo cola=actual;
            while(actual.siguiente!=null){
                cola=actual;
                actual=actual.siguiente;    
            }
            cola.siguiente=null;
           
            
            
        }
        
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
