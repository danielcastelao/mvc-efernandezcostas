import cod.mvc.controller.Controller;
import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ControllerTest {
    private Controller controller;
    private Model model;

    @BeforeEach
    public void setup() {
        model = Model.getInstance();
        controller = new Controller(model);
    }

    @Test
    public void crearCocheconMatriculayModelo() {
        controller.crearCoche("TestCar", "1234");
        Coche coche = model.getCoche("1234");
        assertNotNull(coche);
        assertEquals("TestCar", coche.modelo);
        assertEquals("1234", coche.matricula);
    }

    @Test
    public void cambiarVelocidadCoche() {
        controller.crearCoche("TestCar", "1234");
        controller.cambiarVelocidad("1234", 50);
        Coche coche = model.getCoche("1234");
        assertEquals(50, coche.velocidad);
    }

    /**
     * Test unitario para comprobar que la velocidad se sube correctamente
     */
    @Test
    public void subirVelocidadCocheCorrectamente() {
        controller.crearCoche("TestCar", "1234");
        controller.subirVelocidad("1234", 10);
        Coche coche = model.getCoche("1234");
        assertEquals(10, coche.velocidad);
    }

    /**
     * Test unitario para comprobar que la velocidad se baja correctamente
     */
    @Test
    public void bajarVelocidadCocheCorrectamente() {
        controller.crearCoche("TestCar", "1234");
        controller.cambiarVelocidad("1234", 50);
        controller.bajarVelocidad("1234", 10);
        Coche coche = model.getCoche("1234");
        assertEquals(40, coche.velocidad);
    }

    /**
     * Test para comprobar que la velocidad negativa se pone automáticamente en 0
     */
    @Test
    public void bajarVelocidadPorDebajoDeCero() {
        controller.crearCoche("TestCar", "1234");
        controller.bajarVelocidad("1234", 10);
        Coche coche = model.getCoche("1234");
        assertEquals(0, coche.velocidad);
    }

    // test cambiar velocidad y supera el limite de 120
    @Test
    public void changesCarSpeedAndExceedsLimit() {

        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        controller.crearCoche("TestCocheRapido", "BX5555");
        controller.cambiarVelocidad("BX5555", 150);
        Coche coche = model.getCoche("BX5555");
        assertEquals(120, coche.getVelocidad()); // Va bajando la velocidad hasta los 120

    }


}