
package edd_proyecto_fase1_201801106;

public class Impresora {
    private Nodo cabecera;
    private int tamanio;
    public String contenidoG="";
    
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
                 nodos+="Im"+aux.id+cs+aux.tipo+"[label=\""+aux.tipo  +"\"];\n";
                 if(aux.siguiente != null){
                    conexiones+="Im"+aux.id+cs+aux.tipo+ " -> "+"Im"+aux.siguiente.id +(cs+1)+aux.tipo+";\n";
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
    
     public String GraPrimero(){
        String auxiliar="";
        if(cabecera == null){
            return "";
        }
        else{
            int cs=0;
            int c=0;
            Nodo aux = cabecera;
            while(aux != null){
                c=c+1;
                if(c==1){
                    auxiliar="Im"+aux.id+"1"+aux.tipo;
                }
                
                
                aux = aux.siguiente;
            }
            
            return auxiliar;
        }
    }
      
    
}
