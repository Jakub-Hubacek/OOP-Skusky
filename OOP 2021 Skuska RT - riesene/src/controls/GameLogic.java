package controls;

import canvas.DrawingCanvas;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameLogic extends  UniversalAdapter{
    @Getter
    private final DrawingCanvas canvas;
    @Getter
    private final JButton drawButton;
    @Getter
    private final JButton moveButton;
    @Getter
    private final JButton colorButton;
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

        this.drawButton = new JButton("Tree");
        this.drawButton.addActionListener(this);
        this.drawButton.setFocusable(false);


        this.moveButton = new JButton("Move");
        this.moveButton.addActionListener(this);
        this.moveButton.setFocusable(false);

        this.colorButton = new JButton("Next Color");
        this.colorButton.addActionListener(this);
        this.colorButton.setFocusable(false);

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
                this.currentColorLabel.setText("KRESLENIE");
                break;
            case 2:
                this.currentColorLabel.setText("PRESÚVANIE");
                break;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.colorButton){
           nextColor();
       }
        if(e.getSource() == this.drawButton){
            this.currentAction = 1;
            this.resolveLabel();
        }
        if(e.getSource() == this.moveButton){
            this.currentAction = 2;
            this.resolveLabel();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(currentAction==1){
            this.canvas.startDragPaint(e.getX(),e.getY());
        }
        if(currentAction == 2 && this.canvas.isTreeHere(e.getX(),e.getY())){
            this.canvas.startDragMove(e.getX(),e.getY());
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(currentAction==1){
            this.canvas.dragingPaint(e.getX(),e.getY());
        }
        if(currentAction == 2){
            this.canvas.dragingMove(e.getX(),e.getY());}

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if(currentAction==1){
            this.canvas.endDragPaint(e.getX(),e.getY());
        }
        if(currentAction == 2){
            this.canvas.endedDragingMoveTree();}

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.canvas.isTreeHere(e.getX(),e.getY())){
            System.out.println("That is a tree!");
        }
    }
}
