package dao;

import conexion.ConexionBD;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona las operaciones CRUD de los usuarios.
 */
public class UsuarioDAO {

    /**
     * Crea la tabla usuarios si no existe.
     */
    public void crearTabla() {

        String sql = """
                CREATE TABLE IF NOT EXISTS usuarios (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(100) NOT NULL,
                    correo VARCHAR(150) NOT NULL UNIQUE,
                    contrasena VARCHAR(255) NOT NULL,
                    tipo_usuario VARCHAR(50) NOT NULL
                )
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.executeUpdate();
            System.out.println("Tabla usuarios creada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al crear la tabla usuarios.");
            e.printStackTrace();
        }
    }

    /**
     * CREATE: registra un nuevo usuario.
     */
    public void registrarUsuario(Usuario usuario) {

        String sql = """
                INSERT INTO usuarios
                (nombre, correo, contrasena, tipo_usuario)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getCorreo());
            sentencia.setString(3, usuario.getContrasena());
            sentencia.setString(4, usuario.getTipoUsuario());

            sentencia.executeUpdate();

            System.out.println("Usuario registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al registrar el usuario.");
            e.printStackTrace();
        }
    }

    /**
     * READ: consulta todos los usuarios.
     */
    public List<Usuario> listarUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();

        String sql = """
                SELECT id, nombre, correo, contrasena, tipo_usuario
                FROM usuarios
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Usuario usuario = new Usuario(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("correo"),
                        resultado.getString("contrasena"),
                        resultado.getString("tipo_usuario")
                );

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar los usuarios.");
            e.printStackTrace();
        }

        return usuarios;
    }

    /**
     * UPDATE: actualiza los datos de un usuario.
     */
    public void actualizarUsuario(Usuario usuario) {

        String sql = """
                UPDATE usuarios
                SET nombre = ?,
                    correo = ?,
                    contrasena = ?,
                    tipo_usuario = ?
                WHERE id = ?
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getCorreo());
            sentencia.setString(3, usuario.getContrasena());
            sentencia.setString(4, usuario.getTipoUsuario());
            sentencia.setInt(5, usuario.getId());

            sentencia.executeUpdate();

            System.out.println("Usuario actualizado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario.");
            e.printStackTrace();
        }
    }

    /**
     * DELETE: elimina un usuario por su identificador.
     */
    public void eliminarUsuario(int id) {

        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, id);
            sentencia.executeUpdate();

            System.out.println("Usuario eliminado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario.");
            e.printStackTrace();
        }
    }
}
