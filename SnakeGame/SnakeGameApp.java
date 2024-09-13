import Game.Map;
import Game.Painel;

public class SnakeGameApp {

    public static void main(String[] args) {
        Map map = new Map();

        for (int i = 0; i < 100; i++) {
            map.AppleGenerator();
            System.out.println(map.getApples()[i][0]+" "+ map.getApples()[i][1]);
        }
        System.out.println("testando");
        Painel.GamePainel();
    }
}