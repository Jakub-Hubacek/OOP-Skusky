package canvas;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingCanvas extends JPanel {

    @Setter
    private Color currentColor;

    private ArrayList<Shape> shapes;

    private Shape selected;
    public DrawingCanvas(Color color) {
        this.currentColor = color;
        this.shapes = new ArrayList<>();
        this.shapes.add(new Cross(100,10,200,100,color));

        this.shapes.add(new Route(100,10, 100,100,Color.RED));
    }

    public void startDragPaintRoute(int x, int y){
        this.selected = new Route(x,y,x+1,y+1,currentColor);
        this.shapes.add(this.selected);
        repaint();
    }

    public void dragingPaintRoute(int x, int y){
        this.selected.drawingCoorinates(x,y);
        repaint();
    }

    public void endDragPaintRoute(int x, int y){
        this.selected.drawingCoorinates(x,y);
        repaint();
        this.selected = null;
    }

    public void startDragPaintCross(int x, int y){
        this.selected = new Cross(x,y,x+1,y+1,currentColor);
        this.shapes.add(this.selected);
        repaint();
    }
    public void dragingPaintCross(int x, int y){
        this.selected.drawingCoorinates(x,y);
        repaint();
    }
    public void endDragPaintCross(int x, int y){
        this.selected.drawingCoorinates(x,y);
        this.selected.makeCoordinatesRight();
        repaint();
        this.selected = null;
    }

    public boolean isShapeHere(int x, int y){
        //System.out.println("Searched coordinates " +x +" " + y);
        for (Shape t: this.shapes){
            //System.out.println("shapes startingX " + t.getStartX());
            if(x > t.getStartX() && x < t.getEndX() && y > t.getStartY() && y < t.getEndY()) {
                //System.out.println("Shape found");
                return true;}
        }
        return false;
    }

    private Shape getShape (int x, int y ){
        for (Shape t: this.shapes){
            if(isPointInsideShape(x,y,t)) {//x > t.getStartX() && x < t.getEndX() && y > t.getStartY() && y < t.getEndY()
                return t;}
        }
        return null;
    }
    public boolean isPointInsideShape(int x, int y, Shape shape) {
        int minX = Math.min(shape.getStartX(), shape.getEndX());
        int maxX = Math.max(shape.getStartX(), shape.getEndX());
        int minY = Math.min(shape.getStartY(), shape.getEndY());
        int maxY = Math.max(shape.getStartY(), shape.getEndY());

        return x >= minX && x <= maxX && y >= minY && y <= maxY;
    }
    public void changeShapeColor(int x, int y, Color c){
        Shape s = this.getShape(x,y);
        if(s!= null){
            s.setColor(c);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);
        for (Shape s: this.shapes) {
            g.setColor(s.getColor());
            s.draw(g);
        }
    }
}
