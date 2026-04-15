package controller;

import dao.AdministradorDAO;
import dao.UsuarioDAO;
import dao.UsuarioNormalDAO;
import model.Usuario;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class UsuarioController {

    private UsuarioDAO dao = new UsuarioDAO();
    AdministradorDAO administradorDAO = new AdministradorDAO();
    UsuarioNormalDAO usuarioNormalDAO = new UsuarioNormalDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void crearUsuario (String correo, String contrasena, String nombre, String fecha_nacimiento, String tipo_usuario){
        Date fechaSQL = Date.valueOf(fecha_nacimiento);
        Usuario u = new Usuario(correo, contrasena, nombre, fechaSQL, tipo_usuario);
        dao.insertar(u);
    }

    public void listarUsuarios(){
        List<Usuario> lista = dao.obtenerTodos();

        for (Usuario u : lista){
            System.out.println(u.getIdUsuario() + "-" + u.getNombre() + "-" + u.getCorreo());
        }
    }

    public void eliminarUsuario(int id){
        dao.eliminar(id);
    }

    public void modificarUsuario(int id, String correo, String contrasena, String nombre, String fecha_nacimiento, String tipo_usuario){
        Date fechaSQL = Date.valueOf(fecha_nacimiento);
        Usuario u = new Usuario(correo, contrasena, nombre, fechaSQL, tipo_usuario);
        u.setIdUsuario(id);
        dao.modificar(u);
    }

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

    public void buscarPorCorreo(String correo){
        Usuario u = dao.buscarPorCorreo(correo);

        if (u != null){
            System.out.println(u.getIdUsuario() + "-" + u.getNombre() + "-" + u.getCorreo());
        } else {
            System.out.println("Usuario no encontrado con ese correo");
        }

    }

    public void crearAdministrador(String correo, String contrasena, String nombre, String fecha, String telefono_guardia){

        Date fechaSQL = Date.valueOf(fecha);

        Usuario u = new Usuario(correo, contrasena, nombre, fechaSQL, "administrador");

        int id_usuario = usuarioDAO.recuperarId(u);

        if (id_usuario != -1){
            administradorDAO.insertar(id_usuario, telefono_guardia);
        }
    }

    public void crearUsuarioNormal(String correo, String contrasena, String nombre, String fecha, String direccion, String telefono, String foto){

        Date fechaSQL = Date.valueOf(fecha);

        Usuario u = new Usuario(correo, contrasena, nombre, fechaSQL, "normal");

        int id_usuario = usuarioDAO.recuperarId(u);

        if (id_usuario != -1){
            usuarioNormalDAO.insertar(id_usuario, direccion, telefono, foto);
        }
    }

}