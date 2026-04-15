package view;

import controller.UsuarioController;

import java.util.Scanner;

public class UsuarioView {

    Scanner sc = new Scanner(System.in);

    UsuarioController controller = new UsuarioController();

    public void menuUsuarios(){
        int op;

        do {
            System.out.println("==== MENÚ USUARIOS ====");
            System.out.println("1.Crear administrador");
            System.out.println("2.Crear usuario normal");
            System.out.println("3.Dar de baja a un usuario");
            System.out.println("4.Modificar a un usuario");
            System.out.println("5.Listar usuarios");
            System.out.println("6.Buscar por nombre");
            System.out.println("7.Buscar por correo");
            System.out.println("0.Volver");

            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    crearAdministrador();
                    break;
                case 2:
                    crearUsuarioNormal();
                    break;
                case 3:
                    eliminarUsuario();
                    break;
                case 4:
                    modificarUsuario();
                    break;
                case 5:
                    controller.listarUsuarios();
                    break;
                case 6:
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    controller.buscarPorNombre(nombre);
                    break;
                case 7:
                    System.out.println("Correo: ");
                    String correo = sc.nextLine();
                    controller.buscarPorCorreo(correo);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
            }
        } while (op != 0);
    }

    private void crearUsuario(){
        System.out.println("Correo: ");
        String correo = sc.nextLine();

        System.out.println("Contraseña: ");
        String contrasena = sc.nextLine();

        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Fecha de nacimiento (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        System.out.println("Tipo (administrador/usuarionormal): ");
        String tipo = sc.nextLine();

        controller.crearUsuario(correo, contrasena, nombre, fecha, tipo);
    }

    private void eliminarUsuario(){
        System.out.println("ID usuario: ");
        int id = sc.nextInt();
        controller.eliminarUsuario(id);
    }

    private void modificarUsuario(){
        System.out.println("ID usuario: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Nuevo correo: ");
        String correo = sc.nextLine();

        System.out.println("Nueva contraseña: ");
        String contrasena = sc.nextLine();

        System.out.println("Nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Nueva fecha de nacimiento (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        System.out.println("Tipo (administrador/usuarionormal): ");
        String tipo = sc.nextLine();

        controller.modificarUsuario(id, correo, contrasena, nombre, fecha, tipo);
    }

    private void crearAdministrador(){
        System.out.println("Correo: ");
        String correo = sc.nextLine();

        System.out.println("Contraseña: ");
        String contrasena = sc.nextLine();

        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Fecha de nacimiento (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        System.out.println("Teléfono de guardia: ");
        String telefono = sc.nextLine();

        controller.crearAdministrador(correo, contrasena, nombre, fecha, telefono);
    }

    private void crearUsuarioNormal(){
        System.out.println("Correo: ");
        String correo = sc.nextLine();

        System.out.println("Contraseña: ");
        String contrasena = sc.nextLine();

        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Fecha de nacimiento (YYYY-MM-DD): ");
        String fecha = sc.nextLine();

        System.out.println("Dirección: ");
        String direccion = sc.nextLine();

        System.out.println("Teléfono: ");
        String telefono = sc.nextLine();

        System.out.println("Foto: ");
        String foto = sc.nextLine();

        controller.crearUsuarioNormal(correo, contrasena, nombre, fecha, direccion, telefono, foto);
    }

}