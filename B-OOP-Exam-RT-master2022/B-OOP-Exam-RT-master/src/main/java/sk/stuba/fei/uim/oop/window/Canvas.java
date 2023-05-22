package sk.stuba.fei.uim.oop.window;

import sk.stuba.fei.uim.oop.shapes.Line;
import sk.stuba.fei.uim.oop.shapes.Turtle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {

    private Turtle turtle;

    private List<Line> lines;

    public Canvas(Turtle turtle) {
        super();
        this.turtle = turtle;
        this.lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        this.lines.add(line);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        lines.forEach(l -> l.draw(g));
        turtle.draw(g);
    }
}

