package presenter;

import model.Model;
import view.View;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void mainMenu() {
        view.showMainMenu();
    }
}
