
import br.univali.modelos.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1978233
 */
public class Pomerode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animal[] animais = new Animal[6];
        animais[0] = new Elefante();
        animais[1] = new Macaco();
        animais[2] = new Leao();
        animais[3] = new Papagaio();
        animais[4] = new Urubu();
        animais[5] = new Elefante();
        
        for(Animal animal:animais) {
            animal.acordar();
            animal.sonorizar();
            if (animal instanceof Voador) {
                ((Voador)animal).voar();
            }
            if (animal instanceof Carniceiro) {
                Carniceiro carniceiro = (Carniceiro)animal;
                carniceiro.comerCarnica();
            }
        }
        
        
    }
    
}
