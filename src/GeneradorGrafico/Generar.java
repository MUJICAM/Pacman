
package GeneradorGrafico;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.KeyEventDispatcher;
import javax.swing.JFrame;
import javax.swing.JLabel;
import laberinto3.*;
import java.util.Random;

/**
 *
 * @author MujicaM
 */
public class Generar extends JFrame {

    private Logica LaberintoVirtual = new Logica();//se llama al constructor predefinido
    private JLabel grafico[][] = new JLabel[30][30];
    private JButton boton;
    private int x = 650, y = 3;//para el boton iniciar juego
    private int i = 1, j = 28;//para las posiciones del pacman
    private int f1_i = 14, f1_j = 13;//para las posiciones del fantasma 1

    public Generar() {
        JDesktopPane p = new JDesktopPane();
        setTitle("..::PACMAN::..");

        boton = new JButton("Iniciar Juego");
        p.add(boton);
        boton.setBounds(x, y, 103, 15);
        boton.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 650);
        setVisible(true);

        LaberintoVirtual.getM()[28][1] = LaberintoVirtual.getPa();
        LaberintoVirtual.getM()[f1_i][f1_j] = LaberintoVirtual.getF1();//se agrega el fantasma 1 en la matriz
        //Genera el laberinto grafico a partir del Laberinto virtual
        GenerardorGrafico();
         accion(i, j);
//        int k=0;
//        while(k<20){
//         moverFantasma1();
//         k++;
//        }
        
    }
//Generar Laberinto
    public void GenerardorGrafico() {
        //Aqui reubicamos el tablero ya que se encuentra invertida originalmente**********************************************************************   
        Object aux[][] = new Object[30][30];//Matriz auxliar para ordenar bn el tablero
        try {
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {
                    aux[i][j] = LaberintoVirtual.getM()[j][i];
                }
            }
        } catch (Exception e) {
            System.out.println("aqui esta el error en el for 1");
        }

        try {
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {
                    LaberintoVirtual.getM()[i][j] = aux[i][j];
                }
            }
        } catch (Exception e) {
            System.out.println("aqui esta el error en el for 2");
        }

        //fin la reubicacion**************************************************************  
        //PINTA 
        try {
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {
                    grafico[i][j] = new JLabel();
                    add(grafico[i][j]);
                    if (LaberintoVirtual.getM()[i][j] == LaberintoVirtual.getMu()) {//si es muro
                        grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
                    }
                    if (LaberintoVirtual.getM()[i][j] == LaberintoVirtual.getCc()) {//si es fruta
                        grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
                    }
                    if (LaberintoVirtual.getM()[i][j] == LaberintoVirtual.getCa()) {//si es calle
                        grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
                    }
                    if (LaberintoVirtual.getM()[i][j] == LaberintoVirtual.getCp()) {//si es calle y punto
                        grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
                    }
                    if (LaberintoVirtual.getM()[i][j] == LaberintoVirtual.getPa()) {//si es pacman
                        grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
                    }
                    if (LaberintoVirtual.getM()[i][j] == LaberintoVirtual.getF1()) {//si es Fantasma1
                        grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Fantasma/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("adentro del for 3 esta el error");
        }

        try {
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {
                    grafico[i][j].setBounds(i * 20, j * 20, 20, 20);
                    grafico[i][j].validate();
                }
            }
        } catch (Exception e) {
            System.out.println("adentro del for 4 esta el error");
        }
    }

// metodo para sleep
public void Retraso() throws InterruptedException{
    Thread.sleep(1000);
}  
////Mover pacman original
//    public void MoverPacman(KeyEvent evento) throws InterruptedException {
//      switch (evento.getKeyCode()) {  
//        case KeyEvent.VK_UP :{//mover a arriba 
//            if (LaberintoVirtual.getM()[i][j - 1] != LaberintoVirtual.getMu()) {
//                if ((LaberintoVirtual.getM()[i][j - 1] == LaberintoVirtual.getCp())) {//valida q si hay un punto lo sumara a pacman
//                    LaberintoVirtual.sumaPuntos(1);//agregamos el punto
//                    System.out.println("Puntos= " + LaberintoVirtual.puntos());//mostramos el punto
//
//                } //fin de validar puntos
//                //en el if de abajo verificamos que no se encuentre un fantasma si lo hay se le quitara una vida al pacman y regresara a su posicion original
//                if (LaberintoVirtual.getM()[i][j - 1] == LaberintoVirtual.getF1() || LaberintoVirtual.getM()[i][j - 1] == LaberintoVirtual.getF2() || LaberintoVirtual.getM()[i][j - 1] == LaberintoVirtual.getF3() || LaberintoVirtual.getM()[i][j - 1] == LaberintoVirtual.getF4()) {
//                    LaberintoVirtual.restarVidas(1);
//                    System.out.println("Vidas= " + LaberintoVirtual.vidas());
//
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getCa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//
//                    i = 1;
//                    j = 28;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();//posicion inicial
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//                }
//                j -= 1;
//                LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();//iguala al pacman a la siguiente posision
//                grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Pacman/paRRIBA.jpg")));
//
//                LaberintoVirtual.getM()[i][j + 1] = LaberintoVirtual.getCa();
//                grafico[i][j + 1].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j + 1) + ".jpg")));
//                //break;
//            } else {
//                System.out.println("Hay muro no se mueve");
//            }
//             break;
//        }
//
//        case KeyEvent.VK_DOWN: {
//            //mover a abajo
//            if (LaberintoVirtual.getM()[i][j + 1] != LaberintoVirtual.getMu()) {
//
//                if ((LaberintoVirtual.getM()[i][j + 1] == LaberintoVirtual.getCp())) {
//                    LaberintoVirtual.sumaPuntos(1);//suma puntos
//                    System.out.println("Puntos= " + LaberintoVirtual.puntos());//muestra los puntos
//                }
//                //en el if de abajo verificamos que no se encuentre un fantasma si lo hay se le quitara una vida al pacman y regresara a su posicion original
//                if (LaberintoVirtual.getM()[i][j + 1] == LaberintoVirtual.getF1() || LaberintoVirtual.getM()[i][j + 1] == LaberintoVirtual.getF2() || LaberintoVirtual.getM()[i][j + 1] == LaberintoVirtual.getF3() || LaberintoVirtual.getM()[i][j + 1] == LaberintoVirtual.getF4()) {
//                    LaberintoVirtual.restarVidas(1);
//                    System.out.println("Vidas= " + LaberintoVirtual.vidas());
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getCa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//
//                    i = 1;
//                    j = 28;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();//posicion inicial
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//                } else {
//                    j += 1;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Pacman/paBAJO.jpg")));
//
//                    LaberintoVirtual.getM()[i][j - 1] = LaberintoVirtual.getCa();
//                    grafico[i][j - 1].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j - 1) + ".jpg")));
//                    break;
//                }
//            } else {
//                System.out.println("Hay muro no se mueve");
//            }
//              break;
//        }
//
//        case KeyEvent.VK_LEFT: {
//            //mover a la izquierda 
//            if (LaberintoVirtual.getM()[i - 1][j] != LaberintoVirtual.getMu()) {
//
//                if ((LaberintoVirtual.getM()[i - 1][j] == LaberintoVirtual.getCp())) {
//                    LaberintoVirtual.sumaPuntos(1);
//                    System.out.println("Puntos= " + LaberintoVirtual.puntos());
//                }
//                if (LaberintoVirtual.getM()[i - 1][j] == LaberintoVirtual.getF1() || LaberintoVirtual.getM()[i - 1][j] == LaberintoVirtual.getF2() || LaberintoVirtual.getM()[i - 1][j] == LaberintoVirtual.getF3() || LaberintoVirtual.getM()[i - 1][j] == LaberintoVirtual.getF4()) {
//                    LaberintoVirtual.restarVidas(1);
//                    System.out.println("Vidas= " + LaberintoVirtual.vidas());
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getCa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//
//                    i = 1;
//                    j = 28;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();//posicion inicial
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//                } else {
//                    i -= 1;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/paIZQ.jpg")));
//
//                    LaberintoVirtual.getM()[i + 1][j] = LaberintoVirtual.getCa();
//                    grafico[i + 1][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i + 1, j) + ".jpg")));
//                     break;
//                }
//            } else {
//                System.out.println("Hay muro no se mueve"); 
//            }
//             break;
//        }
//
//        case KeyEvent.VK_RIGHT: {
//            //mover a la derecha 
//            if (LaberintoVirtual.getM()[i + 1][j] != LaberintoVirtual.getMu()) {
//
//                if ((LaberintoVirtual.getM()[i + 1][j] == LaberintoVirtual.getCp())) {
//                    LaberintoVirtual.sumaPuntos(1);
//                    System.out.println("Puntos= " + LaberintoVirtual.puntos());
//                }
//                if (LaberintoVirtual.getM()[i + 1][j] == LaberintoVirtual.getF1() || LaberintoVirtual.getM()[i + 1][j] == LaberintoVirtual.getF2() || LaberintoVirtual.getM()[i + 1][j] == LaberintoVirtual.getF3() || LaberintoVirtual.getM()[i + 1][j] == LaberintoVirtual.getF4()) {
//                    LaberintoVirtual.restarVidas(1);
//                    System.out.println("Vidas= " + LaberintoVirtual.vidas());
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getCa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//
//                    i = 1;
//                    j = 28;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();//posicion inicial
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//                } else {
//                    i += 1;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//
//                    LaberintoVirtual.getM()[i - 1][j] = LaberintoVirtual.getCa();
//                    grafico[i - 1][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i - 1, j) + ".jpg")));
//                     break;
//                }
//            } else {
//                System.out.println("Hay muro no se mueve");break;
//            }
//             break;
//        }
//          default: {
//         System.out.println("No presionaste ninguna tecla");
//         }
//
//        }
//    }
//Mover pacman while
    public void MoverPacman(KeyEvent evento) throws InterruptedException {
        while (evento.getKeyCode()==KeyEvent.VK_UP ){//mover a arriba 
            if (LaberintoVirtual.getM()[i][j - 1] != LaberintoVirtual.getMu()) {
                if ((LaberintoVirtual.getM()[i][j - 1] == LaberintoVirtual.getCp())) {//valida q si hay un punto lo sumara a pacman
                    LaberintoVirtual.sumaPuntos(1);//agregamos el punto
                    System.out.println("Puntos= " + LaberintoVirtual.puntos());//mostramos el punto

                } //fin de validar puntos
                //en el if de abajo verificamos que no se encuentre un fantasma si lo hay se le quitara una vida al pacman y regresara a su posicion original
                if (LaberintoVirtual.getM()[i][j - 1] == LaberintoVirtual.getF1() || LaberintoVirtual.getM()[i][j - 1] == LaberintoVirtual.getF2() || LaberintoVirtual.getM()[i][j - 1] == LaberintoVirtual.getF3() || LaberintoVirtual.getM()[i][j - 1] == LaberintoVirtual.getF4()) {
                    LaberintoVirtual.restarVidas(1);
                    System.out.println("Vidas= " + LaberintoVirtual.vidas());

                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getCa();
                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));

                    i = 1;
                    j = 28;
                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();//posicion inicial
                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
                }
                j -= 1;
                LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();//iguala al pacman a la siguiente posision
                grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Pacman/paRRIBA.jpg")));

                LaberintoVirtual.getM()[i][j + 1] = LaberintoVirtual.getCa();
                grafico[i][j + 1].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j + 1) + ".jpg")));
                //break;
            } else {
                System.out.println("Hay muro no se mueve");
            }
             //break;
            Thread.sleep(100);
        }

//         while (evento.getKeyCode()== KeyEvent.VK_DOWN) {
//            //mover a abajo
//            if (LaberintoVirtual.getM()[i][j + 1] != LaberintoVirtual.getMu()) {
//
//                if ((LaberintoVirtual.getM()[i][j + 1] == LaberintoVirtual.getCp())) {
//                    LaberintoVirtual.sumaPuntos(1);//suma puntos
//                    System.out.println("Puntos= " + LaberintoVirtual.puntos());//muestra los puntos
//                }
//                //en el if de abajo verificamos que no se encuentre un fantasma si lo hay se le quitara una vida al pacman y regresara a su posicion original
//                if (LaberintoVirtual.getM()[i][j + 1] == LaberintoVirtual.getF1() || LaberintoVirtual.getM()[i][j + 1] == LaberintoVirtual.getF2() || LaberintoVirtual.getM()[i][j + 1] == LaberintoVirtual.getF3() || LaberintoVirtual.getM()[i][j + 1] == LaberintoVirtual.getF4()) {
//                    LaberintoVirtual.restarVidas(1);
//                    System.out.println("Vidas= " + LaberintoVirtual.vidas());
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getCa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//
//                    i = 1;
//                    j = 28;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();//posicion inicial
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//                } else {
//                    j += 1;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Pacman/paBAJO.jpg")));
//
//                    LaberintoVirtual.getM()[i][j - 1] = LaberintoVirtual.getCa();
//                    grafico[i][j - 1].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j - 1) + ".jpg")));
//                    break;
//                }
//            } else {
//                System.out.println("Hay muro no se mueve");
//            }
//              break;
//        }
//
//        while (evento.getKeyCode()== KeyEvent.VK_LEFT) {
//            //mover a la izquierda 
//            if (LaberintoVirtual.getM()[i - 1][j] != LaberintoVirtual.getMu()) {
//
//                if ((LaberintoVirtual.getM()[i - 1][j] == LaberintoVirtual.getCp())) {
//                    LaberintoVirtual.sumaPuntos(1);
//                    System.out.println("Puntos= " + LaberintoVirtual.puntos());
//                }
//                if (LaberintoVirtual.getM()[i - 1][j] == LaberintoVirtual.getF1() || LaberintoVirtual.getM()[i - 1][j] == LaberintoVirtual.getF2() || LaberintoVirtual.getM()[i - 1][j] == LaberintoVirtual.getF3() || LaberintoVirtual.getM()[i - 1][j] == LaberintoVirtual.getF4()) {
//                    LaberintoVirtual.restarVidas(1);
//                    System.out.println("Vidas= " + LaberintoVirtual.vidas());
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getCa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//
//                    i = 1;
//                    j = 28;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();//posicion inicial
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//                } else {
//                    i -= 1;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/paIZQ.jpg")));
//
//                    LaberintoVirtual.getM()[i + 1][j] = LaberintoVirtual.getCa();
//                    grafico[i + 1][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i + 1, j) + ".jpg")));
//                     break;
//                }
//            } else {
//                System.out.println("Hay muro no se mueve"); 
//            }
//             break;
//        }
//
//         while (evento.getKeyCode()== KeyEvent.VK_RIGHT) {
//            //mover a la derecha 
//            if (LaberintoVirtual.getM()[i + 1][j] != LaberintoVirtual.getMu()) {
//
//                if ((LaberintoVirtual.getM()[i + 1][j] == LaberintoVirtual.getCp())) {
//                    LaberintoVirtual.sumaPuntos(1);
//                    System.out.println("Puntos= " + LaberintoVirtual.puntos());
//                }
//                if (LaberintoVirtual.getM()[i + 1][j] == LaberintoVirtual.getF1() || LaberintoVirtual.getM()[i + 1][j] == LaberintoVirtual.getF2() || LaberintoVirtual.getM()[i + 1][j] == LaberintoVirtual.getF3() || LaberintoVirtual.getM()[i + 1][j] == LaberintoVirtual.getF4()) {
//                    LaberintoVirtual.restarVidas(1);
//                    System.out.println("Vidas= " + LaberintoVirtual.vidas());
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getCa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//
//                    i = 1;
//                    j = 28;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();//posicion inicial
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//                } else {
//                    i += 1;
//                    LaberintoVirtual.getM()[i][j] = LaberintoVirtual.getPa();
//                    grafico[i][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/pacman/" + LaberintoVirtual.CodigoImagen(i, j) + ".jpg")));
//
//                    LaberintoVirtual.getM()[i - 1][j] = LaberintoVirtual.getCa();
//                    grafico[i - 1][j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(i - 1, j) + ".jpg")));
//                     break;
//                }
//            } else {
//                System.out.println("Hay muro no se mueve");break;
//            }
//             break;
//        }
    }
//parte de mover pacman
    public void accion(int i, int j) {
        KeyListener lis = new lis();
        addKeyListener(lis);
        setFocusable(true);
    }
//KeyListiner de mover pacman y accion
    public class lis implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            try {
                MoverPacman(e);
            } catch (InterruptedException k) {
                System.out.println("Error de mover");
            }
        }
    }
//mover Fantasma1
    public void moverFantasma1() {
        int direccion = 0;//se utilizara para elejir la direccion a donde se movera el fantasma
        Random random = new Random();
        direccion = random.nextInt(4);
      //  grafico[f1_i][f1_j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/" + LaberintoVirtual.CodigoImagen(f1_i, f1_j) + ".jpg")));

     //borrar_fantasma();
        // choque_pacman();
        int boli = f1_i, bolj = f1_j;

        /* if(mapa[f1_i][f1_j] == '|'){
         direccion = rand()%4;
         }*/ //crear un objeto especial donde un camino se consiga con otro mano
 /*    if(mapa[f1_i][f1_j] == '*'){
         direccion = 0;
         }*/ //crear objeto especial para q suba y salga de la cueva 
        if (direccion == 2) {//abajo
            if (LaberintoVirtual.getM()[f1_i][f1_j + 1] != LaberintoVirtual.getMu()) {
                LaberintoVirtual.getM()[f1_i][f1_j + 1] = LaberintoVirtual.getCa();
                grafico[f1_i][f1_j+1].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Casilla/" + LaberintoVirtual.CodigoImagen(f1_i, f1_j+1) + ".jpg")));
                f1_j++;
                LaberintoVirtual.getM()[f1_i][f1_j]=LaberintoVirtual.getF1();
                grafico[f1_i][f1_j].setIcon(new ImageIcon(getClass().getResource("Grafico/Imagenes/Fantasma/" + LaberintoVirtual.CodigoImagen(f1_i, f1_j) + ".jpg")));
            } else {
                direccion = random.nextInt(4);
            }

        }
        if (direccion == 3) {//arriba
            if (LaberintoVirtual.getM()[f1_i][f1_j - 1] != LaberintoVirtual.getMu()) {
                f1_j--;
            } else {
                direccion = random.nextInt(4);
            }
        }
        if (direccion == 0) {//izquierda
            if (LaberintoVirtual.getM()[f1_i - 1][f1_j] != LaberintoVirtual.getMu()) {
                f1_i--;
            } else {
                direccion = random.nextInt(4);
            }
        }
        if (direccion == 1) {//derecha
            if (LaberintoVirtual.getM()[f1_i + 1][f1_j] != LaberintoVirtual.getMu()) {
                f1_i++;
            } else {
                direccion = random.nextInt(4);
            }
        }

        if (LaberintoVirtual.getM()[boli][bolj] == LaberintoVirtual.getCp()) {
            LaberintoVirtual.getM()[boli][bolj] = LaberintoVirtual.getCp();
        }

        if (LaberintoVirtual.getM()[boli][bolj] == LaberintoVirtual.getCc()) {
            LaberintoVirtual.getM()[boli][bolj] = LaberintoVirtual.getCc();
        }
        //dibujar_fantasma();
    }
//no modificar
 private javax.swing.JPanel Panel;
}
