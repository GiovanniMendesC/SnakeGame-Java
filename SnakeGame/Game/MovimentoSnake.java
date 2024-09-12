package Game;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class MovimentoSnake extends JPanel implements ActionListener, KeyListener {
    private int direcao = 0; //1 frente
                             //2 trás
                             //3 direita
                             //4 esquerda
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (direcao) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            default:
                System.out.println("Tecla inválida");
                break;
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

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
    
}
