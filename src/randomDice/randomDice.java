/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomDice;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 *
 * @author swalker
 */
public class randomDice {

    private int size = 80;
    private int width, height;
    private int cellWidth, cellHeight;

    public void paint(Graphics g) {
        width = 1000;
        height = 650    ;
        int hSize = 8 * width / 100;
        int vSize = 8 * height / 65;
        size = Math.min(hSize, vSize);
        cellWidth = width / 5;
        cellHeight = height / 2;
        boxPattern(g);
        dicePattern(g);
    }

    private void boxPattern(Graphics g) {
        g.drawLine(0, cellHeight, width, cellHeight);
        for (int i = 1; i <= 4; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, height);
        }
    }

    private void dicePattern(Graphics g) {
        for (int i = 0; i < 5; i++) {
            int xVal = i * cellWidth;
            pairODice(g, xVal + cellWidth / 2, height / 4);
            pairODice(g, xVal + cellWidth / 2, 3 * height / 4);
        }
    }

    private void pairODice(Graphics g, int x, int y) {
        int h = x - size;
        int v = y;
        g.drawRect(h, v, size, size);
        randomDots(g, h, v);
        h = x;
        v = y - size;
        g.drawRect(h, v, size, size);
        randomDots(g, h, v);
    }

    private void randomDots(Graphics g, int x, int y) {
        Random rnd = new Random();
        int numDots = rnd.nextInt(6) + 1;
        int[] pos = new int[]{};
        switch (numDots) {
            case 1:
                pos = new int[]{4};
                break;
            case 2:
                pos = new int[]{2, 6};
                break;
            case 3:
                pos = new int[]{2, 4, 6};
                break;
            case 4:
                pos = new int[]{0, 2, 6, 8};
                break;
            case 5:
                pos = new int[]{0, 2, 4, 6, 8};
                break;
            case 6:
                pos = new int[]{0, 2, 3, 5, 6, 8};
        }
        drawDots(g, x, y, pos);
    }

    private void drawDots(Graphics g, int x, int y, int[] pos) {
        Graphics2D g2 = (Graphics2D) g;
        int r, c;
        double offsetBase, offsetStep, diam, h, v;
        for (int i = 0; i < pos.length; i++) {
            r = pos[i] / 3;
            c = pos[i] % 3;
            offsetBase = size / 10.0;
            offsetStep = 3 * offsetBase;
            diam = 2 * offsetBase;
            h = x + c * offsetStep + offsetBase;
            v = y + r * offsetStep + offsetBase;
            g2.fill(new Ellipse2D.Double(h, v, diam, diam));
        }
    }

}
