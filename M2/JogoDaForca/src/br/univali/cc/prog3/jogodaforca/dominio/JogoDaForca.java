package br.univali.cc.prog3.jogodaforca.dominio;


class JogoDaForca {
    public static void main(String[] args){
         JogoDaForca jogo = new JogoDaForca();
         jogo.jogar();
    }
    
    public void jogar() {
        String[] palavras = {"java", "objeto", "gremio", "musica", "programador", "agua", "controle", "computador"};
        
        PalavraSecreta palavraSecreta = new PalavraSecreta(palavras);
        
        // Definindo tamanho do campo de texto para a palavraAdivinhada
        String palavraAdivinhada = "";
        for(int i = 0; i < palavraSecreta.getPalavra().length(); i++){
            palavraAdivinhada += "_";
        }
        
        Tabuleiro tabuleiro = new Tabuleiro(palavraSecreta.getPalavra(), palavraAdivinhada);
        Jogador jogador = new Jogador();
        
        while(!tabuleiro.jogoTerminou()){
            
            System.out.println("Palavra adivinhada: " + tabuleiro.getPalavraAdivinhada());
            System.out.println("Letras certas: " + tabuleiro.getLetrasCertas());
            System.out.println("Letras erradas: " + tabuleiro.getLetrasErradas());
            
            char palpite = jogador.fazerPalpite();
            if(!tabuleiro.tentativaCorreta(palpite)){
                System.out.println("Letra errada!");
            }
        }
        
        if(tabuleiro.venceu()) {
            System.out.println("Parabéns! Você adivinhou a palavra: " + palavraSecreta.getPalavra());
        }else{
            System.out.println("Fim de jogo. A palavra era: " + palavraSecreta.getPalavra());
        }        
    }
}