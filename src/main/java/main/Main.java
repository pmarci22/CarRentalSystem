package main;

import model.Model;
import presenter.Presenter;
import view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Presenter presenter = new Presenter(model, view);

        presenter.mainMenu();
    }
}
