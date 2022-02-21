
package edd_proyecto_fase1_201801106;

public class Pila_imagen {
    private Nodo cabecera;
    private int tamanio;
    public String contenidoG="";
    public String x="";
    
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
    
     public String Graficars(){
         contenidoG="";
        if(cabecera == null){
            return "";
        }
        else{
            int cs=0;
            String nodos="";
            String conexiones="";
            Nodo aux = cabecera;
            int c=0;
            while(aux != null){
                cs=cs+1;
                 nodos+="I"+aux.id+cs+"[label=\""+aux.tipo  +"\"];\n";
                 if(aux.siguiente != null){
                    conexiones+="I"+aux.id+cs+ " -> "+"I"+aux.siguiente.id +(cs+1)+";\n";
                   }
                
                
                aux = aux.siguiente;
            }
            contenidoG+=nodos+"\n";
            contenidoG+="\n{rank=same\n";
            contenidoG+="\n"+conexiones+"\n";
            contenidoG+="\n}\n";
            return contenidoG;
        }
    }
    
 
    
}
