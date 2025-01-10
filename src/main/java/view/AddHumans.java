package view;

import model.Human;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddHumans extends JPanel {
    private JTextField nameField, ageField, idField, addressField, phoneNumberField;

    public AddHumans(ActionListener backListener, ActionListener saveListener) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("ID number:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        inputPanel.add(addressField);

        inputPanel.add(new JLabel("Phone number:"));
        phoneNumberField = new JTextField();
        inputPanel.add(phoneNumberField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(saveListener);
        inputPanel.add(saveButton);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(backListener);
        inputPanel.add(backButton);

        add(inputPanel, BorderLayout.CENTER);
    }

    Human getHuman() {
        String name = nameField.getText();
        int age;
        int id;
        String address = addressField.getText();
        String phoneNumber = phoneNumberField.getText();

        if (name.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name, address and phone number are requied fields!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            age = Integer.parseInt(ageField.getText());
            id = Integer.parseInt(idField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age and ID number must be valid numbers!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            ageField.setText("");
            idField.setText("");
            return null;
        }

        nameField.setText("");
        ageField.setText("");
        idField.setText("");
        addressField.setText("");
        phoneNumberField.setText("");

        return new Human(name, age, id, address, phoneNumber);
    }
}
