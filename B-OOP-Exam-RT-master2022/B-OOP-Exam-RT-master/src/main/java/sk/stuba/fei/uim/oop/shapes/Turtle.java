package sk.stuba.fei.uim.oop.shapes;

import lombok.Getter;

import java.awt.*;

@Getter
public class Turtle {

    private static final int TURTLE_SHELL_RADIUS = 20;
    private static final int TURTLE_HEAD_RADIUS = 10;
    private static final Color TURTLE_SHELL_COLOR = new Color(0, 130, 0);
    private static final Color TURTLE_HEAD_COLOR = new Color(200, 160, 130);

    private int x;
    private int y;
    private int degrees;

    public Turtle(int x, int y) {
        this.degrees = -90;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        Color original = g.getColor();
        g.setColor(TURTLE_SHELL_COLOR);
        g.fillOval(x - TURTLE_SHELL_RADIUS, y - TURTLE_SHELL_RADIUS, 2 * TURTLE_SHELL_RADIUS, 2 * TURTLE_SHELL_RADIUS);
        g.setColor(TURTLE_HEAD_COLOR);
        g.fillOval((int) (x + TURTLE_SHELL_RADIUS * Math.cos(getRadians()) - TURTLE_HEAD_RADIUS), (int) (y + TURTLE_SHELL_RADIUS * Math.sin(getRadians()) - TURTLE_HEAD_RADIUS), 2 * TURTLE_HEAD_RADIUS, 2* TURTLE_HEAD_RADIUS);
        g.setColor(original);
    }

    private double getRadians() {
        return Math.toRadians(degrees);
    }

    public void forward(int distance) {
        this.x += distance * Math.cos(getRadians());
        this.y += distance * Math.sin(getRadians());
    }

    public void backwards(int distance) {
        forward(-distance);
    }

    public void turnRight(int angle) {
        this.degrees += angle;
    }

    public void turnLeft(int angle) {
        this.degrees -= angle;
    }
}
