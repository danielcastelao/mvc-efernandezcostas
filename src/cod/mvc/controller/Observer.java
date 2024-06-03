package cod.mvc.controller;

import cod.mvc.model.Coche;
import cod.mvc.model.Model;


/**
 * Interfaz Observer
 */
public interface Observer {
    // metodo que se ejecutará cuando el objeto observado cambie
    void update(Coche arg, Model model);
}
