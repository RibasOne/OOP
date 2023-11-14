package br.univali.cc.prog3.garagemsteve.dominio;

public class Caminhao extends VeiculoTerrestre implements Veiculo{
    private double capacidadeCarga;

    public Caminhao(double capacidade, String modelo, String placa){
        super(modelo, placa);
        this.capacidadeCarga = capacidade;
    }

    public double getCapacidadeCarga(){
        return capacidadeCarga;
    }
    
    @Override
    public String obterDescricaoVeiculo(){
        return "Caminhão => " + super.detalhar() + "- Capacidade de Carga: " + this.capacidadeCarga;
    }
}
