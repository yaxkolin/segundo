/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn2afd;

import java.util.*;

/**
 *
 * @author escom
 */
public class AutoFinitoD extends autoFinito {
     private int TablaTran [][];
     public AutoFinitoD ( int edos, String sim, String finales ){
                super(edos,sim,finales);
                TablaTran = new int [NumEdos][NumSim];
     }
     public void setRenglon (String R)        
     {  
           if(tope >= 0 && tope< NumEdos && R!= null )
           {
              StringTokenizer ST= new StringTokenizer(R); 
              
              for (int i=0; i< NumSim;i++){
                
                    TablaTran[tope][i]=Integer.parseInt(ST.nextToken());
                }          
              tope++;
           }       
     }   
   public void setTran (int f, int c,int edo){
      if (f >= 0 && f < NumEdos && c >= 0 && c < NumSim )
           TablaTran[f][c]=edo;
   }         
   public int ir_a (int edo, String sim){
       
       if(sim==null||sim.equals(""))
           return -1;
       int Pos=SimEnt.indexOf(sim);
       if(Pos==-1)
          return -1;
       Pos/=2;    
       if ( edo >= 0 && edo < NumEdos && Pos >= 0 && Pos < NumSim )
           return TablaTran[edo][Pos];
       return -1;
   }         
   public boolean Aceptar(String Cad){
       String Caracter; 
       int edoactual=0;
       if (Cad==null||Cad.equals(""))
             return false;    
       for(int i=0;i<Cad.length();i++){
            Caracter=Cad.substring(i,i+1);
            edoactual=ir_a(edoactual,Caracter);
            if (edoactual==-1){
                return false;
            }    
       }
      return EdosFinales.indexOf(edoactual+"")>=0;  
   }
     @Override
   public String toString (){
           String S= "\n\n Numero de Estados: "+NumEdos+"\n"+"Simbolos de entrada: "+ SimEnt + "\n" + "estados Finales : " + EdosFinales + "\n\n";
           
           for (int j=0;j<NumEdos;j++){
               for (int i=0; i< NumSim;i++){
                   S+= TablaTran[j][i]+" ";
               }
               S+="\n";      
             }   
           
           return S;      
    } 
}
