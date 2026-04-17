package controller;

import dao.HorarioDAO;
import model.Horario;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class HorarioController {

    private HorarioDAO dao = new HorarioDAO();

    public void crearHorario(String dia, String horarioInicio, String horarioFin){

        try {
            Time inicio = Time.valueOf(horarioInicio.trim());
            Time fin = Time.valueOf(horarioFin.trim());

            if (fin.before(inicio)) {
                System.out.println("Error: La hora fin debe ser mayor que la hora de inicio");
                return;
            }

            Horario h = new Horario(dia, Time.valueOf(horarioInicio), Time.valueOf(horarioFin));
            dao.insertar(h);

        } catch (Exception e){
            System.out.println("Formato de la hora incorrecto");
        }

    }

    public void listarHorarios(){
        List<Horario> lista = dao.listarHorarios();

        for (Horario h : lista){
            System.out.println(h.getDiaSemana() + "-" + h.getHoraInicio() + "-" + h.getHoraFin());
        }
    }

    public void modificarHorarios(int id, String dia, String horaInicio, String horaFin){

        try {
            Time inicio = Time.valueOf(horaInicio.trim());
            Time fin = Time.valueOf(horaFin.trim());

            if (fin.before(inicio)) {
                System.out.println("Error: La hora de fin debe ser mayor que la hora de inicio");
                return;
            }

            Horario h = new Horario(dia, Time.valueOf(horaInicio), Time.valueOf(horaFin));
            h.setIdHorario(id);
            dao.modificar(h);

        } catch (Exception e){
            System.out.println("Formato de hora incorrecto");
        }

    }

    public void eliminarHorario(int id){
        dao.eliminar(id);
    }

}