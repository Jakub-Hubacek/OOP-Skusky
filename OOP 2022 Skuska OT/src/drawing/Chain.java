package drawing;

import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;

public class Chain {
    private int x;
    private int y;
    @Setter
    private int radius;
    private ArrayList<Shape> shapes;
    @Setter
    private int chainLength;
    @Setter
    private int spacing;
    @Setter
    private int shapeId;

    private Color startColor = Color.RED;
    private Color endColor = Color.BLUE;
    public Chain(int chainLength,int spacing, int shapeRadius,int shapeId) {
        this.shapes = new ArrayList<>();
        this.chainLength = chainLength;
        this.spacing = spacing;
        this.radius = shapeRadius;
        this.shapeId = shapeId;
    }
    public void addCoordinates(int x,int y){
        this.x = x;
        this.y = y;
        this.changeShapesRadius();
        this.addNewChainLinks();
        this.deleteExcessChainLinks();
        this.setGradientColors();
    }
    public void removeAllShapes(){
        this.shapes.clear();
    }
    private void addNewChainLinks(){
        this.addShape();
    }
    private void deleteExcessChainLinks(){
        this.trimShapesList();
    }
    private void trimShapesList(){
        if(this.shapes.size() > chainLength){
            this.shapes.remove(0);
        }
    }
    private void addShape(){
        switch (shapeId){
            case 1:
                this.shapes.add(new Square(this.x,this.y,this.radius));
                break;
            case 2:
                this.shapes.add(new Circle(this.x,this.y,this.radius));
                break;
            case 3:
                this.shapes.add(new Hourglass(this.x,this.y,this.radius));
                break;
        }
    }

    public void changeShapesRadius(){
        for (Shape s: this.shapes
             ) {
            s.setRadius(this.radius);
        }
    }
    public void changeShapes(){
        ArrayList<Shape> newShapes = new ArrayList<>();
        for (Shape s: this.shapes
             ) {
            switch (shapeId){
                case 1:
                    newShapes.add(new Square(s.getX(),s.getY(),this.radius));
                    break;
                case 2:
                    newShapes.add(new Circle(s.getX(),s.getY(),this.radius));
                    break;
                case 3:
                    newShapes.add(new Hourglass(s.getX(),s.getY(),this.radius));
                    break;
            }
        }
        this.shapes.clear();
        this.shapes = newShapes;
        this.setGradientColors();
    }

    private void setGradientColors() {
        int numShapes = this.shapes.size();
        int redDiff = endColor.getRed() - startColor.getRed();
        int greenDiff = endColor.getGreen() - startColor.getGreen();
        int blueDiff = endColor.getBlue() - startColor.getBlue();

        for (int i = 0; i < numShapes; i++) {
            Shape shape = this.shapes.get(i);

            int red = startColor.getRed() + (int) (i * (double) redDiff / (numShapes - 1));
            int green = startColor.getGreen() + (int) (i * (double) greenDiff / (numShapes - 1));
            int blue = startColor.getBlue() + (int) (i * (double) blueDiff / (numShapes - 1));
            Color gradientColor = new Color(red, green, blue);

            shape.setColor(gradientColor);
        }
    }
    public void draw(Graphics g){
        System.out.println("painting");
        int counter = 1;
        g.setColor(Color.black);
        for (Shape s: this.shapes) {
            counter++;
            if (counter % this.spacing == 0) {;
                s.draw(g);
            }
        }

    }


}
