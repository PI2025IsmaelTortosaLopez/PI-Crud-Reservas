package controller;

import dao.ReservaDAO;
import model.Reserva;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ReservaController {

    public ReservaDAO dao = new ReservaDAO();

    public void crearReserva(int idRecurso, int idUsuario, String fecha, String horaInicio, String horaFin, double coste, int plazas, String motivo, String observaciones) {

        Date f = Date.valueOf(fecha);
        Time hi = Time.valueOf(horaInicio);
        Time hf = Time.valueOf(horaFin);

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

    public void eliminarReserva(int idRecurso, int idReservaLocal) {
        dao.eliminar(idRecurso, idReservaLocal);
    }

    public void listarReservas() {
        List<Reserva> lista = dao.listarTodas();

        for (Reserva r : lista) {
            System.out.println(r.getIdRecurso() + "-" + r.getIdReservaLocal() + "-" + r.getIdUsuario() + "-" + r.getFecha() + "-" + r.getHoraInicio() + "-" + r.getHoraFin());
        }
    }

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

    public void buscarPorUsuario(int idUsuario){
        List<Reserva> lista = dao.buscarPorUsuario(idUsuario);

        for (Reserva r : lista){
            System.out.println(r.getIdRecurso() + "-" + r.getFecha());
        }
    }

    public void buscarPorRecurso(int idRecurso){
        List<Reserva> lista = dao.buscarPorRecurso(idRecurso);

        for (Reserva r : lista){
            System.out.println(r.getIdReservaLocal() + "-" + r.getIdUsuario());
        }
    }

}