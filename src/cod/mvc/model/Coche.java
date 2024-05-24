package cod.mvc.model;

public class Coche {
    private String matricula;
    private String modelo;
    private int velocidad;

    public Coche(String matricula, String modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.velocidad = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)    return true;
        if (obj == null || obj.getClass() != this.getClass())   return false;
        Coche coche = (Coche) obj;
        return this.matricula.equals(coche.matricula);
    }
}
