
package edd_fase2;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Matriz {
    public Cabecera CFilas=new Cabecera(null);
    public Cabecera CColumnas=new Cabecera(null);
    
    public void Matriz(){
    
        
    }
    
    public void append( int fila, int columna, String dato){
        Nodo nuevo=new Nodo(fila,columna,dato);
        nCabecera CFila = this.CFilas.getCabecera(fila);
        if (CFila == null){
            CFila = new nCabecera(fila);
            CFila.accesoNodo = nuevo;
            this.CFilas.appendCabecera(CFila);
        }
        else{
            if (nuevo.columna <  CFila.accesoNodo.columna){
                nuevo.derecha = CFila.accesoNodo;
                CFila.accesoNodo.izquierda = nuevo;
                CFila.accesoNodo = nuevo;
            }
            else{
                Nodo actual = CFila.accesoNodo;
                while (actual.derecha != null){
                    if (nuevo.columna < actual.derecha.columna){
                        nuevo.derecha = actual.derecha;
                        actual.derecha.izquierda = nuevo;
                        nuevo.izquierda = actual;
                        actual.derecha = nuevo;
                        break;
                    } 
                    actual = actual.derecha;
                    
                }
                
                if (actual.derecha == null){
                    actual.derecha = nuevo;
                    nuevo.izquierda = actual;
                }
            }
        }
        nCabecera CColumna = this.CColumnas.getCabecera(columna);
        if (CColumna == null){
            CColumna = new nCabecera(columna);
            CColumna.accesoNodo = nuevo;
            this.CColumnas.appendCabecera(CColumna);
        }
        else{
            if (nuevo.fila <  CColumna.accesoNodo.fila){
                nuevo.abajo = CColumna.accesoNodo;
                CColumna.accesoNodo.arriba = nuevo;
                CColumna.accesoNodo = nuevo;
            }
            else{
                Nodo actual = CColumna.accesoNodo;
                while (actual.abajo != null){
                    if (nuevo.fila < actual.abajo.fila){
                        nuevo.abajo = actual.abajo;
                        actual.abajo.arriba = nuevo;
                        nuevo.arriba = actual;
                        actual.abajo = nuevo;
                        break;
                    }
                    actual = actual.abajo;
                }
                
                if (actual.abajo == null){
                    actual.abajo = nuevo;
                    nuevo.arriba = actual;
                }
            }
        }
    }
    
    boolean verificarExiste( int ff, int cc){
        boolean encontrado=false;
        nCabecera CFila = this.CFilas.primero;
        while (CFila != null){
            Nodo actual = CFila.accesoNodo;
            int f=actual.fila;
            while (actual !=null){
                int c=actual.columna;
                if ((c==cc) && ( f==ff)){
                    encontrado=true;
                }
                actual = actual.derecha;
            }
            CFila = CFila.siguiente;
        }
        return encontrado;
    }
    
    public void Actualizar(int ff, int cc,String dato){
        nCabecera CFila = this.CFilas.primero;
        while (CFila != null){
            Nodo actual = CFila.accesoNodo;
            int f=actual.fila;
            while (actual != null){
                int c=actual.columna;
                if ((c==cc) && ( f==ff)){ 
                    actual.dato=dato;
                }
                actual = actual.derecha;
            }
            CFila = CFila.siguiente;
        }
    }
    
    public void  Graficar_Nodo(){
        int controlx=0;
        nCabecera CFila,CColumna;
        CFila = this.CFilas.primero;
        String resultado="";
        int fanterior=0;
        
        
        
        // agrafica=open("Grafica.dot","w")
        resultado += "digraph G {\n";
        resultado +="node[styles=\"filled\" , shape=\"box\"]\n";

        //______________columnas de Y ___________________________________________
        CColumna = this.CColumnas.primero;
        String nombrey="Y0";
        String n2=nombrey+"[label=\"Inicio\" ,group=0]\n";
        resultado += n2;
        while (CColumna != null){
            Nodo actual = CColumna.accesoNodo;
            String nny="Y"+actual.columna;
            String label="\"Y=" + actual.columna+"\"" ;
            String nodoy=nny+ "[label="+label+",group=0]";
            resultado += nodoy+"\n";
            resultado += nombrey+"->"+nny+"\n";
            resultado += nny+"->"+nombrey+"\n";

            nombrey=nny;
            
            CColumna = CColumna.siguiente;
        }
        // ____________________________________________________
        
        while (CFila != null){
            
            Nodo actual = CFila.accesoNodo;
            String m="X="+actual.fila;
            controlx=controlx+1;
            int nfila=actual.fila;
            String nombrex="X"+actual.fila;
            String m2=nombrex+"[label=\""+m+"\",group="+ controlx +"]\n";
            resultado += m2;    
            while (actual != null){
                String nombrenodo="nodo"+actual.fila+actual.columna;
                String y="\"" +actual.dato+"\"";
                String nodo=nombrenodo+"[label=\"\""+",group="+ controlx+ ",style=\"filled\", color="+ y+ ", fillcolor="+y +"]";
                resultado += nodo+"\n";
                resultado += nombrex+"->"+nombrenodo+"\n";
                resultado+=nombrenodo+"->"+nombrex+"\n";

                nombrex=nombrenodo;
                
                actual = actual.derecha;
            }
            if (controlx >1){
                resultado +="X"+fanterior+"->" + "X"+nfila+"\n";
                resultado += "X"+nfila+"->" + "X"+fanterior+"\n";
                resultado +="{rank=\"same\";"+"X"+fanterior+";"+"X"+nfila+"}\n";
                fanterior=nfila;
            }
            else if (controlx==1){
                resultado += "Y0"+"->" + "X"+nfila+"\n";
                resultado+= "X"+nfila +"->" + "Y0\n";
                resultado+="{rank=\"same\";"+"Y0"+";"+"X"+nfila +";}\n";
                fanterior=nfila;
            }
                

            CFila = CFila.siguiente;
        }
        
        //_________________unidendo_nodos_en_Y_________________
        CColumna = this.CColumnas.primero;
        while (CColumna != null){
            Nodo actual = CColumna.accesoNodo;
            String ncolumna="Y"+actual.columna;
            String rank=ncolumna+";";
            while (actual != null){
                String nf="nodo"+actual.fila+actual.columna;
                resultado+= ncolumna+"->"+nf+"\n";
                resultado+=nf+"->"+ncolumna+"\n";
                rank=rank+nf+";";
                ncolumna=nf;
                actual = actual.abajo;
            }
            
            resultado+="{rank=\"same\";"+rank+"}\n";

            CColumna = CColumna.siguiente;
        }
        //___________________________________________________
        resultado+="}";
        
        FileWriter fw=null;
        PrintWriter pw=null;
        try{
            fw=new FileWriter("Grafica.dot");
            pw=new PrintWriter(fw);
            pw.write(resultado);
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
            pb=new ProcessBuilder("dot","-Tpng","-o","matriz.png","Grafica.dot");
            pb.redirectErrorStream(true);
            pb.start(); 
        }catch(Exception e){
         e.printStackTrace();
        }
        
        
    
    }

    
}
