package br.univali.cc.prog3.banco.aplicacao;

import br.univali.cc.prog3.banco.dominio.*;
import java.util.Scanner;

public class Sistema {
    Banco banco;
    
    public Sistema(){
        this.banco = new Banco("Banco", 1);
    }
    
    public String lerValor(String rotulo){
        System.out.print(rotulo + ": ");
        Scanner leitor = new Scanner(System.in);
        return leitor.nextLine();
    }
    
    public void menu(){
        System.out.println("==================================");
        System.out.println("\tBem-vindo ao " + this.banco.getNome());
        System.out.println("==================================");
        
        int inputOpcao;
        do{
            
            System.out.println("==================================");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Extrato");
            System.out.println("6 - Sair");
            System.out.println("==================================");
            
            inputOpcao = Integer.parseInt(this.lerValor("Digite uma opcao [1-6]"));
            if(inputOpcao == 1){
                criarConta();
            }
            else if(inputOpcao == 2){
                sacar();
            }
            else if(inputOpcao == 3){
                depositar();
            }
            else if(inputOpcao == 4){
                transferir();
            }
            else if(inputOpcao == 5){
                emitirExtrato();
            }
        }while(inputOpcao != 6);
    }
    
    private void criarConta(){
        
        double saldoInicial = Double.parseDouble(lerValor("Informe o saldo inicial"));
        String isContaEspecial = lerValor("É conta especial? [S ou N]");
        
        if(isContaEspecial.equals("S")){
            double limite = Double.parseDouble(lerValor("Informe o limite"));
            banco.criarConta(saldoInicial, limite);
        }else
            banco.criarConta(saldoInicial);
    }
    
    private void sacar(){
        int numeroConta = Integer.parseInt(lerValor("Informe o numero da conta"));
        double valor = Double.parseDouble(lerValor("Informe o valor"));
        banco.sacar(numeroConta, valor);
    }
    
    private void depositar(){
        int numeroConta = Integer.parseInt(lerValor("Informe o numero da conta"));
        double valor = Double.parseDouble(lerValor("Informe o valor"));
        banco.depositar(numeroConta, valor);
    }
    
    private void transferir(){
        int numeroContaOrigem = Integer.parseInt(lerValor("Informe o numero da conta de origem"));
        int numeroContaDestino = Integer.parseInt(lerValor("Informe o numero da conta de destino"));
        double valor = Double.parseDouble(lerValor("Informe o valor"));
        banco.transferir(numeroContaOrigem, numeroContaDestino, valor);
    }
    
    private void emitirExtrato(){
        int numeroConta = Integer.parseInt(lerValor("Informe o numero da conta"));
        System.out.println(banco.emitirExtrato(numeroConta));
    }
}