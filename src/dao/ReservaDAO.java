package dao;

import jdk.jshell.spi.ExecutionControlProvider;
import model.Reserva;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase DAO encargada de gestionar las operaciones de base de datos relacionadas con la entidad reserva.
 * Incluye operaciones de CRUD, consultas y validaciones relacionadas con las reservas de los recursos.
 */
public class ReservaDAO {

    /**
     * Inserta una nueva reserva en la base de datos.
     * Calcula automáticamente el id_reserva_local dentro del recurso.
     *
     * @param r objeto reserva con los datos a insertar.
     */
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

    /**
     * Elimina una reserva de la base de datos.
     *
     * @param idRecurso identificador del recurso.
     * @param idReservaLocal identificador de la reserva dentro del recurso.
     */
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

    /**
     * Modifica una reserva existente en la base de datos.
     *
     * @param r objeto reserva con los datos actualizados a los nuevos introducidos.
     */
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

    /**
     * Obtiene todas las reservas registradas en la base de datos.
     *
     * @return lista de reservas.
     */
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

    /**
     * Busca reservas asociadas a un usuario.
     *
     * @param idUsuario identificador del usuario.
     * @return lista de reservas del usuario.
     */
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

    /**
     * Busca reservas asociadas a un recurso.
     *
     * @param idRecurso identificador del recurso.
     * @return lista de reservas del recurso.
     */
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

    /**
     * Comprueba si existe solapamiento de reservas en un recurso.
     *
     * @param idRecurso identificador del recurso.
     * @param fecha fecha de la reserva.
     * @param inicio inicio de la reserva.
     * @param fin fin de la reserva.
     * @return true si existe solapamiento, false en caso contrario.
     */
    public boolean solapamientoReservas(int idRecurso, Date fecha, Time inicio, Time fin){
        String sql = """
                SELECT * FROM reserva
                WHERE id_recurso=? AND fecha=?
                AND (? < hora_fin AND ? > hora_inicio)
                """;

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, idRecurso);
            ps.setDate(2, fecha);
            ps.setTime(3, inicio);
            ps.setTime(4, fin);

            ResultSet rs = ps.executeQuery();

            return  rs.next();

        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Obtiene la capacidad máxima de un recurso.
     *
     * @param idRecurso identificador del recurso.
     * @return capacidad del recurso, o -1 si no existe.
     */
    public int obtenerCapacidad(int idRecurso){

        String sql = "SELECT capacidad FROM recurso WHERE id_recurso=?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, idRecurso);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getInt("capacidad");
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return -1;
    }

    /**+
     * Busca reservas por fecha concreta.
     *
     * @param fecha fecha a consultar.
     * @return lista de reservas en ese fecha.
     */
    public List<Reserva> encontrarPorFecha(LocalDate fecha) {

        List<Reserva> lista = new ArrayList<>();

        String sql = "SELECT * FROM reserva WHERE fecha = ?";

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(fecha));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva r = new Reserva();

                r.setIdRecurso(rs.getInt("id_recurso"));
                r.setFecha(rs.getDate("fecha"));
                r.setHoraInicio(rs.getTime("hora_inicio"));
                r.setHoraFin(rs.getTime("hora_fin"));

                lista.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Obtiene un ranking de los recursos más utilizados.
     *
     * @return mapa con el nombre del recurso y el número de usos.
     */
    public Map<String, Integer> recursosMasUsados() {

        Map<String, Integer> mapa = new LinkedHashMap<>();

        String sql = """
        SELECT r.nombre, COUNT(*) as total
        FROM reserva res
        JOIN recurso r ON res.id_recurso = r.id_recurso
        GROUP BY r.nombre
        ORDER BY total DESC
        """;

        try (Connection con = DBConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                mapa.put(rs.getString("nombre"), rs.getInt("total"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapa;
    }

}