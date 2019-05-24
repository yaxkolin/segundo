/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn2afd;
import java.io.*;
/**
 *
 * @author escom
 */

public class AFN2AFD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       String path=null;
       String SimEnt,EdoFin,renglon;
       int NumEdo;
       AutoFinitoN A1;
       
   try {  
       
          path = new java.io.File(".").getCanonicalPath(); 
          //System.out.println(path);
       
       } catch (IOException e) {
              e.printStackTrace();
       }
       
       File file = new File(path+"\\"+"A1.txt");

       FileReader fileR = null;
       BufferedReader file2 = null;
       String lines=null;
     try {
           fileR = new FileReader(file);
           file2 = new BufferedReader(fileR);
           

    } catch (FileNotFoundException e) {
        System.out.println("No se encontro el archivo "+file.getName());
    }

    try {
        //Leer el Archivo crear e inicializar el Automata finito No Determinista
        NumEdo = Integer.parseInt(file2.readLine());
        SimEnt = file2.readLine();
        EdoFin = file2.readLine();
        A1=new AutoFinitoN(NumEdo,SimEnt,EdoFin);
        
        for (int i=0; i< NumEdo;i++){
                  renglon=file2.readLine();
                  A1.setRenglon(renglon);    
        }
       //Convertir AFN->AFD 
       AutoFinitoD AFD=A1.Convertir();
       System.out.println(AFD);
              
       if ( AFD.Aceptar("una cadena xxxxx"))
       // le estoy agregando     
           System.out.println("La cadena se Acepto");
       else
           System.out.println("La cadena NO se Acepto");
       
  } catch (IOException e) {
    e.printStackTrace();
  }
    
    
    }
    
}
