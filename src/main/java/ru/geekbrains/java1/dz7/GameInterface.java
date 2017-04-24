package ru.geekbrains.java1.dz7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by олег on 05.02.2017.
 */
public class GameInterface extends JFrame {
    private Graphics g;
    int x, y;

    public GameInterface() {
        setTitle("GameInterface");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 300);
        this.setResizable(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                g = getGraphics();
                x = e.getX();
                y = e.getY();
                repaint();

                if ((x > 0 && x < 100) && (y > 0 && y < 100)) g.drawOval(25, 35, 50, 50); // [0,0]
                else if ((x > 0 && x < 100) && (y > 100 && y < 200)) g.drawOval(25, 125, 50, 50); // [0,1]
                else if ((x > 0 && x < 100) && (y > 200 && y < 300)) g.drawOval(25, 225, 50, 50); // [0,2]
                else if ((x > 100 && x < 200) && (y > 0 && y < 100)) g.drawOval(125, 35, 50, 50); // [1,0]
                else if ((x > 100 && x < 200) && (y > 100 && y < 200)) g.drawOval(125, 125, 50, 50); // [1,1]
                else if ((x > 100 && x < 200) && (y > 200 && y < 300)) g.drawOval(125, 225, 50, 50); // [1,2]
                else if ((x > 200 && x < 300) && (y > 0 && y < 100)) g.drawOval(225, 35, 50, 50); // [2,0]
                else if ((x > 200 && x < 300) && (y > 100 && y < 200)) g.drawOval(225, 125, 50, 50); // [2,1]
                else if ((x > 200 && x < 300) && (y > 200 && y < 300)) g.drawOval(225, 225, 50, 50); // [2,2]

            }
        });

        setVisible(true);
    }


    @Override
    public void paint(Graphics g) {

        g.drawLine(100, 0, 100, 300);
        g.drawLine(200, 0, 200, 300);
        g.drawLine(0, 100, 300, 100);
        g.drawLine(0, 200, 300, 200);

    }
}