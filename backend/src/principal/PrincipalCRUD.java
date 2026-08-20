package principal;

import dao.UsuarioDAO;
import modelo.Usuario;

import java.util.List;

/**
 * Clase principal para probar las operaciones CRUD de usuarios.
 */
public class PrincipalCRUD {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Crear la tabla.
        usuarioDAO.crearTabla();

        // CREATE: registrar usuario.
        Usuario usuario = new Usuario(
                "Santiago Pastrana",
                "santiago@comfey.com",
                "123456",
                "Paciente"
        );

        usuarioDAO.registrarUsuario(usuario);

        // READ: consultar usuarios.
        System.out.println("\n--- USUARIOS REGISTRADOS ---");

        List<Usuario> usuarios = usuarioDAO.listarUsuarios();

        for (Usuario usuarioRegistrado : usuarios) {
            System.out.println(usuarioRegistrado);
        }

        // UPDATE: actualizar usuario.
        if (!usuarios.isEmpty()) {

            Usuario usuarioActualizar = usuarios.get(0);

            usuarioActualizar.setNombre("Santiago Pastrana Aroca");

            usuarioDAO.actualizarUsuario(usuarioActualizar);
        }

        // READ: verificar actualización.
        System.out.println("\n--- USUARIOS DESPUÉS DE ACTUALIZAR ---");

        usuarios = usuarioDAO.listarUsuarios();

        for (Usuario usuarioRegistrado : usuarios) {
            System.out.println(usuarioRegistrado);
        }

        // DELETE: eliminar usuario.
        if (!usuarios.isEmpty()) {

            int idUsuario = usuarios.get(0).getId();

            usuarioDAO.eliminarUsuario(idUsuario);
        }

        // READ: verificar eliminación.
        System.out.println("\n--- USUARIOS DESPUÉS DE ELIMINAR ---");

        usuarios = usuarioDAO.listarUsuarios();

        for (Usuario usuarioRegistrado : usuarios) {
            System.out.println(usuarioRegistrado);
        }
    }
}
