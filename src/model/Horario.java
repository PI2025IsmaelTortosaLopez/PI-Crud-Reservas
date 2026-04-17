package model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class Horario {

    private int idHorario;
    private String diaSemana;
    private Time horaInicio;
    private Time horaFin;

    public Horario(){}

    public Horario(String diaSemana, Time horaInicio, Time horaFin){
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getIdHorario() {
        return idHorario;
    }
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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
}