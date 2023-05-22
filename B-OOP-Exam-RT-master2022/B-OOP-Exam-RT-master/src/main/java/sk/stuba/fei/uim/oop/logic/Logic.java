package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.shapes.Line;
import sk.stuba.fei.uim.oop.shapes.Turtle;
import sk.stuba.fei.uim.oop.window.Canvas;
import sk.stuba.fei.uim.oop.window.ExamRT;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Logic extends UniversalAdapter {

    private final Turtle turtle;
    @Getter
    private final Canvas canvas;
    @Getter
    private JLabel angleLabel;
    @Getter
    private JLabel colorLabel;
    private Color color;
    private int distance;
    private int angle;

    public Logic() {
        this.turtle = new Turtle(400, 300);
        this.canvas = new Canvas(turtle);
        this.color = Color.RED;
        this.angleLabel = new JLabel("0");
        this.colorLabel = new JLabel("RED");
        this.distance = 10;
        this.angle = 45;
        this.updateAngleLabel();
    }

    private Line createLine(int angle) {
        return new Line(turtle.getX(), turtle.getY(), this.distance, angle, this.color);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                canvas.addLine(createLine(turtle.getDegrees()));
                turtle.forward(this.distance);
                break;
            case KeyEvent.VK_DOWN:
                canvas.addLine(createLine(turtle.getDegrees() + 180));
                turtle.backwards(this.distance);
                break;
            case KeyEvent.VK_RIGHT:
                turtle.turnRight(this.angle);
                break;
            case KeyEvent.VK_LEFT:
                turtle.turnLeft(this.angle);
                break;
        }
        canvas.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ExamRT.COLOR)) {
            this.resolveColor();
        } else if (e.getActionCommand().equals(ExamRT.ACTION)) {
            this.resolveAction();
        } else if (e.getSource() instanceof JComboBox) {
            this.angle = (int) ((JComboBox) e.getSource()).getSelectedItem();
            this.updateAngleLabel();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.distance = ((JSlider) e.getSource()).getValue();
        this.updateAngleLabel();
    }

    private void resolveColor() {
        if (this.color == Color.RED) {
            this.color = Color.GREEN;
            this.colorLabel.setText("GREEN");
        } else if (this.color == Color.GREEN) {
            this.color = Color.BLUE;
            this.colorLabel.setText("BLUE");
        } else {
            this.color = Color.RED;
            this.colorLabel.setText("RED");
        }
    }

    private void resolveAction() {
        turtle.turnRight(this.angle);
        canvas.addLine(createLine(turtle.getDegrees()));
        turtle.forward(this.distance);
        canvas.repaint();
    }

    private void updateAngleLabel() {
        this.angleLabel.setText("D: " + this.distance + ", A: " + this.angle);
    }
}
