
package edd_fase2;

public class nCabecera {    
    public int id;
    public nCabecera siguiente,anterior;
    public Nodo accesoNodo;
    public  nCabecera(int id){
        this.id=id;
        this.siguiente = null;
        this.anterior = null;
        this.accesoNodo = null;
            
    }
  
}
