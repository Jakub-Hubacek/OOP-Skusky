package canvas;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingCanvas extends JPanel {
    @Setter
    private Color currentColor;

    private ArrayList<Tree> trees;
    private ArrayList<House> houses;
    private ArrayList<Route> routes;
    private Tree selectedTree;
    private House selectedHouse;

    private Route selectedRoute;

    private Shape selectedRouteShape;

    private Shape endRouteShape;

    public Shape getShape(int x, int y){
        for (Tree t: this.trees) {
            if(t.areCoordinatesInside(x,y)){
                //System.out.println("TREE HERE");
                return t;
            }
        }
        for (House h: this.houses) {
            if(h.areCoordinatesInside(x,y)){
                //System.out.println("HOUSE HERE");
                return h;
            }
        }
        return null;
    }

    public DrawingCanvas(Color currentColor) {
        this.currentColor = currentColor;
        setBackground(Color.YELLOW);
        this.trees = new ArrayList<>();
        this.trees.add(new Tree(100,20,Color.BLUE));
        this.houses = new ArrayList<>();
        this.houses.add(new House(200,40,Color.BLUE));

        this.routes = new ArrayList<>();
        this.routes.add(new Route(this.trees.get(0),this.houses.get(0)));

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);

        for (Tree t: this.trees) {
            g.setColor(t.getColor());
            t.draw(g);
        }
        for (House t:this.houses) {
            g.setColor(t.getColor());
            t.draw(g);
        }
        for (Route r:this.routes) {
            r.draw(g);
        }
        if(this.selectedHouse != null) {this.selectedHouse.drawOutline(g);}
        if(this.selectedTree != null){this.selectedTree.drawOutline(g);}
        if(this.selectedRoute != null){this.selectedRoute.draw(g);}
    }

    public void drawingRoadShape(int x, int y){
        this.selectedRouteShape = getShape(x,y);
        if(this.selectedRouteShape != null){
            //System.out.println("Shape found");
            this.selectedRoute = new Route(this.selectedRouteShape.getCenterX(),
                    this.selectedRouteShape.getCenterY(),Color.black);
            //System.out.println(selectedRouteShape + " added");
            this.selectedRoute.addShape(selectedRouteShape);
        }
    }

    public void movingRoadShape(int x, int y){
        if(this.selectedRoute != null){
            //System.out.println("painting route on " + x + " " + y);
            this.selectedRoute.setEndCoordinates(x,y);
            repaint();}

    }

    public void endDrawingRoadShape(int x, int y){
        this.endRouteShape = getShape(x,y);
        if(this.endRouteShape == null){
            this.deleteRoadShape();
        } else if (this.selectedRoute.containsShape(this.endRouteShape)) {
            this.deleteRoadShape();
        }else {
            this.selectedRoute.addShape(this.endRouteShape);
            this.selectedRoute.setEndCoordinates(this.endRouteShape.getCenterX(),this.endRouteShape.getCenterY());
            this.routes.add(this.selectedRoute);
            repaint();
        }
    }
    public void deleteRoadShape(){
        this.selectedRoute = null;
        this.selectedRouteShape = null;
        repaint();
    }

    public void addTree(int startX, int startY){
        this.trees.add(new Tree(startX,startY,currentColor));
        repaint();
    }
    public void drawingTreeShape(int startX, int startY){
        this.selectedTree = new Tree(startX,startY,currentColor);
        repaint();
    }
    public void movingTreeShape(int x, int y){
        this.selectedTree.setNewCoordinates(x,y);
        repaint();
    }
    public void deleteTreeShape(){
        this.selectedTree = null;
        repaint();
    }
    public void addHouse(int startX, int startY){
        this.houses.add(new House(startX,startY,currentColor));
        repaint();
    }
    public void drawingHouseShape(int startX, int startY){
        this.selectedHouse = new House(startX,startY,currentColor);
        repaint();
    }
    public void movingHouseShape(int x, int y){
        this.selectedHouse.setNewCoordinates(x,y);
        repaint();
    }

    public void deleteHouseShape(){
        this.selectedHouse = null;
        repaint();
    }
}
