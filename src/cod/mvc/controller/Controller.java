package cod.mvc.controller;

import cod.mvc.model.Model;
import cod.mvc.view.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model){
        this.model = model;
        this.view = new View();

        ObserverVelocidad observerVelocidad = new ObserverVelocidad();
        model.addObserver(observerVelocidad);

        ObserverLimiteVelocidad observerLimiteVelocidad = new ObserverLimiteVelocidad();
        model.addObserver(observerLimiteVelocidad);
    }

    public void crearCoche(String matricula, String modelo){
        model.crearCoche(matricula, modelo);
    }

    public void cambiarVelocidad(String matricula, int velocidad){
        model.cambiarVelocidad(matricula, velocidad);
    }

}
