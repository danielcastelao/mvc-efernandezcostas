package cod.mvc;

public class Coche {
    private String matricula;
    private String modelo;
    private double velocidad;

    public Coche(String matricula, String modelo, double velocidad) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getVelocidad() {
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
