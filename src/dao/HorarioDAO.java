package dao;

import model.Horario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO encargada de gestionar las operaciones de bases de datos relacionadas con la entidad horario.
 * Permite realizar operaciones de CRUD sobre la tabla horario.
 */
public class HorarioDAO {

    /**
     * Inserta un nuevo horario en la base de datos.
     *
     * @param h objeto horario con los datos a insertar.
     */
    public void insertar(Horario h){
        String sql = "INSERT INTO horario (dia_semana, hora_inicio, hora_fin) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, h.getDiaSemana());
            ps.setTime(2, h.getHoraInicio());
            ps.setTime(3, h.getHoraFin());

            ps.executeUpdate();
            System.out.println("Horario creado correctamente");

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Obtiene todos los horarios registrados en la base de datos.
     *
     * @return lista de horarios.
     */
    public List<Horario> listarHorarios(){
        List<Horario> lista = new ArrayList<>();
        String sql = "SELECT * FROM horario";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                Horario h = new Horario();
                h.setIdHorario(rs.getInt("id_horario"));
                h.setDiaSemana(rs.getString("dia_semana"));
                h.setHoraInicio(rs.getTime("hora_inicio"));
                h.setHoraFin(rs.getTime("hora_fin"));

                lista.add(h);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Actualiza los datos de un horario existente en la base de datos.
     *
     * @param h objeto horario con los datos actualizados a los nuevos datos introducidos.
     */
    public void modificar(Horario h){
        String sql = "UPDATE horario SET dia_semana=?, hora_inicio=?, hora_fin=? WHERE id_horario=?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, h.getDiaSemana());
            ps.setTime(2, h.getHoraInicio());
            ps.setTime(3, h.getHoraFin());
            ps.setInt(4, h.getIdHorario());

            ps.executeUpdate();
            System.out.println("Horario modificado correctamente");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Elimina un horario de la base de datos por su identificador.
     *
     * @param idHorario identificador del horario a eliminar.
     */
    public void eliminar(int idHorario){
        String sql = "DELETE FROM horario WHERE id_horario=?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, idHorario);

            ps.executeUpdate();
            System.out.println("Horario eliminado");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}