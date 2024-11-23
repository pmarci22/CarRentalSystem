package view;



import model.Car;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;


public class ViewCars extends JPanel {
    private DefaultTableModel tableModel;
    private JTable carTable;

    public ViewCars(ActionListener backListener, ActionListener deleteListener) {
        setLayout(new BorderLayout());

        String[] columnNames = {"Make", "Model", "Year", "Color", "Price/Day"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        carTable = new JTable(tableModel);
        carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(carTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(backListener);
        add(backButton, BorderLayout.SOUTH);

        JButton deleteButton = new JButton("Delete Selected Car");
        deleteButton.addActionListener(deleteListener);
        add(deleteButton, BorderLayout.NORTH);
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

    public int getSelectedRow() {
        int n = carTable.getSelectedRow();

        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Please select a car to delete");
        }
        return n;
    }
}
