/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.modelos;

/**
 *
 * @author 1978233
 */
public class Urubu extends Animal implements Voador, Carniceiro{

    @Override
    public void sonorizar() {
        System.out.println("Você gosta de pipoca?");
    }

    @Override
    public void voar() {
        System.out.println("Voando....");
    }

    @Override
    public void comerCarnica() {
        System.out.println("Comendo o pobre animal podre fedido que está morto a 10 dias");
    }
    
    
    
}
