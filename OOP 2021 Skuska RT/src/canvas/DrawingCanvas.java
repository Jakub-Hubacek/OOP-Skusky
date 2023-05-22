package canvas;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingCanvas extends JPanel {
    @Setter
    private Color currentColor;

    private ArrayList<Tree> trees;

    private int treeOffsetX;
    private int treeOffsetY;

    private Tree selected;

    public DrawingCanvas(Color currentColor) {
        this.currentColor = currentColor;
        setBackground(Color.YELLOW);
        this.trees = new ArrayList<>();
        this.trees.add(new Tree(20,20,200,200,Color.BLUE));
    }
    public void addTree(int startX,int startY,int endX, int endY,Color color){
        Tree tree = new Tree(startX,startY,endX,endY,color);
        this.trees.add(tree);
        this.repaint();
    }
    public boolean isTreeHere(int x, int y){
        for (Tree t: this.trees){
            if((x > t.getStartX() && y > t.getStartY()) && (x < t.getEndX() && y < t.getEndY())){return true;}
        }
        return false;
    }

    private Tree getTree(int x, int y) {
        for (Tree tree : this.trees) {
            if (x > tree.getStartX() && y > tree.getStartY() && x < tree.getEndX() && y < tree.getEndY()) {
                this.treeOffsetX = x - tree.getStartX();
                this.treeOffsetY = y - tree.getStartY();
                return tree;
            }
        }
        return null;
    }
    public void setNewTreeCoordinates(int x, int y,Tree t){
       t.setNewCooridnates(x,y);
    }

    public void startDragPaint(int x, int y){
        this.selected = new Tree(x,y,x+50,y+50,currentColor);
        this.trees.add(this.selected);
        System.out.println("starting coordinates " + x + " " + y);
        repaint();
    }
    public void dragingPaint(int x, int y){
        this.selected.drawingCoorinates(x,y);
        repaint();
    }
    public void endDragPaint(int x, int y){
        //this.trees.add(new Tree(this.dragStartX,this.dragStartY,x,y,this.currentColor));
        this.selected.drawingCoorinates(x,y);
        repaint();
    }
    public void startDragMove(int x, int y){
        System.out.println("starting coordinates " + x + " " + y);
        this.selected = getTree(x,y);
    }
    public void dragingMove(int x, int y){
        setNewTreeCoordinates(x -treeOffsetX ,y - treeOffsetY,selected);
        repaint();
    }
    public void endedDragingMoveTree(){
        selected.makeCoordinatesRight();
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);
        for (Tree t: this.trees) {
            g.setColor(t.getColor());
            t.draw(g);
        }
    }
}