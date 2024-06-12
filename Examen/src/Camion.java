import java.io.Serializable;

public class Camion implements Serializable {
    private String empresa;
    private int capacidad;

    public Camion(String empresa, int capacidad) {
        this.empresa = empresa;
        this.capacidad = capacidad;
    }

    public String getEmpresa() {
        return empresa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Camion {" +
                "empresa='" + empresa + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
