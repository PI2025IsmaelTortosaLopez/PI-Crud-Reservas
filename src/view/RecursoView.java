package view;

import java.util.Scanner;

public class RecursoView {

    Scanner sc = new Scanner(System.in);

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

            switch (op) {
                case 1:
                    System.out.println("Creamos un nuevo recurso");
                    break;
                case 2:
                    System.out.println("Eliminamos un recurso");
                    break;
                case 3:
                    System.out.println("Modificamos un recurso");
                    break;
                case 4:
                    System.out.println("Listado de recrusos");
                    break;
                case 5:
                    System.out.println("Buscando por nombre");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
            }

        } while (op != 0);
    }
}