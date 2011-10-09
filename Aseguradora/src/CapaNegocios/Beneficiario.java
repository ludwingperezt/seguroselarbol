package CapaNegocios;


public class Beneficiario extends Cliente {

    private int idBeneficiario;

    private int idContratoVida;

    private int idContratoHogar;

    public Beneficiario () {
    }

    public int getIdBeneficiario () {
        return idBeneficiario;
    }

    public void setIdBeneficiario (int val) {
        this.idBeneficiario = val;
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

