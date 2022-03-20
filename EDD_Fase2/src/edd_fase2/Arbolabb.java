/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_fase2;


public class Arbolabb {
    
    public class NodoABB  {
        int valor;
        NodoABB rama_izquierda;
        NodoABB rama_derecha;
        public  NodoABB(int valor){
            this.valor = valor;
            this.rama_izquierda =null;
            this.rama_derecha = null;
        }
    }
    
    int tamaño;
    NodoABB raiz;
    
    public  Arbolabb(){
        this.raiz=null;
        this.tamaño=0;
        
    }
    
    public void insert(int valor){
        
        this.raiz = this.recorrer_insert(valor, this.raiz);
    }
    
    NodoABB recorrer_insert(int valor,NodoABB raiz){
        if (raiz == null){
            NodoABB nodos =new NodoABB(valor);
            return nodos;
        }
        else if (valor==raiz.valor){
            
        }
        else{
            if (valor < raiz.valor){
                raiz.rama_izquierda = this.recorrer_insert(valor,raiz.rama_izquierda);
            }
            else{
                raiz.rama_derecha = this.recorrer_insert(valor,raiz.rama_derecha);
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
    
    
    
}
