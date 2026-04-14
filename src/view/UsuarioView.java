package view;

import java.util.Scanner;

public class UsuarioView {

    Scanner sc = new Scanner(System.in);

    public void menuUsuarios(){
        int op;

        do {
            System.out.println("==== MENÚ USUARIOS ====");
            System.out.println("1.Dar de alta a un usuario");
            System.out.println("2.Dar de baja a un usuario");
            System.out.println("3.Modificar a un usuario");
            System.out.println("4.Listar usuarios");
            System.out.println("5.Buscar por nombre");
            System.out.println("6.Buscar por correo");
            System.out.println("0.Volver");

            op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.println("Crear usuario (pendiente)");
                    break;
                case 2:
                    System.out.println("Borrar un usuario (pendiente)");
                    break;
                case 3:
                    System.out.println("Modificar usuario");
                    break;
                case 4:
                    System.out.println("Listado de usuarios");
                    break;
                case 5:
                    System.out.println("Buscando por nombre");
                    break;
                case 6:
                    System.out.println("Buscando por correo");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");

                    break;
            }

        } while (op != 0);
    }
}