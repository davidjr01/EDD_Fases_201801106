
package edd_fase2;

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

public class EDD_Fase2 {
    public static Matriz m =new Matriz();
    
    public static void CargaCapas(String nombreD){
        JSONParser parser = new JSONParser();
        
        try{
             Object obj = parser.parse(new FileReader(nombreD));
             JSONArray array = (JSONArray) obj;   
             for (int i=0;i<array.size();i++){
                 JSONObject jsonO = (JSONObject) array.get(i);
                 System.out.println("capa : " + jsonO.get("id_capa")+"--------------------------------");
                 JSONArray pixeles = (JSONArray) jsonO.get("pixeles");
                 for (int j=0;j<pixeles.size();j++){
                     JSONObject pixel2 = (JSONObject) pixeles.get(j);
                     int filaa=Integer.parseInt(pixel2.get("fila").toString());
                     int columnaa=Integer.parseInt(pixel2.get("columna").toString());
                     String datoo=pixel2.get("color").toString();
                     if( m.verificarExiste(columnaa,filaa)){
                       m.Actualizar(columnaa, filaa, datoo);
                       }
                     else{
                     m.append(columnaa,filaa, datoo);
                     }
                     System.out.println("fila:" + pixel2.get("fila"));
                     System.out.println("columna:" + pixel2.get("columna"));
                     System.out.println("color:" + pixel2.get("color"));
                     
                 }
                 
                 
             }
             
    
            System.out.println("Lectura con exito ");
            
        }catch(FileNotFoundException e){
            System.out.println("No se encontro el documento");}
        catch(IOException e){}
        catch(ParseException e){}
        
        
    }
    
    public static void CargaImagenes(String nombreD){
        
        JSONParser parser = new JSONParser();
        
        try{
             Object obj = parser.parse(new FileReader(nombreD));
             JSONArray array = (JSONArray) obj;   
             for (int i=0;i<array.size();i++){
                 JSONObject jsonO = (JSONObject) array.get(i);
                 System.out.println("Id Imagen : " + jsonO.get("id")+"--------------------------------");
                 JSONArray capas = (JSONArray) jsonO.get("capas");
                 for (int j = 0; j < capas.size(); j++) {
                     String x=capas.get(j).toString();
                     int y=Integer.parseInt(x);
                     System.out.println(y);
                     
                     
                 }
                 
                 
             }
             
             
             
    
            System.out.println("Lectura con exito ");
            
        }catch(FileNotFoundException e){
            System.out.println("No se encontro el documento");}
        catch(IOException e){}
        catch(ParseException e){}
        
    }

    
    public static void main(String[] args) {
        
    }
    
}
