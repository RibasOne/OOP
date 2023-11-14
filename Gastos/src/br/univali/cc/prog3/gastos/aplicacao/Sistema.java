package br.univali.cc.prog3.gastos.aplicacao;

import br.univali.cc.prog3.gastos.dominio.*;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class Sistema {
    Aplicacao aplicacao;
    
    public Sistema() {
        this.aplicacao = new Aplicacao();
    }
    
    public String lerValor(String rotulo){
        System.out.print(rotulo + ": ");
        Scanner leitor = new Scanner(System.in);
        return leitor.nextLine();
    }
    
    public void menu(){
        
        int inputOpcao;
        do{
            
            System.out.println("==================================");
            System.out.println("1 - Listar gastos");
            System.out.println("2 - Adicionar gastos");
            System.out.println("3 - Obter formas de pagamento");
            System.out.println("4 - Obter tipos de gastos");
            System.out.println("5 - Sair");
            System.out.println("==================================");
            
            inputOpcao = Integer.parseInt(this.lerValor("Digite uma opcao [1-5]"));
            switch (inputOpcao) {
                case 1:
                    listarGastos();
                    break;
                case 2:
                    novoGasto();
                    break;
                case 3:
                    obterFormasPagamento();
                    break;
                case 4:
                    obterTipoGasto();
                    break;
                default:
                    inputOpcao = 5;
                    break;
            }
        }while(inputOpcao != 5);
        
    }
    
    private void listarGastos(){
        int mes = Integer.parseInt(lerValor("Digite o mês (1-12)"));
        int ano = Integer.parseInt(lerValor("Digite o ano"));
        String gastos = this.aplicacao.listarGastos(mes + 1, ano);
        if (gastos.equals(""))
            System.out.println("Nenhum Gasto nesse periodo");
        else{
            System.out.println("Lista de gastos:");
            System.out.println(gastos);
        }
        
    }
    
    private void novoGasto() {
        double valor;
        int dia, mes, ano;
        String descricao;
        
        // Solicita o valor
        do {
            valor = Double.parseDouble(lerValor("Informe o valor do Gasto"));
        } while(valor < 1);
        
        // Selecione a Data
        do {
            dia = Integer.parseInt(lerValor("Informe o Dia do Gasto"));
        } while(dia < 1 || dia > 31);
        
        mes = Integer.parseInt(lerValor("Digite o mês (1-12)"));
        ano = Integer.parseInt(lerValor("Informe o Ano do Gasto"));
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);
        
        Date data = calendar.getTime();
        
        // Cria Tipo de Gasto
        descricao = lerValor("Informe uma descricao para o Tipo de Gasto");
        TipoGasto tipo = new TipoGasto(descricao);
        
        // Cria Forma de Pagamento
        descricao = lerValor("Informe uma descricao para a Forma de Pagamento");
        FormaPagamento forma = new FormaPagamento(descricao);
        
        // Cria Novo Gasto
        this.aplicacao.novoGasto(data, valor, tipo, forma);
    }
    
    private void obterFormasPagamento() {
        String formas = "";

        for (int i = 0; i < this.aplicacao.obterFormasPagamento().length; i++) {
            if (this.aplicacao.obterFormasPagamento()[i] != null)
                formas += (i + 1) + ": " + this.aplicacao.obterFormasPagamento()[i].getDescricao() + "\n";
        }

        if (formas.equals(""))
            formas = "Nenhuma Forma de Pagamento Cadastrada";
        
        System.out.println("Lista das Formas de Pagamento:");
        System.out.println(formas);
    }
    
    private void obterTipoGasto(){
        String tipos = "";

        for (int i = 0; i < this.aplicacao.obterTiposGastos().length; i++) {
            if (this.aplicacao.obterTiposGastos()[i] != null)
                tipos += (i + 1) + ": " + this.aplicacao.obterTiposGastos()[i].getDescricao() + "\n";
        }

        if (tipos.equals(""))
            tipos = "Nenhum Tipo de Gasto Cadastrado";

        System.out.println("Lista dos Tipos de Gastos:");
        System.out.println(tipos);
    }
}