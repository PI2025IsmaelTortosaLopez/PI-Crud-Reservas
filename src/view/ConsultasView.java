package view;

import controller.ReservaController;
import model.Reserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsultasView {

    Scanner sc = new Scanner(System.in);
    public ReservaController controller = new ReservaController();

    public void menuConsultas(){
        int op;

        do {
            System.out.println("==== MENÚ CONSULTAS ====");
            System.out.println("1.Reservas de hoy");
            System.out.println("2.Reservas en un día concreto");
            System.out.println("3.Recursos más usados");
            System.out.println("0.Volver");

            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    reservasHoy();
                    break;
                case 2:
                    reservasPorFecha();
                    break;
                case 3:
                    recursosMasUsados();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
            }

        } while (op != 0);
    }

    private void reservasHoy() {

        LocalDate hoy = LocalDate.now();

        List<Reserva> lista = controller.reservasPorFecha(hoy);

        System.out.println("==== RESERVAS DE HOY ====");

        lista.forEach(r -> System.out.println("Id recurso: " + r.getIdRecurso() + " - " + "Fecha: " + r.getFecha() + " - "
                + "Hora inicio: " + r.getHoraInicio() + " - " + "Hora fin: " + r.getHoraFin()));
    }

    private void reservasPorFecha() {

        System.out.println("Introduce fecha (YYYY-MM-DD):");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        List<Reserva> lista = controller.reservasPorFecha(fecha);

        System.out.println("==== RESERVAS DEL DÍA ====");

        for (Reserva r : lista) {
            System.out.println("Id recurso: " + r.getIdRecurso() + " - " + "Fecha: " + r.getFecha() + " - "
                    + "Hora inicio: " + r.getHoraInicio() + " - " + "Hora fin: " + r.getHoraFin());
        }
    }

    private void recursosMasUsados() {

        Map<String, Integer> datos = controller.recursosMasUsados();

        System.out.println("==== RECURSOS MÁS USADOS ====");

        datos.forEach((recurso, veces) -> {
            System.out.println(recurso + " → " + veces + " reservas");
        });
    }

}