
package edd_proyecto_fase1_201801106;

public class Lista_Ventanilla {
    private Nodo cabecera;
    private int tamanio;
    
    public class Nodo{
        public int id,estado;
        public Cliente cliente;
        public Pila_imagen pila;
        public Nodo siguiente = null;
        public Nodo(int id,Cliente cliente,Pila_imagen pila,int estado){
            this.id = id;
            this.cliente = cliente;
            this.pila = pila;
        }
    }
    
    
    public void InsertarFinal(int id,Cliente cliente,Pila_imagen pila,int estado){ //inserta al final de la lista
        Nodo nodonuevo = new Nodo(id,cliente,pila,estado);
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
    
    public void InsertarPila(int ids, String tipo){
        cabecera.pila.InsertarIn(ids, tipo);
        
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
    
    public void Acliente(Cliente cliente , int ide){ //agrega el cliente a la ventanilla
        Nodo aux = cabecera;
        while(aux != null){
            if (aux.id==ide){
                aux.cliente=cliente;
                
                aux.estado=1;
                
            }
            else{
                
            }
            aux = aux.siguiente;
        }
        
        
        
    }
    
    public int Buscar(){
        Nodo aux = cabecera;
        int c=0;
        int scr=0;
        while(aux != null && scr!=1){
            if (aux.estado==0){
                c=aux.id;
                scr=1;
            }
            else{
                c=0;
            }
            aux = aux.siguiente;
        }
        return c;
    }
    
    public void Mostrar(){
        if(cabecera == null){
            System.err.print("La lista se encuentra vacia");
        }
        else{
            Nodo aux = cabecera;
            int c=0;
            while(aux != null){
                System.out.println("ventanilla  " + aux.id + "  " + "Cliente :  " + aux.cliente.getNombre() );
                aux = aux.siguiente;
            }
        }
    }
      
    
}
