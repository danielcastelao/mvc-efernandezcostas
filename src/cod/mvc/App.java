package cod.mvc;

import cod.mvc.controller.Controller;
import cod.mvc.model.Model;

/**
 * Clase principal
 */
public class App {


    public static void main(String[] args) {
        // Inicializamos la app
        // instanciamos el modelo
        Model miModel = Model.getInstance();
        // instanciamos el controlador
        // le pasamos el Model instanciado
        Controller miController = new Controller(miModel);

        // Crear tres coches
        miController.crearCoche("BMW", "SPQ 5432");
        miController.crearCoche("Audi", "JFK 9876");
        miController.crearCoche("Mercedes", "MNO 8546");

        // Cambiar la velocidad de un coche
        miController.bajarVelocidad("SPQ 5432", 50);

        // otro cambio de velocidad
        // sobrepasando la velocidad máxima
        miController.subirVelocidad("JFK 9876", 140);

        // Buscar un coche por su matrícula
        miController.buscarCoche();

        // Cambiar la velocidad de un coche para volver a buscarlo
        miController.subirVelocidad("SPQ 5432", 100);
        miController.buscarCoche();
    }
}