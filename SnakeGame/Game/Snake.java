package Game;

import static Game.Constants.Constants.TAMANHO_INICIAL;
import static Game.Constants.Constants.POSICAO_INICIAL;

public class Snake {
    private int size = TAMANHO_INICIAL;
    private int[][] posicao_atual = new int[196][2];
    private int pontuacao = 0;

    public boolean ContaPonto(int x, int y) {
        if (PosicaoDaCobraIgual(x, y)) {
            pontuacao++;
            size++;
            return true;
        }
        return false;
    }

    public boolean PosicaoDaCobraIgual(int x, int y) {
        if (posicao_atual[0][0] == x && posicao_atual[0][1] == y) {
            return true;
        }
        return false;
    }

    public void FixSnakeBody(int[] newHead) {
        System.out.println(" { " + newHead[0] + ", " + newHead[1] + " }");
        for (int i = size; i > 0; i--) {
            posicao_atual[i] = posicao_atual[i - 1];
        }
        posicao_atual[0] = new int[] { newHead[0], newHead[1] };
    }
    
    public boolean ColidiuCorpo(int[] head) {
        for (int i = size; i > 0; i--) {
            if (posicao_atual[i][0] == head[0] && posicao_atual[i][1] == head[1]) {
                return true;
            }
        }
        return false;
    }
    
    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] getPosicao_atual() {
        return this.posicao_atual;
    }

    public void setPosicao_atual(int[][] posicao_atual) {
        this.posicao_atual = posicao_atual;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Snake() {
        for (int i = 0; i < 3; i++) {
            posicao_atual[i] = POSICAO_INICIAL[i];
        }
    }

}
