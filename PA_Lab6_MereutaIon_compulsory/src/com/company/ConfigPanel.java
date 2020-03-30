package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final Main frame;
    public JLabel label;
    public JSpinner spinner;
    public JComboBox combobox;

    public ConfigPanel(Main frame) {
        this.frame = frame;
        init();
    }
    public void init() {
        label = new JLabel("SIDES");
        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spinner.setValue(4);
        String color[] = {"Blue", "Black"};
        combobox = new JComboBox(color);
        JButton button = new JButton("CHANGE");
        button.addActionListener(this::Change);
        add(button);
        add(label);
        add(spinner);
        add(combobox);
    }
    private void Change (ActionEvent event) {
        frame.drawingPanel.setSides((int)spinner.getValue());
        Random random = new Random();
        int r = random.nextInt(10);
        System.out.println(frame.configPanel.combobox.getSelectedItem().toString());

    }
}
