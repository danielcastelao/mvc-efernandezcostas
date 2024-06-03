package cod.mvc.controller;

import cod.mvc.model.Coche;
import cod.mvc.model.Model;

/**
 * Otro observador que se suscribe a los cambios de velocidad de un coche
 */
public class ObserverLimiteVelocidad implements Observer {
    // velocidad máxima
    final static int LIMITE = 120;
    /**
     * Este es el observador de limite de velocidad
     * @param coche Coche al que se le actualizó la velocidad
     */
    @Override
    public void update(Coche coche, Model model) {
        /* Si la velocidad se pasa del límite va bajando de 10 en 10 */
        if(coche.velocidad>LIMITE){
            System.out.println("INFRACCION"+
                    "\nSe ha reducido la velocidad");
            model.bajarVelocidad(coche.matricula, 10);
        }

        /* Si la velocidad llega a ser negativa, se pone velocidad 0 */
        if (coche.velocidad<0){
            System.out.println("INFRACCION\nLa velocidad no puede ser negativa");
            model.cambiarVelocidad(coche.matricula, 0);
        }
    }
}
