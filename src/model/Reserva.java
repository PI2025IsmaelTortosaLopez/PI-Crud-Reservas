package model;

import java.sql.Date;
import java.sql.Time;

/**
 * Clase que representa una reserva del sistema de gestión de reservas.
 * Una reserva asocia un usuario con un recurso en una fecha y hora específica.
 * Incluye información adicional como el motivo de la reserva o alguna petición especial.
 */
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

    /**
     * Constructor vacío.
     * Se utiliza para crear una reserva sin inicializar atributos.
     */
    public Reserva(){}

    /**
     * Constructor con parámetros para inicializar una reserva.
     *
     * @param idRecurso identificador del recurso reservado.
     * @param idUsuario identificador del usuario que realiza la reserva.
     * @param fecha fecha de la reserva.
     * @param horaInicio hora de inicio de la reserva.
     * @param horaFin hora de fin de la reserva.
     * @param coste coste de la reserva.
     * @param numeroPlazas número de plazas reservadas.
     * @param motivo motivo de la reserva.
     * @param observaciones observaciones adicionales.
     */
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

    /**
     * Obtiene el identificador del recurso.
     *
     * @return id del recurso.
     */
    public int getIdRecurso() {
        return idRecurso;
    }

    /**
     * Establece el identificador del recurso.
     *
     * @param idRecurso id del recurso.
     */
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    /**
     * Obtiene el identificador de la reserva local.
     *
     * @return id de la reserva local.
     */
    public int getIdReservaLocal() {
        return idReservaLocal;
    }

    /**
     * Establece el identificador de la reserva local.
     *
     * @param idReservaLocal id de la reserva local.
     */
    public void setIdReservaLocal(int idReservaLocal) {
        this.idReservaLocal = idReservaLocal;
    }

    /**
     * Obtiene el identificador del usuario.
     *
     * @return id del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param idUsuario id del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene la fecha de la reserva.
     *
     * @return fecha de la reserva.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la reserva.
     *
     * @param fecha fecha de la reserva.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    /**
     * Obtiene la hora de inicio de la reserva.
     *
     * @return hora de inicio.
     */
    public Time getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio de la reserva.
     *
     * @param horaInicio hora de inicio.
     */
    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de fin de la reserva.
     *
     * @return hora de fin.
     */
    public Time getHoraFin() {
        return horaFin;
    }

    /**
     * Establece la hora de fin de la reserva.
     *
     * @param horaFin hora de fin.
     */
    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Obtiene el coste de la reserva.
     *
     * @return coste de la reserva.
     */
    public double getCoste() {
        return coste;
    }

    /**
     * Establece el coste de la reserva.
     *
     * @param coste coste de la reserva.
     */
    public void setCoste(double coste) {
        this.coste = coste;
    }

    /**
     * Obtiene el número de plazas reservadas.
     *
     * @return número de plazas.
     */
    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    /**
     * Establece el número de plazas reservadas.
     *
     * @param numeroPlazas número de plazas.
     */
    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    /**
     * Obtiene el motivo de la reserva.
     *
     * @return motivo de la reserva.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo de la reserva.
     *
     * @param motivo motivo de la reserva.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene las observaciones de la reserva.
     *
     * @return observaciones.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece las observaciones de la reserva.
     *
     * @param observaciones observaciones.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}