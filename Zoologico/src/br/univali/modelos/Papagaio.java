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
public class Papagaio extends Animal implements Voador{

    @Override
    public void sonorizar() {
        System.out.println("falo o que quiser! bom dia!");
    }

    @Override
    public void voar() {
        System.out.println("Voando feliz como um papagaio sem asas cortadas");
    }
    
}
