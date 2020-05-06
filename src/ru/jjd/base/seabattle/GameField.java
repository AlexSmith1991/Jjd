package ru.jjd.base.seabattle;

import java.util.Random;

public class GameField {
    private int[][] field;
    private final int height;
    private final int width;
    private int allDeckCount;

    public GameField(int height, int width) {
        this.height = height;
        this.width = width;
        setField(new int[height][width]);
        setAllDeckCount(0);
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        if (field != null && field.length == height && field[0].length == width){
            this.field = field;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getAllDeckCount() {
        return allDeckCount;
    }

    public void setAllDeckCount(int allDeckCount) {
        if (allDeckCount >= 0) {
            this.allDeckCount = allDeckCount;
        }
    }

    private void tookPlace(int row, int col){
        int rowBegin = (row > 0) ? row - 1 : row;
        int rowEnd = (row < getHeight() - 1) ? row + 1 : row;
        int colBegin = (col > 0) ? col - 1 : col;
        int colEnd = (col < getWidth() - 1) ? col + 1 : col;
        for (int i = rowBegin; i <= rowEnd ; i++) {
            for (int j = colBegin; j < colEnd; j++) {
                if (field[i][j] == 0){
                    field[i][j] = 1;
                }
            }
        }
    }

    private boolean nextDeck(int deckCount, int row, int col){
        boolean result = true;

        if (deckCount == 1){
            if (field[row][col] == 0){
                field[row][col] = 2;
                tookPlace(row, col);
            } else {
                result = false;
            }
        } else {
            int nextRow = row;
            int nextCol = col;
            Random random = new Random();
            int direction = random.nextInt(4);
            for (int i = 0; i < 4; i++) {
                direction = (direction + i) % 4;
                switch (direction) {
                    case 0:
                        
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    default:

                        break;
                }
            }

        }
        return result;
    }

    private boolean generateBattleship(int deckCount, int row, int col){
        boolean result = true;
        for (int i = 0; i < deckCount; i++) {

        }
        return result;
    }
}