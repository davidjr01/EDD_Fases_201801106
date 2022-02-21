
package edd_proyecto_fase1_201801106;

public class Pila_imagen {
    private Nodo cabecera;
    private int tamanio;
    
    public class Nodo{
        public int id;
        public String tipo;
        public Nodo siguiente = null;
        public Nodo(int id,String tipo){
            this.id = id;
            this.tipo = tipo;
        }
    }
    
    public void InsertarIn(int ids,String tipo){ //agregar al inicio
       
        Nodo nuevo=new Nodo(ids,tipo);
        if (cabecera== null){
            cabecera=nuevo;
        }else{
            nuevo.siguiente=cabecera;
            cabecera=nuevo;
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

    public int CColor(){
         int color1=0;
         Nodo aux = cabecera;
         while(aux != null){
              if(aux.tipo=="Color"){
                  color1+=1;   
              }
              aux = aux.siguiente;
              
        }
        return color1;
        
    }
    
    public int ByN(){
        int bnr=0;
         Nodo aux = cabecera;
         while(aux != null){
              if(aux.tipo=="ByN"){
                  bnr+=1;   
              }
              aux = aux.siguiente;
              
        }
        return bnr;
        
    }
    

    
    
    public void Mostrar(){
        if(cabecera == null){
            System.err.print("La lista se encuentra vacia");
        }
        else{
            Nodo aux = cabecera;
            int c=0;
            while(aux != null){
                System.out.println(aux.id +"   "+ aux.tipo);
                aux = aux.siguiente;
            }
        }
    }
      
    
}
