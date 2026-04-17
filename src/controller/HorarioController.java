package controller;

import dao.HorarioDAO;
import model.Horario;

import java.sql.Time;
import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con los horarios.
 * Actúa como intermediario entre la capa DAO y la lógica de la aplicación.
 * Incluye validaciones básicas sobre el formato y coherencia de las horas.
 */
public class HorarioController {

    private HorarioDAO dao = new HorarioDAO();

    /**
     * Crea un nuevo horario en el sistema.
     * Valida que la hora de fin sea posterior a la hora de inicio.
     *
     * @param dia dia de la semana.
     * @param horarioInicio hora de inicio
     * @param horarioFin hora de fin
     */
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

    /**
     * Muestra por consola todos los horarios registrados.
     */
    public void listarHorarios(){
        List<Horario> lista = dao.listarHorarios();

        for (Horario h : lista){
            System.out.println("Día: " + h.getDiaSemana() + " - " + "Hora inicio: " + h.getHoraInicio() + " - " + "Hora fin: " + h.getHoraFin());
        }
    }

    /**
     * Modifica un horario existente en el sistema.
     * Valida que la hora de fin sea posterior a la hora de inicio.
     *
     * @param id identificador del horario.
     * @param dia dia de la semana.
     * @param horaInicio hora de inicio.
     * @param horaFin hora de fin.
     */
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

    /**
     * Elimina un horario del sistema por su identificador.
     *
     * @param id identificador del horario.
     */
    public void eliminarHorario(int id){
        dao.eliminar(id);
    }

}