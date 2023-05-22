package canvas;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingCanvas extends JPanel {
    @Setter
    private Color currentColor;
    private Turtle turtle;

    private ArrayList<Shape> shapes;

    public DrawingCanvas() {
        this.turtle = new Turtle(100,100);
        this.shapes = new ArrayList<>();

    }

    public void changeTurtleCoordinates(int x, int y){
        this.turtle.setCoordinates(x,y);
    }
    public void moveTurtle(int distance){
        int startX  = this.turtle.getX();
        int startY = this.turtle.getY();

        this.turtle.moveTurtle(distance);

        this.shapes.add(new Route(startX,startY,this.turtle.getX(),this.turtle.getY(),currentColor));

        this.repaint();
    }
    public void changeTurtleAngle(int angle){
        this.turtle.addAngle(angle);
        this.repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape: this.shapes
             ) {
            shape.draw(g);
        }
        turtle.draw(g);
        }

    }

