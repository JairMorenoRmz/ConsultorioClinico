import java.util.HashMap;
import java.util.Map;

public class Administrador {
    private static Map<String, String> administradores = new HashMap<>();

    static {
        administradores.put("Sysadmin1", "password1");
        administradores.put("Sysadmin2", "password2");
    }

    public static boolean autenticar(String id, String contraseña) {
        return administradores.containsKey(id) && administradores.get(id).equals(contraseña);
    }
}
