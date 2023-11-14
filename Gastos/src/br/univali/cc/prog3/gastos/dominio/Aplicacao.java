package br.univali.cc.prog3.gastos.dominio;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Aplicacao {
    private Gasto[] gastos = new Gasto[999];
    private TipoGasto[] tipos = new TipoGasto[999];
    private FormaPagamento[] formas = new FormaPagamento[999];
    
    public String listarGastos(int mes, int ano){
        String lista = "";
        for(Gasto gasto : gastos){
            if(gasto != null){
                System.out.println(gasto.getData().getMonth().getValue());
                System.out.println(gasto.getData().getYear());
            }
            if (gasto != null && gasto.getData().getMonth().getValue() == mes && gasto.getData().getYear() == ano)
                lista += gasto.obterDescricao() + "\n";
        }
        return lista;
    }
    
    public void novoGasto(Date data, double valor, TipoGasto tipo, FormaPagamento forma){
        LocalDate dataLocal = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        // Adiciona o Gasto, TipoGasto e FormaPagamento
        for(int i = 0; i < gastos.length; i++){
            if(gastos[i] == null){
                gastos[i] = new Gasto(dataLocal, valor, tipo, forma);
                tipos[i] = tipo;
                formas[i] = forma;
                break;
            }
        }
    }
    
    public FormaPagamento[] obterFormasPagamento(){
        return this.formas;
    }
    
    public TipoGasto[] obterTiposGastos(){
        return this.tipos;
    }
}