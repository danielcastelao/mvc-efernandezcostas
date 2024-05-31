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
        model = new Model();
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