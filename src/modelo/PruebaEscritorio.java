/**
 * La clase PruebaEscritorio tiene atributos (instancias de clase), para el estado,
 * simbolo y entrada.
 */
package modelo;

import javafx.beans.property.*;

public class PruebaEscritorio 
{
    /**
     * Propiedades de la clase PruebaEscritorio. 
     * Nos ayudara a recibir notificaciones automaticamente cuando el valor de una 
     * variable cambie. Ayuda a mantener sincronizados la vista y los datos
     */
    private final StringProperty estado;
    private final StringProperty simbolo;
    private final StringProperty entrada;

    public PruebaEscritorio()
    {
        estado = new SimpleStringProperty();
        simbolo = new SimpleStringProperty();
        entrada = new SimpleStringProperty();
    }
    
    public PruebaEscritorio(String estado, String simbolo)
    {
        this.estado = new SimpleStringProperty(estado);
        this.simbolo = new SimpleStringProperty(simbolo);
        entrada = new SimpleStringProperty();
    }
    
    public PruebaEscritorio(String estado, String simbolo, String entrada)
    {
        this.estado = new SimpleStringProperty(estado);
        this.simbolo = new SimpleStringProperty(simbolo);
        this.entrada = new SimpleStringProperty(entrada);
    }
    
    public PruebaEscritorio(String estado)
    {
        this.estado = new SimpleStringProperty(estado);
        simbolo = new SimpleStringProperty();
        entrada = new SimpleStringProperty();
    }
    
    public StringProperty getEstadoPro()
    {
        return estado;
    }
    
    public String getEstado()
    {
        return estado.get();
    }
    
    public void setEstado(String estado)
    {
        this.estado.set(estado);
    }
    
    public StringProperty getSimboloPro()
    {
        return simbolo;
    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo.get();
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo.set(simbolo);
    }

    public StringProperty getEntradaPro()
    {
        return entrada;
    }
    
    /**
     * @return the entrada
     */
    public String getEntrada() {
        return entrada.get();
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(String entrada) {
        this.entrada.set(entrada);
    }
    
    
}