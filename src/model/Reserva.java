package model;

import java.sql.Date;
import java.sql.Time;

public class Reserva {

    private int idRecurso;
    private int idReservaLocal;
    private int idUsuario;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;
    private double coste;
    private int numeroPlazas;
    private String motivo;
    private String observaciones;

    public Reserva(){}

    public Reserva (int idRecurso, int idUsuario, Date fecha, Time horaInicio, Time horaFin, double coste, int numeroPlazas, String motivo, String observaciones){
        this.idRecurso = idRecurso;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.coste = coste;
        this.numeroPlazas = numeroPlazas;
        this.motivo = motivo;
        this.observaciones = observaciones;
    }

    public int getIdRecurso() {
        return idRecurso;
    }
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public int getIdReservaLocal() {
        return idReservaLocal;
    }
    public void setIdReservaLocal(int idReservaLocal) {
        this.idReservaLocal = idReservaLocal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public double getCoste() {
        return coste;
    }
    public void setCoste(double coste) {
        this.coste = coste;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }
    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}