package org.example.logic;


import lombok.Getter;
import org.example.shapes.Line;
import org.example.shapes.Turtle;
import org.example.window.Canvas;
import org.example.window.App;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Logic extends UniversalAdapter {
    private Turtle turtle;
    @Getter
    private Canvas canvas;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(App.ACTION)) {
            resolveAction();
        } else if (e.getActionCommand().equals(App.COLOR)) {
            resolveColor();
        } else if (e.getSource() instanceof JComboBox) {
            this.angle = (int) ((JComboBox) e.getSource()).getSelectedItem();
            updateAngleLabel();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                canvas.addLine(createLine(turtle.getDegrees()));
                turtle.forward(distance);
                break;
            case KeyEvent.VK_DOWN:
                canvas.addLine(createLine(turtle.getDegrees() + 180));
                turtle.backwards(distance);
                break;
            case KeyEvent.VK_LEFT:
                turtle.rotateLeft(this.angle);
                break;
            case KeyEvent.VK_RIGHT:
                turtle.rotateRight(this.angle);
                break;
        }
        canvas.repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.distance = ((JSlider) e.getSource()).getValue();
        this.updateAngleLabel();

    }

    private void resolveAction() {
        turtle.rotateRight(angle);
        canvas.addLine(createLine(turtle.getDegrees()));
        turtle.forward(distance);
        canvas.repaint();

    }

    private Line createLine(int angle) {
        return new Line(turtle.getX(), turtle.getY(), this.distance, angle, this.color);
    }


    private void resolveColor() {
        if (this.color == Color.RED) {
            this.color = Color.BLUE;
            this.colorLabel.setText("BLUE");
        } else if (this.color == Color.BLUE) {
            this.color = Color.GREEN;
            this.colorLabel.setText("GREEN");
        } else {
            this.color = Color.RED;
            this.colorLabel.setText("RED");
        }
    }


    private void updateAngleLabel() {
        this.angleLabel.setText("D: " + this.distance + ", A: " + this.angle);
    }
}
