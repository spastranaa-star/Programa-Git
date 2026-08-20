package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gestiona la conexión de COMFEY con la base de datos H2.
 */
public class ConexionBD {

    private static final String URL = "jdbc:h2:./comfey";
    private static final String USUARIO = "sa";
    private static final String CONTRASENA = "";

    /**
     * Establece una conexión con la base de datos.
     *
     * @return conexión activa con H2.
     * @throws SQLException si ocurre un error de conexión.
     */
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
            URL,
            USUARIO,
            CONTRASENA
        );
    }
}


