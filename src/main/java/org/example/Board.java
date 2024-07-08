package org.example;

import java.util.Arrays;
import java.util.Random;

public class Board {

    private int boardSize;
    private int numMines;
    private Tile[][] playerBoard;

    public Board(int boardSize, int numMines) {
        this.boardSize = boardSize;
        this.numMines = numMines;
        this.playerBoard = new Tile [boardSize][boardSize];
        for (int i = 0; i<boardSize; i++) {
            for (int j = 0; j<boardSize; j++) {
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

        for (int i = 0; i<boardSize; i++) {
            for (int j = 0; j<boardSize;j++) {
                if (!playerBoard[i][j].isMine()) {
                    playerBoard[i][j].setAdjacentMines(countAdjacebtMines(i, j));

                }
            }
        }


    }

    private int countAdjacebtMines(int row, int col) {
        int mineCount = 0;
        for (int i = 0; i< boardSize; i++) {
            for (int j = 0; j<boardSize; j++) {
                if (i==0 && j==0) continue;
                int adjRow = row + 1;
                int adjCol = col + 1;
                if (adjRow >= 0 && adjRow < boardSize
                    && adjCol >= 0 && adjCol <boardSize) {
                    if (playerBoard[adjCol][adjCol].isMine()) {
                        mineCount ++;
                    }
                }
            }
        }
    }

//    public void displayBoard() {
//        for (int i = 0; i < boardSize; i++) {
//            for (int j = 0; j < boardSize; j++) {
//                if (revealedBoard[i][j]) {
//                    int tileValue = playerBoard[i][j];
//                    if (tileValue == -1) {
//                        System.out.print('*');
//                    } else if (tileValue == 0) {
//                        System.out.print('0');
//                    }
//
//                } else {
//                    System.out.println('-');
//                }
//
//
//                System.out.println();
//            }
//        }
//    }





}



