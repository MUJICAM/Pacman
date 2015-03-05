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
public class Fantasma extends Personaje{

    public Fantasma(String color, String nombre, int velocidad, boolean estado) {
        super(color, nombre, velocidad, estado);
    }

    @Override
    public void setEstado(boolean estado) {
        super.setEstado(estado); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getEstado() {
        return super.getEstado(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVelocidad(int velocidad) {
        super.setVelocidad(velocidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getVelocidad() {
        return super.getVelocidad(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(String color) {
        super.setColor(color); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColor() {
        return super.getColor(); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
