package cod.mvc.model;

import cod.mvc.controller.Observer;

import java.util.ArrayList;



/**
 * Vamos a usar la interface Observable
 * El Model será el encargado de notificar a los observadores
 */
public class Model implements Observable {
    private static Model instance = null;

    // array de coches
    static ArrayList<Coche> parking = new ArrayList<>();

    // para los observadores
    private static final ArrayList<Observer> observers = new ArrayList<Observer>();

    private Model(){ }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifica a los observadores
     * Se ejecutara el método update() de cada observador
     * @param coche
     */
    @Override
    public void notifyObservers(Coche coche,Model model) {
        for (Observer observer : observers) {
            observer.update(coche,model);
        }
    }


    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Método que cambia la velocidad, por lo tanto
     * tendrá que avisar al controlador que ha cambiado
     *
     * @param matricula identificador del coche
     * @param v nueva velocidad
     */
    public void cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;

        // lo notificamos a todos los observadores
        notifyObservers(getCoche(matricula),this);

    }

    /**
     * Devuelve la velocidad según la matrícula
     * @param matricula identificador del coche
     * @return velocidad del coche actual
     */
    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}