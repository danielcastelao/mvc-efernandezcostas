package cod.mvc.controller;

import cod.mvc.model.Coche;
import cod.mvc.view.View;

public class ObserverVelocidad implements Observer {
    @Override
    public void update(Coche coche) {
        System.out.println("(ObserverVelocidad) La velocidad del coche "+coche.getMatricula()+" ha cambiado a: "+coche.getVelocidad()+" km/h");

        View.muestraVelocidad(coche.getMatricula(), coche.getVelocidad());
    }
}
