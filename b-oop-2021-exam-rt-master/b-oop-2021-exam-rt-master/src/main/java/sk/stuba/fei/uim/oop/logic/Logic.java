package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.App;
import sk.stuba.fei.uim.oop.Canvas;
import sk.stuba.fei.uim.oop.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Logic extends UniversalAdapter{
    @Getter
    private final JLabel infoLabel;
    @Getter
    private final Canvas canvas;
    private Color color;
    private Tree tree;
    public Logic(){
        infoLabel = new JLabel("FUNKCIA");
        this.infoLabel.setForeground(Color.RED);
        canvas = new Canvas();
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
        this.infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.color = Color.RED;

    }

    private void resolveColor() {
        if (this.color == Color.RED) {
            this.color = Color.BLUE;
            this.infoLabel.setForeground(Color.BLUE);
        } else if (this.color == Color.BLUE) {
            this.color = Color.GREEN;
            this.infoLabel.setForeground(Color.GREEN);
        } else {
            this.color = Color.RED;
            this.infoLabel.setForeground(Color.RED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(infoLabel.getText().equals("KRESLENIE")){
            this.tree = new Tree(e.getPoint(), color);
            canvas.getTrees().add(this.tree);
        } else if (infoLabel.getText().equals("PRESÚVANIE")){
            for (Tree t : canvas.getTrees()) {
                if (t.contains(e.getPoint())) {
                    this.tree = t;
                    //break;
                }
            }
        }
        canvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(infoLabel.getText().equals("KRESLENIE")) {
            canvas.getTrees().get(canvas.getTrees().indexOf(tree)).setPosition(e.getPoint());
        } else if (infoLabel.getText().equals("PRESÚVANIE")) {
            for (Tree t : canvas.getTrees()) {
                if (t.contains(e.getPoint())) {
                    this.tree = t;
                    //break;
                }
            }
            tree.setPosition(e.getPoint());
        }
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e){
        if(infoLabel.getText().equals("KRESLENIE")){
        tree = canvas.getTrees().get(canvas.getTrees().indexOf(tree));
        tree.setPosition(e.getPoint());
        } else if (infoLabel.getText().equals("PRESÚVANIE")) {
            for (Tree t : canvas.getTrees()) {
                if (t.contains(e.getPoint())) {
                    this.tree = t;
                    //break;
                }
            }
            tree.setPosition(e.getPoint());
        }
        canvas.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(App.TREE_BUTTON)){
            infoLabel.setText("KRESLENIE");
        } else if (e.getActionCommand().equals(App.MOVE_BUTTON)){
            infoLabel.setText("PRESÚVANIE");
        } else if (e.getActionCommand().equals(App.COLOR_BUTTON)) {
            resolveColor();
        }
    }

}
