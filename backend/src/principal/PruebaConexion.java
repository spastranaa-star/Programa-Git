package principal;

import conexion.ConexionBD;

import java.sql.Connection;

public class PruebaConexion {

    public static void main(String[] args) {

        try (Connection conexion = ConexionBD.conectar()) {

            if (conexion != null) {
                System.out.println("Conexion JDBC establecida correctamente.");
            }

        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
    }
}
