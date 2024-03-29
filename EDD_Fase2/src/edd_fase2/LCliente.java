
package edd_fase2;

import javax.swing.JOptionPane;

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
    
    public Lista_Capa BuscarIdImagen(String cliente){
        Nodo aux = cabecera;
        Lista_Capa listac=new Lista_Capa();
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c.equals(cliente)){
                listac=aux.imagenes.ObtenerId();
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
     
     public int TamañoCapa(String cliente){
        Nodo aux = cabecera;
        int tamaño=0;
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c.equals(cliente)){
                tamaño=aux.capas.tamaño;
                aux=null;
            }
            else{
                aux = aux.siguiente;
                
            }
            
        }
        return tamaño;
        
        
    }
     
     public Lista_Capa RecorridoCapa(String cliente,String recorrido){
        Nodo aux = cabecera;
        Lista_Capa aux2=new Lista_Capa();
        int tamaño=0;
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c.equals(cliente)){
                aux2=aux.capas.Recorrido(recorrido);
                aux=null;
            }
            else{
                aux = aux.siguiente;
                
            }
            
        }
        return aux2;
        
        
    }
     
    public Lista_Pixel2 RecorridoCapa2(String cliente){
        Nodo aux = cabecera;
        Lista_Pixel2 aux2=new Lista_Pixel2();
        int tamaño=0;
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c.equals(cliente)){
                aux2=aux.capas.Recorrido2();
                aux=null;
            }
            else{
                aux = aux.siguiente;
                
            }
            
        }
        return aux2;
        
        
    }
     
     public void GraficarABB(String cliente){
        Nodo aux = cabecera;
        int tamaño=0;
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c.equals(cliente)){
                aux.capas.Graficar();
                aux=null;
            }
            else{
                aux = aux.siguiente;
                
            }
            
        }
  
        
    }
    
     
     public void GraficarAVL(String cliente){
        Nodo aux = cabecera;
        int tamaño=0;
        while(aux != null){
            String c=aux.cliente.dpi;
            if (c.equals(cliente)){
                aux.imagenes.Graficar();
                aux=null;
            }
            else{
                aux = aux.siguiente;
                
            }
            
        }
  
        
    }
    public Boolean Verificar(String Dpi){
        Boolean x =false;
        if(cabecera == null){
            System.err.print("La lista se encuentra vacia");
        }
        else{
            Nodo aux = cabecera;
            int c=0;
            while(aux != null){
                
                if(Dpi.equals(aux.cliente.dpi)){
                    x=true;
                    aux=null;
                }else{
                    aux = aux.siguiente;
                }
                
            }
        }
        return x;
    }
      
    
}
