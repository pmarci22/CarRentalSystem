package view;

import model.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddCars extends JPanel {
    private JTextField makeField, modelField, yearField, colorField, priceField;

    public AddCars(ActionListener backListener, ActionListener saveListener) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        inputPanel.add(new JLabel("Make:"));
        makeField = new JTextField();
        inputPanel.add(makeField);

        inputPanel.add(new JLabel("Model:"));
        modelField = new JTextField();
        inputPanel.add(modelField);

        inputPanel.add(new JLabel("Year:"));
        yearField = new JTextField();
        inputPanel.add(yearField);

        inputPanel.add(new JLabel("Color:"));
        colorField = new JTextField();
        inputPanel.add(colorField);

        inputPanel.add(new JLabel("Price/Day:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(saveListener);
        inputPanel.add(saveButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(backListener);
        inputPanel.add(backButton);

        add(inputPanel, BorderLayout.CENTER);
    }

    Car getCar() {
        String make = makeField.getText();
        String model = modelField.getText();
        int year;
        String color = colorField.getText();
        int price;

        if (make.isEmpty() || model.isEmpty() || color.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Make, model, and color are required fields.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            year = Integer.parseInt(yearField.getText());
            price = Integer.parseInt(priceField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Year and Price must be valid numbers!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            yearField.setText("");
            priceField.setText("");
            return null;
        }

        makeField.setText("");
        modelField.setText("");
        yearField.setText("");
        colorField.setText("");
        priceField.setText("");

        return new Car(make, model, year, color, price);
    }
}
