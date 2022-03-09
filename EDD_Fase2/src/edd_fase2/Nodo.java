package edd_fase2;

public class Nodo {
    public int fila,columna;
    public String dato;
    public Nodo derecha,izquierda,abajo,arriba;
    public  Nodo(int fila,int columna,String dato){
        this.fila = fila;
        this.columna = columna;
        this.dato =  dato;
        this.derecha = null;
        this.abajo = null;
        this.izquierda = null;
        this.arriba = null;
            
    }
    
}
