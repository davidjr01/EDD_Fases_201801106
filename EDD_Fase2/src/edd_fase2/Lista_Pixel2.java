
package edd_fase2;

public class Lista_Pixel2 {
    private Nodo cabecera;
    private int tamanio=0;
    
    public class Nodo{
        public Lista_Pixel pixel;
        public int valor;
        public Nodo siguiente = null;
        public Nodo(int valor,Lista_Pixel pixel){
            this.pixel = pixel;
            this.valor=valor;
        }
    }
    public Lista_Pixel2(){
        this.tamanio=0;
    }
    
    
    public void InsertarFinal(int valor,Lista_Pixel pixel){ //inserta al final de la lista
        Nodo nodonuevo = new Nodo(valor,pixel);
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
    public int Tamaño(){
        return this.tamanio;
    }
    
    
    public Lista_Pixel  DevolverValor(int i){
        if(cabecera == null){
            System.err.print("La lista se encuentra vacia");
            return null;
        }
        else{
            Lista_Pixel mandar=null;
            Nodo aux = cabecera;
            int c=0;
            while(aux != null){
                c+=1;
                if(c==i){
                    mandar=aux.pixel;
                    aux=null;
                }
                else{
                    aux = aux.siguiente;
                    
                }  
            }
            return mandar;
        }
    }
    
    public int TamCapa(){
        return this.tamanio;
    }
    
      
    
}
