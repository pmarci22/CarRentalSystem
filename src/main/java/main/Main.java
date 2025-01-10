package main;

import model.Model;
import presenter.Presenter;
import serialization.SerializationUtility;
import view.View;

public class Main {
    public static void main(String[] args) {
        Model model;
        try {
            model = SerializationUtility.deserializeModel("Database.txt");
        } catch (Exception e) {
            System.out.println("No data found. Starting with empty model.");
            System.out.println("Error: " + e.getMessage());
            model = new Model();
        }
        View view = new View();
        Presenter presenter = new Presenter(model, view);

        presenter.mainMenu();
    }
}
