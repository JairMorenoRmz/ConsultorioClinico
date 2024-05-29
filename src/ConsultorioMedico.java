import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultorioMedico {
    private static List<Doctor> doctores = new ArrayList<>();
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Cita> citas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (!controlDeAcceso()) {
            System.out.println("Acceso denegado. Usuario o contraseña incorrectos.");
            return;
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    altaDoctor();
                    break;
                case 2:
                    altaPaciente();
                    break;
                case 3:
                    crearCita();
                    break;
                case 4:
                    mostrarCitas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private static boolean controlDeAcceso() {
        System.out.print("Ingrese su ID de administrador: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();
        return Administrador.autenticar(id, contraseña);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Dar de alta doctor");
        System.out.println("2. Dar de alta paciente");
        System.out.println("3. Crear cita");
        System.out.println("4. Mostrar citas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void altaDoctor() {
        try {
            System.out.print("Ingrese el nombre completo del doctor: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la especialidad del doctor: ");
            String especialidad = scanner.nextLine();
            Doctor doctor = new Doctor(nombre, especialidad);
            doctores.add(doctor);
            System.out.println("Doctor dado de alta exitosamente: " + doctor);
            System.out.println("ID del Doctor: " + doctor.getId()); // Mostrar el ID del doctor
        } catch (Exception e) {
            System.out.println("Error al dar de alta al doctor: " + e.getMessage());
        }
    }

    private static void altaPaciente() {
        try {
            System.out.print("Ingrese el nombre completo del paciente: ");
            String nombre = scanner.nextLine();
            Paciente paciente = new Paciente(nombre);
            pacientes.add(paciente);
            System.out.println("Paciente dado de alta exitosamente: " + paciente);
        } catch (Exception e) {
            System.out.println("Error al dar de alta al paciente: " + e.getMessage());
        }
    }

    private static void crearCita() {
        try {
            if (doctores.isEmpty() || pacientes.isEmpty()) {
                System.out.println("No hay doctores o pacientes registrados.");
                return;
            }

            System.out.print("Ingrese la fecha y hora de la cita (formato: yyyy-MM-dd HH:mm): ");
            String fechaHoraStr = scanner.nextLine();
            LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            System.out.print("Ingrese el motivo de la cita: ");
            String motivo = scanner.nextLine();

            System.out.println("Doctores disponibles:");
            for (Doctor doctor : doctores) {
                System.out.println(doctor);
            }
            System.out.print("Ingrese el ID del doctor: ");
            int doctorId = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            System.out.println("Pacientes registrados:");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
            System.out.print("Ingrese el ID del paciente: ");
            int pacienteId = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            Doctor doctor = doctores.stream().filter(d -> d.getId() == doctorId).findFirst().orElse(null);
            Paciente paciente = pacientes.stream().filter(p -> p.getId() == pacienteId).findFirst().orElse(null);

            if (doctor == null || paciente == null) {
                System.out.println("Doctor o paciente no encontrado.");
                return;
            }

            Cita cita = new Cita(fechaHora, motivo, doctor, paciente);
            citas.add(cita);
            System.out.println("Cita creada exitosamente: " + cita);
        } catch (Exception e) {
            System.out.println("Error al crear la cita: " + e.getMessage());
        }
    }

    private static void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        for (Cita cita : citas) {
            System.out.println(cita);
        }
    }
}
