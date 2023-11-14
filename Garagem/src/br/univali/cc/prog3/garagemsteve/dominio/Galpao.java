package br.univali.cc.prog3.garagemsteve.dominio;

public class Galpao {
    private Veiculo[] veiculos = new Veiculo[999];

    public void adicionarVeiculo(Veiculo veiculo){
        for(int i = 0; i < this.veiculos.length; i++){
            if(this.veiculos[i] == null){
                this.veiculos[i] = veiculo;
                return;
            }
        }
    }

    public String ImprimirRelacaoVeiculos(){
        String relacaoVeiculos = "";

        for (Veiculo veiculo : this.veiculos) {
            if(veiculo != null){
                relacaoVeiculos += veiculo.obterDescricaoVeiculo() + "\n";
            }
        }
        
        return relacaoVeiculos;
    }
}
