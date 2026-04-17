package controller;

import dao.AdministradorDAO;
import dao.UsuarioDAO;
import dao.UsuarioNormalDAO;
import model.Usuario;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con los usuarios.
 * Actúa como intermediario entre la capa DAO y la lógica de la aplicación.
 * Permite crear, modificar, eliminar y consultar usuarios, así como crear usuarios con roles específicos (admin o normal).
 */
public class UsuarioController {

    private UsuarioDAO dao = new UsuarioDAO();
    AdministradorDAO administradorDAO = new AdministradorDAO();
    UsuarioNormalDAO usuarioNormalDAO = new UsuarioNormalDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    /**
     * Crea un nuevo usuario en el sistema.
     *
     * @param correo correo del usuario.
     * @param contrasena contraseña del usuario.
     * @param nombre nombre del usuario.
     * @param fecha_nacimiento fecha de nacimiento del usuario.
     * @param tipo_usuario tipo de usuario.
     */
    public void crearUsuario (String correo, String contrasena, String nombre, String fecha_nacimiento, String tipo_usuario){
        Date fechaSQL = Date.valueOf(fecha_nacimiento);
        Usuario u = new Usuario(correo, contrasena, nombre, fechaSQL, tipo_usuario);
        dao.insertar(u);
    }

    /**
     * Lista de todos los usurios registrados en el sistema.
     */
    public void listarUsuarios(){
        List<Usuario> lista = dao.obtenerTodos();

        for (Usuario u : lista){
            System.out.println(u.getIdUsuario() + "-" + u.getNombre() + "-" + u.getCorreo());
        }
    }

    /**
     * Elimina un usuario del sistema por su identificador.
     *
     * @param id identificador del usuario.
     */
    public void eliminarUsuario(int id){
        dao.eliminar(id);
    }

    /**
     * Modifica los datos de un usuario existente.
     *
     * @param id identificador del usuario.
     * @param correo correo del usuario.
     * @param contrasena contraseña del usuario.
     * @param nombre nombre del usuario.
     * @param fecha_nacimiento fecha de nacimiento del usuario.
     * @param tipo_usuario tipo de usuario.
     */
    public void modificarUsuario(int id, String correo, String contrasena, String nombre, String fecha_nacimiento, String tipo_usuario){
        Date fechaSQL = Date.valueOf(fecha_nacimiento);
        Usuario u = new Usuario(correo, contrasena, nombre, fechaSQL, tipo_usuario);
        u.setIdUsuario(id);
        dao.modificar(u);
    }

    /**
     * Busca usuarios por nombre y muestra los resultados por consola.
     *
     * @param nombre nombre o parte del nombre a buscar.
     */
    public void buscarPorNombre(String nombre){
        List<Usuario> lista = dao.buscarPorNombre(nombre);

        if (lista.isEmpty()){
            System.out.println("No se encontraron usuarios con ese nombre");
        } else {
            for (Usuario u : lista){
                System.out.println(u.getIdUsuario() + "-" + u.getNombre() + "-" + u.getCorreo());
            }
        }
    }

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param correo correo del usuario.
     */
    public void buscarPorCorreo(String correo){
        Usuario u = dao.buscarPorCorreo(correo);

        if (u != null){
            System.out.println(u.getIdUsuario() + "-" + u.getNombre() + "-" + u.getCorreo());
        } else {
            System.out.println("Usuario no encontrado con ese correo");
        }

    }

    /**
     * Crea un usuario con el rol de administrador.
     * Primero se inserta el usuario y después se añade información adicional en la tabla de administradores.
     *
     * @param correo correo del usuario.
     * @param contrasena contraseña del usuario.
     * @param nombre nombre del usuario.
     * @param fecha fecha de nacimiento.
     * @param telefono_guardia teléfono de contacto del administrador.
     */
    public void crearAdministrador(String correo, String contrasena, String nombre, String fecha, String telefono_guardia){

        Date fechaSQL = Date.valueOf(fecha);

        Usuario u = new Usuario(correo, contrasena, nombre, fechaSQL, "administrador");

        int id_usuario = usuarioDAO.recuperarId(u);

        if (id_usuario != -1){
            administradorDAO.insertar(id_usuario, telefono_guardia);
        }
    }

    /**
     * Crea un usuario con rol de usuario normal.
     * Inserta primero el usuario y luego los datos adicionales en su tabla específica.
     *
     * @param correo correo del usuario.
     * @param contrasena contraseña del usuario.
     * @param nombre nombre del usuario.
     * @param fecha fecha de nacimiento.
     * @param direccion dirección del usuario.
     * @param telefono telefono de contacto del usuario.
     * @param foto foto del usuario.
     */
    public void crearUsuarioNormal(String correo, String contrasena, String nombre, String fecha, String direccion, String telefono, String foto){

        Date fechaSQL = Date.valueOf(fecha);

        Usuario u = new Usuario(correo, contrasena, nombre, fechaSQL, "normal");

        int id_usuario = usuarioDAO.recuperarId(u);

        if (id_usuario != -1){
            usuarioNormalDAO.insertar(id_usuario, direccion, telefono, foto);
        }
    }

}