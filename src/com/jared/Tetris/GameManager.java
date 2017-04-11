package com.jared.Tetris;

import com.jared.Tetris.input.Input;
import com.jared.Tetris.menus.Game;
import com.jared.Tetris.menus.MainMenu;
import com.jared.Tetris.menus.Menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jared H on 3/29/2017.
 */
public class GameManager extends JFrame{



    public static void main(String[] args){
        GameManager gameManager = new GameManager("Tetris", new Dimension(600, 800));
        gameManager.init();

    }
    private Menu menu;
    private Container container;
    private Input input;
    private final String title;

    public GameManager(String title, Dimension size){
        container = getContentPane();
        input = new Input();
        addKeyListener(input);
        addMouseListener(input);
        addMouseMotionListener(input);
        this.title = title;
        setResizable(false);
        setTitle(title);
        setSize(size);
        setPreferredSize(size);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        requestFocus();
        setBackground(Color.black);

    }

    public void run(){
        menu.start();
    }

    private void init(){
        GamePanel();
    }

    public void stop(){
        System.exit(0);
    }

    public void MainMenuPanel(){
        container.removeAll();
        menu = new MainMenu(/*this */input, title, getSize());
        add(menu);
        validate();
        pack();
        menu.start();
    }

    public void GamePanel(){
        container.removeAll();
        menu = new Game(/*this */input, getSize());
        add(menu);

        validate();
        pack();
        menu.start();
    }


}
