import cod.mvc.model.Coche;
import cod.mvc.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelTest {
    Model model;

    @BeforeEach
    public void setUp() {
        model = new Model();
    }

    /**
     * Test para comprobar que se crea un coche correctamente
     */
    @Test
    public void testCrearCoche() {
        Coche coche = new Coche("1234ABC", "Seat", 100);
        assertEquals(coche, model.crearCoche("1234ABC", "Seat", 100));
    }

    /**
     *
     */
    @Test
    public void testCocheEnLista() {
        Coche coche = model.crearCoche("1234ABC", "Seat", 100);
        assertTrue(model.getListaCoches().contains(coche));
    }

    /**
     * Test para comprobar que se crea un coche y se devuelve correctamente
     */
    @Test
    public void testGetCoche() {
        model.crearCoche("1234ABC", "Seat", 100);
        assertEquals(new Coche("1234ABC", "Seat", 100), model.getCoche("1234ABC"));
    }

    /**
     * Test para comprobar que se cambia la velocidad de un coche
     */
    @Test
    public void testCambiarVelocidad() {
        model.crearCoche("1234ABC", "Seat", 100);
        model.cambiarVelocidad("1234ABC", 200);
        assertEquals(200, model.getVelocidad("1234ABC"));
    }

    /**
     * Test para comprobar que se devuelve la velocidad de un coche
     */
    @Test
    public void testGetVelocidad() {
        model.crearCoche("1234ABC", "Seat", 100);
        assertEquals(100, model.getVelocidad("1234ABC"));
    }
}
