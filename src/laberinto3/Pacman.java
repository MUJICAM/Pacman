
package laberinto3;

/**
 *
 * @author MujicaM
 */
public class Pacman extends Personaje{
   private int vida;
   private int puntos; 

    public Pacman(int vida, int puntos, String color, String nombre, int velocidad, boolean estado) {
        super(color, nombre, velocidad, estado);
        this.vida = vida;
        this.puntos = puntos;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida -= vida;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }  
}
