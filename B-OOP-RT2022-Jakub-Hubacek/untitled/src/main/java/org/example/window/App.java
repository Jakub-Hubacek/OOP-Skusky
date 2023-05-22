package org.example.window;

import org.example.logic.Logic;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    public final static String APP_NAME = "TURTLE DRAW";
    public final static String ACTION = "ACTION";
    public final static String COLOR = "COLOR";

    public App() throws HeadlessException {
        super(APP_NAME);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        JPanel sideMenu = new JPanel();
        Logic logic = new Logic();

        Integer[] angle = {0, 5, 10, 45, 90, 180};
        JComboBox angles = new JComboBox<>(angle);
        angles.setFocusable(false);
        angles.setSelectedIndex(3);
        angles.addActionListener(logic);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(10);
        slider.setSnapToTicks(true);
        slider.setFocusable(false);
        slider.addChangeListener(logic);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);

        JButton action = new JButton(ACTION);
        action.setFocusable(false);
        action.addActionListener(logic);
        JButton color = new JButton(COLOR);
        color.setFocusable(false);
        color.addActionListener(logic);

        sideMenu.setLayout(new GridLayout(2,3));
        sideMenu.add(angles);
        sideMenu.add(slider);
        sideMenu.add(action);
        sideMenu.add(logic.getAngleLabel());
        sideMenu.add(color);
        sideMenu.add(logic.getColorLabel());


        this.add(sideMenu, BorderLayout.PAGE_END);
        this.add(logic.getCanvas(), BorderLayout.CENTER);
        this.addKeyListener(logic);
        this.setFocusable(true);
        this.setVisible(true);





    }

}
