
package edd_proyecto_fase1_201801106;

public class Lista_Cliente {
    private Nodo cabecera;
    private int tamanio;
    
    public class Nodo{
        public Cliente cliente;
        public Nodo siguiente = null;
        public Nodo(Cliente cliente){
            this.cliente= cliente;
        }
    }
    
    public void InsertarIn(Cliente cliente){ //agregar al inicio
        Nodo nuevo=new Nodo(cliente);
        if (cabecera== null){
            cabecera=nuevo;
        }else{
            nuevo.siguiente=cabecera;
            cabecera=nuevo;
        }
    
    }
    
    public void InsertarFinal(Cliente cliente){ //inserta al final de la lista
        Nodo nodonuevo = new Nodo(cliente);
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
                System.out.println(aux.cliente.getNombre());
                aux = aux.siguiente;
            }
        }
    }
      
    
}
