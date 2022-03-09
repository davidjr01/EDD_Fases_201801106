
package edd_fase2;

public class Cabecera {
    public nCabecera primero;
    public Cabecera(nCabecera primero){
      
        this.primero=primero;     
    }
    
  
    
    public void appendCabecera(nCabecera nuevo){
        if (this.primero==null){
            this.primero=nuevo;
        }
        else if( nuevo.id < this.primero.id){
            nuevo.siguiente = this.primero;
            this.primero.anterior = nuevo;
            this.primero = nuevo;
        }
        else{
            nCabecera actual = this.primero;
            while (actual.siguiente != null){
                if (nuevo.id < actual.siguiente.id){
                    nuevo.siguiente = actual.siguiente;
                    actual.siguiente.anterior = nuevo;
                    nuevo.anterior = actual;
                    actual.siguiente = nuevo;
                    break;
                }
                actual = actual.siguiente;
            }

            if (actual.siguiente == null){
                actual.siguiente = nuevo;
                nuevo.anterior = actual;         
            }
        }
        
    }
    public nCabecera getCabecera(int id){
        nCabecera actual =this.primero;
        while (actual != null){
            if (actual.id == id){
                return actual;
            }
            actual = actual.siguiente;
        
        }
        return null;
    }
    
    
    
    
}
