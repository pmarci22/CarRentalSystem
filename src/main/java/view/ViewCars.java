package view;



import model.Car;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;


public class ViewCars extends JPanel {
    private DefaultTableModel tableModel;

    public ViewCars(ActionListener backListener) {
        setLayout(new BorderLayout());

        String[] columnNames = {"Make", "Model", "Year", "Color", "Price/Day"};
        tableModel = new DefaultTableModel(columnNames, 0);

        JTable carTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(carTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(backListener);
        add(backButton, BorderLayout.SOUTH);
    }

    public void updatePanel(List<Car> cars) {
        tableModel.setRowCount(0);
        for (Car car : cars) {
            Object[] rowData = {
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getColor(),
                    car.getPrice(),
            };
            tableModel.addRow(rowData);
        }
    }
}
