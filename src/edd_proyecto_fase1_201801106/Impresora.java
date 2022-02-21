
package edd_proyecto_fase1_201801106;

public class Impresora {
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
    
    
    public void InsertarFinal(int id,String tipo){ //inserta al final de la lista
        Nodo nodonuevo = new Nodo(id,tipo);
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
    
    
    public int shift(){ // elimina el primer dato de la lista
        if (cabecera==null){
         return 0;
        }else{
            Nodo eliminado=cabecera;
            cabecera=eliminado.siguiente;
            eliminado.siguiente=null;   
            return eliminado.id;
        }
           
    }
    
    
    public void Mostrar(){
        if(cabecera == null){
            System.err.print("La impresora se encuentra vacia");
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
