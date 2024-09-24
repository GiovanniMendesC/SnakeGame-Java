package Game;

import static Game.Constants.Constants.MACA_INCIAL;
import static Game.Constants.Constants.TAMANHO_MAX;

public class Map {
    private int[] apples = new int[2];
    private int contador = 1;

    public void AppleGenerator(int[][] snakeBody) {
        
        int x = (int) (Math.random() * 15);
        int y = (int) (Math.random() * 15);
        x = FixVariable(x);
        y = FixVariable(y);

        if (ValidateApplePosition(snakeBody, x, y)) {
            AppleGenerator(snakeBody);
        } else {
            AddApple(x, y);
        }
    }

    public static final int[][] map =
    {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public int FixVariable(int value) {
        if (value == 0) {
            value++;
        } else if (value == 15) {
            value--;
        }
        return value;
    }

    //verifica se o corpo cabeça passou por uma das maças (pode verificar apenas na maçã mais atual)
    public boolean ValidateApplePosition(int x, int y) {
        if (apples[0] == x && apples[1] == y) {
            return true;
        }
        return false;
    }

    //verifica se a maçã nova vai estar dentro do corpo da cobra ou não
    public boolean ValidateApplePosition(int[][] snakeBody, int x, int y) {
        for (int i = 0; i < TAMANHO_MAX; i++) {
            if (snakeBody[i][0] == x && snakeBody[i][1] == y) {
                return true;
            }
        }
        return false;
    }

    public void AddApple(int x, int y) {
        apples[0] = x;
        apples[1] = y;

        contador++;
    }

    public static int VerifyMapPosition(int x, int y) {
        return map[x][y];
    }

    public void reset() {
        apples = new int[2];
        apples = new int[] { MACA_INCIAL[0], MACA_INCIAL[1] };
        contador = 1;
    }

    public int[] getApples() {
        return this.apples;
    }

    public void setApples(int[] apples) {
        this.apples = apples;
    }

    public int getContador() {
        return this.contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Map() {
        apples = new int[] { MACA_INCIAL[0], MACA_INCIAL[1] };
    }
}
