package br.univali.cc.dominio;


abstract public class Despesa {
    protected String descricao;
    
    // 
    public Despesa(String descricao){
        this.descricao = descricao;
    }
    
    abstract public double calcularCusto();
}
