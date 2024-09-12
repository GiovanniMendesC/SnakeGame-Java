import Game.Map;
import Game.Painel;

public class SnakeGameApp {
    
    public static final int TAMANHO_INICIAL = 3;
    public static final int TAMANHO_MAX = 196;
    public static final int VELOCIDADE = 2;
    public static final int[] POSICAO_INICIAL = { 8, 8 };

    public static void main(String[] args) {
        Map map = new Map();

        for (int i = 0; i < 100; i++) {
            map.AppleGenerator();
            System.out.println(map.getApples()[i][0]+" "+ map.getApples()[i][1]);
        }
        System.out.println("testando");
        Painel.Painel();
    }
}