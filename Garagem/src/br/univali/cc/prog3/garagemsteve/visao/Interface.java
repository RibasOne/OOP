package br.univali.cc.prog3.garagemsteve.visao;

import java.util.Scanner;
import br.univali.cc.prog3.garagemsteve.dominio.*;

public class Interface {
    Galpao galpao;

    public Interface(){
        this.galpao = new Galpao();
    }

    public String lerValor(String rotulo){
        System.out.print(rotulo + ": ");
        Scanner leitor = new Scanner(System.in);
        return leitor.nextLine();
    }

    public void menu(){
        int opcao;
        do{
            System.out.println("--------------------");
            System.out.println("1 - Adicionar Carro");
            System.out.println("2 - Adicionar Caminhao");
            System.out.println("3 - Adicionar Iate");
            System.out.println("4 - Adicionar Helicoptero");
            System.out.println("5 - Mostrar veiculos do Galpao");
            System.out.println("6 - Sair");

            opcao = Integer.parseInt(this.lerValor("Digite uma opção [1-6]"));

            switch(opcao){
                case 1:
                    adicionarCarro();
                    break;
                case 2:
                    adicionarCaminhao();
                    break;
                case 3:
                    adicionarIate();
                    break;
                case 4:
                    adicionarHelicoptero();
                    break;
                case 5:
                    mostrarVeiculos();
                    break;
            }
        }while(opcao != '6');
    }

    private void adicionarCarro(){
        Double potencia = Double.parseDouble(this.lerValor("Digite a potencia do carro"));
        String modelo = this.lerValor("Digite o modelo do carro");
        String placa = this.lerValor("Digite a placa do carro");

        Carro carro = new Carro(potencia, modelo, placa);

        String motorista = this.lerValor("Digite o nome do motorista");
        carro.setMotorista(motorista);

        // Cria um novo Veiculo => Carro
        this.galpao.adicionarVeiculo(carro);
    }

    private void adicionarCaminhao(){
        double capacidade = Double.parseDouble(this.lerValor("Digite a capacidade de carga do caminhao"));
        String modelo = this.lerValor("Digite o modelo do caminhao");
        String placa = this.lerValor("Digite a placa do caminhao");

        Caminhao caminhao = new Caminhao(capacidade, modelo, placa);

        // Cria um novo Veiculo => Caminhao
        this.galpao.adicionarVeiculo(caminhao);
    }

    private void adicionarIate(){
        String nome = this.lerValor("Digite o nome do iate");

        Iate iate = new Iate(nome);

        String capitao = this.lerValor("Digite o nome do capitao");
        iate.setCapitao(capitao);

        // Cria um novo Veiculo => Iate
        this.galpao.adicionarVeiculo(iate);
    }

    private void adicionarHelicoptero(){
        String modelo = this.lerValor("Digite o modelo do helicoptero");
        String sigla = this.lerValor("Digite a sigla do helicoptero");

        Helicoptero helicoptero = new Helicoptero(modelo, sigla);

        String piloto = lerValor("Digite o nome do piloto");
        helicoptero.setPiloto(piloto);

        // Cria um novo Veiculo => Helicoptero
        this.galpao.adicionarVeiculo(helicoptero);
    }

    private void mostrarVeiculos(){
        String relacaoVeiculos = this.galpao.ImprimirRelacaoVeiculos();
        System.out.println(relacaoVeiculos);
    }
}
