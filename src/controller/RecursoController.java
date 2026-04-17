package controller;

import dao.RecursoDAO;
import model.Recurso;

import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con los recursos.
 * Actúa como intermediario entre la capa DAO y la lógica de la aplicación.
 * Permite crear, modificar, eliminar y consultar recursos.
 */
public class RecursoController {

    private RecursoDAO dao = new RecursoDAO();

    /**
     * Crea un nuevo recurso en el sistema.
     *
     * @param nombre nombre del recurso.
     * @param descripcion descripción del recurso.
     * @param ubicacion ubicación física del recurso.
     * @param capacidad capacidad máxima del recurso.
     */
    public void crearRecurso (String nombre, String descripcion, String ubicacion, int capacidad){
        if (nombre.isEmpty() || capacidad <= 0){
            System.out.println("Datos inválidos");
            return;
        }

        Recurso r = new Recurso(nombre, descripcion, ubicacion, capacidad);
        dao.insertar(r);
    }

    /**
     * Muestra por consola todos los recursos registrados.
     */
    public void listarRecursos(){
        List<Recurso> lista = dao.obtenerTodos();

        for (Recurso r : lista){
            System.out.println(r.getIdRecurso() + "-" + r.getNombre() + "-" + r.getDescripcion() + "-" + r.getUbicacion() + "-" + r.getCapacidad());
        }
    }

    /**
     * Elimina un recurso del sistema por su identificador.
     *
     * @param id identificador del recurso.
     */
    public void eliminarRecurso(int id){
        dao.eliminar(id);
    }

    /**
     * Modifica los datos de un recurso existente.
     *
     * @param id identificador del recurso.
     * @param nombre nombre del recurso.
     * @param descripcion descripción del recurso.
     * @param ubicacion ubicación física del recurso.
     * @param capacidad capacidad del recurso.
     */
    public void modificarRecurso(int id, String nombre, String descripcion, String ubicacion, int capacidad){
        Recurso r = new Recurso(nombre, descripcion, ubicacion, capacidad);
        r.setIdRecurso(id);
        dao.modificar(r);
    }

    /**
     * Busca recursos por nombre y muestra los resultados por consola.
     *
     * @param nombre nombre o parte del nombre a buscar.
     */
    public void buscarPorNombre(String nombre){
        List<Recurso> lista = dao.buscarPorNombre(nombre);

        if (lista.isEmpty()){
            System.out.println("No se encontraron recursos con ese nombre");
        } else {
            for (Recurso r : lista){
                System.out.println(r.getIdRecurso() + "-" + r.getNombre() + "-" + r.getDescripcion() + "-" + r.getUbicacion() + "-" + r.getCapacidad());
            }
        }
    }

}