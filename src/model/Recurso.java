package model;

/**
 * Clase que representa un recurso del sistema de gestión de reservas.
 * Un recurso en este caso es un espacio (por ejemplo, pista de padel, de futbol, etc.).
 * Un recurso puede ser reservado o gestionado en la aplicación.
 */
public class Recurso {

    private int idRecurso;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private int capacidad;

    /**
     * Constructor vacío.
     * Se utiliza principal y únicamente para crear objetos sin inicializar atributos.
     */
    public Recurso (){}

    /**
     * Constructor con parámetros para inicializar un recurso.
     *
     * @param nombre nombre del recurso.
     * @param descripcion descripción del recurso.
     * @param ubicacion ubicación física del recurso.
     * @param capacidad capacidad del recurso.
     */
    public Recurso (String nombre, String descripcion, String ubicacion, int capacidad){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el identificador del recurso.
     *
     * @return id del recurso.
     */
    public int getIdRecurso() {
        return idRecurso;
    }

    /**
     * Establece el identificar del recurso.
     *
     * @param idRecurso identificador del recurso.
     */
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    /**
     * Obtiene el nombre del recurso.
     *
     * @return nombre del recurso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del recurso.
     *
     * @param nombre nombre del recurso.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del recurso.
     *
     * @return descripción del recurso.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del recurso.
     *
     * @param descripcion descripción del recurso.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la ubicación del recurso.
     *
     * @return ubicación del recurso.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación del recurso.
     *
     * @param ubicacion ubicación del recurso.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene la capacidad del recurso.
     *
     * @return capacidad del recurso.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad del recurso.
     *
     * @param capacidad capacidad del recurso.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
