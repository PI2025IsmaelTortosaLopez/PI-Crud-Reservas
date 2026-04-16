package dao;

import model.Recurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecursoDAO {

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
