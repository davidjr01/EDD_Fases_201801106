/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_fase2;

import java.io.FileWriter;
import java.io.PrintWriter;


public class Arbolabb {
    public Lista_Pixel lista2;
    
    public class NodoABB  {
        int valor;
        Lista_Pixel lista;
        NodoABB rama_izquierda;
        NodoABB rama_derecha;
        public  NodoABB(int valor,Lista_Pixel lista){
            this.valor = valor;
            this.lista=lista;
            this.rama_izquierda =null;
            this.rama_derecha = null;
        }
        
        public String textoGraphviz(){
            if(this.rama_izquierda == null && this.rama_derecha == null){
                return String.valueOf(this.valor);
            }
            else{
                String texto = "";
                if(this.rama_izquierda !=null){
                    texto  +=  this.valor+"->"+ this.rama_izquierda. textoGraphviz()+"\n";
                }
                if(this.rama_derecha!=null){
                    texto +=  this.valor+"->"+this.rama_derecha. textoGraphviz()+"\n";
                }
                return texto;
            }
        }
    }
    
    int tamaño;
    NodoABB raiz;
    
    public  Arbolabb(){
        this.raiz=null;
        this.tamaño=0;
        
    }
    
    public void insert(int valor,Lista_Pixel lista){
        
        this.raiz = this.recorrer_insert(valor,lista, this.raiz);
    }
    
    NodoABB recorrer_insert(int valor,Lista_Pixel lista,NodoABB raiz){
        if (raiz == null){
            NodoABB nodos =new NodoABB(valor,lista);
            return nodos;
        }
        else if (valor==raiz.valor){
            
        }
        else{
            if (valor < raiz.valor){
                raiz.rama_izquierda = this.recorrer_insert(valor,lista,raiz.rama_izquierda);
            }
            else{
                raiz.rama_derecha = this.recorrer_insert(valor,lista,raiz.rama_derecha);
            }
        }
        return raiz;
    }
    
    public void recorrer_preorder(NodoABB nodo){
        System.out.println(nodo.valor);
            if (nodo.rama_izquierda != null){
                recorrer_preorder(nodo.rama_izquierda);
            }
            if (nodo.rama_derecha != null){
                recorrer_preorder(nodo.rama_derecha);
            }
        
    }
    public void preorder(){
        recorrer_preorder(this.raiz);
        
    
   }
    
    
    public void Inorden(){
        this.recorrer_inorden(this.raiz);
    }
    public void recorrer_inorden(NodoABB nodo){
        if (nodo.rama_izquierda!=null){
            recorrer_inorden(nodo.rama_izquierda); 
        }
        System.out.println("Valor :"+nodo.valor);
        if (nodo.rama_derecha!=null){
            recorrer_inorden(nodo.rama_derecha); 
        }    
        
    }
    

    
    
    
    public void Postorder(){
        this.recorrer_postorder(this.raiz);
    }
    public void recorrer_postorder(NodoABB nodo){
        if (nodo.rama_izquierda!=null){
            recorrer_postorder(nodo.rama_izquierda); 
        }
        if (nodo.rama_derecha!=null){
            recorrer_postorder(nodo.rama_derecha); 
        }
        System.out.println("Valor :"+nodo.valor); 
        
    }
    
    public Lista_Pixel  Buscar(int valor){
        lista2=null;
        return recorrer_buscar(this.raiz, valor);
        
    }
    public Lista_Pixel recorrer_buscar(NodoABB nodo,int valor){
        
        if (valor == nodo.valor){
                lista2=nodo.lista;
        }
        else if (valor < nodo.valor){
            if (nodo.rama_izquierda == null){
                lista2=null;
            }
            else{
                recorrer_buscar( nodo.rama_izquierda,valor);
            }
        }
        else{
            if (nodo.rama_derecha == null){
                lista2=null;
            }
            else{
                recorrer_buscar( nodo.rama_izquierda,valor);
            }
       }
       return lista2;
        
    }
    
    

    
    public void Graficar() {
        String texto ="digraph G{\n"
               +"\n"
               +"node [shape = circle]\n"
               +"node [stile = filled]\n"
               +"node [fillcolor =\" #EEEEE\"]\n"
               +"node [color =\" #EEEEE\"]\n"
               +"edge[color =\" #31CEF0\"]\n";
        if(raiz !=null){
            texto+=raiz.textoGraphviz();
        }
        texto+= "\n}";
        
        FileWriter fw=null;
        PrintWriter pw=null;
        try{
            fw=new FileWriter("Arbolabb.dot");
            pw=new PrintWriter(fw);
            pw.write(texto);
            pw.close();
            fw.close();
        
        }catch(Exception ex){
        System.out.println(ex.getMessage());
         }finally{
            if (pw!=null)
                pw.close();
        }
        
        try{
            ProcessBuilder pb;
            pb=new ProcessBuilder("dot","-Tpng","Arbolabb.dot","-o","Arbolabb.png");
            pb.redirectErrorStream(true);
            pb.start(); 
        }catch(Exception e){
         e.printStackTrace();
        }
    }
  
    
    
}
