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
                    System.exit(0);
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
    
    private void adicionarDespesa() {
        String opcaoDespesa = lerValor("Defina o tipo de despesa: [A] para aquisição e [M] para mão de obra");

        if(opcaoDespesa.charAt(0) == 'A'){
            adicionarDespesaAquisicao();
        }else{
            adicionarDespesaMaoDeObra();
        }

        String opcaoContinuar = lerValor("Adicionar outra despesa? [S] para sim, [N] para não");

        if(opcaoContinuar.charAt(0) == 'S'){
            adicionarDespesa();
        }else{
            imprimirResumoDoProjeto();
        }
    }

    private void adicionarDespesaAquisicao(){
        String descricao = lerValor("Dê uma descrição para esta despesa");
        double valorUnitario = Double.parseDouble(lerValor("Defina o valor unitário"));
        int quantidadeItens = Integer.parseInt(lerValor("Defina a quantidade de itens"));

        projeto.adicionarDespesa(descricao, valorUnitario, quantidadeItens);
    }

    private void adicionarDespesaMaoDeObra(){
        String descricao = lerValor("Dê uma descrição para esta despesa");
        int qtdeHoras = Integer.parseInt(lerValor("Defina a quantidade de horas de atividade"));
        String dificuldade = lerValor("Defina a dificuldade da atividade? - [F]: Fácil - [M]: Média - [D]: Difícil");

        projeto.adicionarDespesa(descricao, qtdeHoras, dificuldade.charAt(0));
    }

    private void imprimirResumoDoProjeto(){
        System.out.println("Descrição do Projeto: " + this.projeto.getDescricao());
        System.out.println("Custo Total: R$" + this.projeto.calcularCustoTotal());
        System.out.println("Valor Final: R$" + this.projeto.calcularPrecoFinal());
    }
}
