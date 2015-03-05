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
public class Personaje {
    private String color;
    private String nombre;
    private int velocidad;
    private boolean estado;

    public Personaje(String color, String nombre, int velocidad, boolean estado) {
        this.color = color;
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
