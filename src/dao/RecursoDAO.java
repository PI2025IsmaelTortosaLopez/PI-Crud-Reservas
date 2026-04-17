package dao;

import model.Recurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO encargada de gestionar las operaciones de base de datos relacionadas con la entidad recurso.
 * Permite realizar operaciones de CRUD sobre la tabla recurso.
 */
public class RecursoDAO {

    /**
     * Inserta un nuevo recurso en la base de datos.
     *
     * @param r objeto recurso con los datos a insertar.
     */
    public void insertar(Recurso r){
        String sql = "INSERT INTO recurso (nombre, descripcion, ubicacion, capacidad) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, r.getNombre());
            ps.setString(2, r.getDescripcion());
            ps.setString(3, r.getUbicacion());
            ps.setInt(4, r.getCapacidad());

            ps.executeUpdate();
            System.out.println("Recurso insertado correctamente");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Obtiene todos los recursos registrados en la base de datos.
     *
     * @return lista de recursos.
     */
    public List<Recurso> obtenerTodos(){
        List<Recurso> lista = new ArrayList<>();
        String sql = "SELECT * FROM recurso";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){
             ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Recurso r = new Recurso();
                r.setIdRecurso(rs.getInt("id_recurso"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setUbicacion(rs.getString("ubicacion"));
                r.setCapacidad(rs.getInt("capacidad"));
                lista.add(r);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Elimina un recurso de la base de datos por su identificador.
     *
     * @param id identificador del recurso a eliminar.
     */
    public void eliminar(int id){
        String sql = "DELETE FROM recurso WHERE id_recurso = ?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Recurso eliminado");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Actualiza los datos de un recurso existente en la base de datos por los nuevos datos introducidos.
     *
     * @param r objeto recurso con los datos actualizados.
     */
    public void modificar(Recurso r){
        String sql = "UPDATE recurso SET nombre=?, descripcion=?, ubicacion=?, capacidad=? WHERE id_recurso=?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, r.getNombre());
            ps.setString(2, r.getDescripcion());
            ps.setString(3, r.getUbicacion());
            ps.setInt(4, r.getCapacidad());
            ps.setInt(5, r.getIdRecurso());

            ps.executeUpdate();
            System.out.println("Recurso modificado");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Busca recursos por nombre utilizando coincidencias parciales.
     *
     * @param nombre nombre o parte del nombre a buscar.
     * @return lista de recursos que coinciden con los datos introducidos en la búsqueda.
     */
    public List<Recurso> buscarPorNombre(String nombre){
        List<Recurso> lista = new ArrayList<>();
        String sql = "SELECT * FROM recurso WHERE nombre LIKE ?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, "%" + nombre + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Recurso r = new Recurso();
                r.setIdRecurso(rs.getInt("id_recurso"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setUbicacion(rs.getString("ubicacion"));
                r.setCapacidad(rs.getInt("capacidad"));
                lista.add(r);

            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return  lista;
    }

}
