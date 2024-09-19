package Game;

import static Game.Constants.Constants.COMPRIMENTO_TELA;
import static Game.Constants.Constants.LARGURA_TELA;

import javax.swing.JFrame;

public class Painel {
    public static void GamePainel() {
        MovimentoSnake ms = new MovimentoSnake();
        JFrame frame = new JFrame("Snake Game Console");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(LARGURA_TELA+20, COMPRIMENTO_TELA+55);
        frame.add(ms);

        frame.setVisible(true);
    }
}
