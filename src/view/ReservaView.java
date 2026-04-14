package view;

import java.util.Scanner;

public class ReservaView {

    Scanner sc = new Scanner(System.in);

    public void menuReservas(){
        int op;

        do {
            System.out.println("==== MENÚ RESERVAS ====");
            System.out.println("1.Alta reserva");
            System.out.println("2.Baja reserva");
            System.out.println("3.Modificar reserva");
            System.out.println("4.Buscar reservas por usuario");
            System.out.println("5.Buscar reservas por recurso");
            System.out.println("6.Resumen general");
            System.out.println("0.Volver");

            op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.println("Dar de alta nueva reserva");
                    break;
                case 2:
                    System.out.println("Eliminar una reserva");
                    break;
                case 3:
                    System.out.println("Modificar una reserva");
                    break;
                case 4:
                    System.out.println("Buscando por usuario");
                    break;
                case 5:
                    System.out.println("Buscando por recurso");
                    break;
                case 6:
                    System.out.println("Resumen de la reserva");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
            }

        } while (op != 0);
    }
}