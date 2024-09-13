package Game;

import javax.swing.JFrame;

public class Painel {
    public static void GamePainel() {
        MovimentoSnake ms = new MovimentoSnake();
        JFrame frame = new JFrame("Snake Game Console");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 960);
        frame.add(ms);

        frame.setVisible(true);
    }
}
