package org.example.shapes;

import lombok.Getter;

import java.awt.*;

public class Turtle {
    private final static int TURTLE_HEAD_RADIUS = 10;
    private final static int TURTLE_BODY_RADIUS = 20;
    private final static Color TURTLE_BODY_COLOR = new Color(5, 111, 5);
    private final static Color TURTLE_HEAD_COLOR = new Color(253, 190, 75);
    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private int degrees;
    public Turtle(int x, int y){
        this.x = x;
        this.y = y;
        this.degrees = -90;
    }

    public void draw(Graphics g){
        Color original = g.getColor();
        g.setColor(TURTLE_BODY_COLOR);
        g.fillOval(x - TURTLE_BODY_RADIUS, y - TURTLE_BODY_RADIUS, 2* TURTLE_BODY_RADIUS, 2* TURTLE_BODY_RADIUS);
        g.setColor(TURTLE_HEAD_COLOR);
        g.fillOval((int) (x + TURTLE_BODY_RADIUS * Math.cos(Math.toRadians(degrees)) - TURTLE_HEAD_RADIUS), (int) (y + TURTLE_BODY_RADIUS * Math.sin(Math.toRadians(degrees)) - TURTLE_HEAD_RADIUS), 2 * TURTLE_HEAD_RADIUS, 2* TURTLE_HEAD_RADIUS );
        g.setColor(original);
    }

    public void forward(int distance){
        this.x += distance * Math.cos(Math.toRadians(degrees));
        this.y += distance * Math.sin(Math.toRadians(degrees));
    }
    public void backwards(int distance){
        forward(-distance);
    }
    public void rotateRight(int degrees){
        this.degrees += degrees;
    }
    public void rotateLeft(int degrees){
        this.degrees -= degrees;
    }
}
