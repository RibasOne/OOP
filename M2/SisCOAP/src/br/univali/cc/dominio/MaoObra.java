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
    public double calcularCusto() { // Mudar = if's talvez fiquem na interface, ou em Projeto???
        if(this.dificuldade == 'F'){
            return quantidadeHoras * 10;
        }else if(this.dificuldade == 'M'){
            return quantidadeHoras * 25;
        }else if(this.dificuldade == 'D'){
            return quantidadeHoras * 50;
        }
        // return quantidadeHoras * 10;
    }
}
