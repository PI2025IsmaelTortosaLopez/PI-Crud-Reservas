package model;
import java.sql.Date;

/**
 * Clase que representa un usuario dentro del sistema de gestión de reservas.
 * Contiene la información básica para poder identificar y gestionar a un usuario dentro del sistema de gestión de reservas.
 */
public class Usuario {

    private int idUsuario;
    private String correo;
    private String contrasena;
    private String nombre;
    private Date fechaNacimiento;
    private String tipoUsuario;

    /**
     * Constructor vacío.
     * Se utiliza principal y únicamente para crear objetos sin inicializar atributos.
     */
    public Usuario(){}

    /**
     * Constructor con parámetros para inicializar un usuario dentro del sistema.
     *
     * @param correo Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @param nombre Nombre del usuario.
     * @param fechaNacimiento Fecha de nacimiento del usuario.
     * @param tipoUsuario Tipo de usuario
     */
    public Usuario (String correo, String contrasena, String nombre, Date fechaNacimiento, String tipoUsuario){
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Obtiene el identificar del usuario.
     *
     * @return id del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param idUsuario identificador del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return correo del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo correo del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return fecha de nacimiento.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento fecha de nacimiento.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el tipo de usuario.
     *
     * @return tipo de usuario.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipoUsuario tipo de usuario.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}