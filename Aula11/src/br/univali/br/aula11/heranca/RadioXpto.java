/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.br.aula11.heranca;

/**
 *
 * @author 1978233
 */
public class RadioXpto implements Radio {
    
    private boolean ligado;
    private double decibeis;
    private double frequencia;

    @Override
    public void ligar() {
        this.ligado = !this.ligado;
        System.out.println("Xpto ativo");
    }
    
    public void volumar(double decibeis) {
        System.out.println("mudando o volume do xpto");
        if (this.ligado && decibeis >= 0 && decibeis <= 100) {
            this.decibeis = decibeis;
        }
    }
    
    public void sintonizar(double frequencia) {
        System.out.println("sintonizando frequencia no xpto");
        if (this.ligado) {
            this.frequencia = frequencia;
        }
    }

    

}
