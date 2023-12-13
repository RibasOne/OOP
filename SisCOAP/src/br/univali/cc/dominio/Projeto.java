package br.univali.cc.dominio;

public class Projeto {
    private String nome;
    private String dataInicio;
    private String dataFim;
    private double margemLucro; // Percentual de lucro 
    public Despesa listaDespesas[];
    
    // Constructor
    public Projeto(String nome, String dataInicio, String dataFim, double margem){
        this.listaDespesas = new Despesa[999];
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.margemLucro = margem;
    }
    
    public double calcularCustoTotal(){ // Custo do projeto
        double custoTotal = 0;
        for(Despesa despesa : listaDespesas){
            if(despesa != null){
                custoTotal += despesa.calcularCusto();
            }
        }
        return custoTotal;
    }
    
    public double calcularPrecoFinal(){ // Custo para o cliente, aplicar percentual de lucro 
        double custoTotal = 0;
        for(Despesa despesa : listaDespesas){
            if(despesa != null){
                custoTotal += despesa.calcularCusto();
            }
        }
        return custoTotal * margemLucro;
    }
    
    public void adicionarDespesa(String descricao, int qtdeHoras, char dificuldade){
        for(int i = 0; i < this.listaDespesas.length; i++){
            if(listaDespesas[i] == null){
                listaDespesas[i] = new MaoObra(descricao, qtdeHoras, dificuldade);
                return;
            }
        }
    }
    
    public void adicionarDespesa(String descricao, double valorUnitario, int qtdeItens){
        for(int i = 0; i < this.listaDespesas.length; i++){
            if(listaDespesas[i] == null){
                listaDespesas[i] = new Aquisicao(descricao, valorUnitario, qtdeItens);
                return;
            }
        }
    }
    
    public String getDescricao(){
        return "Projeto: " + this.nome + "- Data Inicio:" + this.dataInicio + "- Data Final: " + this.dataFim;
    }
}
