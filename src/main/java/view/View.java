package view;

import model.Car;
import presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Presenter presenter;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    private ViewCars viewCars;
    private AddCars addCars;

    private JPanel viewHumans, viewRentals;
    private JPanel addHumans, addRentals;
    private JPanel mainMenuPanel;

    public View() {
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        viewCars = new ViewCars(e -> showMainMenu());
        addCars = new AddCars(e -> showMainMenu(), e -> saveCar());
        viewHumans = new JPanel();
        viewRentals = new JPanel();
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

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int fontSize = (int) (screenSize.height * 0.03);
        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        mainMenuPanel.add(titleLabel);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        String[] buttonLabels = {"View Cars", "View Clients", "View Rentals", "Add Cars", "Add Clients", "Add Rentals"};
        String[] panelNames = {"ViewCars", "ViewHumans", "ViewRentals", "AddCars", "AddHumans", "AddRentals"};


        int buttonWidth = (int) (screenSize.width * 0.2);
        int buttonHeight = (int) (screenSize.height * 0.05);
        Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            String panelName = panelNames[i];
            button.setPreferredSize(buttonSize);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            if (panelName.equals("ViewCars")) {
                button.addActionListener(e -> {
                    refreshViewCars();
                    cardLayout.show(mainPanel, panelName);
                });
            } else {
                button.addActionListener(e -> cardLayout.show(mainPanel, panelName));
            }
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

    public void refreshViewCars() {
        viewCars.updatePanel(presenter.getCarList());
    }

    public void saveCar() {
        Car c = addCars.getCar();

        if (c != null){
            presenter.addCar(c);
        }

        showMainMenu();
    }
}