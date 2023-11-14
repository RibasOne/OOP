package br.univali.cc.prog3.garagemsteve.dominio;

abstract public class VeiculoTerrestre {
    protected String modelo;
    protected String placa;
    protected String motorista;

    public VeiculoTerrestre(String modelo, String placa){
        this.modelo = modelo;
        this.placa = placa;
    }

    public void setMotorista(String nome){
        this.motorista = nome;
    }

    public String getPlaca(){
        return placa;
    }

    public String detalhar(){
        return "Modelo: " + this.modelo + "- Placa: " + this.placa + "- Motorista: " + this.motorista;
    }
}
