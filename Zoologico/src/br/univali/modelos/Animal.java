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
abstract public class Animal {
    
    final public void acordar() {
        System.out.println("Acordando....");
    }
    
    abstract public void sonorizar();
    
}
