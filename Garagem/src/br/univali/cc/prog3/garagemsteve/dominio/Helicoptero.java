package br.univali.cc.prog3.garagemsteve.dominio;

public class Helicoptero implements Veiculo{
    private String modelo;
    private String sigla;
    private String piloto;

    public Helicoptero(String modelo, String sigla){
        this.modelo = modelo;
        this.sigla = sigla;
    }

    public void setPiloto(String nome){
        this.piloto = nome;
    }

    public String detalhar(){
        return "Modelo: " + this.modelo + "- Sigla: " + this.sigla + "- Piloto: " + this.piloto;
    }

    @Override
    public String obterDescricaoVeiculo() {
        return "Helicoptero => " + this.detalhar();
    }
}
