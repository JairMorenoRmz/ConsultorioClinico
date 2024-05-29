public class Doctor {
    private static int idCounter = 0;
    private int id;
    private String nombreCompleto;
    private String especialidad;

    public Doctor(String nombreCompleto, String especialidad) {
        this.id = ++idCounter;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + ", Nombre: " + nombreCompleto + ", Especialidad: " + especialidad;
    }
}
