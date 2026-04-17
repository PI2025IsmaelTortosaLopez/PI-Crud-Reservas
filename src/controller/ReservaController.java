package controller;

import dao.ReservaDAO;
import model.Reserva;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con las reservas.
 * Actúa como intermediario entre la capa DAO y la lógica de la aplicación.
 * Incluye validaciones de negocia antes de realizar operaciones sobre la pase de datos.
 */
public class ReservaController {

    public ReservaDAO dao = new ReservaDAO();

    /**
     * Crea una nueva reserva en el sistema realizando validaciones previas:
     * -La fecha no puede ser anterior a la actual.
     * -La hora de fin debe ser posterior a la de inicio.
     * -No se puede superar la capacidad del recurso.
     * -No puede existir solapamiento de reservas.
     *
     * @param idRecurso identificador del recurso.
     * @param idUsuario identificador del usuario.
     * @param fecha fecha de la reserva.
     * @param horaInicio hora de inicio.
     * @param horaFin hora de fin.
     * @param coste coste de la reserva.
     * @param plazas número de plazas.
     * @param motivo motivo de la reserva.
     * @param observaciones observaciones adicionales.
     */
    public void crearReserva(int idRecurso, int idUsuario, String fecha, String horaInicio, String horaFin, double coste, int plazas, String motivo, String observaciones) {

        Date f = Date.valueOf(fecha);
        Time hi = Time.valueOf(horaInicio);
        Time hf = Time.valueOf(horaFin);

        Date hoy = new Date(System.currentTimeMillis());
        if (f.before(hoy)){
            System.out.println("La fecha introducida no es válida");
            return;
        }

        if (hf.before(hi)){
            System.out.println("La hora fin debe ser mayor que hora inicio");
            return;
        }

        int capacidad = dao.obtenerCapacidad(idRecurso);
        if (plazas > capacidad){
            System.out.println("Supera la capacidad máxima del recurso");
            return;
        }

        if (dao.solapamientoReservas(idRecurso, f, hi, hf)){
            System.out.println("Ya existe una reserva en ese horario");
            return;
        }

        Reserva r = new Reserva();
        r.setIdRecurso(idRecurso);
        r.setIdUsuario(idUsuario);
        r.setFecha(f);
        r.setHoraInicio(hi);
        r.setHoraFin(hf);
        r.setCoste(coste);
        r.setNumeroPlazas(plazas);
        r.setMotivo(motivo);
        r.setObservaciones(observaciones);

        dao.insertar(r);
    }

    /**
     * Elimina una reserva del sistema.
     *
     * @param idRecurso identificador del recurso.
     * @param idReservaLocal identificador de la reserva dentro del recurso.
     */
    public void eliminarReserva(int idRecurso, int idReservaLocal) {
        dao.eliminar(idRecurso, idReservaLocal);
    }

    /**
     * Muestra por consola todas las reservas registradas.
     */
    public void listarReservas() {
        List<Reserva> lista = dao.listarTodas();

        for (Reserva r : lista) {
            System.out.println("Id recurso: " + r.getIdRecurso() + " - " + "Id reserva local: " + r.getIdReservaLocal()
                    + " - " + "Id usuario: " + r.getIdUsuario() + " - " + "Fecha de la reserva: " + r.getFecha() + " - " + "Hora inicio reserva: "
                    + r.getHoraInicio() + " - " + "Hora fin reserva: " + r.getHoraFin());
        }
    }

    /**
     * Modifica una reserva existente en el sistema.
     *
     * @param idRecurso identificador del recurso.
     * @param idReservaLocal identificador de la reserva.
     * @param idUsuario identificador del usuario.
     * @param fecha fecha de la reserva.
     * @param horaInicio hora de inicio.
     * @param horaFin hora de fin.
     * @param coste coste de la reserva.
     * @param plazas número de plazas.
     * @param motivo motivo de la reserva.
     * @param observaciones observaciones adicionales.
     */
    public void modificarReserva(int idRecurso, int idReservaLocal, int idUsuario, String fecha, String horaInicio, String horaFin, double coste, int plazas, String motivo, String observaciones) {

        Reserva r = new Reserva();

        r.setIdRecurso(idRecurso);
        r.setIdReservaLocal(idReservaLocal);
        r.setIdUsuario(idUsuario);
        r.setFecha(Date.valueOf(fecha));
        r.setHoraInicio(Time.valueOf(horaInicio));
        r.setHoraFin(Time.valueOf(horaFin));
        r.setCoste(coste);
        r.setNumeroPlazas(plazas);
        r.setMotivo(motivo);
        r.setObservaciones(observaciones);

        dao.modificar(r);
    }

    /**
     * Busca reservas asociadas a un usuario.
     *
     * @param idUsuario identificador del usuario.
     */
    public void buscarPorUsuario(int idUsuario){
        List<Reserva> lista = dao.buscarPorUsuario(idUsuario);

        for (Reserva r : lista){
            System.out.println("Id recurso: " + r.getIdRecurso() + " - " + "Fecha reserva: " + r.getFecha());
        }
    }

    /**
     * Busca reservas asociadas a un recurso.
     *
     * @param idRecurso identificador del recurso.
     */
    public void buscarPorRecurso(int idRecurso){
        List<Reserva> lista = dao.buscarPorRecurso(idRecurso);

        for (Reserva r : lista){
            System.out.println("Id reserva local: " + r.getIdReservaLocal() + " - " + "Id Usuario: " + r.getIdUsuario());
        }
    }

    /**
     * Obtiene las reservas filtradas por fecha.
     *
     * @param fecha fecha a consultar.
     * @return lista de reservas en esa fecha.
     */
    public List<Reserva> reservasPorFecha(LocalDate fecha) {
        return dao.encontrarPorFecha(fecha);
    }

    /**
     * Obtiene un ranking de los recursos más utilizados.
     *
     * @return mapa con nombre del recurso y número de usos.
     */
    public Map<String, Integer> recursosMasUsados() {
        return dao.recursosMasUsados();
    }

}