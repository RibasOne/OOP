package br.univali.cc.prog3.banco.dominio;

public class ContaCorrente {
    private boolean especial;
    private double limite;
    private int numero;
    private double saldo;
    private Movimentacao[] movimentacoes;
    
    // Constructors
    public ContaCorrente(int numero, double saldoInicial){
        this.especial = false;
        this.numero = numero;
        this.saldo = saldoInicial;
        this.limite = 0;
        this.movimentacoes = new Movimentacao[999];
    }
    
    public ContaCorrente(int numero, double saldoInicial, double limite){
        this.especial = true;
        this.numero = numero;
        this.saldo = saldoInicial;
        this.limite = limite;
        this.movimentacoes = new Movimentacao[999];
    }
    
    // Getters
    public int getNumero(){
        return numero;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    // Methods
    private void criarMovimentacao(String descricao, char tipo, double valor){
        for(int i = 0; i < movimentacoes.length; i++){
            if(movimentacoes[i] == null){
                movimentacoes[i] = new Movimentacao(descricao, tipo, valor);
                break;
            }
        }
    }
    
    protected boolean depositar(double valor){
        if(valor > 0){
            this.saldo += valor;
            criarMovimentacao("Deposito", 'D', valor);
            return true;
        }
        
        return false;
    }
    
    protected boolean sacar(double valor){
        if(valor > 0 && valor <= this.saldo + this.limite){
            this.saldo -= valor;
            criarMovimentacao("Saque", 'S', valor);
            return true;
        }
        
        return false;
    }
    
    protected String emitirExtrato(){
        String extrato = "";
        for(Movimentacao movimentacao : movimentacoes){
            if(movimentacao != null)
                extrato += movimentacao.getMovimentacao();
        }
        
        return extrato;
    }
}