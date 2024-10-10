package view;

import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private Presenter presenter;

    private JPanel titlePanel;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JPanel viewCars, viewHumans, viewRentals;
    private JPanel addCars, addHumans, addRentals;
    private JPanel mainMenuPanel;

    public View() {
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        viewCars = new JPanel();
        viewHumans = new JPanel();
        viewRentals = new JPanel();
        addCars = new JPanel();
        addHumans = new JPanel();
        addRentals = new JPanel();

        mainPanel.add(viewCars, "ViewCars");
        mainPanel.add(viewHumans, "ViewHumans");
        mainPanel.add(viewRentals, "ViewRentals");
        mainPanel.add(addCars, "AddCars");
        mainPanel.add(addHumans, "AddHumans");
        mainPanel.add(addRentals, "AddRentals");

        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainMenuPanel.add(titleLabel);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        String[] buttonLabels = {"View Cars", "View Clients", "View Rentals", "Add Cars", "Add Clients", "Add Rentals"};
        String[] panelNames = {"ViewCars", "ViewHumans", "ViewRentals", "AddCars", "AddHumans", "AddRentals"};

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int buttonWidth = (int) (screenSize.width * 0.2);
        int buttonHeight = (int) (screenSize.height * 0.05);
        Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            String panelName = panelNames[i];
            button.setPreferredSize(buttonSize);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(mainPanel, panelName);
                }
            });
            mainMenuPanel.add(button);
            mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        mainPanel.add(mainMenuPanel, "MainMenu");

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = (int) (screenSize.width * 0.5);
        int height = (int) (screenSize.height * 0.5);
        setSize(width, height);
        setVisible(true);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void showMainMenu() {
        cardLayout.show(mainPanel, "MainMenu");
    }
}