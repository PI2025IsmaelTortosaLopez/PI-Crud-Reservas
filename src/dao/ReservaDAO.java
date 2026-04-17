package dao;

import jdk.jshell.spi.ExecutionControlProvider;
import model.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public void insertar(Reserva r){
        String sqlMax = "SELECT MAX(id_reserva_local) FROM reserva WHERE id_recurso =?";
        String sqlInsert = "INSERT INTO reserva VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.conectar()){

            int nuevoId = 1;

            PreparedStatement psMax = con.prepareStatement(sqlMax);
            psMax.setInt(1, r.getIdRecurso());

            ResultSet rs = psMax.executeQuery();

            if (rs.next()){
                int max = rs.getInt(1);
                if (!rs.wasNull()){
                    nuevoId = max + 1;
                }
            }

            PreparedStatement ps = con.prepareStatement(sqlInsert);

            ps.setInt(1, r.getIdRecurso());
            ps.setInt(2, nuevoId);
            ps.setInt(3, r.getIdUsuario());
            ps.setDate(4, r.getFecha());
            ps.setTime(5, r.getHoraInicio());
            ps.setTime(6, r.getHoraFin());
            ps.setDouble(7, r.getCoste());
            ps.setInt(8, r.getNumeroPlazas());
            ps.setString(9, r.getMotivo());
            ps.setString(10, r.getObservaciones());

            ps.executeUpdate();
            System.out.println("Reserva realizada correctamente");

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void eliminar(int idRecurso, int idReservaLocal){
        String sql = "DELETE FROM reserva WHERE id_recurso=? AND id_reserva_local=?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, idRecurso);
            ps.setInt(2, idReservaLocal);

            ps.executeUpdate();
            System.out.println("Reserva cancelada correctamente");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void modificar(Reserva r){
        String sql = "UPDATE reserva SET id_usuario=?, fecha=?, hora_inicio=?, hora_fin=?, coste=?, numero_plazas=?, motivo=?, observaciones=? WHERE id_recurso=? AND id_reserva_local=?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, r.getIdUsuario());
            ps.setDate(2, r.getFecha());
            ps.setTime(3, r.getHoraInicio());
            ps.setTime(4, r.getHoraFin());
            ps.setDouble(5, r.getCoste());
            ps.setInt(6, r.getNumeroPlazas());
            ps.setString(7, r.getMotivo());
            ps.setString(8, r.getObservaciones());
            ps.setInt(9, r.getIdRecurso());
            ps.setInt(10, r.getIdReservaLocal());

            ps.executeUpdate();
            System.out.println("Reserva modificada");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Reserva> listarTodas(){
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                Reserva r = new Reserva();

                r.setIdRecurso(rs.getInt("id_recurso"));
                r.setIdReservaLocal(rs.getInt("id_reserva_local"));
                r.setIdUsuario(rs.getInt("id_usuario"));
                r.setFecha(rs.getDate("fecha"));
                r.setHoraInicio(rs.getTime("hora_inicio"));
                r.setHoraFin(rs.getTime("hora_fin"));
                r.setCoste(rs.getDouble("coste"));
                r.setNumeroPlazas(rs.getInt("numero_plazas"));
                r.setMotivo(rs.getString("motivo"));
                r.setObservaciones(rs.getString("observaciones"));

                lista.add(r);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<Reserva> buscarPorUsuario(int idUsuario){
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE id_usuario=?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reserva r = new Reserva();
                r.setIdRecurso(rs.getInt("id_recurso"));
                r.setIdReservaLocal(rs.getInt("id_reserva_local"));
                r.setFecha(rs.getDate("fecha"));
                r.setHoraInicio(rs.getTime("hora_inicio"));
                r.setHoraFin(rs.getTime("hora_fin"));

                lista.add(r);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<Reserva> buscarPorRecurso(int idRecurso){
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE id_recurso=?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, idRecurso);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Reserva r = new Reserva();
                r.setIdReservaLocal(rs.getInt("id_reserva_local"));
                r.setIdUsuario(rs.getInt("id_usuario"));
                r.setFecha(rs.getDate("fecha"));
                r.setHoraInicio(rs.getTime("hora_inicio"));
                r.setHoraFin(rs.getTime("hora_fin"));

                lista.add(r);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

}