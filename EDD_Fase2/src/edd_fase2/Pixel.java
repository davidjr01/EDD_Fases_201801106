/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_fase2;

public class Pixel {
    public int fila,columna;
    public String color;
    public Pixel(int fila,int columna,String color){
        this.fila =fila;
        this.columna=columna;
        this.color=color;
        
    }
    
    public Pixel(){
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    
}
