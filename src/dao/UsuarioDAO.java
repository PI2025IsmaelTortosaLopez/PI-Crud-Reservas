package dao;

import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void insertar(Usuario u){
        String sql= "INSERT INTO usuario (correo_electronico, contrasena, nombre, fecha_nacimiento, tipo_usuario) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, u.getCorreo());
            ps.setString(2, u.getContrasena());
            ps.setString(3, u.getNombre());
            ps.setDate(4, u.getFechaNacimiento());
            ps.setString(5, u.getTipoUsuario());

            ps.executeUpdate();
            System.out.println("Usuario insertado");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Usuario> obtenerTodos(){
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try(Connection con = DBConnection.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setCorreo(rs.getString("correo_electronico"));
                u.setNombre(rs.getString("nombre"));
                lista.add(u);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
       return  lista;
    }

    public void eliminar(int id){
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Usuario eliminado");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void modificar(Usuario u){
        String sql = "UPDATE usuario SET correo_electronico=?, contrasena=?, nombre=?, fecha_nacimiento=?, tipo_usuario=? WHERE id_usuario=?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, u.getCorreo());
            ps.setString(2, u.getContrasena());
            ps.setString(3, u.getNombre());
            ps.setDate(4, u.getFechaNacimiento());
            ps.setString(5, u.getTipoUsuario());
            ps.setInt(6, u.getIdUsuario());

            ps.executeUpdate();
            System.out.println("Usuario modificado");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Usuario> buscarPorNombre(String nombre){
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE nombre LIKE ?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, "%" + nombre + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setCorreo(rs.getString("correo_electronico"));
                u.setNombre(rs.getString("nombre"));
                lista.add(u);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public Usuario buscarPorCorreo(String correo){
        String sql = "SELECT * FROM usuario WHERE correo_electronico = ?";
        Usuario u = null;

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, correo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setCorreo(rs.getString("correo_electronico"));
                u.setNombre(rs.getString("nombre"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return  u;
    }

    public int recuperarId(Usuario u){
        String sql = "INSERT INTO usuario (correo_electronico, contrasena, nombre, fecha_nacimiento, tipo_usuario)  VALUES (?, ?, ?, ?, ?)";

        int idGenerado = -1;

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, u.getCorreo());
            ps.setString(2, u.getContrasena());
            ps.setString(3, u.getNombre());
            ps.setDate(4, u.getFechaNacimiento());
            ps.setString(5, u.getTipoUsuario());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                idGenerado = rs.getInt(1);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return idGenerado;
    }
}