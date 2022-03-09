
package edd_proyecto_fase1_201801106;

import static java.lang.Integer.parseInt;

public class Lista_Paso {
    private Nodo cabecera;
    private int tamanio;
    
    public class Nodo{
        public Cliente cliente;
        public Pila_imagen pila;
        public Nodo siguiente = null;
        public Nodo(Cliente cliente,Pila_imagen pila){
            this.cliente = cliente;
            this.pila = pila;
        }
    }
    
    
    public void InsertarFinal(Cliente cliente,Pila_imagen pila){ //inserta al final de la lista
        Nodo nodonuevo = new Nodo(cliente,pila);
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
               // System.out.println("ventanilla  " + aux.id + "  " + "Cliente :  " + aux.cliente.getNombre() );
                aux.pila.Mostrar();
                System.out.println("");
                aux = aux.siguiente;
            }
        }
    }
      
    
}
