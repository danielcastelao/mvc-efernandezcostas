package cod.mvc.controller;

import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import cod.mvc.view.View;

public class Controller{

    // definimos la instancia del modelo
    private final Model miModel;

    /**
     * Constructor. Inicializamos el controller
     * Creamos los observadores que necesitamos
     * @param miModel
     */
    public Controller(Model miModel){
        this.miModel = Model.getInstance();

        // instanciamos al observador de la velocidad
        ObserverVelocidad observoVelocidad = new ObserverVelocidad();
        miModel.addObserver(observoVelocidad);

        // instanciamos un segundo observador para el limite de velocidad
        ObserverLimiteVelocidad observoLimite = new ObserverLimiteVelocidad();
        miModel.addObserver(observoLimite);
    }

    /**
     * Crea un coche
     * @param nombre del coche
     * @param matricula del coche
     */
    public void crearCoche(String nombre, String matricula){
        miModel.crearCoche(nombre, matricula);
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula del coche
     * @param velocidad nueva
     */
    public void cambiarVelocidad(String matricula, Integer velocidad){
        miModel.cambiarVelocidad(matricula, velocidad);
    }

    /**
     * Busca un coche y muestra sus datos en view por su matrícula
     */
    public void buscarCoche(){
        String matricula = View.solicitarMatriculaDelCoche();

        System.out.println("[Controller] Buscando coche con matrícula "+matricula);
        Coche coche = miModel.getCoche(matricula);
        if (coche == null){
            View.mensajeCocheInexistente(matricula);
        } else {
            View.mostrarDatosCoche(matricula, coche.modelo, coche.velocidad);
        }
    }
}
