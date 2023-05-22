package gui;

import controls.GameLogic;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window() {

        JFrame frame = new JFrame("2022 SKUSKA RT");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.setFocusable(true);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        GameLogic logic = new GameLogic();


        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(2,3));
        menu.add(logic.getComboBox());
        menu.add(logic.getSlider());
        menu.add(logic.getActionButton());
        menu.add(logic.getLabelSize());
        menu.add(logic.getColorButton());
        menu.add(logic.getLabelColor());

        frame.add(logic.getCanvas());
        frame.add(menu,BorderLayout.PAGE_END);
        frame.setVisible(true);
        logic.getCanvas().changeTurtleCoordinates(logic.getCanvas().getSize().width/2,logic.getCanvas().getSize().height/2);
        logic.getCanvas().requestFocusInWindow();
        System.out.println(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());

    }
}
