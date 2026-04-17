package model;

import java.sql.Time;

/**
 * Clase que representa un horario dentro del sistema de gestión de reservas.
 * Define un intervalo que hace referencia a un día, teniendo en cuenta la disponibilidad de los recursos y las reservas.
 */
public class Horario {

    private int idHorario;
    private String diaSemana;
    private Time horaInicio;
    private Time horaFin;

    /**
     * Constructor vacío.
     * Permite crear un objeto sin inicializar sus atributos.
     */
    public Horario(){}

    /**
     * Constructor con parámetros para inicializar un horario.
     *
     * @param diaSemana día de la semana al que pertenece el horario.
     * @param horaInicio hora de inicio del horario.
     * @param horaFin hora de fin del horario.
     */
    public Horario(String diaSemana, Time horaInicio, Time horaFin){
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     * Obtiene el identificador del horario.
     *
     * @return id del horario.
     */
    public int getIdHorario() {
        return idHorario;
    }

    /**
     * Establece el identificador del horario.
     *
     * @param idHorario id del horario.
     */
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    /**
     * Obtiene el dia de la semana del horario.
     *
     * @return dia de la semana.
     */
    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     * Establece el día de la semana del horario.
     *
     * @param diaSemana dia de la semnana.
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    /**
     * Obtiene la hora de inicio del horario.
     *
     * @return hora de inicio.
     */
    public Time getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio del horario.
     *
     * @param horaInicio hora de inicio.
     */
    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de fin del horario.
     *
     * @return hora de fin.
     */
    public Time getHoraFin() {
        return horaFin;
    }

    /**
     * Establece la hora de fin del horario.
     *
     * @param horaFin hora de fin.
     */
    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }
}