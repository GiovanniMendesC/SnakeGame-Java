package Game;

import Game.Map;

import javax.swing.Timer;
import java.awt.event.ActionListener;

import static Game.Constants.Constants.TAMANHO_MAX;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class MovimentoSnake extends JPanel implements ActionListener, KeyListener {
    Snake snake = new Snake();
    boolean perdeu = false;
    private final Timer timer;

    private int direcao = 0; //1 cima
                             //2 baixo
                             //3 direita
                             //4 esquerda

    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_RIGHT){
            direcao = 3;
        }
        if(keyCode == KeyEvent.VK_LEFT){
            direcao = 4;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            direcao = 2;
        }
        if(keyCode == KeyEvent.VK_UP){
            direcao = 1;
        }
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {}
    
    public MovimentoSnake() {
        
        timer = new Timer(10, e-> {
            if (snake.getSize() != TAMANHO_MAX && !perdeu) {
                
                int[] posicao = snake.getPosicao_atual();
                switch (direcao) {
                    case 1:
                        posicao[0] = posicao[0]++;
                        break;
                    case 2:
                        posicao[0] = posicao[0]--;
                        break;
                    case 3:
                        posicao[1] = posicao[1]++;
                        break;
                    case 4:
                        posicao[1] = posicao[1]--;
                        break;
                    default:
                        System.out.println("Tecla inválida");
                        break;
                }
                
                if (Map.VerifyMapPosition(posicao[0], posicao[1]) == 0) {
                    snake.setPosicao_atual(posicao);
                } else {
                    perdeu = true;
                }
            }
        });
    }
    
}
