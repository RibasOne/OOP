import br.univali.cc.prog3.garagemsteve.dominio.Galpao;

public class App {
    public static void main(String[] args){
        Galpao galpao = new Galpao();
        Interface interface = new Interface(galpao);
        interface.menu;
    }
}