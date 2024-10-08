package Game;

import javax.swing.Timer;
import java.awt.event.ActionListener;

import static Game.Constants.Constants.TAMANHO_MAX;
import static Game.Constants.Constants.TEXT_CONTINUE;
import static Game.Constants.Constants.TEXT_DERROTA;
import static Game.Constants.Constants.TEXT_POINTS;
import static Game.Constants.Constants.COMPRIMENTO_TELA;
import static Game.Constants.Constants.LARGURA_TELA;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MovimentoSnake extends JPanel implements ActionListener, KeyListener {
    Snake snake = new Snake();
    Map appleMap = new Map();
    boolean perdeu = false;
    private final Timer timer;
    boolean comecou = false;

    private int direcao = 0; // 1 cima
                             // 2 baixo
                             // 3 direita
                             // 4 esquerda

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("key pressed " + keyCode);
        if (keyCode == KeyEvent.VK_RIGHT) {
            if (snake.PredictColision(3)) {
                direcao = 3;
                comecou = true;
            }
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            if (snake.PredictColision(4)) {
                direcao = 4;
                comecou = true;
            }
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            if (snake.PredictColision(2)) {
                direcao = 2;
                comecou = true;
            }
        }
        if (keyCode == KeyEvent.VK_UP) {
            if (snake.PredictColision(1)) {
                direcao = 1;
                comecou = true;
            }
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            if (perdeu) {
                perdeu = false;
                snake.reset();
                appleMap.reset();
                comecou = false;
                direcao = 0;
                timer.start();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public MovimentoSnake() {

        timer = new Timer(150, e -> {
            if (snake.getSize() != TAMANHO_MAX - 1) {

                int[] posicao = new int[] { snake.getPosicao_atual()[0][0], snake.getPosicao_atual()[0][1] };
                switch (direcao) {
                    case 1:
                        posicao[0]--;
                        break;
                    case 2:
                        posicao[0]++;
                        break;
                    case 3:
                        posicao[1]++;
                        break;
                    case 4:
                        posicao[1]--;
                        break;
                    default:
                        break;
                }

                if (Map.VerifyMapPosition(posicao[0], posicao[1]) == 0 && !snake.ColidiuCorpo(posicao)) {

                    if (comecou) {
                        snake.FixSnakeBody(posicao);
                        if (appleMap.ValidateApplePosition(posicao[0], posicao[1])) {
                            appleMap.AppleGenerator(snake.getPosicao_atual());
                            snake.ContaPonto(posicao[0], posicao[1]);
                        }
                    }
                } else {
                    perdeu = true;
                    System.out.println(Map.VerifyMapPosition(posicao[0], posicao[1]) == 0);
                    System.out.println(!snake.ColidiuCorpo(posicao));
                    System.out.println("{ " + posicao[0] + ", " + posicao[1] + " }   ->  " + Map.VerifyMapPosition(posicao[0], posicao[1]));
                }

                repaint();
            }
        });

        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    protected void paintComponent(Graphics g) {
        int[][] snakeBody = snake.getPosicao_atual();
        Font font = new Font("Arial", Font.PLAIN, 30);
        super.paintComponent(g);
        setBackground(Color.GREEN);

        for (int i = 0; i < Map.map.length; i++) {
            for (int j = 0; j < Map.map[0].length; j++) {
                if (Map.VerifyMapPosition(i, j) == 1) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(j * 60, i * 60, 60, 60);
                }

                if (appleMap.ValidateApplePosition(i, j)) {
                    g.setColor(Color.RED);
                    g.fillRect(j * 60, i * 60, 60, 60);
                }
            }
        }

        for (int i = 0; i < snakeBody.length; i++) {
            if (snakeBody[i][0] != 0 && snakeBody[i][1] != 0) {
                g.setColor(Color.BLUE);
                g.fillRect(snakeBody[i][1] * 60, snakeBody[i][0] * 60, 60, 60);
            }
        }

        if (perdeu) {
            setBackground(Color.BLACK);
            g.setColor(Color.RED);
            g.setFont(font);
            g.drawString(TEXT_DERROTA, (LARGURA_TELA / 2) - (TEXT_DERROTA.length() * 10), COMPRIMENTO_TELA / 2);
            g.drawString(TEXT_CONTINUE, (LARGURA_TELA / 2) - (TEXT_CONTINUE.length()*5), COMPRIMENTO_TELA / 2 + 30);

            timer.stop();
            repaint();
        }

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(TEXT_POINTS + snake.getPontuacao(), 30, 30);
    }

}
