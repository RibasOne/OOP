package br.univali.cc.dominio;

public class Aquisicao extends Despesa{
    private double valorUnitario;
    private int quantidadeItens;

    // Constructor
    public Aquisicao(String descricao, double valorUnitario, int quantidadeItens) {
        super(descricao);
        this.valorUnitario = valorUnitario;
        this.quantidadeItens = quantidadeItens;
    }

    @Override
    public double calcularCusto() {
        return this.valorUnitario * this.quantidadeItens;
    }
    
}
