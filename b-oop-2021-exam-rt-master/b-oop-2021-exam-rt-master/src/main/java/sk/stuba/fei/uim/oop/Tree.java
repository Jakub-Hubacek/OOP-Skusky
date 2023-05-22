package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class Tree extends Shapes{
    @Setter
    @Getter
    private Point position;
    private final Color color;
    public Tree(Point position, Color color){
        this.color = color;
        this.position = position;
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect( position.x - 5, position.y, 10, 15);
        g.fillOval(position.x-15, position.y - 15, 30, 20);
    }

    @Override
    public boolean contains(Point2D p) {
        return super.contains(p);
    }

}
