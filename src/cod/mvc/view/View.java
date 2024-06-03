package cod.mvc.view;

import java.util.Scanner;

public class View {
    /**
     * Muestra la velocidad de un coche
     * @param matricula del coche
     * @param v velocidad del coche
     * @return true
     */
    public static boolean muestraVelocidad(String matricula, Integer v){
        System.out.println("[View] " + matricula + ": " + v + "km/hr");
        return true;
    }

    /**
     * Muestra los datos de un coche
     * @param modelo del coche
     * @param matricula del coche
     * @param velocidad del coche
     */
    public static void mostrarDatosCoche(String modelo, String matricula, int velocidad){
        System.out.println("[View] Modelo: "+modelo);
        System.out.println("[View] Matrícula: "+matricula);
        System.out.println("[View] Velocidad: "+velocidad+" km/hr");
        System.out.println();
    }

    /**
     * Solicita la matrícula del coche al usuario
     * @return matrícula del coche
     */
    public static String solicitarMatriculaDelCoche() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Matrícula del coche del que quieres saber los datos: ");
        return scanner.nextLine();
    }

    /**
     * Muestra un mensaje de coche inexistente
     * @param matricula del coche
     */
    public static void mensajeCocheInexistente(String matricula) {
        System.out.println("El coche con matrícula "+matricula+" no existe");
    }
}
