package br.univali.cc.prog3.gastos.dominio;

import java.time.LocalDate;

public class Gasto {
    private LocalDate data;
    private double valor;
    private TipoGasto tipo;
    private FormaPagamento forma;
    
    public Gasto(LocalDate data, double valor, TipoGasto tipo, FormaPagamento forma){
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.forma = forma;
    }
    
    public LocalDate getData() {
        return data;
    }

    public String obterDescricao() {
        return "(" + this.data + ") " + this.tipo.getDescricao() + " -> " + this.forma.getDescricao() + " : R$ " + this.valor;
    }
}
