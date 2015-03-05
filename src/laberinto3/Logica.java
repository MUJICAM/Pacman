package laberinto3;

/**
 *
 * @author MujicaM
 */
public class Logica {

    private Casilla mu = new Casilla(true, false, false, false);//muro=true los demas false
    private Casilla ca = new Casilla(false, true, false, false);//calle=true lo demas false
    private Casilla cp = new Casilla(false, false, true, false);//calle y punto= true lo demas false
    private Casilla cc = new Casilla(false, false, false, true);//calle y fruta=true lo demas false
    
    private Pacman pa = new Pacman(3, 0, "amarillo", "Muji", 3, false);
    
    private Fantasma f1= new Fantasma("rojo","blinky",2,true);//Blinky
    private Fantasma f2= new Fantasma("rosa","pinky",2,true);//Pinky
    private Fantasma f3= new Fantasma("cyan","Inky",2,true);//Inky
    private Fantasma f4= new Fantasma("naranja","clyde",2,true);//Clyde
    
    private Object m[][] = {//Matriz de objetos muro y calle //m[][] es una variable de tipo Object       
        {mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu},
        {mu, cc, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, mu, mu, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cc, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, cp, cp, cp, cp, cp, mu, mu, cp, cp, cp, cp, cp, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, ca, ca, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, ca, ca, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cc, cp, cp, cp, cp, cp, cp, cp, cp, mu, mu, ca, ca, ca, ca, ca, ca, mu, mu, cp, cp, cp, cp, cp, cp, cp, cp, cc, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, cp, cp, cp, cp, cp, cp, cp, mu, mu, cp, cp, cp, cp, cp, cp, cp, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, cp, cp, cp, cp, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, cp, cp, cp, cp, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, mu, mu, mu, mu, cp, mu},
        {mu, cp, cp, cp, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, cp, cp, cp, mu},
        {mu, mu, mu, cp, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, cp, mu, mu, mu},
        {mu, cp, cp, cp, cp, cp, cp, mu, mu, cp, cp, cp, cp, cp, mu, mu, cp, cp, cp, cp, cp, mu, mu, cp, cp, cp, cp, cp, cp, mu},
        {mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu},
        {mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu, mu, cp, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, cp, mu},
        {mu, ca, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, cp, mu},
        {mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu, mu},};
//metodos de casilla
    //Getss

    public Casilla getMu() {
        return mu;
    }

    public void setMu(Casilla mu) {
        this.mu = mu;
    }

    public Casilla getCa() {
        return ca;
    }

    public Casilla getCc() {
        return cc;
    }

    //Sets
    public void setCa(Casilla ca) {
        this.ca = ca;
    }

    public Casilla getCp() {
        return cp;
    }

    public void setCp(Casilla cp) {
        this.cp = cp;
    }

    public void setCc(Casilla cc) {
        this.cc = cc;
    }
//metodos De la matriz de objetos
    //Gets

    public Object[][] getM() {
        return m;
    }

    //Sets

    public void setM(Object[][] m) {
        this.m = m;
    }
//Metodos de Pacaman
    //Gets

    public Pacman getPa() {
        return pa;
    }

    //Sets

    public void setPa(Pacman pa) {
        this.pa = pa;
    }

    //sumar puntos

    public void sumaPuntos(int puntos) {
        pa.setPuntos(puntos);
    }

    public int puntos() {//muestra los puntos
        return pa.getPuntos();
    }
   //restar vidas
  public void restarVidas(int vida){
      pa.setVida(vida);
  }
 public int vidas(){//muestra vidas
     return pa.getVida();
 } 
//Metodos de fantasmas
    //get y set de BLINKY
    public Fantasma getF1() {
        return f1;
    }
    public void setF1(Fantasma f1) {
        this.f1 = f1;
    }
    public Fantasma getF2() {
        return f2;
    }
   //get y set de PINKY
    public void setF2(Fantasma f2) {
        this.f2 = f2;
    }
  //get y set de INKY
    public Fantasma getF3() {
        return f3;
    }
    public void setF3(Fantasma f3) {
        this.f3 = f3;
    }
//get y set de CLYDE
    public Fantasma getF4() {
        return f4;
    }
    public void setF4(Fantasma f4) {
        this.f4 = f4;
    }

//metodo
    //esta metodo sirve para retornar la cadena para imprimir el tablero
    public String CodigoImagen(int i, int j) {
        String retorno = "Aqui Se retorna el nombre de la imagen";
        if (m[i][j] == mu)//muro
        {
            retorno = "mu";
        }
        if (m[i][j] == ca)//calle 
        {
            retorno = "ca";
        }
        if (m[i][j] == cp) {//calle y punto
            retorno = "cp";
        }
        if (m[i][j] == cc) {//fruta y calle
            retorno = "cc";
        }
        if (m[i][j] == pa) {//Pacman 1
            retorno = "pa";
        }
        if (m[i][j] == f1) {//FANTASMA 1
            retorno = "blinky";
        }
        if (m[i][j] == f2) {//FANTASMA 2
            retorno = "inky";
        } 
        if (m[i][j] == f3) {//FANTASMA 3
            retorno = "pinky";
        } 
        if (m[i][j] == f4) {//FANTASMA 4
            retorno = "clyde";
        }         
        return retorno;
    }
}
