package view;

import controller.RecursoController;

import java.util.Scanner;

public class RecursoView {

    Scanner sc = new Scanner(System.in);
    RecursoController controller = new RecursoController();

    public void menuRecursos(){
        int op;

        do {
            System.out.println("==== MENÚ RECURSOS ====");
            System.out.println("1.Alta recurso");
            System.out.println("2.Baja de recurso");
            System.out.println("3.Modificar un recurso");
            System.out.println("4.Lista de recursos");
            System.out.println("5.Buscar recurso por nombre");
            System.out.println("0.Volver");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    crearRecurso();
                    break;
                case 2:
                    eliminarRecurso();
                    break;
                case 3:
                    modificarRecurso();
                    break;
                case 4:
                    controller.listarRecursos();
                    break;
                case 5:
                    buscarRecurso();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
            }

        } while (op != 0);
    }

    private void crearRecurso() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        System.out.print("Ubicación: ");
        String ubicacion = sc.nextLine();

        System.out.print("Capacidad: ");
        int capacidad = sc.nextInt();
        sc.nextLine();

        controller.crearRecurso(nombre, descripcion, ubicacion, capacidad);
    }

    private void eliminarRecurso() {
        System.out.print("ID recurso: ");
        int id = sc.nextInt();
        controller.eliminarRecurso(id);
    }

    private void modificarRecurso() {
        System.out.print("ID recurso: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Nueva descripción: ");
        String descripcion = sc.nextLine();

        System.out.print("Nueva ubicación: ");
        String ubicacion = sc.nextLine();

        System.out.print("Nueva capacidad: ");
        int capacidad = sc.nextInt();
        sc.nextLine();

        controller.modificarRecurso(id, nombre, descripcion, ubicacion, capacidad);
    }

    private void buscarRecurso() {
        System.out.print("Nombre del recurso: ");
        String nombre = sc.nextLine();

        controller.buscarPorNombre(nombre);
    }

}