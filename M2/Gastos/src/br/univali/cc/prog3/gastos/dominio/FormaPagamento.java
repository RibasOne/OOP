package br.univali.cc.prog3.gastos.dominio;

public class FormaPagamento {
    private String descricao;
    
    // Constructor
    public FormaPagamento(String descricao){
        this.descricao = descricao;
    }
    
    // Getter
    public String getDescricao(){
        return descricao;
    }
    
    // Setter
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
