package br.univali.cc.prog3.jogodaforca.dominio;
import java.util.Scanner;

class Jogador {
    public char fazerPalpite() {
        System.out.print("Digite uma letra: ");
        Scanner scanner = new Scanner(System.in);
        String letra = scanner.next().toLowerCase();
        
        if(letra.length() != 1){
            System.out.println("Letra invalida!");
            return fazerPalpite();
        }
        return letra.charAt(0);
    }
}
