package view;

import model.Human;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewHumans extends JPanel {
    private DefaultTableModel tableModel;

    public ViewHumans(ActionListener backListener) {
        setLayout(new BorderLayout());

        String[] columnNames = {"Name", "Age", "ID number", "Address", "Phone number"};
        tableModel = new DefaultTableModel(columnNames, 0);

        JTable humanTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(humanTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(backListener);
        add(backButton, BorderLayout.SOUTH);
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
}
