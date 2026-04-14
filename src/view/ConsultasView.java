package view;

import java.util.Scanner;

public class ConsultasView {

    Scanner sc = new Scanner(System.in);

    public void menuConsultas(){
        int op;

        do {
            System.out.println("==== MENÚ CONSULTAS Y LISTADOS ====");
            System.out.println("1.Listar administradores");
            System.out.println("2.Listar usuarios normales");
            System.out.println("3.Listar recursos disponibles por horario");
            System.out.println("4.Listar reservas de un usuario");
            System.out.println("5.Listar reservas de un recurso");
            System.out.println("6.Resumen general");
            System.out.println("0.Volver");

            op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.println("Listado de usuarios administradores");
                    break;
                case 2:
                    System.out.println("Listado de usuarios normales");
                    break;
                case 3:
                    System.out.println("Listado de recursos disponibles");
                    break;
                case 4:
                    System.out.println("Listado de reservas de un usuario");
                    break;
                case 5:
                    System.out.println("Listado de reservas de un recurso");
                    break;
                case 6:
                    System.out.println("Resumen general");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");

                    break;
            }

        } while (op != 0);
    }
}