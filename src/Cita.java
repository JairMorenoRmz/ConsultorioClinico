import java.time.LocalDateTime;

public class Cita {
    private static int idCounter = 0;
    private int id;
    private LocalDateTime fechaHora;
    private String motivo;
    private Doctor doctor;
    private Paciente paciente;

    public Cita(LocalDateTime fechaHora, String motivo, Doctor doctor, Paciente paciente) {
        this.id = ++idCounter;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public String toString() {
        return "Cita ID: " + id + ", Fecha y Hora: " + fechaHora + ", Motivo: " + motivo +
                ", Doctor: " + doctor.getNombreCompleto() + ", Paciente: " + paciente.getNombreCompleto();
    }
}
