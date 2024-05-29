public class Paciente {
    private static int idCounter = 0;
    private int id;
    private String nombreCompleto;

    public Paciente(String nombreCompleto) {
        this.id = ++idCounter;
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    @Override
    public String toString() {
        return "Paciente ID: " + id + ", Nombre: " + nombreCompleto;
    }
}
