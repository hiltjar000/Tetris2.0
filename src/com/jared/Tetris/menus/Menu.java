package com.jared.Tetris.menus;

import com.jared.Tetris.input.Input;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Jared H on 4/6/2017.
 */
public abstract class Menu extends JPanel{

    private boolean running;
    private int fps = 0, ups = 0;
    private final int TEXT_COUNTERSIZE = 20;
    private long time;
    Input input;


    Menu(){
        setVisible(true);
        setBackground(Color.BLACK);
    }


    Menu(Input input, Dimension size){
        setSize(size);
        setVisible(true);
        setBackground(Color.BLACK);
        this.input = input;

    }


    public void start(){
        running = true;
        run();
    }


    void run() {
        long lastTime = System.nanoTime();
        time = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double deltau = 0;
        double deltaf = 0;
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            deltau += (now-lastTime) / ns;
            deltaf += (now-lastTime) / ns;
            lastTime = now;
            while (deltau >= 1){ //60 ps
                update();
                updates++;
                deltau--;
            }
            while (deltaf >= .5) { //120 ps
                repaint();
                frames++;
                deltaf-=.5;
            }

            if (System.currentTimeMillis() - time > 1000){
                fps = frames;
                ups = updates;
                frames = 0;
                updates = 0;
                time += 1000;
            }


        }
        stop();
    }

    void update(){
        checkKeys();
        checkButtons();
    }

    public void paint(Graphics g){
        super.paint(g);
    }


    void drawFpsCounter(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman", Font.BOLD, TEXT_COUNTERSIZE));
        String s = "UPS: " + ups + " | FPS: " + fps;
        g.drawString(s, 2, getHeight()%TEXT_COUNTERSIZE+(int)g.getFontMetrics().getStringBounds(s,g).getHeight()/4);
    }

    void stop(){
        running = false;
    }

    void drawString(String string, int x, int y, Graphics g){
        g.drawString(string, x - (int)(g.getFontMetrics().getStringBounds(string,g).getWidth()/2), y);
    }

    abstract void checkKeys();
    abstract void checkButtons();



}
