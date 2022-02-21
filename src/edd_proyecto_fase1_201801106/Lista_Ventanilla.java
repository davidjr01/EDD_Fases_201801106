
package edd_proyecto_fase1_201801106;

import static java.lang.Integer.parseInt;

public class Lista_Ventanilla {
    public Impresora color=new Impresora();
    public Impresora byn=new Impresora();
    private Lista_Paso  paso =new Lista_Paso();
    public int controlpasos=0;
    public int señalimpresora=0;
    public DobleEnlazadaCircular esperaClientes =new DobleEnlazadaCircular();
    
    public Nodo cabecera;
    private int listo=0;
    
    
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
    public void Ocupado(){
        Nodo aux = cabecera;
        listo=0;
        Lista_Paso  paso2 =new Lista_Paso();
        paso=paso2;
        
        while(aux != null){
            if (aux.estado==1){
                
                if ((parseInt(aux.cliente.imgBw)>=1)|| (parseInt(aux.cliente.imgC)>=1)){
                    if (parseInt(aux.cliente.imgC)>0){
                        aux.pila.InsertarIn(aux.cliente.id, "Color" );
                        int x=parseInt(aux.cliente.imgC);
                        x= x-1;
                        aux.cliente.imgC=x+""; 
                        System.out.println("Imagen Color del cliente  "+ aux.cliente.id +"  Pasa a Pila de ventanilla  " + aux.id);
                    }else if(parseInt(aux.cliente.imgBw)>0) {
                        aux.pila.InsertarIn(aux.cliente.id, "ByN" );
                        int x=parseInt(aux.cliente.imgBw);
                        x= x-1;
                        aux.cliente.imgBw=x+"";
                        System.out.println("Imagen ByN del cliente  "+ aux.cliente.id +"  Pasa a Pila de ventanilla  " + aux.id);
                    }    
                     
                }else{
                    señalimpresora=1;
                    Pila_imagen pilas=new Pila_imagen();
                    esperaClientes.InsertarFin(aux.cliente,pilas, aux.cliente.totalImagen);
                    //cabecera.pila.Aimpresora();
                    int ccolor=aux.pila.CColor();
                    int cbyn=aux.pila.ByN();
                    Aimpresoras(aux.cliente.id,ccolor,cbyn);
                    System.out.println("Lista de imagenes del cliente " + aux.cliente.id + "  pasan a impresora ");
                    System.out.println("Cliente " + aux.cliente.id + " pasa a lista de espera ");
                    Cliente cliente2= new Cliente(0,"","","",0);
                    Pila_imagen pila2=new Pila_imagen();
                    aux.cliente=cliente2;
                    aux.pila=pila2;
                    aux.estado=0;
                    System.out.println("ventanilla " + aux.id +  "  vacia");
                    listo=1;
                    
                }

            } //primer if 
            
            aux = aux.siguiente;
        }//while
      
    }
    
    public void Aimpresoras(int id,int c, int b){
        for(int i=0;i<c;i++){
            color.InsertarFinal(id, "Color");    
        }
        for(int i=0;i<b;i++){
            byn.InsertarFinal(id, "ByN");    
        }
        
        
    }
    
    public int SeñalImpresora(){ // en el main para saber si la impresora ya empezo a trabajar
        return señalimpresora;
    }
    
    public void Psos(){
        controlpasos+=1;
        if(controlpasos==2){
            int x =color.shift();
            if(x>=1){
                esperaClientes.InsertarImagen(x, "Color");
                System.out.println("Imagen a color del cliente " + x +" Impresa");
                
            }  
            controlpasos=0;
        }else{
            int y=0;
            y =byn.shift();
            if(y>=1){
               esperaClientes.InsertarImagen(y, "ByN");
               System.out.println("Imagen ByN del cliente " + y +"Impresa"); 
            }
        }
        
    }
    
    
    
    
    
    public int Pasarr(){
        if(listo==1){
            return 1;
        }else{
           return 0; 
        }
    }
    
    public Lista_Paso Pasarr2(){
        return paso;

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
                aux.pila.Mostrar();
                System.out.println("");
                aux = aux.siguiente;
                
            }
        }
    }
      
    
}
