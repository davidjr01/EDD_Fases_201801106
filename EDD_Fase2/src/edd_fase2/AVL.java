/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_fase2;

public class AVL {
    public String contenido;
    public Nodo root;
    public AVL a;
    public class Nodo{
        public Nodo derecha,izquierda;
        public int id,tamaño;
        public Lista_Capa lista;
        public Nodo(int id,Lista_Capa lista){
            this.id=id;
            this.lista=lista;
            this.derecha=null;
            this.izquierda=null;
            tamaño=0; 
        }
    }
    
    public AVL(){
        root=null;
        
    }
    public void add(int id,Lista_Capa lista){
        this.root=this._add(id,lista,this.root);
        
    }

    
    
    
    public Nodo _add(int id,Lista_Capa lista,Nodo root){
        if (root == null){
            Nodo x=new Nodo(id,lista);
            return x;
            }
        else{
            if (id < root.id){
                root.izquierda = this._add(id,lista,root.izquierda);
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
                root.derecha = this._add( id,lista, root.derecha);
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
    
    public Lista_Capa search(int id){
        if (this.root==null){
            return null;
        }
        else{
            return this._search(id, this.root);
        }
    }

    public Lista_Capa _search(int id, Nodo node){
        if (node ==null){
            return null;
        }
        else if(id < node.id){
            return this._search( id, node.izquierda );
        }
        else if ( id > node.id){
            return this._search( id, node.derecha );
        }
        else{
            return node.lista;
        }
    }

    public Nodo getMin(){
            if (this.root ==null){
                return null;
            }
            else{
                return this._getMin( this.root );
            }
    }

    public Nodo _getMin(Nodo node){
        if (node.izquierda!=null){
            return this._getMin( node.izquierda );
        }
        else{
            return node;
        }
    }
    
    public Nodo getMax(){
        if (this.root==null){
            return null;
        }
        else{
            return this._getMax( this.root );
        }
    }

    public Nodo _getMax(Nodo node){
        if (node.derecha!=null){
            return this._getMax( node.derecha );
        }
        else{
            return node;
        }
    }

    //------------------------------------------------ Eliminar nodo del arbol ------------------------------------------------------
    public void delete(int id){
        this.root = this._delete(id, this.root);
    }

    public Nodo _delete(int id, Nodo node){
        if (node ==null){
            System.out.println("imagen no registrada");
        }

        else if (id < node.id){
            node.izquierda = this._delete(id, node.izquierda);
            if ((this.height(node.derecha) - this.height(node.izquierda)) == 2){
                if (this.height(node.derecha.derecha) >= this.height(node.derecha.izquierda)){
                    node = this.SimpleDer(node);
                }
                else{
                    node = this.dobleDer(node);
                }
            }
            node.tamaño= this.max_min(this.height(node.izquierda), this.height(node.derecha)) + 1;
        }
            
        else if(id>node.id) {
            node.derecha = this._delete(id, node.derecha);
            if ((this.height(node.izquierda) - this.height(node.derecha)) == 2){
                if (this.height(node.izquierda.izquierda) >= this.height(node.izquierda.derecha)){
                    node = this.SimpleIzq(node);
                }
                else{
                    node = this.dobleIzq(node);
                }
            }
            node.tamaño = this.max_min(this.height(node.izquierda), this.height(node.derecha))  +1;
        }
        
        else if((node.izquierda!=null) && (node.derecha!=null)) {
            if (node.izquierda.tamaño <= node.derecha.tamaño){
                Nodo minNode = this._getMin(node.derecha);
                node.id = minNode.id;
                node.derecha = this._delete(node.id, node.derecha);
            }
            else{
                Nodo maxNode = this._getMax(node.izquierda);
                node.id = maxNode.id;
                node.izquierda = this._delete(node.id,node.izquierda);
            }
            node.tamaño = this.max_min(this.height(node.izquierda), this.height(node.derecha)) + 1;
        }
        else{
            if (node.derecha!=null){
                node = node.derecha;
            }
            else{
                node = node.izquierda;
            }
        }
        
        return node;
    }

    // ------------------------------------------------- Recorrcarnetos del arbol --------------------------------------------------------
    public void preorden(){
        this._preorden(this.root);
    }

    public void _preorden(Nodo root){
        if (root !=null){
            System.out.println(root.id);
            this._preorden(root.izquierda);
            this._preorden(root.derecha);
        }
    }
    
    public void inorden(){
        this._inorden(this.root);
     }
    public void _inorden(Nodo root){
        if (root !=null){
            this._inorden(root.izquierda);
            System.out.println(root.id);
            this._inorden(root.derecha);
        }
    } 

    public void postorden(){
        this._postorden(this.root);
    }

    public void _postorden(Nodo root){
        if (root !=null){
            this._postorden(root.izquierda);
            this._postorden(root.derecha);
            System.out.println(root.id);
        }
    }
    
    // ------------------------------------------------- GRAFICAR --------------------------------------------------------

    public void preordenG(){
        this._preordenG(this.root);
    }

    public void _preordenG(Nodo root){
        if (root != null){
            this.contenido += "\n\t\tn" + root.id + " [label = \" "+(root.id) +"\" penwidth=2.5];";
        
            if (root.izquierda != null){
                this.contenido += "\n\t\tn" + (root.id) + " -> n" + (root.izquierda.id) + "[tailport=sw headport=n];";
            }
            if (root.derecha !=null){
                this.contenido += "\n\t\tn" + (root.id) + " -> n" + (root.derecha.id) + "[tailport=se headport=n];";
            }
            this._preordenG(root.izquierda);
            this._preordenG(root.derecha);
        }
    }


    public void Graficar(){
        this.contenido = "";
        this.contenido+= "digraph G\n{\n"
            +"node[shape=box, style=filled, fillcolor=\"#303F9F\", fontcolor=white, color=\"#0A122A\"];\n"
            +"splines=false;\n";
     
        this.preordenG();
        this.contenido += "\n\t\tedge[dir=none];";
        this.contenido += "\n\t\tnode[fillcolor=white, fontcolor=black];";

        this.contenido += "\n\t}";
        System.out.println(this.contenido);
    }
    
    
    
}
