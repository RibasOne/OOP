/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonic;

import br.univali.br.aula11.heranca.Radio;
import br.univali.br.aula11.heranca.Relogio;

/**
 *
 * @author 1978233
 */
public class RadioCabeceira  implements Radio, Relogio{

    @Override
    public void ligar() {
        System.out.println("Cabeceira ligado");
    }

    @Override
    public void sintonizar(double frequencia) {
        System.out.println("Cabeceira sintonizado");
    }

    @Override
    public void volumar(double decibeis) {
        System.out.println("Cabeçeira volumado");
    }

    @Override
    public void ajustarHora(int hora, int minuto, int segundo) {
        System.out.println("ajustando hora");
    }

    @Override
    public String mostrarHora() {
        return "mostrando hora... hora de ficar na sala";
    }
    
}
