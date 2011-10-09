package CapaNegocios;


public class ClienteSeguro {

    private int idClienteSeguro;

    private int idAgente;

    private int idCliente;

    private int idContratoVida;

    private int idContratoAuto;

    private int idContratoHogar;

    public ClienteSeguro () {
    }

    public int getIdAgente () {
        return idAgente;
    }

    public void setIdAgente (int val) {
        this.idAgente = val;
    }

    public int getIdCliente () {
        return idCliente;
    }

    public void setIdCliente (int val) {
        this.idCliente = val;
    }

    public int getIdClienteSeguro () {
        return idClienteSeguro;
    }

    public void setIdClienteSeguro (int val) {
        this.idClienteSeguro = val;
    }

    public int getIdContratoAuto () {
        return idContratoAuto;
    }

    public void setIdContratoAuto (int val) {
        this.idContratoAuto = val;
    }

    public int getIdContratoHogar () {
        return idContratoHogar;
    }

    public void setIdContratoHogar (int val) {
        this.idContratoHogar = val;
    }

    public int getIdContratoVida () {
        return idContratoVida;
    }

    public void setIdContratoVida (int val) {
        this.idContratoVida = val;
    }

}

