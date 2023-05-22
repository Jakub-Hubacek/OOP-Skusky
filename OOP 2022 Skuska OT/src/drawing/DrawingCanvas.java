package drawing;

import javax.swing.*;
import java.awt.*;

public class DrawingCanvas extends JPanel {

    private Chain chain;

    public DrawingCanvas(int chainLength,int spacing, int shapeRadius, int shapeID) {
        this.chain = new Chain(chainLength,spacing,shapeRadius, shapeID);
    }
    public void setChainShapeId(int id){
        this.chain.setShapeId(id);
        this.chain.changeShapes();
        repaint();}
    public void setChainLength(int length){
        this.chain.setChainLength(length);
        repaint();
    }

    public void setChainSpacing(int spacing){
        this.chain.setSpacing(spacing);
        repaint();
    }

    public void setChainRadius(int radius){
        this.chain.setRadius(radius);
        this.chain.changeShapesRadius();
        repaint();
    }
    public void addChainCoordinates(int x, int y){
        this.chain.addCoordinates(x,y);
        repaint();
    }
    public void removeAllChainCoordinates(){
        this.chain.removeAllShapes();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.chain.draw(g);
    }
}
