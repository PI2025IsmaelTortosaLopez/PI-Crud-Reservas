package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Clase DAO encargada de gestionar las operaciones de bases de datos relacionadas con la tabla de usuarionormal.
 * Permite insertar información adicional asociada a un usuario.
 */
public class UsuarioNormalDAO {

    /**
     * Inserta un usuario normal en la base de datos.
     * Este método guarda información adicional asociada a un usuario existente.
     *
     * @param id_usuario identificador del usuario principal.
     * @param direccion dirección del usuario.
     * @param telefono_movil número de móvil del usuario.
     * @param fotografia foto del usuario.
     */
    public void insertar(int id_usuario, String direccion, String telefono_movil, String fotografia){
        String sql = "INSERT INTO usuarionormal (direccion, telefono_movil, fotografia, id_usuario) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, direccion);
            ps.setString(2, telefono_movil);
            ps.setString(3, fotografia);
            ps.setInt(4, id_usuario);

            ps.executeUpdate();
            System.out.println("Usuario normal creado");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}