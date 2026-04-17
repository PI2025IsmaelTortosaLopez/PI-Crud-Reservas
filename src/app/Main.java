package app;
import dao.DBConnection;
import view.ConsolaView;

import java.sql.Connection;

/**
 * Clase principal de la aplicación.
 * Es el punto de entrada del programa y se encarga de iniciar la conexión con la base de datos y lanzar la interfaz de consola.
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del programa.
     *
     * @param args
     */
    public static void main(String[] args){

        Connection conexion = DBConnection.conectar();

        if (conexion != null){
            System.out.println("Conexión establecida.");
        }

        ConsolaView menu = new ConsolaView();
        menu.iniciar();

    }
}