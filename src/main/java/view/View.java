package view;

import model.Car;
import model.Human;
import model.Rental;
import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class View extends JFrame {
    private Presenter presenter;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    private ViewCars viewCars;
    private AddCars addCars;

    private ViewHumans viewHumans;
    private AddHumans addHumans;

    private ViewRentals viewRentals;
    private AddRentals addRentals;

    private JPanel mainMenuPanel;

    public View() {
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        viewCars = new ViewCars(e -> showMainMenu(), e-> removeCar());
        addCars = new AddCars(e -> showMainMenu(), e -> saveCar());
        viewHumans = new ViewHumans(e -> showMainMenu(), e-> removeHuman());
        viewRentals = new ViewRentals(e -> showMainMenu(), e -> removeRental(), e -> checkInRental());
        addHumans = new AddHumans(e -> showMainMenu(), e -> saveHuman());
        addRentals = new AddRentals(e -> showMainMenu(), e -> saveRental());

        mainPanel.add(viewCars, "ViewCars");
        mainPanel.add(viewHumans, "ViewHumans");
        mainPanel.add(viewRentals, "ViewRentals");
        mainPanel.add(addCars, "AddCars");
        mainPanel.add(addHumans, "AddHumans");
        mainPanel.add(addRentals, "AddRentals");

        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridLayout(4, 2));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int fontSize = (int) (screenSize.height * 0.03);
        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        mainMenuPanel.add(titleLabel);
        mainMenuPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        String[] buttonLabels = {"View Cars", "Add Car", "View Rentals", "Add Rental", "View Clients", "Add Client"};
        String[] panelNames = {"ViewCars", "AddCars", "ViewRentals", "AddRentals", "ViewHumans", "AddHumans"};


        int buttonWidth = (int) (screenSize.width * 0.2);
        int buttonHeight = (int) (screenSize.height * 0.07);
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
            } else if(panelName.equals("ViewHumans")) {
                button.addActionListener(e -> {
                    refreshViewHumans();
                    cardLayout.show(mainPanel, panelName);
                });
            } else if(panelName.equals("ViewRentals")) {
                button.addActionListener(e -> {
                    refreshViewRentals();
                    cardLayout.show(mainPanel, panelName);
                });
            } else if(panelName.equals("AddRentals")) {
                button.addActionListener(e -> {
                    refreshAddRentals();
                    cardLayout.show(mainPanel, panelName);
                });
            } else {
                button.addActionListener(e -> cardLayout.show(mainPanel, panelName));
            }
            mainMenuPanel.add(button);
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

    public void refreshViewHumans() {
        viewHumans.updatePanel(presenter.getHumanList());
    }

    public void refreshViewRentals() {
        viewRentals.updatePanel(presenter.getRentalList());
    }

    public void refreshAddRentals() {
        addRentals.updatePanel(presenter.getCarList(), presenter.getHumanList());
    }

    public void saveCar() {
        Car c = addCars.getCar();

        if (c != null){
            presenter.addCar(c);
        }

        showMainMenu();
    }

    public void removeCar() {
        int n = viewCars.getSelectedRow();

        if (n != -1){
            presenter.removeCar(n);
        }

        showMainMenu();
    }

    public void saveHuman() {
        Human h = addHumans.getHuman();

        if (h != null){
            presenter.addHuman(h);
        }

        showMainMenu();
    }

    public void removeHuman() {
        int n = viewHumans.getSelectedRow();

        if (n != -1){
            presenter.removeHuman(n);
        }

        showMainMenu();
    }

    public void saveRental() {
        Rental r = addRentals.getRental();

        if (r != null){
            presenter.addRental(r);
        }

        showMainMenu();
    }

    public void removeRental() {
        int n = viewRentals.getSelectedRow();

        if (n != -1){
            presenter.removeRental(n);
        }

        showMainMenu();
    }

    public void checkInRental() {
        int n = viewRentals.getSelectedRow();
        int response;

        if(n != -1) {
            response = JOptionPane.showConfirmDialog(
                    this,
                    "Is everything ok with the car?",
                    "Car Check",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                Rental r = presenter.getRentalList().get(n);
                r.setCheckInDate(LocalDate.now());
            }

            if (response == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Call Client to solve the issue!");
            }
        }
        showMainMenu();
    }
}