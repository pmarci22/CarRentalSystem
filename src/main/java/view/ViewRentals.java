package view;

import model.Rental;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewRentals extends JPanel {
    private JTable rentalsTable;
    private DefaultTableModel tableModel;

    public ViewRentals(ActionListener backListener) {
        setLayout(new BorderLayout());

        String[] columnNames = {"Human", "Car", "Days", "Price", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        rentalsTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(rentalsTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(backListener);
        add(backButton, BorderLayout.SOUTH);
    }

    public void updatePanel(List<Rental> rentals) {
        tableModel.setRowCount(0);

        for (Rental rental : rentals) {
            Object[] rowData = {
                    rental.getHuman().getName(),
                    rental.getCar().getModel(),
                    rental.getDays(),
                    rental.getPrice(),
                    rental.getCheckInDate()
            };
            tableModel.addRow(rowData);
        }
    }
}
