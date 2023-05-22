package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.logic.Logic;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    public static final String APP_NAME = "RT 2021";
    public static final String TREE_BUTTON = "Strom";
    public static final String MOVE_BUTTON = "Presun";
    public static final String COLOR_BUTTON = "Ďalšia farba";


    public App () throws HeadlessException{
        super(APP_NAME);
        Logic logic = new Logic();
        this.setSize(800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout());



        JButton tree = new JButton(TREE_BUTTON);
        tree.addActionListener(logic);
        tree.setFocusable(false);
        JButton move = new JButton(MOVE_BUTTON);
        move.addActionListener(logic);
        move.setFocusable(false);
        JButton color = new JButton(COLOR_BUTTON);
        color.addActionListener(logic);
        color.setFocusable(false);
        JPanel bottomMenu = new JPanel();
        bottomMenu.setLayout(new GridLayout(1,4));
        bottomMenu.setFocusable(false);
        bottomMenu.add(tree);
        bottomMenu.add(move);
        bottomMenu.add(color);
        bottomMenu.add(logic.getInfoLabel());
        this.add(BorderLayout.PAGE_END, bottomMenu);
        this.add(BorderLayout.CENTER, logic.getCanvas());
        this.setVisible(true);
    }


}
