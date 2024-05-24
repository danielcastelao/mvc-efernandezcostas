package cod.mvc.controller;

import cod.mvc.model.Coche;

public class ObserverLimiteVelocidad implements Observer{
    @Override
    public void update(Coche coche) {
        if (coche.getVelocidad()>120){
            System.out.println("(ObserverLimiteVelocidad) Infracción de velocidad");
        }
    }
}
