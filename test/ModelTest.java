import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ModelTest {
    Model model;

    @BeforeEach
    void setUp() {
        model = Model.getInstance();
    }

    @Test
    void testCrearCoche() {
        Coche coche = model.crearCoche("LaFerrari", "1234ABC");
        assertNotNull(coche);
        assertEquals("1234ABC", coche.getMatricula());
        assertEquals("LaFerrari", coche.getModelo());
        assertEquals(0, coche.getVelocidad());
    }

    @Test
    void testGetCoche() {
        model.crearCoche("LaFerrari", "1234ABC");
        Coche coche = model.getCoche("1234ABC");
        assertNotNull(coche);
        assertEquals("1234ABC", coche.getMatricula());
    }

    @Test
    void testCambiarVelocidad() {
        model.crearCoche("LaFerrari", "1234ABC");
        model.cambiarVelocidad("1234ABC", 180);
        Integer velocidad = model.getVelocidad("1234ABC");
        assertEquals(180, velocidad);
    }

    /**
     * Test unitario para comprobar que la velocidad se sube correctamente
     */
    @Test
    public void subirVelocidadCocheCorrectamente() {
        model.crearCoche("TestCar", "1234");
        model.subirVelocidad("1234", 10);
        Coche coche = model.getCoche("1234");
        assertEquals(10, coche.velocidad);
    }

    /**
     * Test unitario para comprobar que la velocidad se baja correctamente
     */
    @Test
    public void bajarVelocidadCocheCorrectamente() {
        model.crearCoche("TestCar", "1234");
        model.cambiarVelocidad("1234", 50);
        model.bajarVelocidad("1234", 10);
        Coche coche = model.getCoche("1234");
        assertEquals(40, coche.velocidad);
    }

    @Test
    void testGetVelocidad() {
        model.crearCoche("LaFerrari", "1234ABC");
        Integer velocidad = model.getVelocidad("1234ABC");
        assertEquals(0, velocidad);
    }
}
