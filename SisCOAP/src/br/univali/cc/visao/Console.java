package br.univali.cc.visao;

import br.univali.cc.dominio.*;
import java.util.Scanner;

public class Console {
    Projeto projeto;
    
    public String lerValor(String rotulo){
        System.out.print(rotulo + ": ");
        Scanner leitor = new Scanner(System.in);
        return leitor.nextLine();
    }
    
    public void menu(){
        int opcao;
        
        do{
            System.out.println("1 - Criar Projeto");
            System.out.println("2 - Adicionar despesa");
            System.out.println("3 - Sair");
            
            opcao = Integer.parseInt(lerValor("Escolha uma opcao"));
            
            switch(opcao){
                case 1:
                    criarProjeto();
                    break;
                case 2:
                    adicionarDespesa();
                    break;
                default:
            }
        }while(opcao != 5);
        
    }
    
    private void criarProjeto(){
        String nome = lerValor("De um nome ao seu projeto");
        String dataInicio = lerValor("Defina uma data inicial para o projeto");
        String dataFim = lerValor("Defina uma data final para o projeto");
        double margemLucro = Double.parseDouble(lerValor("Define a margem de lucro do projeto (apenas numeros)"));
        
        margemLucro = (margemLucro / 100) + 1;
        
        projeto = new Projeto(nome, dataInicio, dataFim, margemLucro);
    }
    
    private void adicionarDespesa(){
        
        // Start: Adicionar Despesa
        
        String opcaoDespesa;
        opcaoDespesa = lerValor("Defina o tipo de despesa: [A] para aquisicao e [M] para mão de obra");
            
        
        if(opcaoDespesa.charAt(0) == 'A'){
            String descricao = lerValor("Escreve uma descricao para esta despesa");
            double valorUnitario = Double.parseDouble(lerValor("Defina o valor unitario"));
            int quantidadeItens = Integer.parseInt(lerValor("Defina a quantidade de itens"));
            
            projeto.adicionarDespesa(descricao, valorUnitario, quantidadeItens);
        }else{
            String descricao = lerValor("Escreve uma descricao para esta despesa");
            int qtdeHoras = Integer.parseInt(lerValor("Defina a quantidade de horas de atividade"));
            String dificuldade = lerValor("Defina a dificuldade da atividade");
            
            projeto.adicionarDespesa(descricao, qtdeHoras, dificuldade.charAt(0));
        }
        
        // End: Adicionar Despesa
        String opcaoContinuar = lerValor("Adicionar outra despesa? [S] para sim, [N] para não");
        
        if(opcaoContinuar.charAt(0) == 'N'){
            calcularCustoProjeto();
            calcularCustoCliente();
        }
    }
    
    private void calcularCustoProjeto(){
//        String custoTotal = "";
//        for(int i = 0; i < projeto.listaDespesas.length; i++){
//            if(this.projeto.listaDespesas[i] != null){
//                custoTotal += "Custo total do projeto: " + projeto.calcularCustoTotal() + "\n";
//            }
//        }
//        return custoTotal;
        this.projeto.calcularCustoTotal();
    }
    
    private void calcularCustoCliente(){
//        String custoTotal = "";
//        for(int i = 0; i < projeto.listaDespesas.length; i++){
//            if(this.projeto.listaDespesas[i] != null){
//                custoTotal += "Valor a ser cobrado do cliente: " + projeto.calcularPrecoFinal()+ "\n";
//            }
//        }
//        return custoTotal;
        this.projeto.calcularPrecoFinal();
    }
    
}
