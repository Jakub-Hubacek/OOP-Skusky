package controls;

import canvas.DrawingCanvas;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

public class GameLogic extends UniversalAdapter{
    @Getter
    private JButton buttonCross;
    @Getter
    private JButton buttonRoute;
    @Getter
    private JLabel  label;
    @Getter
    private Choice choice;

    @Getter
    private JButton buttonColor;
    private Color currentColor;
    private int actionID;
    @Getter
    DrawingCanvas canvas;
    public GameLogic() {
        this.buttonCross = new JButton("Plus");
        this.buttonCross.setFocusable(false);
        this.buttonCross.addActionListener(this);

        this.buttonRoute = new JButton("Usecka");
        this.buttonRoute.setFocusable(false);
        this.buttonRoute.addActionListener(this);

        this.choice = new Choice();
        this.choice.setFocusable(false);
        this.choice.addItemListener(this);
        this.choice.add("Modra");
        this.choice.add("Cervena");
        this.choice.add("Zelena");
        this.currentColor= Color.BLUE;

        this.label = new JLabel();
        this.label.setFocusable(false);
        this.label.setOpaque(true);
        this.label.setBackground(currentColor);

        this.buttonColor = new JButton("Vyfarbuj");
        this.buttonColor.setFocusable(false);
        this.buttonColor.addActionListener(this);

        this.canvas = new DrawingCanvas(Color.black);
        this.canvas.setBackground(Color.yellow);
        this.canvas.addMouseListener(this);
        this.canvas.addMouseMotionListener(this);
    }

    private Color getColorFromOption(String option) {
        switch (option) {
            case "Cervena":
                return Color.RED;
            case "Zelena":
                return Color.GREEN;
            case "Modra":
                return Color.BLUE;
            default:
                return Color.BLACK;
        }
    }
    private void updateColor() {
        this.canvas.setCurrentColor(currentColor);
        this.label.setBackground(currentColor);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buttonCross){
            this.actionID = 1;
        }
        if(e.getSource() == this.buttonRoute){
            this.actionID = 2;
        }
        if(e.getSource() == this.buttonColor){
            this.actionID = 3;
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedItem = (String) choice.getSelectedItem();
            currentColor = getColorFromOption(selectedItem);
            updateColor();
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(actionID==3){
            System.out.println("Click registered");
            this.canvas.changeShapeColor(e.getX(),e.getY(),currentColor);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(actionID==1){
            this.canvas.startDragPaintCross(e.getX(),e.getY());
        }
        if(actionID==2){
            this.canvas.startDragPaintRoute(e.getX(),e.getY());
        }

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if(actionID==1){
            this.canvas.dragingPaintCross(e.getX(),e.getY());
        }
        if(actionID==2){
            this.canvas.dragingPaintRoute(e.getX(),e.getY());
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(actionID==1){
            this.canvas.endDragPaintCross(e.getX(),e.getY());
        }
        if(actionID==2){
            this.canvas.endDragPaintRoute(e.getX(),e.getY());
        }

    }
}
