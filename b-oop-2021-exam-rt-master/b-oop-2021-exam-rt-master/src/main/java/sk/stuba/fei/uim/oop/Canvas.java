package sk.stuba.fei.uim.oop;


import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    @Getter
    private ArrayList<Tree> trees;

    public Canvas() {
        this.trees = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        trees.forEach(t -> t.draw(g));
    }
}
