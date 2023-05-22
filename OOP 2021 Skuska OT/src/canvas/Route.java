package canvas;

import java.awt.*;
import java.util.ArrayList;

public class Route extends Shape{
    private int endX;
    private int endY;
    private ArrayList<Shape> shapes;

    public void addShape(Shape s){
        this.shapes.add(s);
    }

    public boolean containsShape(Shape s) {
        for (Shape shape : this.shapes) {
            if (s.getClass().isInstance(shape)) {
                return true;
            }
        }
        return false;
    }
    public Route(int startX, int startY, Color color) {
        setNewCoordinates(startX,startY);
        this.calculateWidthAndHeight();
        this.shapes = new ArrayList<>();
    }
    public Route(Shape s1, Shape s2){
        this.setNewCoordinates(s1.getCenterX(),s1.getCenterY());
        this.setEndCoordinates(s2.getCenterX(),s2.getCenterY());

        this.shapes = new ArrayList<>();
    }
    public void setEndCoordinates(int x,int y){
        this.endX = x;
        this.endY = y;
    }
    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        int thickness = 5; // Set the thickness of the line
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawLine(this.getCenterX(), getCenterY(), this.endX, this.endY);
    }
}
