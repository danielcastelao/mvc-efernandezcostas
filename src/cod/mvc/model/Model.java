package cod.mvc.model;

import cod.mvc.controller.Observer;

import java.util.ArrayList;

public class Model implements Observable {

    private ArrayList<Coche> listaCoches = new ArrayList<>();
    private ArrayList<Observer> listaObservers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        listaObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        listaObservers.remove(observer);
    }

    @Override
    public void notifyObservers(Coche coche) {
        for (Observer observer : listaObservers){
            observer.update(coche);
        }
    }

    /**
     * Crea un coche y lo añade a la lista de coches
     * @param matricula Matrícula del coche
     * @param modelo Modelo del coche
     * @return true si se ha creado el coche, false en caso contrario
     */
    public Coche crearCoche(String matricula, String modelo) {
        Coche coche = new Coche(matricula, modelo);
        listaCoches.add(coche);
        return coche;
    }

    /**
     * Devuelve un coche a partir de su matrícula
     * @param matricula Matrícula del coche
     * @return Coche con la matrícula especificada
     */
    public Coche getCoche(String matricula) {
        Coche temporal = new Coche(matricula, "");
        return listaCoches.get(listaCoches.indexOf(temporal));
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula Matrícula del coche
     * @param velocidad Nueva velocidad
     */
    public void cambiarVelocidad(String matricula, int velocidad) {
        Coche coche = getCoche(matricula);
        coche.setVelocidad(velocidad);
        notifyObservers(coche);
    }

    /**
     * Devuelve la velocidad de un coche
     * @param matricula Matrícula del coche
     * @return Velocidad del coche
     */
    public double getVelocidad(String matricula) {
        return getCoche(matricula).getVelocidad();
    }

    public ArrayList<Coche> getListaCoches() {
        return listaCoches;
    }

}