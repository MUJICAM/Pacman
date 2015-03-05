/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto3;

/**
 *
 * @author MujicaM
 */
public class Casilla {
    private boolean muro,calle,caPts,caFruti;
//constructor c/p
    public Casilla(boolean muro, boolean calle, boolean caPts, boolean caFruti) {
        this.muro = muro;
        this.calle = calle;
        this.caPts = caPts;
        this.caFruti = caFruti;
    }
//Metodos    
  //sets

   public void setMuro(boolean muro) {
        this.muro = muro;
    } 
   public void setCalle(boolean calle) {
        this.calle = calle;
    }  
   public void setCaPts(boolean caPts) {
        this.caPts = caPts;
    } 
   public void setCaFruti(boolean caFruti) {
        this.caFruti = caFruti;
    }     
    
  //gets
    public boolean GetMuro() {
        return muro;
     }
    public boolean GetCalle() {
        return calle;
     }
    public boolean GetCaPts() {
        return caPts;
     }
    public boolean GetCaFruti() {
        return caFruti;
     }


    
}
