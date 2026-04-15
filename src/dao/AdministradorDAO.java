package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AdministradorDAO {

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