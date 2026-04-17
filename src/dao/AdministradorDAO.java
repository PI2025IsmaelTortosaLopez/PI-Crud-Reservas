package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Clase DAO encargada de gestionar las operaciones de base de datos relacionadas con la tabla administrador.
 * Permite insertar administradores asociados a un usuario del sistema existente.
 */
public class AdministradorDAO {

    /**
     * Inserta un nuevo administrador en la base de datos.
     * Asocia un usuario existente con el rol de administrador.
     *
     * @param id_usuario identificador del usuario asociado.
     * @param telefono_guardia teléfono de contacto del administrador (guardia).
     */
    public void insertar(int id_usuario, String telefono_guardia){
        String sql = "INSERT INTO administrador (telefono_guardia, id_usuario) VALUES (?, ?)";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, telefono_guardia);
            ps.setInt(2, id_usuario);

            ps.executeUpdate();
            System.out.println("Administrador creado");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}