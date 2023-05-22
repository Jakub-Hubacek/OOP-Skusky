package gui;

import controls.GameLogic;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window() {
        JFrame frame = new JFrame("SKUSKA RT");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.setLayout(new BorderLayout());

        GameLogic logic = new GameLogic();
        JPanel menu = new JPanel();
        menu.add(logic.getTreeButton());
        menu.add(logic.getHouseButton());
        menu.add(logic.getRouteButton());
        menu.add(logic.getCurrentColorLabel());
        menu.setLayout(new GridLayout(1,4));

        frame.add(logic.getCanvas(),BorderLayout.CENTER);
        frame.add(menu,BorderLayout.PAGE_END);
        frame.setVisible(true);
    }
}
