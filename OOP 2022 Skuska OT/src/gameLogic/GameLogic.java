package gameLogic;

import drawing.DrawingCanvas;
import lombok.Getter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

public class GameLogic extends UniversalAdapter{
    @Getter
    private JLabel lengthLabel;
    @Getter
    private JLabel radiusLabel;
    @Getter
    private JLabel spacingLabel;
    @Getter
    private JSlider lengthSlider;
    @Getter
    private JSlider radiusSlider;
    @Getter
    private JSlider spacingSlider;

    @Getter
    private JComboBox comboBox;

    @Getter
    private DrawingCanvas canvas;

    private int shapeId;

    public GameLogic() {
        this.lengthLabel = new JLabel("Length");
        this.lengthLabel.setFocusable(false);

        this.radiusLabel = new JLabel("Radius");
        this.radiusLabel.setFocusable(false);

        this.spacingLabel = new JLabel("Spacing");
        this.spacingLabel.setFocusable(false);

        this.lengthSlider = new JSlider(JSlider.VERTICAL, 20, 200, 50);
        this.lengthSlider.setSnapToTicks(true);
        this.lengthSlider.setMajorTickSpacing(10);
        this.lengthSlider.setPaintTicks(true);
        this.lengthSlider.setPaintLabels(true);

        this.lengthSlider.setFocusable(false);
        this.lengthSlider.addChangeListener(this);


        this.radiusSlider = new JSlider(JSlider.VERTICAL,1,20,5);
        this.radiusSlider.setSnapToTicks(true);
        this.radiusSlider.setMajorTickSpacing(1);
        this.radiusSlider.setMinorTickSpacing(1);
        this.radiusSlider.setPaintTicks(true);
        this.radiusSlider.setPaintLabels(true);
        this.radiusSlider.setFocusable(false);
        this.radiusSlider.addChangeListener(this);


        this.spacingSlider = new JSlider(JSlider.VERTICAL,1,20,5);
        this.spacingSlider.setSnapToTicks(true);
        this.spacingSlider.setMajorTickSpacing(1);
        this.spacingSlider.setMinorTickSpacing(1);
        this.spacingSlider.setPaintTicks(true);
        this.spacingSlider.setPaintLabels(true);
        this.spacingSlider.setFocusable(false);
        this.spacingSlider.addChangeListener(this);

        this.comboBox = new JComboBox<>();
        this.comboBox.addItem("Square");
        this.comboBox.addItem("Circle");
        this.comboBox.addItem("Hourglass");
        this.comboBox.addItemListener(this);
        this.comboBox.setFocusable(false);

        this.resovleShapeId(this.comboBox.getSelectedItem().toString());


        this.canvas = new DrawingCanvas(this.lengthSlider.getValue(),this.spacingSlider.getValue(),this.radiusSlider.getValue(), shapeId);
        this.canvas.setBackground(Color.ORANGE);
        this.canvas.addMouseMotionListener(this);
        this.canvas.addMouseListener(this);
    }
    private void resovleShapeId(String s){
        switch (s){
            case "Square":
                this.shapeId=1;
                break;
            case "Circle":
                this.shapeId=2;
                break;

            case "Hourglass":
                this.shapeId=3;
                break;
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == this.comboBox){
            this.resovleShapeId(e.getItem().toString());
            this.canvas.setChainShapeId(this.shapeId);

        }
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == this.lengthSlider){
            this.canvas.setChainLength(this.lengthSlider.getValue());
        }
        if(e.getSource() == this.radiusSlider){

            this.canvas.setChainRadius(this.radiusSlider.getValue());
        }
        if(e.getSource() == this.spacingSlider){
            this.canvas.setChainSpacing(this.spacingSlider.getValue());
        }


    }
    @Override
    public void mouseEntered(MouseEvent e) {
        this.canvas.addChainCoordinates(e.getX(),e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {

        this.canvas.addChainCoordinates(e.getX(),e.getY());
    }

}
