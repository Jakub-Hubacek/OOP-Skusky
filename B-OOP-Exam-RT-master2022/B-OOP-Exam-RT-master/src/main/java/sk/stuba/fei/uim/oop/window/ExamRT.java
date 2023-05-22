package sk.stuba.fei.uim.oop.window;

import sk.stuba.fei.uim.oop.logic.Logic;

import javax.swing.*;
import java.awt.*;

public class ExamRT extends JFrame {

    public static final String APP_NAME = "Exam RT";
    public static final String COLOR = "COLOR";
    public static final String ACTION = "ACTION";

    public ExamRT() throws HeadlessException {
        super(APP_NAME);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        JPanel sideMenu = new JPanel();
        Logic logic = new Logic();

        Integer[] angle = {0, 5, 10, 45, 90, 180};
        JComboBox angles = new JComboBox(angle);
        angles.setSelectedIndex(3);
        angles.addActionListener(logic);
        angles.setFocusable(false);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(10);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(logic);
        slider.setFocusable(false);

        JButton action = new JButton(ACTION);
        action.addActionListener(logic);
        action.setFocusable(false);
        JButton color = new JButton(COLOR);
        color.addActionListener(logic);
        color.setFocusable(false);

        sideMenu.setLayout(new GridLayout(2, 3));
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
