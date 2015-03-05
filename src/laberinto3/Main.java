/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto3;
import GeneradorGrafico.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.KeyEventDispatcher;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author MujicaM
 */
public class Main {

    public static void main(String[] args) {
        Hilo hil = new Hilo();
        hil.start();
    }
    
}
