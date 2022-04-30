package clases;

public class Membresia {
    int id, idEstado, meses;
    String nombre, fechaCreacion;
    float precio;

    public Membresia() {
    }

    public Membresia(int id, int idEstado, int meses, String nombre, String fechaCreacion, float precio) {
        this.id = id;
        this.idEstado = idEstado;
        this.meses = meses;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
