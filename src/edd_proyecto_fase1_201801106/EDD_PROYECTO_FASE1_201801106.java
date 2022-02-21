/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto_fase1_201801106;

import java.io.FileNotFoundException;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author david
 */
public class EDD_PROYECTO_FASE1_201801106 {
    
    public static Lista_Cliente LClientes=new Lista_Cliente();
    public static Lista_Ventanilla LVentanilla =new Lista_Ventanilla();
    public static Lista_Paso  datos =new Lista_Paso();
    public static int contar=0,iVentanilla=0;
    public static Cliente cl;
    public static int  señal2=0;
    
    
    
    public static void CargaM(String nombreD){
        JSONParser parser = new JSONParser();
        
        try{
            Object obj=parser.parse(new FileReader(nombreD));
            JSONObject jsonObject =(JSONObject) obj;
            
            for (int i=1;i<=jsonObject.size();i++){
                JSONObject contenido =(JSONObject) jsonObject.get("Cliente"+i);
                //System.out.println(contenido.get("nombre_cliente"));
                int tot= Integer.parseInt(contenido.get("img_color").toString())+ Integer.parseInt(contenido.get("img_bw").toString());      
                Cliente cliente=new Cliente(Integer.parseInt(contenido.get("id_cliente").toString()),contenido.get("nombre_cliente").toString(),contenido.get("img_color").toString(),contenido.get("img_bw").toString(),tot);
                LClientes.InsertarFinal(cliente);
            }
            System.out.println("Lectura con exito ");
            
        }catch(FileNotFoundException e){
            System.out.println("No se encontro el documento");}
        catch(IOException e){}
        catch(ParseException e){}
        
        
    }
    public static void Ventanilla(){
        int ventanilla;
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese cantidad de ventanillas");
        ventanilla=sc.nextInt();
        
        for(int i=1;i<=ventanilla;i++){
            Cliente cliente= new Cliente(0,"","","",0);
            Pila_imagen pila=new Pila_imagen();
            LVentanilla.InsertarFinal(i, cliente, pila,0);
            
        }
       
    }
    
    
    
    public static void Menu2(){
        int op=0;   
        while(op!=3){
            System.out.println("");
            System.out.println("1.........Carga Masiva de Clientes");
            System.out.println("2.........Cantidad de Ventanillas");
            System.out.println("3.........Salir");
            System.out.println("");
            Scanner sc= new Scanner(System.in);
            op=sc.nextInt();
            switch(op){
                case 1:{
                    String nombreD;
                    System.out.println("Ingrese Nombre del documento");
                    Scanner sc2= new Scanner(System.in);
                    nombreD=sc2.nextLine();
                    CargaM(nombreD);
                    
                    
         
                }break;  
                case 2:{
                    Ventanilla();
                   
                    
                    op=3; // para salir al menu principal
                    
                 }break; 
            }
        }
        
    }
    
    public static void Ejecutar(){
        contar=contar+1;
        System.out.println("______________________Paso "+ contar+" ______________________");
        int ide=LVentanilla.Buscar(); 
        if(ide!=0){
            cl=LClientes.EliminarU();
            LVentanilla.Acliente(cl,ide);
            System.out.println("El cliente  "+ cl.id + " Ingresa a Ventanilla "+ ide);
            
        }
        LVentanilla.Ocupado();
        int b=LVentanilla.SeñalImpresora();
        if(b==1){
          señal2+=1;
          if(señal2>1){
              LVentanilla.Psos();
          }
 
        }
        
        
    }
    
    public static void Crear(String ruta,String contenido){
        FileWriter fw=null;
        PrintWriter pw=null;
        try{
            fw=new FileWriter(ruta);
            pw=new PrintWriter(fw);
            pw.write(contenido);
            pw.close();
            fw.close();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            if (pw!=null)
                pw.close();
        }
         
    }
    
     public void Dibujar(){
         
     }

    public static void main(String[] args) {
        int op=0;   
        while(op!=6){
            System.out.println("");
            System.out.println("1.........Parametros Iniciales");
            System.out.println("2.........Ejecutar Paso ");
            System.out.println("3.........Estado de Memoria de Las Estructuras");
            System.out.println("5.........Reportes");
            System.out.println("5.........Acerca de");
            System.out.println("6.........Salir");
            System.out.println("");
            Scanner sc= new Scanner(System.in);
            op=sc.nextInt();
            switch(op){
                case 1:{
                    Menu2();
                       
                          
                }break;  
                case 2:{
                    Ejecutar();
                    
                 }break; 
                case 3:{
                    String total="";
                    String fin="\n}";
                    String cab="digraph G { "+"\n node [shape=box];\n";
                    String Gcliente=LClientes.Grafica();
                    String Gventanilla=LVentanilla.Grafica();
                    String Gimpresora=LVentanilla.GraficarImpresora();
                    total=cab+"\n"+Gcliente+"\n"+Gventanilla+"\n"+Gimpresora+"\n"+fin;
                    
                    try{
                        Crear("file.dot",total);
                        ProcessBuilder pb;
                        pb=new ProcessBuilder("dot","-Tpng","-o","list.png","file.dot");
                        pb.redirectErrorStream(true);
                        pb.start();
            
                    }catch(Exception e){
                         e.printStackTrace();
                    }
                    System.out.println("Ventanilla\n");
                    LVentanilla.Mostrar();
                    System.out.println("\nimpresora color\n");
                    LVentanilla.color.Mostrar();
                    System.out.println("\nimpresora byn\n");
                    LVentanilla.byn.Mostrar();
                    System.out.println("\nlista espera\n");
                    LVentanilla.esperaClientes.Mostrar();
                    
                    
                    
                    
                }break; 
                
                case 4:{
                    LClientes.Mostrar();
                    
                    
                }break; 
                
                case 5:{
                    System.out.println("201801106 Luis David Juarez Reyes");
                    
                    
                }break; 
            }
        }
    }
    
    
    
    
        
 }
    

