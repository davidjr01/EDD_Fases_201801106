
package edd_fase2;

public class Lista_Pixel {
    private Nodo cabecera;
    private int tamanio=0;
    
    public class Nodo{
        public Pixel pixel;
        public int valor;
        public Nodo siguiente = null;
        public Nodo(Pixel pixel){
            this.pixel = pixel;
        }
    }
    public Lista_Pixel(){
        this.tamanio=0;
    }
    
    
    public void InsertarFinal(Pixel pixel){ //inserta al final de la lista
        Nodo nodonuevo = new Nodo(pixel);
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
    
    
    Pixel  DevolverValor(int i){
        if(cabecera == null){
            System.err.print("La lista se encuentra vacia");
            return null;
        }
        else{
            Pixel mandar=null;
            Nodo aux = cabecera;
            int c=0;
            while(aux != null){
                c+=1;
                System.out.println(aux.valor);
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
    
    int TamCapa(){
        return this.tamanio;
    }
    
      
    
}
