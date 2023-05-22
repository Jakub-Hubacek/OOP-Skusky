package controls;

import canvas.DrawingCanvas;
import lombok.*;

import javax.naming.NamingEnumeration;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameLogic extends UniversalAdapter{
    @Getter
    private JComboBox comboBox;
    @Getter
    private JSlider slider;
    @Getter
    private JButton actionButton;
    @Getter
    private JLabel labelSize;
    @Getter
    private JButton colorButton;
    @Getter
    private JLabel labelColor;
    @Getter
    private DrawingCanvas canvas;
    private int colorIndex;
    private Color currentColor;
    private String colorString;
    private ArrayList<Color> colors;
    private ArrayList<String> colorNames;

    private int stepLength;
    private int stepRadius;
    public GameLogic(){
        this.comboBox = new JComboBox<>();
        this.comboBox.addItem(0);
        this.comboBox.addItem(5);
        this.comboBox.addItem(10);
        this.comboBox.addItem(45);
        this.comboBox.addItem(90);
        this.comboBox.addItem(180);

        this.comboBox.setSelectedItem(45);
        this.comboBox.addItemListener(this);
        this.comboBox.setFocusable(false);
        this.slider =new JSlider();
        this.slider.setMinimum(0);
        this.slider.setMaximum(100);
        this.slider.setMajorTickSpacing(10);
        this.slider.setMinorTickSpacing(10);
        this.slider.setSnapToTicks(true);
        this.slider.setPaintLabels(true);
        this.slider.setValue(10);

        this.slider.addChangeListener(this);
        this.slider.setFocusable(false);
        this.slider.addChangeListener(this);

        this.actionButton = new JButton("Action");
        this.actionButton.setFocusable(false);
        this.actionButton.addActionListener(this);

        this.labelSize = new JLabel();
        this.labelSize.setFocusable(false);
        this.labelSize.setOpaque(true);

        this.colorButton = new JButton("Color");
        this.colorButton.setFocusable(false);
        this.colorButton.addActionListener(this);

        this.labelColor = new JLabel();
        this.labelColor.setFocusable(false);
        this.labelColor.setOpaque(true);

        this.canvas = new DrawingCanvas();
        this.canvas.setBackground(Color.YELLOW);
        this.canvas.setFocusable(true);
        this.canvas.addKeyListener(this);

        this.colors = new ArrayList<>();
        this.colors.add(Color.red);
        this.colors.add(Color.blue);
        this.colors.add(Color.green);

        this.colorNames = new ArrayList<>();
        this.colorNames.add("Cervena");
        this.colorNames.add("Modra");
        this.colorNames.add("Zelena");

        this.colorIndex = 0;

        this.currentColor = this.colors.get(colorIndex);
        this.colorString = this.colorNames.get(colorIndex);
        this.nextColor();
        this.updateStepLabel();
    }

    private void updateColorLabel(){
        this.labelColor.setBackground(currentColor);
        this.labelColor.setText(colorString);
    }
    private void updateStepLabel(){
        this.stepLength = this.slider.getValue();
        this.stepRadius = (int)this.comboBox.getSelectedItem();
        this.labelSize.setText("Step: " + stepLength + " Angle: " + stepRadius);
    }
    private void nextColor(){
        this.colorIndex++;
        if(this.colorIndex >= this.colors.size()){
            this.colorIndex = 0;
        }
        this.currentColor = colors.get(colorIndex);
        this.colorString = colorNames.get(colorIndex);
        this.canvas.setCurrentColor(currentColor);
        this.updateColorLabel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.colorButton){
            System.out.println(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner()
            );
            nextColor();
        }
        if(e.getSource() == this.actionButton){
            this.canvas.moveTurtle(this.slider.getValue());
        }
    }


    @Override
    public void itemStateChanged(ItemEvent e) {

        if(e.getSource() == this.comboBox){
            this.updateStepLabel();
            this.canvas.changeTurtleAngle((int)this.comboBox.getSelectedItem());
        }
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        this.updateStepLabel();
    }

    @Override
    public void keyTyped(KeyEvent e) {

        switch (e.getKeyChar()){
            case 'a':
                this.canvas.changeTurtleAngle(-(int)this.comboBox.getSelectedItem());
                break;
            case 'd':
                this.canvas.changeTurtleAngle((int)this.comboBox.getSelectedItem());
                break;
            case 'w':
                this.canvas.moveTurtle(this.slider.getValue());
                break;
            case 's':
                this.canvas.moveTurtle(-this.slider.getValue());
                break;
        }
    }
}
