package Game;

import static Game.Constants.Constants.TAMANHO_INICIAL;
import static Game.Constants.Constants.POSICAO_INICIAL;

public class Snake {
    private int size = TAMANHO_INICIAL;
    private int[] posicao_atual = POSICAO_INICIAL;
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
        if (posicao_atual[0] == x && posicao_atual[1] == y) {
            return true;
        }
        return false;
    }


    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getPosicao_atual() {
        return this.posicao_atual;
    }

    public void setPosicao_atual(int[] posicao_atual) {
        this.posicao_atual = posicao_atual;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

}
