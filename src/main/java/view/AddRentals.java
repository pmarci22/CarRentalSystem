package view;

import model.Car;
import model.Human;
import model.Rental;
import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class AddRentals extends JPanel {
    private JComboBox<Car> carComboBox;
    private JComboBox<Human> humanComboBox;
    private JTextField daysField;
    private JTextField priceField;
    private JButton saveButton;

    public AddRentals(ActionListener backAction, ActionListener saveAction) {
        setLayout(new GridLayout(0, 2, 10, 10));

        carComboBox = new JComboBox<>();
        humanComboBox = new JComboBox<>();
        daysField = new JTextField();
        priceField = new JTextField();
        priceField.setEditable(false);

        saveButton = new JButton("Save");
        saveButton.addActionListener(saveAction);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(backAction);

        add(new JLabel("Select Car:"));
        add(carComboBox);
        add(new JLabel("Select Client:"));
        add(humanComboBox);
        add(new JLabel("Days:"));
        add(daysField);
        add(new JLabel("Price:"));
        add(priceField);
        add(saveButton);
        add(backButton);

        daysField.addActionListener(e -> calculatePrice());
    }

    public void updatePanel(List<Car> cars, List<Human> humans) {
        carComboBox.removeAllItems();
        humanComboBox.removeAllItems();

        for (Car car : cars) {
            carComboBox.addItem(car);
        }

        for (Human human : humans) {
            humanComboBox.addItem(human);
        }
    }

    private void calculatePrice() {
        Car selectedCar = (Car) carComboBox.getSelectedItem();
        int days = Integer.parseInt(daysField.getText());
        if (selectedCar != null) {
            int price = selectedCar.getPrice() * days;
            priceField.setText(String.valueOf(price));
        }
    }

    public Rental getRental() {
        Car selectedCar = (Car) carComboBox.getSelectedItem();
        Human selectedHuman = (Human) humanComboBox.getSelectedItem();
        int days;
        int price;
        try {
            days = Integer.parseInt(daysField.getText());
            price = Integer.parseInt(priceField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Days must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            daysField.setText("");
            priceField.setText("");
            return null;
        }

        if (selectedCar != null && selectedHuman != null) {
            priceField.setText("");
            daysField.setText("");
            return new Rental(selectedHuman, selectedCar, days, price);
        } else {
            JOptionPane.showMessageDialog(this, "Car and Client must be selected!", "Error", JOptionPane.ERROR_MESSAGE);
            priceField.setText("");
            daysField.setText("");
            return null;
        }
    }
}