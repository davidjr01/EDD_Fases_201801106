/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto_fase1_201801106;

public class Cliente {
    public int id;
    public String nombre;
    public String imgC;
    public String imgBw;
    public int totalImagen;
    
    public Cliente( int id , String nombre,String imgC,String imgBw,int totalImagen) {
        this.id = id;
        this.nombre = nombre;
        this.imgC = imgC;
        this.imgBw = imgBw;
        this.totalImagen = totalImagen;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgC() {
        return imgC;
    }

    public void setImgC(String imgC) {
        this.imgC = imgC;
    }

    public String getImgBw() {
        return imgBw;
    }

    public void setImgBw(String imgBw) {
        this.imgBw = imgBw;
    }
    
    public int getTotalImagen() {
        return totalImagen;
    }

    public void setTotalImagen(int totalImagen) {
        this.totalImagen = totalImagen;
    }
    
    
    
}
