package org.example;

import java.util.Random;

public class Board {

    private int boardSize;
    private int numMines;
    private Tile[][] playerBoard;

    public Board(int boardSize, int numMines) {
        this.boardSize = boardSize;
        this.numMines = numMines;
        this.playerBoard = new Tile[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                playerBoard[i][j] = new Tile();
            }
        }
        createBoard();
    }


    public void createBoard() {

        //Random mine placement
        Random rand = new Random();
        int currentMines = 0;
        while (currentMines < numMines) {
            int row = rand.nextInt(boardSize);
            int col = rand.nextInt(boardSize);

            if (!playerBoard[row][col].isMine()) {
                playerBoard[row][col].setMine(true);
                currentMines++;
            }
        }

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (!playerBoard[i][j].isMine()) {
                    playerBoard[i][j].setAdjacentMines(countAdjacentMines(i, j));

                }
            }
        }


    }

    private int countAdjacentMines(int row, int col) {
        int mineCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int adjRow = row + i;
                int adjCol = col + j;

                if (i == 0 && j == 0) continue;

                if (adjRow >= 0 && adjRow < boardSize
                        && adjCol >= 0 && adjCol < boardSize) {
                    if (playerBoard[adjRow][adjCol].isMine()) {
                        mineCount++;
                    }
                }
            }
        }
        return mineCount;
    }

    public boolean checkWin() {
        int noMineTilesRevealed = 0;
        int noMineTiles = boardSize*boardSize - numMines;

        for (int i = 0; i<boardSize; i++) {
            for (int j = 0;j<boardSize; j++) {
                if (playerBoard[i][j].isRevealed() && !playerBoard[i][j].isMine()) {
                    noMineTilesRevealed++;
                }
            }
        }
        return noMineTilesRevealed == noMineTiles;

    }


    public boolean revealBoard(int row, int col) {
        //user input starts from 1
        row--;
        col--;
        if (playerBoard[row][col].isMine()) {
            return false;
        } else {
            revealTile(row, col);
            return !checkWin();
        }


    }



    private void revealTile(int row, int col) {

        //If out of bounds
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize || playerBoard[row][col].isRevealed()) {
            return;
        }

        //Reveal Tile to player
        playerBoard[row][col].reveal();

        if (playerBoard[row][col].getAdjacentMines() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int r = row + i;
                    int c = col + j;
                    revealTile(r, c);
                }
            }
        }
    }


    public void displayBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (playerBoard[i][j].isRevealed()) {
                    if (playerBoard[i][j].isMine()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(playerBoard[i][j].getAdjacentMines() + " ");
                    }
                } else {
                    System.out.print("- ");
                }


            }
            System.out.println();
        }


    }



    public void revealAllTiles() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                playerBoard[i][j].reveal();
            }
        }
    }


}









