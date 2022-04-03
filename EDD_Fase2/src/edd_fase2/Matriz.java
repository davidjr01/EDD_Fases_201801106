
package edd_fase2;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Matriz {
    public Cabecera CFilas=new Cabecera(null);
    public Cabecera CColumnas=new Cabecera(null);
    String stringGraficar;
    String auxstringGraficar;
    
    public void Matriz(){
        this.stringGraficar = "";
        this.auxstringGraficar = "";
        
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
        String nombrey="INICIO";
        String n2=nombrey+"[label=\"Inicio\" ,group=0]\n";
        resultado += n2;
        String conecciones="";
        while (CColumna != null){
            Nodo actual = CColumna.accesoNodo;
            String nny="Y"+actual.columna;
            String label="\"Y=" + actual.columna+"\"" ;
            String nodoy=nny+ "[label="+label+",group=0"+"]";
            resultado += nodoy+"\n";
            conecciones+=nombrey+"->"+nny+"\n";
           
            nombrey=nny;
            
            CColumna = CColumna.siguiente;
        }
        resultado+="edge[dir=\"both\"];\n";
        resultado+=conecciones;
        resultado+="edge[dir=\"forward\"];\n";
        // ______________________en x______________________________
        String conecciones2="";
        String rankx="";
        String primero="";
        int cprimerox=0;
        String nodosyy="";
        String conecy="";
        String conecy2="";

        while (CFila != null){
            cprimerox+=1;
            Nodo actual = CFila.accesoNodo;
            String m="X="+actual.fila;
            String m22="X"+actual.fila;
            int nfila=actual.fila;
            String nombrex="X"+actual.fila;
            if(cprimerox==1){
                primero="INICIO->"+nombrex +"\n"+nombrex+"->INICIO\n";
            }
            String m2=nombrex+"[label=\""+m+"\",group="+actual.fila +"]\n";
            resultado += m2;  
            if(CFila.siguiente!=null){
                Nodo actual2 = CFila.siguiente.accesoNodo;
                String nx2="X"+actual2.fila;
                conecciones2 += nombrex+"->"+nx2+"\n";  
               // conecciones2 += nx2+"->"+nombrex+"\n"; 
                rankx+=nombrex+";";
            }else if (CFila.siguiente==null){
                rankx+=nombrex;
            }
            int primerony=0;
            while (actual != null){
                primerony+=1;
                
                String nombrenodo="n"+actual.fila+"c"+actual.columna;
                String y="\"" +actual.dato+"\"";
                String nodo=nombrenodo+"[label=\"\""+",group="+ actual.fila+ ",style=\"filled\", color="+ y+ ", fillcolor="+y +"]";
                nodosyy += nodo+"\n";
                nombrex=nombrenodo;
                
                if(primerony==1){
                    conecy+=m22+"->"+nombrenodo+"\n";
                    //conecy+=nombrenodo+"->"+m22+"\n";
                }
                
                if(actual.derecha!=null){
                    conecy+=nombrenodo+"->"+"n"+actual.derecha.fila+"c"+actual.derecha.columna+"\n";
                    //conecy+="n"+actual.derecha.fila+actual.derecha.columna+"->"+nombrenodo+"\n";
                }
          
                
                
                actual = actual.derecha;
            }
            
            
            CFila = CFila.siguiente;
        }
        resultado+=conecciones2;
        resultado+=primero;
        resultado+="{rank=\"same\";INICIO;"+rankx+"}\n" ;
        resultado+=nodosyy + conecy;
        
        
        //_________________unidendo_nodos_en_Y_________________
        CColumna = this.CColumnas.primero;
        while (CColumna != null){
            int primerony=0;
            Nodo actual = CColumna.accesoNodo;
            String ncolumna="Y"+actual.columna;
            String rank=ncolumna+";";
            while (actual != null){
                String nf="n"+actual.fila+"c"+actual.columna;
                resultado+= ncolumna+"->"+nf+"\n";
                //resultado+=nf+"->"+ncolumna+"\n";
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
            fw=new FileWriter("Grafica1.dot");
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
            pb=new ProcessBuilder("dot","-Tpng","-o","matriz1.png","Grafica1.dot");
            pb.redirectErrorStream(true);
            pb.start(); 
        }catch(Exception e){
         e.printStackTrace();
        }
        
        
    
    }
    
     public void  Graficar_Nodo3(String nombress){
        int controlx=0;
        nCabecera CFila,CColumna;
        CFila = this.CFilas.primero;
        String resultado="";
        int fanterior=0;
        
        
        
        // agrafica=open("Grafica.dot","w")
        resultado += "digraph G {\n";
        resultado +="node[shape = box,width=0.7,height=0.7,fillcolor=\"white\" color=\"black\" style=\"filled\"];\n";
        resultado+="edge[style = \"bold\"];\n";
        //resultado+="node[label = inicio fillcolor=\" white\" pos = \"-1,1!\"]INICIO;\n";
        resultado+="INICIO[label=\"INICIO\",group=0]";
        resultado+="rankdir=LR;\n";
        //________________CabeceraX__________________
        
        String conecciones2="";
        String rankx="";
        String primero="";
        int cprimerox=0;
        String nodosyy="";
        String nodosyy2="";
        String conecy="";
        String conecy2="";
        
        String nombrey="INICIO";
        String nodoof="";
       
        while (CFila != null){
            cprimerox+=1;
            Nodo actual = CFila.accesoNodo;
            String m="X="+actual.fila;
            String m22="X"+actual.fila;
            int nfila=actual.fila;
            String nombrex="X"+actual.fila;
            if(cprimerox==1){
                conecciones2+= primero="INICIO->";
            }
            String m2=nombrex+"[label=\""+m+"\",group=0"+"]\n";
            resultado += m2;  
            conecy=m22+",";
            nodosyy=m22+"->";
            if(CFila.siguiente!=null){
                //Nodo actual2 = CFila.siguiente.accesoNodo;
                //String nx2="X"+actual2.fila;
                
                conecciones2 += nombrex+"->";  
                
               // conecciones2 += nx2+"->"+nombrex+"\n"; 
         
            }else if (CFila.siguiente==null){
                conecciones2 += nombrex+"\n";
            }
            int primerony=0;
            while (actual != null){
                primerony+=1;
                
                String nombrenodo="n"+actual.fila+"c"+actual.columna;
                String y="\"" +actual.dato+"\"";
                String nodo=nombrenodo+"[label=\"\""+",group="+ (actual.columna +1 )+ ",style=\"filled\", color="+ y+ ", fillcolor="+y +"]";
                nodoof += nodo+"\n";
                
                nombrex=nombrenodo;
                
                
                if(actual.derecha!=null){
                    
                    conecy+=nombrenodo+",";
                    nodosyy+=nombrenodo+"->";
                }else{
                     conecy+=nombrenodo;
                     nodosyy+=nombrenodo;
                }
          
                
                
                actual = actual.derecha;
            }
            conecy2+="{rank = same;"+conecy+"};"+"\n";
            nodosyy2+=nodosyy+"\n";
            
            CFila = CFila.siguiente;
        }
        resultado+=nodoof;
        resultado+=conecciones2;
        resultado+=conecy2;
        resultado+="edge[ dir=\"both\"]; \n";
        resultado+=nodosyy2;
        resultado+="edge[dir=\"forward\"]; \n";
        
        
        resultado+="\n\n\n";
     
 

        //______________columnas de Y ___________________________________________
        CColumna = this.CColumnas.primero;
        
        String conecciones="";
        String rnky="";
        String rnky2="";
        int primeroy=0;
        while (CColumna != null){
            primeroy+=1;
            Nodo actual = CColumna.accesoNodo;
            String nny="Y"+actual.columna;
            String label="\"Y=" + actual.columna+"\"" ;
            String nodoy=nny+ "[label="+label+",group="+(actual.columna+1)+"]";
            resultado += nodoy+"\n";
            if (primeroy==1){
                conecciones+=nombrey+"->";
                rnky+=nombrey+",";
            }
            if (CColumna.siguiente!=null){
            conecciones+=nny+"->";
            rnky+=nny+",";
            }
            else{
                conecciones+=nny+"\n";
                rnky+=nny;
            }
           
            nombrey=nny;
            
            CColumna = CColumna.siguiente;
        }
        resultado+="{rank = same;"+rnky+"};\n";
        resultado+=conecciones;
        resultado+="edge[ dir=\"both\"]; \n";
        
        
        
        
        
        //_________________unidendo_nodos_en_Y_________________
        CColumna = this.CColumnas.primero;
        while (CColumna != null){
            int primerony=0;
            Nodo actual = CColumna.accesoNodo;
            String ncolumna="Y"+actual.columna;
            String rank=ncolumna+"->";
            while (actual != null){
                String nf="n"+actual.fila+"c"+actual.columna;
                if(actual.abajo!=null){
                   rank+=nf+"->"; 
                }else{
                    rank+=nf;
                }
                
                ncolumna=nf;
                actual = actual.abajo;
            }
            
            resultado+=rank+"\n";

            CColumna = CColumna.siguiente;
        }
        //___________________________________________________
        resultado+="}";
        
        FileWriter fw=null;
        PrintWriter pw=null;
        try{
            fw=new FileWriter(nombress+".dot");
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
            pb=new ProcessBuilder("dot","-Gnslimit=2","-Tpng",nombress+".dot","-o",nombress+".png");
            pb.redirectErrorStream(true);
            pb.start(); 
        }catch(Exception e){
         e.printStackTrace();
        }
        
        
    
    }
    
    
    ///////////////////////////////////////////////////////////////////////
    public void getDataFilas(){
        nCabecera CFila = this.CFilas.primero;
        String idFila = "";
        String conectarIdFilas="";
        String nodosInteriores = "";
        String direccionInteriores = "";
        while (CFila != null){
            boolean Primero=true ;   
            Nodo actual = CFila.accesoNodo;
            idFila+= "\n\t\tF"+(actual.fila)+" [label = \"Y="+ actual.fila + "\"   width = 1 style = filled, fillcolor = \"white\", color=\"black\" penwidth=2.5 group = 1 ];";
            if (CFila.siguiente!= null){
                conectarIdFilas += "\n\t\tF"+(actual.fila)+"-> F"+(CFila.siguiente.accesoNodo.fila)+";";
                // conectarIdFilas += "\n\t\tF"+str(CFila.siguiente.accesoNodo.fila)+" -> F"+str(actual.fila)+";";
             }
            direccionInteriores += "\n\t\t{ rank = same; F"+(actual.fila)+"; ";
            while (actual != null){
                nodosInteriores += "\n\t\tN"+actual.fila+"_L"+actual.columna+" [label = \""+"\" width = 1, style=\"filled, rounded\" fillcolor=\""+actual.dato+"\" color=\" "+actual.dato+"\" penwidth=2 group = "+actual.columna+" ];";
                direccionInteriores += "N"+actual.fila+"_L"+(actual.columna)+"; ";
                // print(str(actual.columna)+"         "+actual.dato)
                if (Primero){
                    nodosInteriores += "\n\t\tF"+actual.fila+"->N"+actual.fila+"_L"+(actual.columna)+";";
                    if (actual.derecha != null){
                        nodosInteriores += "\n\t\tN"+actual.fila+"_L"+actual.columna+ "-> N"+actual.derecha.fila+"_L"+actual.derecha.columna+";";
                        nodosInteriores += "\n\t\tN"+(actual.derecha.fila)+"_L"+(actual.derecha.columna)+ "->N"+(actual.fila)+"_L"+(actual.columna)+";";
                    }    
                    Primero=false;
                }
                else{
                    if (actual.derecha !=null){
                        nodosInteriores += "\n\t\tN"+(actual.fila)+"_L"+(actual.columna)+ "-> N"+(actual.derecha.fila)+"_L"+(actual.derecha.columna)+";";
                        nodosInteriores += "\n\t\tN"+(actual.derecha.fila)+"_L"+(actual.derecha.columna)+ "-> N"+(actual.fila)+"_L"+(actual.columna)+";";
                    }   
                }
                actual = actual.derecha;
            }
            CFila = CFila.siguiente;
            direccionInteriores += "}";
        }
        this.stringGraficar+=idFila;
        this.stringGraficar += "\n\t\tedge[dir=\"both\"];";
        this.stringGraficar+=conectarIdFilas;
        this.stringGraficar += "\n\t\tedge[dir=\"forward\"];";
      
        this.getDataColumnas();
        this.stringGraficar+=nodosInteriores;
        this.stringGraficar+=direccionInteriores;
        }

    public void  getDataColumnas(){
        nCabecera CColumna = this.CColumnas.primero;
        long primeroC = this.CColumnas.primero.accesoNodo.columna;
        long primeroF = this.CFilas.primero.accesoNodo.fila;
        String idColumna = "";
        String conectarIdColumnas = "";
        String direccion = "\n\t\t{ rank = same; Head;";
        while (CColumna != null){
            boolean primero = true;
            Nodo actual = CColumna.accesoNodo;
            idColumna += "\n\t\tC"+(actual.columna)+" [label = \"X="+actual.columna +"\"   width = 1 style = filled, fillcolor = \"white\", color=\"black\" penwidth=2.5 group = "+(actual.columna)+" ];";
            direccion += "C"+(actual.columna)+"; ";
            if (CColumna.siguiente !=null){
                conectarIdColumnas += "\n\t\tC"+(actual.columna)+"-> C"+(CColumna.siguiente.accesoNodo.columna)+";";
                conectarIdColumnas += "\n\t\tC"+(CColumna.siguiente.accesoNodo.columna)+" -> C"+(actual.columna)+";";
            }
            while (actual != null){
                // print(str(actual.fila)+"      "+actual.dato)
                if (primero){
                    this.auxstringGraficar+= "\n\t\tC"+(actual.columna)+"-> N"+(actual.fila)+"_L"+(actual.columna)+";";
                    if (actual.abajo != null){
                        this.auxstringGraficar += "\n\t\tN"+(actual.fila)+"_L"+(actual.columna)+ "-> N"+(actual.abajo.fila)+"_L"+(actual.abajo.columna)+";";
                        this.auxstringGraficar += "\n\t\tN"+(actual.abajo.fila)+"_L"+(actual.abajo.columna)+ "-> N"+(actual.fila)+"_L"+(actual.columna)+";";
                    }
                    primero=false;
                }
                else{
                    if (actual.abajo !=null){
                        this.auxstringGraficar += "\n\t\tN"+(actual.fila)+"_L"+(actual.columna)+ "-> N"+(actual.abajo.fila)+"_L"+(actual.abajo.columna)+";";
                        this.auxstringGraficar += "\n\t\tN"+(actual.abajo.fila)+"_L"+(actual.abajo.columna)+ "-> N"+(actual.fila)+"_L"+(actual.columna)+";";
                    }
                }
                actual = actual.abajo;
            }
            CColumna = CColumna.siguiente;
        }
        this.stringGraficar+=idColumna;
        this.stringGraficar+=conectarIdColumnas;
        this.stringGraficar+="\n\t\tHead -> F"+(primeroF)+"; \n\t\tHead -> C"+(primeroC)+";";
        this.stringGraficar+=direccion+"}";
              
    
    }
    //////////////////
    public void Graficar_Nodo2(){
        this.auxstringGraficar="";
        this.stringGraficar="digraph G {\nnode [shape=box, height=0.8];\n";
        this.stringGraficar+="Head[ label = \"Matriz\", width = 1, style = \"filled, rounded\" fillcolor = \"#ff6b6b\", color=\"#c23616\" group = 1 penwidth=2.5];";
        this.getDataFilas();
        this.stringGraficar+=this.auxstringGraficar;
        this.stringGraficar+="\n}";
        
        FileWriter fw=null;
        PrintWriter pw=null;
        try{
            fw=new FileWriter("Grafica.dot");
            pw=new PrintWriter(fw);
            pw.write(this.stringGraficar);
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
