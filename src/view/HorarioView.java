package view;

import java.util.Scanner;

public class HorarioView {

    Scanner sc = new Scanner(System.in);

    public void menuHorarios(){
        int op;

        do {
            System.out.println("==== MENÚ HORARIOS ====");
            System.out.println("1.Alta horario");
            System.out.println("2.Baja horario");
            System.out.println("3.Modificar horario");
            System.out.println("4.Listar horarios");
            System.out.println("0.Volver");

            op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.println("Añadir nuevo horario");
                    break;
                case 2:
                    System.out.println("Eliminar horario");
                    break;
                case 3:
                    System.out.println("Modificar horario");
                    break;
                case 4:
                    System.out.println("Listado de horarios");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
            }

        } while (op != 0);
    }
}