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

    public ViewRentals(ActionListener backListener, ActionListener deleteListener, ActionListener checkinListener) {
        setLayout(new BorderLayout());

        String[] columnNames = { "Human", "Car", "Days", "Price", "Status" };
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        rentalsTable = new JTable(tableModel);
        rentalsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(rentalsTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(backListener);
        add(backButton, BorderLayout.SOUTH);

        JButton deleteButton = new JButton("Delete Selected Rental");
        deleteButton.addActionListener(deleteListener);
        add(deleteButton, BorderLayout.NORTH);

        JButton checkinbutton = new JButton("Check in Selected Rental");
        checkinbutton.addActionListener(checkinListener);
        add(checkinbutton, BorderLayout.WEST);
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

    public int getSelectedRow() {
        int n = rentalsTable.getSelectedRow();

        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Please select a rental");
        }
        return n;
    }
}
