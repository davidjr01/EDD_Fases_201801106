/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto_fase1_201801106;

public class DobleEnlazadaCircular {
    private Nodo cabecera;
    private Nodo cola;
    public int tamanio=0;
    
    public class Nodo{
        public Cliente cliente;
        public Pila_imagen pila;
        public int valor;
        public Nodo siguiente = null;
        public Nodo anterior = null;
        public Nodo(Cliente cliente , Pila_imagen pila ,int valor){
            this.cliente = cliente;
            this.pila = pila;
            this.valor = valor;
        }
    }
    
    
    public void InsertarFin(Cliente cliente , Pila_imagen pila ,int valor){
        Nodo nuevo=new Nodo(cliente,pila ,valor);
        if((cabecera==null)&& (cola==null)){
            cabecera=nuevo;
            cola=nuevo;
            tamanio+=1;
            
        }else{
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = cabecera; 
            cabecera.anterior = nuevo;
            cola = nuevo;
            tamanio+=1;
        }
    }
    
    public void InsertarImagen(int id ,String tipo){
        Nodo actual=cabecera;
        Boolean pivote=true;
        int contador=tamanio;
        while(contador!=0){
            if((pivote!=false)|(actual!=cabecera)){
                if (id==actual.cliente.id){
                    actual.pila.InsertarIn(id,tipo);
                }
                
                
                actual=actual.siguiente;
                pivote=false;
                contador-=1; 
            }
            else{
                break;
            }
            
        }
    }
    
    
    
    
    
    public void Mostrar(){
        Nodo actual=cabecera;
        Boolean pivote=true;
        int contador=tamanio;
        while(contador!=0){
            if((pivote!=false)|(actual!=cabecera)){
                System.out.println(actual.cliente.nombre);
                actual.pila.Mostrar();
                actual=actual.siguiente;
                pivote=false;
                contador-=1; 
            }
            else{
                break;
            }
            
        }
        
    }
    
  
    
    
    
}
