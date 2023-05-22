package org.example.shapes;

import lombok.AllArgsConstructor;

import java.awt.*;

@AllArgsConstructor
public class Line {
    private int x;
    private int y;
    private int length;
    private int angle;
    private Color color;

    public void draw(Graphics g){
        Color original = g.getColor();
        g.setColor(color);
        g.drawLine(x,y,(int) (x + length * Math.cos(Math.toRadians(angle))), (int) (y + length * Math.sin(Math.toRadians(angle))));
        g.setColor(original);
    }




}
