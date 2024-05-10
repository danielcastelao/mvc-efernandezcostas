package cod.mvc;

import java.util.ArrayList;

public class Model {

    private ArrayList<Coche> listaCoches = new ArrayList<>();

    /**
     * Crea un coche y lo añade a la lista de coches
     * @param matricula Matrícula del coche
     * @param modelo Modelo del coche
     * @param velocidad Velocidad del coche
     * @return true si se ha creado el coche, false en caso contrario
     */
    public Coche crearCoche(String matricula, String modelo, double velocidad) {
        Coche coche = new Coche(matricula, modelo, velocidad);
        listaCoches.add(coche);
        return coche;
    }

    /**
     * Devuelve un coche a partir de su matrícula
     * @param matricula Matrícula del coche
     * @return Coche con la matrícula especificada
     */
    public Coche getCoche(String matricula) {
        return listaCoches.get(listaCoches.indexOf(new Coche(matricula, "", 0)));
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula Matrícula del coche
     * @param velocidad Nueva velocidad
     */
    public void cambiarVelocidad(String matricula, double velocidad) {
        Coche coche = getCoche(matricula);
        coche.setVelocidad(velocidad);
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