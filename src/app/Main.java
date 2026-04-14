package app;
import dao.DBConnection;
import view.ConsolaView;

import java.sql.Connection;

public class Main {
    public static void main(String[] args){

        Connection conexion = DBConnection.conectar();

        if (conexion != null){
            System.out.println("Conexión establecida.");
        }

        ConsolaView menu = new ConsolaView();
        menu.iniciar();

    }
}