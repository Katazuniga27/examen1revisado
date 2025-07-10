/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoevaluado;

/**
 *
 * @author milkyaakath
 */
public class Agente {
    //Atributos
    private String nombreAgente;
    private String cedulaAgente;
    private String codigoAgente;
    private String sucursalAgente;
    private boolean vehiculoAgente;
    
    //método constructor

    public Agente(String nombreAgente, String cedulaAgente, String codigoAgente, String sucursalAgente, boolean vehículoAgente) {
        this.nombreAgente = nombreAgente;
        this.cedulaAgente = cedulaAgente;
        this.codigoAgente = codigoAgente;
        this.sucursalAgente = sucursalAgente;
        this.vehiculoAgente = vehículoAgente;
    }
    
    //setters n getters

    public String getNombreAgente() {
        return nombreAgente;
    }

    public void setNombreAgente(String nombreAgente) {
        this.nombreAgente = nombreAgente;
    }

    public String getCedulaAgente() {
        return cedulaAgente;
    }

    public void setCedulaAgente(String cedulaAgente) {
        this.cedulaAgente = cedulaAgente;
    }

    public String getCodigoAgente() {
        return codigoAgente;
    }

    public void setCodigoAgente(String codigoAgente) {
        this.codigoAgente = codigoAgente;
    }

    public String getSucursalAgente() {
        return sucursalAgente;
    }

    public void setSucursalAgente(String sucursalAgente) {
        this.sucursalAgente = sucursalAgente;
    }

    public boolean isVehículoAgente() {
        return vehiculoAgente;
    }

    public void setVehículoAgente(boolean vehículoAgente) {
        this.vehiculoAgente = vehículoAgente;
    }
    
   
}
