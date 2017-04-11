package com.jared.Tetris.menus;

import com.jared.Tetris.input.Input;
import com.jared.graphics.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Jared H on 4/6/2017.
 */
public class Game extends Menu {

    public Game(Input input, Dimension size){
        super(input, size);
        setLayout(new BorderLayout());
        JButton button = new JButton("Button1" );
        pane.add(button, BorderLayout._____);

    }

    public void paint(Graphics g){
        super.paint(g);

        drawFpsCounter(g);
    }

    /*
    private void drawTileWindow(Graphics g){
        g.setColor(new Color(192,192,192));
        for(int i = 0; i < 4; i++){
            g.drawRect(windowLeft-i, windowTop-i, 32*10+2*i, 32*18+2*i);
        }
        g.setColor(Color.BLACK);
        g.fillRect((int)(getWidth()/32.0*6), getHeight()/12, 32*10, 32*18);




    }
*/
    void checkKeys() {}

    void checkButtons() {}

    void update() {
        super.update();
    }
}
