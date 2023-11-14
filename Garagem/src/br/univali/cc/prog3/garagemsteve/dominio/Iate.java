package br.univali.cc.prog3.garagemsteve.dominio;

public class Iate implements Veiculo{
    private String nome;
    private String capitao;

    public Iate(String nome){
        this.nome = nome;
    }

    public void setCapitao(String nome){
        this.capitao = nome;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String obterDescricaoVeiculo() {
        return "Iate => Nome: " + this.nome + "- Capitao: " + this.capitao;
    }
}
