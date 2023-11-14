package br.univali.cc.prog3.banco.dominio;

public class Banco {
    private String nome;
    private int numero;
    private ContaCorrente[] contas;
    
    // Constructor
    public Banco(String nome, int numero){
        this.nome = nome;
        this.numero = numero;
        this.contas = new ContaCorrente[999];
    }
    
    // Getters
    public String getNome(){
        return nome;
    }
    
    public int getNumero(){
        return numero;
    }
    
    // Methods
    public void criarConta(double saldoInicial){
        for(int i = 0; i < contas.length; i++){
            if(contas[i] == null){
                contas[i] = new ContaCorrente(i, saldoInicial);
                break;
            }
        }
    }
    
    public void criarConta(double saldoInicial, double limite){
        for(int i = 0; i < contas.length; i++){
            if(contas[i] == null){
                contas[i] = new ContaCorrente(i, saldoInicial, limite);
                break;
            }
        }
    }
    
    private ContaCorrente localizarConta(int numeroConta){
        for(int i = 0; i < contas.length; i++){
            if(contas[i] != null && contas[i].getNumero() == numeroConta)
                return contas[i];
        }
        return null;
    }
    
    public void depositar(int numero, double valor) {
        ContaCorrente conta = localizarConta(numero);
        if(conta != null){
            if(conta.depositar(valor))
                System.out.println("Valor depositado");
            else
                System.out.println("Valor invalido!");
        }else{
            System.out.println("Conta nao encontrada!");
        }
    }
    
    public void sacar(int numero, double valor){
        ContaCorrente conta = localizarConta(numero);
        if(conta != null){
            if(conta.sacar(valor))
                System.out.println("Valor sacado");
            else
                System.out.println("Valor invalido!");
        }else
            System.out.println("Conta não encontrada!");
    }
    
    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor){
        ContaCorrente contaOrigem = localizarConta(numeroContaOrigem);
        ContaCorrente contaDestino = localizarConta(numeroContaDestino);
        if(contaOrigem != null && contaDestino != null){
            if(contaOrigem.sacar(valor))
                contaDestino.depositar(valor);
            else
                System.out.println("Valor invalido!");
        }else
            System.out.println("Conta não encontrada!");
    }
    
    public String emitirExtrato(int numero){
        ContaCorrente conta = localizarConta(numero);
        if(conta != null){
            String extrato = "==================================\n";
            //extrato += "\n";
            extrato += "Extrato da Conta - " + numero + "\n";
            extrato += "\n";
            extrato += "Tipo\tDescricao\tValor (R$)\n";
            extrato += " " + conta.emitirExtrato();
            extrato += "\n";
            extrato += "Saldo da Conta: R$ " + conta.getSaldo() + "\n";
            extrato += "==================================";

            return extrato;
        }else
            return "Conta não encontrada!";
    }
}
