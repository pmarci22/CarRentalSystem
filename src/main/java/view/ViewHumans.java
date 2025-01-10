package view;

import model.Human;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewHumans extends JPanel {
    private DefaultTableModel tableModel;
    private JTable humanTable;

    public ViewHumans(ActionListener backListener, ActionListener deleteListener) {
        setLayout(new BorderLayout());

        String[] columnNames = { "Name", "Age", "ID number", "Address", "Phone number" };
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        humanTable = new JTable(tableModel);
        humanTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(humanTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(backListener);
        add(backButton, BorderLayout.SOUTH);

        JButton deleteButton = new JButton("Delete Selected Client");
        deleteButton.addActionListener(deleteListener);
        add(deleteButton, BorderLayout.NORTH);
    }

    public void updatePanel(List<Human> humans) {
        tableModel.setRowCount(0);
        for (Human human : humans) {
            Object[] rowData = {
                    human.getName(),
                    human.getAge(),
                    human.getIdnumber(),
                    human.getAddress(),
                    human.getPhoneNumber(),
            };
            tableModel.addRow(rowData);
        }
    }

    public int getSelectedRow() {
        int n = humanTable.getSelectedRow();

        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Please select a Client to delete");
        }
        return n;
    }
}
