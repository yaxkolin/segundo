/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn2afd;

/**
 *
 * @author escom
 */
public class autoFinito {
        
     protected int NumEdos;
     protected String SimEnt;
     protected String EdosFinales;
     protected int NumSim;
     protected int tope;
     
     public autoFinito ( int edos, String sim, String finales ){
                NumEdos=edos;
                SimEnt=sim;
                EdosFinales=finales;
                NumSim=(sim.length()+1)/2;
                tope=0;
     }
}
