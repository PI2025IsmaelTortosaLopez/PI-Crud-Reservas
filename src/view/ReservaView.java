package view;

import controller.ReservaController;

import java.util.Scanner;

public class ReservaView {

    Scanner sc = new Scanner(System.in);
    ReservaController controller = new ReservaController();

    public void menuReservas(){
        int op;

        do {
            System.out.println("==== MENÚ RESERVAS ====");
            System.out.println("1.Nueva reserva");
            System.out.println("2.Eliminar reserva");
            System.out.println("3.Modificar reserva");
            System.out.println("4.Buscar reservas por usuario");
            System.out.println("5.Buscar reservas por recurso");
            System.out.println("6.Resumen general de reservas");
            System.out.println("0.Volver");

            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    crearReserva();
                    break;
                case 2:
                    eliminarReserva();
                    break;
                case 3:
                    modificarReserva();
                    break;
                case 4:
                    System.out.println("Id Usuario: ");
                    int usuario = sc.nextInt();
                    sc.nextLine();
                    controller.buscarPorUsuario(usuario);
                    break;
                case 5:
                    System.out.println("Id Recurso: ");
                    int recurso = sc.nextInt();
                    sc.nextLine();
                    controller.buscarPorRecurso(recurso);
                    break;
                case 6:
                    controller.listarReservas();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
            }

        } while (op != 0);
    }

    private void crearReserva() {
        System.out.print("ID Recurso: ");
        int idRecurso = sc.nextInt();

        System.out.print("ID Usuario: ");
        int idUsuario = sc.nextInt();
        sc.nextLine();

        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        System.out.print("Hora inicio (HH:MM:SS): ");
        String hi = sc.nextLine();

        System.out.print("Hora fin (HH:MM:SS): ");
        String hf = sc.nextLine();

        System.out.print("Coste: ");
        double coste = sc.nextDouble();

        System.out.print("Plazas: ");
        int plazas = sc.nextInt();
        sc.nextLine();

        System.out.print("Motivo: ");
        String motivo = sc.nextLine();

        System.out.print("Observaciones: ");
        String obs = sc.nextLine();

        controller.crearReserva(idRecurso, idUsuario, fecha, hi, hf, coste, plazas, motivo, obs);
    }

    private void eliminarReserva() {
        controller.listarReservas();

        System.out.print("ID Recurso: ");
        int idRecurso = sc.nextInt();

        System.out.print("ID Reserva Local: ");
        int idReservaLocal = sc.nextInt();
        sc.nextLine();

        controller.eliminarReserva(idRecurso, idReservaLocal);
    }

    private void modificarReserva() {
        controller.listarReservas();

        System.out.print("ID Recurso: ");
        int idRecurso = sc.nextInt();

        System.out.print("ID Reserva Local: ");
        int idReservaLocal = sc.nextInt();

        System.out.print("Nuevo ID Usuario: ");
        int idUsuario = sc.nextInt();
        sc.nextLine();

        System.out.print("Nueva fecha (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        System.out.print("Nueva hora inicio (HH:MM:SS): ");
        String hi = sc.nextLine();

        System.out.print("Nueva hora fin (HH:MM:SS): ");
        String hf = sc.nextLine();

        System.out.print("Nuevo coste: ");
        double coste = sc.nextDouble();

        System.out.print("Nuevas plazas: ");
        int plazas = sc.nextInt();
        sc.nextLine();

        System.out.print("Nuevo motivo: ");
        String motivo = sc.nextLine();

        System.out.print("Nuevas observaciones: ");
        String obs = sc.nextLine();

        controller.modificarReserva(idRecurso, idReservaLocal, idUsuario, fecha, hi, hf, coste, plazas, motivo, obs);
    }

}