package com.jared.Tetris.menus;

import com.jared.Tetris.input.Input;
import com.jared.Tetris.menus.button.Selection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;


/**
 * Created by Jared H on 4/6/2017.
 */
public class MainMenu extends Menu {

    private String title;
    private double x = 0;
    private Color[] colors;
    private Selection button;


    public MainMenu(Input input, String title, Dimension size){
        super(input, size);
        this.title = title;
        colors = new Color[title.length()];
        Random r = new Random();
        for (int i = 0; i < colors.length; i++){
            colors[i] = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        }
        Timer titlePosTimer = new Timer(20, this::titlePosUpdate);
        Timer titleColorTimer = new Timer(1000, this::titleColorUpdate);
        titlePosTimer.start();
        titleColorTimer.start();

        button = new Selection(0,0,0,0, this::Play);

    }


    void update() {
        super.update();

    }

    public void paint(Graphics g) {
        super.paint(g);

        drawTitle(g);

        drawFpsCounter(g);
        g.dispose();
    }

    private void drawTitle(Graphics g){
        g.setFont(new Font("Times New Roman", Font.BOLD, 100));

        double y = x;
        for (int i = 0; i < title.length(); i++){

            g.setColor(colors[i]);
            String s = title.substring(i, i+1).toUpperCase();
            int xPos = (int) (getWidth()/5 + getWidth()*3/5.0/6.0 * i);
            int yPos = (int)(getHeight()/5+20*Math.cos(y));
            if(g.getFontMetrics().getStringBounds(s,g).getWidth() < 40){
                g.drawString(s, xPos+(int)(g.getFontMetrics().getStringBounds(s,g).getWidth()/2), yPos);
            }
            else {
                g.drawString(s, xPos, yPos);
            }
            y-= Math.PI/3.0;
        }
    }

    private void titlePosUpdate(ActionEvent e){
        if (x == 2*Math.PI){
            x= 0;
        }
        x+=Math.PI/40;
    }

    private void titleColorUpdate(ActionEvent e){
        Random r = new Random();
        for (int i = 0; i < colors.length; i++){
            colors[i] = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        }
    }

    void checkKeys() {}


    void checkButtons() {}

    public void Play(ActionEvent e){

    }
}
