package com.jared.graphics;

import java.awt.*;

/**
 * Created by Jared H on 4/8/2017.
 */
public class Tile {
    public static int TILE_SIZE = 32;

    int x, y;
    Color color;
    public Tile(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fill3DRect(x, y, TILE_SIZE, TILE_SIZE, true);
    }
}
