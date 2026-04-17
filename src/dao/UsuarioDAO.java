package dao;

import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Claso DAO encargada de gestionar las operaciones de base de datos relacionadas con la entidad usuario.
 * Permite realizar operaciones CRUD (insertar, modificar, eliminar, consultas) sobre la tabla usuario.
 */
public class UsuarioDAO {

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param u objeto usuario con los datos a insertar en la base de datos.
     */
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

    /**
     * Obtiene todos los usuarios registrados en la base de datos.
     *
     * @return lista de usuarios.
     */
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


    /**
     * Elimina un usuario de la base de datos mediante su identificador (id).
     *
     * @param id identificador del usuario a eliminar.
     */
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

    /**
     * Actualiza los datos de un usuario existente en la base de datos por los nuevos datos introducidos.
     *
     * @param u objeto usuario con los datos actualizados.
     */
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


    /**
     * Busca usuarios por nombre utilizando coincidencias parciales.
     *
     * @param nombre nombre o parte del nombre a buscar.
     * @return lista de usuarios que coinciden con los datos introducidos en la búsqueda.
     */
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


    /**
     * Busca un usuario en la base de datos a partir de su correo electrónico.
     *
     * @param correo correo del usuario.
     * @return objeto usuario si el correo introducido coincide con alguno de los registrados en la base de datos,
     * o null si el correo introducido no coincide con ninguno de los registrados.
     */
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

    /**
     * Inserta un usuario en la base de datos y devuelve el id generado al crearlo.
     *
     * @param u objeto usuario a insertar.
     * @return id generado por la base de datos o -1 si no se pudo obtener.
     */
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