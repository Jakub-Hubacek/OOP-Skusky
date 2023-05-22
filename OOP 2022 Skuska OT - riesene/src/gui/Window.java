package gui;

import gameLogic.GameLogic;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window() {

        JFrame frame = new JFrame("2022 Skuska OT");
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        GameLogic logic = new GameLogic();

        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new BorderLayout());
        sideMenu.setFocusable(false);

        JPanel sliderLabels = new JPanel();
        sliderLabels.setLayout(new GridLayout(1,3));
        sliderLabels.add(logic.getLengthLabel());
        sliderLabels.add(logic.getRadiusLabel());
        sliderLabels.add(logic.getSpacingLabel());
        sliderLabels.setFocusable(false);

        JPanel sliderMenu = new JPanel();
        sliderMenu.setLayout(new GridLayout(1,3));
        sliderMenu.add(logic.getLengthSlider());
        sliderMenu.add(logic.getRadiusSlider());
        sliderMenu.add(logic.getSpacingSlider());
        sliderMenu.setFocusable(false);

        sideMenu.add(sliderLabels,BorderLayout.PAGE_START);
        sideMenu.add(sliderMenu,BorderLayout.CENTER);
        sideMenu.add(logic.getComboBox(),BorderLayout.PAGE_END);

        frame.add(sideMenu,BorderLayout.EAST);
        frame.add(logic.getCanvas(),BorderLayout.CENTER);


        frame.setVisible(true);
    }
}
