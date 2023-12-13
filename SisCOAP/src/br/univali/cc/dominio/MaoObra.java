package br.univali.cc.dominio;

public class MaoObra extends Despesa{
    private int quantidadeHoras;
    private char dificuldade;
    
    // Constructor
    public MaoObra(String descricao, int qtde, char dificuldade) {
        super(descricao);
        this.quantidadeHoras = qtde;
        this.dificuldade = dificuldade;
    }

    @Override
    public double calcularCusto() {
        switch(this.dificuldade){
            case 'F':
                return quantidadeHoras * 10;
            case 'M':
                return quantidadeHoras * 25;
            case 'D':
                return quantidadeHoras * 50;
            default:
                return -1;
        }
    }
}
