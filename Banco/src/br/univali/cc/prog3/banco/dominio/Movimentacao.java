package br.univali.cc.prog3.banco.dominio;

public class Movimentacao {
    private String descricao;
    private char tipo;
    private double valor;
    
    // Constructor
    public Movimentacao(String descricao, char tipo, double valor){
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }
    
    // Getter
    public String getMovimentacao(){
        return tipo + "\t" + descricao + "\t" + valor + "\n";
    }
}