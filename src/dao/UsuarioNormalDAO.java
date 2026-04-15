package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioNormalDAO {

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