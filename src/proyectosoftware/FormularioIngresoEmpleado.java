package proyectosoftware;

/**
 *
 * @author mao_a
 */
public class FormularioIngresoEmpleado {
    private String cedulaIngresada;
    private String nombreIngresado;
    private String apellidoIngresado;
    private String categoriaIngresada;
    private String contratoIngresado;
    private int horasEquivalentesIngresadas;
    private double salarioNetoIngresado;

    public FormularioIngresoEmpleado(String cedulaIngresada, String nombreIngresado, String apellidoIngresado, String categoriaIngresada, String contratoIngresado, int horasEquivalentesIngresadas, double salarioNetoIngresado) {
        this.cedulaIngresada = cedulaIngresada;
        this.nombreIngresado = nombreIngresado;
        this.apellidoIngresado = apellidoIngresado;
        this.categoriaIngresada = categoriaIngresada;
        this.contratoIngresado = contratoIngresado;
        this.horasEquivalentesIngresadas = horasEquivalentesIngresadas;
        this.salarioNetoIngresado = salarioNetoIngresado;
    }

    public String getCedulaIngresada() {
        return cedulaIngresada;
    }

    public String getNombreIngresado() {
        return nombreIngresado;
    }

    public String getApellidoIngresado() {
        return apellidoIngresado;
    }

    public String getCategoriaIngresada() {
        return categoriaIngresada;
    }

    public String getContratoIngresado() {
        return contratoIngresado;
    }

    public int getHorasEquivalentesIngresadas() {
        return horasEquivalentesIngresadas;
    }

    public double getSalarioNetoIngresado() {
        return salarioNetoIngresado;
    }
    
    
}
