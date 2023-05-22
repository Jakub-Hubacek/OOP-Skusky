package canvas;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Turtle extends Shape{
    private Color headColor;
    private int bodyRadius;
    private int headRadius;
    private double angle;
    public Turtle(int x,int y) {
        this.setCoordinates(x,y);
        this.color = Color.green;
        this.headColor = Color.PINK;
        this.bodyRadius = 40;
        this.headRadius = 30;
        this.angle = 0;
    }

    private void drawHead(Graphics2D g, double angle){
        // Remember the current transformation
        AffineTransform old = g.getTransform();

        // Move the origin to the center of the body
        g.translate(this.x, this.y);

        // Rotate the canvas
        g.rotate(angle);

        // Draw the head, noting that the coordinates are now relative to the body's center
        g.fillOval(-headRadius/2, -bodyRadius-headRadius/4, headRadius, headRadius);

        // Revert to the old transformation
        g.setTransform(old);
    }
    public void addAngle(int deg){
        this.angle = (this.angle+deg)%360;
    }
    public void moveTurtle(double distance) {
        double RadAngle;
        // Convert angle from degrees to radians
        RadAngle = Math.toRadians(this.angle);

        // Adjust for the coordinate system
        // Subtract the angle from 90 because we want 0 degrees to be "up"
        // Multiply by -1 to flip the rotation direction
        RadAngle = Math.toRadians(90) - RadAngle;

        // Compute new position
        this.x += distance * Math.cos(RadAngle);
        this.y -= distance * Math.sin(RadAngle); // Subtract because y increases downwards
    }
    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g; // Graphics2D has more features, like rotation

        g2.setColor(this.color);
        g2.fillOval(this.x-bodyRadius/2, this.y -bodyRadius/2, bodyRadius, bodyRadius);
        g2.setColor(headColor);
        double rotation = Math.toRadians(angle); // Replace 'someAngle' with the actual angle of rotation
        drawHead(g2, rotation);
    }

}
