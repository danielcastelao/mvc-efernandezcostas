package cod.mvc;

import cod.mvc.controller.Controller;
import cod.mvc.model.Model;

public class App {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        controller.crearCoche("1234", "Fiat");
        controller.crearCoche("0986", "Seat");
        controller.cambiarVelocidad("1234", 100);
        controller.cambiarVelocidad("0986", 200);
    }
}