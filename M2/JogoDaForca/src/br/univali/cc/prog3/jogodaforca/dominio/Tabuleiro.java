package br.univali.cc.prog3.jogodaforca.dominio;

class Tabuleiro {
    private String palavraAdivinhada;
    private String letrasErradas;
    private String letrasCertas;
    private String palavraSecreta;
    private int maxTentativas = 6;
    
    public Tabuleiro(String palavra, String palavraAdivinhada) {
        this.palavraSecreta = palavra;
        this.palavraAdivinhada = palavraAdivinhada;
        this.letrasErradas = "";
        this.letrasCertas = "";
    }
    
    public boolean tentativaCorreta(char letra){
        if(palavraSecreta.contains(String.valueOf(letra))) {
            for(int i = 0; i < palavraSecreta.length(); i++) {
                if(palavraSecreta.charAt(i) == letra){
                    palavraAdivinhada = palavraAdivinhada.substring(0, i) + letra + palavraAdivinhada.substring(i + 1);
                    
                    if(!letrasCertas.contains(String.valueOf(letra))) { // verifica se a letra advinhada ja esta contida em letrasCertas
                        letrasCertas += letra;
                    }
                }
            }
            return true;
        } else {
            letrasErradas += letra;
            return false;
        }
    }
    
    public boolean jogoTerminou() {
        if(palavraAdivinhada.equals(palavraSecreta))
            return true;
        if(letrasErradas.length() >= maxTentativas)
            return true;
        return false;
    }
    
    public boolean venceu() {
        if(palavraAdivinhada.equals(palavraSecreta))
            return true;
        else
            return false;
    }
    
    public String getPalavraAdivinhada() {
        return palavraAdivinhada;
    }
    
    public String getLetrasCertas() {
        return letrasCertas;
    }
    
    public String getLetrasErradas() {
        return letrasErradas;
    }
}