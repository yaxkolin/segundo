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
public class AutoFinitoN extends autoFinito {
    
     private String TablaTran [][];
     public AutoFinitoN ( int edos, String sim, String finales ){
                super(edos,sim,finales);
                TablaTran = new String [NumEdos][NumSim+1];
     }
             
     public void setRenglon (String R)        
     {  
           if(tope >= 0 && tope< NumEdos && R!= null )
           {
              StringTokenizer ST= new StringTokenizer(R); 
              
              for (int i=0; i<= NumSim;i++){
                
                    TablaTran[tope][i]=ST.nextToken();
                }          
              tope++;
           }       
     }   
    
    public AutoFinitoD Convertir (   ){
           ArrayList < String > Edos = new ArrayList <String>();
           ArrayList < String [] > Tran = new ArrayList <String []>();
           String edo,edosfin="";
           Edos.add(C_E("0"));
           String [] Renglon;
           int Ind=0,nume;
           do{ 
               edo=Edos.get(Ind);
               Renglon= new String [NumSim];
               for(int i=0;i<NumSim;i++){
                   Renglon[i]= C_E(Mover(edo,i));
                   if( !Edos.contains(Renglon[i]) )
                       Edos.add(Renglon[i]);
               }
               Tran.add(Renglon);
               Ind++;    
           }while(Edos.size()!= Tran.size());
    
        // Ver que estados son finales
        nume =(EdosFinales.length()+1)/2;
                    
        StringTokenizer ST=new StringTokenizer (EdosFinales, ",");
                    
        for (int i=0;i<nume;i++){
                 edo=ST.nextToken(); 
                 for(String Ed : Edos)
                 {
                       if(Ed.contains(edo)){    
                           if (edosfin.equals(""))
                               edosfin += Edos.lastIndexOf(Ed); 
                           else
                               edosfin += ","+Edos.lastIndexOf(Ed);
                       }
                     
                 }
        }
        edosfin=quitarRep(edosfin);
        
        AutoFinitoD Conv = new AutoFinitoD(Edos.size(),SimEnt,edosfin);
        String [] T;                                             
        for (int j=0;j<Edos.size();j++)
        {   T=Tran.get(j);
            for(int i=0;i<NumSim;i++){
                  Ind=Edos.indexOf(T[i]);
                  Conv.setTran(j,i,Ind);
            }
        }
        return Conv;
    }   
    
    public String C_E (String Edo){
       
        String EdosAlcan=new String(Edo);
        int nume=(Edo.length()+1)/2;
        int edo;        
        if (Edo == null || Edo.equals("Lambda"))
            return Edo;              
        StringTokenizer ST=new StringTokenizer (Edo, ",");
                    
        for (int i=0;i<nume;i++){
                 edo = Integer.parseInt(ST.nextToken()); 
                 if( edo>=0&&edo<NumEdos && !TablaTran[edo][NumSim].equals("-")) 
                        EdosAlcan+=","+TablaTran[edo][NumSim];     
             }
        
        return quitarRep(EdosAlcan); 
    }
    
    public String Mover(String Edo,int ind_Sim){
        String EdosAlcan="";
        int nume=(Edo.length()+1)/2;
        int edo;        
        if (Edo == null||Edo.equals("Lambda"))
            return Edo;
        if (ind_Sim >= 0 && ind_Sim < NumSim){
              
             StringTokenizer ST=new StringTokenizer (Edo, ",");
                    
             for (int i=0;i<nume;i++){
                 edo = Integer.parseInt(ST.nextToken()); 
                 if(edo>=0&&edo<NumEdos&&!TablaTran[edo][ind_Sim].equals("-")) 
                        EdosAlcan+=","+TablaTran[edo][ind_Sim];         
             }
        }else 
            return null;
        if (EdosAlcan.equals(""))
            return "Lambda";
        return quitarRep(EdosAlcan); 
    }
    public String quitarRep ( String Edo ){
        ArrayList <Integer> edosalc  = new ArrayList <Integer>();  
        int NE=(Edo.length()+1)/2;
        int edo;
        String EdosAlcan;
        
        StringTokenizer ST=new StringTokenizer (Edo, ",");
        for (int i=0;i<NE;i++){
            edo=Integer.parseInt(ST.nextToken());
            if( !edosalc.contains(edo) )
                 edosalc.add(edo);
        }
        
        Collections.sort(edosalc);
        
        NE=edosalc.size();
        EdosAlcan="";
        EdosAlcan+=edosalc.get(0);    
	for (int i=1;i<NE;i++)
               EdosAlcan+=","+edosalc.get(i);
                    
        return EdosAlcan;
    }
     @Override
    public String toString (){
           String S= "\n\n Numero de Estados: "+NumEdos+"\n"+"Simbolos de entrada: "+ SimEnt + "\n" + "estados Finales : " + EdosFinales + "\n\n";
           
           for (int j=0;j<NumEdos;j++){
               for (int i=0; i<= NumSim;i++)
                  S+= TablaTran[j][i]+" ";
               S+="\n";      
             }   
           
           return S;      
    } 
}
