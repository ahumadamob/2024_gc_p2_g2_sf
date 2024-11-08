package gc._4.pr2.grupo2.dto;

public class DTOGuardiaDeSeguridad<T> {
    private boolean estado;
    private String mensaje;
    private T objeto;

    public DTOGuardiaDeSeguridad(boolean estado, String mensaje, T objeto) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.objeto = objeto;
    }

    // Getters y setters
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }
}

