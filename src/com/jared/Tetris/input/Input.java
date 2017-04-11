package com.jared.Tetris.input;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by Jared H on 4/7/2017.
 */
public class Input implements KeyListener, MouseListener, MouseMotionListener{
    public static boolean[] keys;
    public static boolean[] buttons;
    public static Point mousePos;


    public Input(){
        keys = new boolean[156];
        buttons = new boolean[12];
        mousePos = new Point(0,0);
    }

    //KEYS
    @Override
    public void keyPressed(KeyEvent e) {
        try {
            keys[e.getKeyCode()] = true;
        }catch(IndexOutOfBoundsException c){}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            keys[e.getKeyCode()] = false;
        }catch(IndexOutOfBoundsException c){}
    }

    //MOUSE
    @Override
    public void mousePressed(MouseEvent e){
        try {
            buttons[e.getButton()] = true;
        }catch(IndexOutOfBoundsException c){}
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        try {
            buttons[e.getButton()] = false;
        }catch(IndexOutOfBoundsException c){}
    }

    @Override
    public void mouseDragged(MouseEvent e) {mousePos = e.getLocationOnScreen();}
    @Override
    public void mouseMoved(MouseEvent e) {
        mousePos = e.getLocationOnScreen();
    }



    // EXTRANEOUS
    @Override
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
    public void mouseClicked(MouseEvent e) {}
}
