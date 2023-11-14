package br.univali.cc.prog3.jogodaforca.dominio;

import java.util.Random;

public class PalavraSecreta {
    private String palavra;
    
    public PalavraSecreta(String[] palavras){
        Random random = new Random();
        this.palavra = palavras[random.nextInt(palavras.length)];
    }
    
    public boolean contemLetra(char letra){
        return palavra.indexOf(letra) >= 0;
    }
    
    public String getPalavra(){
        return palavra;
    }
}
