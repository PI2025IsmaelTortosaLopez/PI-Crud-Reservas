package view;

import java.util.Scanner;

public class ConsolaView {

    Scanner sc = new Scanner(System.in);

    UsuarioView usuarioView = new UsuarioView();
    RecursoView recursoView = new RecursoView();
    HorarioView horarioView = new HorarioView();
    ReservaView reservaView = new ReservaView();
    ConsultasView consultasView = new ConsultasView();

    public void iniciar(){
        menuPrincipal();
    }

    private void menuPrincipal(){
        int op;

        do {
            System.out.println("==== MENÚ PRINCIPAL ====");
            System.out.println("1.Usuarios");
            System.out.println("2.Recursos");
            System.out.println("3.Horarios");
            System.out.println("4.Reservas");
            System.out.println("5.Consultas");
            System.out.println("0.Salir");

            op = sc.nextInt();

            switch (op){
                case 1:
                    usuarioView.menuUsuarios();
                    break;
                case 2:
                    recursoView.menuRecursos();
                    break;
                case 3:
                    horarioView.menuHorarios();
                    break;
                case 4:
                    reservaView.menuReservas();
                    break;
                case 5:
                    consultasView.menuConsultas();
                case 0:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (op != 0);
    }
}