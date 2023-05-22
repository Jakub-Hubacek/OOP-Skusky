package controls;

import canvas.DrawingCanvas;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameLogic extends UniversalAdapter{
    @Getter
    private final DrawingCanvas canvas;
    @Getter
    private final JButton treeButton;
    @Getter
    private final JButton houseButton;
    @Getter
    private final JButton routeButton;
    @Getter
    private final JLabel currentColorLabel;

    private int currentAction;

    private ArrayList<Color> colors;

    private Color currentColor;
    private int colorIndex;


    public GameLogic() {
        this.colors = new ArrayList<>();
        colors.add(Color.red);
        colors.add(Color.blue);
        colors.add(Color.green);
        this.colorIndex = 0;
        this.currentColor = colors.get(colorIndex);

        this.canvas = new DrawingCanvas(currentColor);
        this.canvas.addMouseListener(this);
        this.canvas.addMouseMotionListener(this);
        this.canvas.setBackground(Color.yellow);

        this.treeButton = new JButton("Strom");
        this.treeButton.setFocusable(false);
        this.treeButton.addActionListener(this);

        this.houseButton = new JButton("Dom");
        this.houseButton.setFocusable(false);
        this.houseButton.addActionListener(this);

        this.routeButton = new JButton("Cesta");
        this.routeButton.setFocusable(false);
        this.routeButton.addActionListener(this);

        this.currentColorLabel = new JLabel();
        this.currentColorLabel.setText("TEST");
        this.currentColorLabel.setOpaque(true);
        this.currentColorLabel.setBackground(currentColor);

        this.currentAction = 0;
    }

    private void nextColor(){
        this.colorIndex++;
        if(this.colorIndex >= this.colors.size()){
            this.colorIndex = 0;
        }
        this.currentColor = colors.get(colorIndex);
        this.canvas.setCurrentColor(currentColor);
        this.currentColorLabel.setBackground(currentColor);
    }

    private void resolveLabel(){
        switch (this.currentAction){
            case 1:
                this.currentColorLabel.setText("Strom");
                break;
            case 2:
                this.currentColorLabel.setText("Dom");
                break;
            case 3:
                this.currentColorLabel.setText("Cesta");
                break;
        }


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.treeButton){
            this.currentAction = 1;
            this.resolveLabel();
        }
        if(e.getSource() == this.houseButton){
            this.currentAction = 2;
            this.resolveLabel();
        }
        if(e.getSource() == this.routeButton){
            this.currentAction = 3;
            this.resolveLabel();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(currentAction == 3){
            System.out.println("PRESSED");
            this.canvas.drawingRoadShape(e.getX(),e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(currentAction == 3){
            this.canvas.endDrawingRoadShape(e.getX(),e.getY());
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

       if(currentAction == 1){
           nextColor();
           this.canvas.addTree(e.getX(),e.getY());
       }
        if(currentAction == 2){
            nextColor();
            this.canvas.addHouse(e.getX(),e.getY());
        }
        if(currentAction == 3){
            this.canvas.getShape(e.getX(),e.getY());
        }

    }
    @Override
    public void mouseMoved(MouseEvent e) {
        if(currentAction == 1){
            this.canvas.movingTreeShape(e.getX(),e.getY());
        }
        if(currentAction == 2){
            this.canvas.movingHouseShape(e.getX(),e.getY());
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(currentAction == 3){
            this.canvas.movingRoadShape(e.getX(),e.getY());
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(currentAction == 1){
            this.canvas.drawingTreeShape(e.getX(),e.getY());
        }
        if(currentAction == 2){
            this.canvas.drawingHouseShape(e.getX(),e.getY());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(currentAction == 1){
            this.canvas.deleteTreeShape();
        }
        if(currentAction == 2){
            this.canvas.deleteHouseShape();
        }
    }
}
