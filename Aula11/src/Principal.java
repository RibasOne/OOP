
import br.univali.br.aula11.heranca.Radio;
import br.univali.br.aula11.heranca.RadioXpto;
import br.univali.br.aula11.heranca.Relogio;
import com.sonic.RadioCabeceira;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1978233
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("parar aqui cac****");
        Radio radio1;
        radio1 = new RadioXpto();
        radio1.ligar();
        radio1.sintonizar(102.7);
        radio1.volumar(50);
        
        //if (radio1 instanceof Relogio){
            ((Relogio)radio1).ajustarHora(5, 5, 10);
            System.out.println(((Relogio)radio1).mostrarHora());
        //}
        
        System.out.println(radio1 instanceof Radio);
        System.out.println(radio1 instanceof RadioXpto);
        System.out.println(radio1 instanceof RadioCabeceira);
        System.out.println(radio1 instanceof Relogio);
        
    }
    
}
