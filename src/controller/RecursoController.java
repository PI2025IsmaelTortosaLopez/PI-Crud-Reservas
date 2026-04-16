package controller;

import dao.RecursoDAO;
import model.Recurso;

import java.util.List;


public class RecursoController {

    private RecursoDAO dao = new RecursoDAO();

    public void crearRecurso (String nombre, String descripcion, String ubicacion, int capacidad){
        if (nombre.isEmpty() || capacidad <= 0){
            System.out.println("Datos inválidos");
            return;
        }

        Recurso r = new Recurso(nombre, descripcion, ubicacion, capacidad);
        dao.insertar(r);
    }

    public void listarRecursos(){
        List<Recurso> lista = dao.obtenerTodos();

        for (Recurso r : lista){
            System.out.println(r.getIdRecurso() + "-" + r.getNombre() + "-" + r.getDescripcion() + "-" + r.getUbicacion() + "-" + r.getCapacidad());
        }
    }

    public void eliminarRecurso(int id){
        dao.eliminar(id);
    }

    public void modificarRecurso(int id, String nombre, String descripcion, String ubicacion, int capacidad){
        Recurso r = new Recurso(nombre, descripcion, ubicacion, capacidad);
        r.setIdRecurso(id);
        dao.modificar(r);
    }

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