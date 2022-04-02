
package edd_fase2;

public class LCliente {
    public Nodo cabecera;
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
            if (c.equals(cliente)){
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
            if (c.equals(cliente)){
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
            if (c.equals(cliente)){
                listac=aux.imagenes.search(x);
                aux=null;
            }
            else{
                aux = aux.siguiente;
                
            }
            
        }
        return listac;
        
        
    }
    
    
    
    public Boolean Login(String Dpi,String contra){
        if(cabecera == null){
            return false;
        }
        else{
            Nodo aux = cabecera;
            Boolean paso=false;
            while(aux != null){
                
                if ((Dpi.equals(aux.cliente.dpi))&&(contra.equals(aux.cliente.contraseña))){
                    paso=true;
                    aux=null;
                }
                else{
                    aux = aux.siguiente;
                    
                }
                
            }
            return paso;
        }  
    }
   
     public void AddCapas(String cliente ,int x,Lista_Pixel lista){
        Nodo aux = cabecera;
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c.equals(cliente)){
                aux.capas.insert(x,lista);
                aux=null;
                
            }
            else{
                aux = aux.siguiente;
                
            }
            
        }     
    }
     
     public Lista_Pixel BuscarCapa(String cliente,int x){
        Nodo aux = cabecera;
        Lista_Pixel listac=new Lista_Pixel();
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c.equals(cliente)){
                listac=aux.capas.Buscar(x);
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
                System.out.println(aux.cliente.nombre);
                aux = aux.siguiente;
            }
        }
    }
      
    
}
