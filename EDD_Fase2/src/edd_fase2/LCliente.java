
package edd_fase2;

public class LCliente {
    private Nodo cabecera;
    private int tamanio=0;
   
    
    
    public class Nodo{
        private OCliente cliente;
        private AVL imagenes;
        private Arbolabb capas;
        //public int valor;
        public Nodo siguiente = null;
        public Nodo(OCliente cliente,AVL imagenes,Arbolabb capas){
            this.cliente=cliente;
            this.imagenes=imagenes;
            this.capas=capas;
        }
    }
    public LCliente(){
        this.tamanio=0;
    }
    
    
    public void InsertarFinal(OCliente cliente,AVL imagenes,Arbolabb capas){ //inserta al final de la lista
        Nodo nodonuevo = new Nodo(cliente , imagenes,capas);
        if(cabecera == null){
            cabecera = nodonuevo;
            this.tamanio+=1;
        }
        else{
            Nodo aux = cabecera;
            while(aux.siguiente != null){
                aux=aux.siguiente;
            }
            aux.siguiente = nodonuevo;
            this.tamanio+=1;
        }
        
    }
    
    public void AddImagen(String cliente ,int x,Lista_Capa lista){
        Nodo aux = cabecera;
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c==cliente){
                aux.imagenes.add(x,lista);
                aux=null;
                
            }
            else{
                aux = aux.siguiente;
                
            }
            
        }     
    }
    
    public void EliminarImagen(String cliente,int x){
        Nodo aux = cabecera;
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c==cliente){
                aux.imagenes.delete(x);
                aux=null;
            }
            else{
                aux = aux.siguiente;
                
            }
            
        }
        
    }
    
    public Lista_Capa BuscarImagen(String cliente,int x){
        Nodo aux = cabecera;
        Lista_Capa listac=new Lista_Capa();
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c==cliente){
                listac=aux.imagenes.search(x);
                aux=null;
            }
            else{
                aux = aux.siguiente;
                
            }
            
        }
        return listac;
        
        
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
