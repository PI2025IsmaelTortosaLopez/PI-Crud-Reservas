package view;

import controller.HorarioController;

import java.util.Scanner;

public class HorarioView {

    Scanner sc = new Scanner(System.in);
    HorarioController controller = new HorarioController();

    public void menuHorarios(){
        int op;

        do {
            System.out.println("==== MENÚ HORARIOS ====");
            System.out.println("1.Crear horario");
            System.out.println("2.Eliminar horario");
            System.out.println("3.Modificar horario");
            System.out.println("4.Listar horarios");
            System.out.println("0.Volver");

            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    crearHorario();
                    break;
                case 2:
                    eliminarHorario();
                    break;
                case 3:
                    modificarHorario();
                    break;
                case 4:
                    controller.listarHorarios();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
            }

        } while (op != 0);
    }

    private void crearHorario(){
        System.out.print("Día de la semana: ");
        String dia = sc.nextLine();

        System.out.print("Hora inicio (HH:MM:SS): ");
        String hi = sc.nextLine();

        System.out.print("Hora fin (HH:MM:SS): ");
        String hf = sc.nextLine();

        controller.crearHorario(dia, hi, hf);
    }

    private void eliminarHorario(){
        controller.listarHorarios();

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        controller.eliminarHorario(id);
    }

    private void modificarHorario(){
        controller.listarHorarios();

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nuevo día: ");
        String dia = sc.nextLine();

        System.out.print("Nueva hora inicio: ");
        String hi = sc.nextLine();

        System.out.print("Nueva hora fin: ");
        String hf = sc.nextLine();

        controller.modificarHorarios(id, dia, hi, hf);
    }

}