package Game;

import javax.swing.JFrame;

public class Painel {
    public static void Painel() {
        JFrame frame = new JFrame("Snake Game Console");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 960);

        frame.setVisible(true);
    }
}
