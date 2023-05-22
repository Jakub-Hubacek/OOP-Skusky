package gui;

import controls.GameLogic;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window() {
        JFrame frame = new JFrame("SKUSKA RT 2019");
        frame.setResizable(false);
        frame.setSize(800,800);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.requestFocusInWindow();
        frame.setLayout(new BorderLayout());


        GameLogic  logic = new GameLogic();


        JPanel menu = new JPanel();
        menu.add(logic.getButtonCross());
        menu.add(logic.getButtonRoute());
        menu.add(logic.getChoice());
        menu.add(logic.getLabel());
        menu.add(logic.getButtonColor());
        menu.setLayout(new GridLayout( 1,5));

        frame.add(logic.getCanvas(),BorderLayout.CENTER);
        frame.add(menu,BorderLayout.PAGE_END);
        frame.setVisible(true);

    }
}
