/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_fase2;

public class AVL {
    public Nodo root;
    public AVL a;
    public class Nodo{
        public Nodo derecha,izquierda;
        public int id,tamaño;
        public Nodo(int id){
            this.id=id;
            this.derecha=null;
            this.izquierda=null;
            tamaño=0; 
        }
    }
    
    public AVL(){
        root=null;
        
    }
    public void add(int id){
        this.root=this._add(id,this.root);
        
    }

    
    
    
    public Nodo _add(int id,Nodo root){
        if (root == null){
            Nodo x=new Nodo(id);
            return x;
            }
        else{
            if (id < root.id){
                root.izquierda = this._add(id,root.izquierda);
                if (this.height(root.derecha) - this.height(root.izquierda) == -2){
                    if (id < root.izquierda.id){
                        root = this.SimpleIzq(root);
                    }
                    else{
                        root = this.dobleIzq(root);
                    }
                }
            }
            else if(id>root.id) {
                root.derecha = this._add( id, root.derecha);
                if (this.height(root.derecha) - this.height(root.izquierda) == 2){
                    if (id > root.derecha.id){
                        root = this.SimpleDer(root);
                    }
                    else{
                        root = this.dobleDer(root);
                    }
                }
            }
            else{
                root.id = id;
            }
        }
        root.tamaño = this.max_min(this.height(root.izquierda), this.height(root.derecha)) + 1;
        return root;
    }
    
    public int height(Nodo nodo){
        if (nodo!=null){
            return nodo.tamaño;
        }
        return -1;
    }
    
    public Nodo SimpleIzq(Nodo node){
        Nodo aux = node.izquierda;
        node.izquierda = aux.derecha;
        aux.derecha = node;
        node.tamaño = this.max_min(this.height(node.derecha), this.height(node.izquierda)) + 1;
        aux.tamaño = this.max_min(this.height(aux.izquierda), node.tamaño) + 1;
        return aux;
    }
    
    public int  max_min(int v1, int v2){
        if (v1 > v2){
            return v1;
        }
        else{
            return v2;
        }
    }
    
    //  ---------------------------------------------- Rotacion simple por la derecha -------------------------------------------------
    public Nodo SimpleDer(Nodo node){
        Nodo aux = node.derecha;
        node.derecha = aux.izquierda;
        aux.izquierda = node;
        node.tamaño = this.max_min(this.height(node.derecha), this.height(node.izquierda)) + 1;
        aux.tamaño = this.max_min(this.height(aux.derecha), node.tamaño) + 1;
        return aux;
    }
    
    //--------------------------------------------- Rotacion doble por la izquierda -------------------------------------------------
    public Nodo dobleIzq(Nodo node){
        node.izquierda = this.SimpleDer(node.izquierda);
        return this.SimpleIzq(node);
    }
    
    // ---------------------------------------------- Rotacion simple por la derecha -------------------------------------------------
    public Nodo dobleDer(Nodo node){
        node.derecha = this.SimpleIzq(node.derecha);
        return this.SimpleDer(node);
    }
    
    // ---------------------------------------------- Funciones para buscar ----------------------------------------------------------
    
    
    
    
}
