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
                    playerBoard[i][j].setAdjacentMines(countAdjacebtMines(i, j));

                }
            }
        }


    }

    private int countAdjacebtMines(int row, int col) {
        int mineCount = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (i == 0 && j == 0) continue;
                int adjRow = row + 1;
                int adjCol = col + 1;
                if (adjRow >= 0 && adjRow < boardSize
                        && adjCol >= 0 && adjCol < boardSize) {
                    if (playerBoard[adjCol][adjCol].isMine()) {
                        mineCount++;
                    }
                }
            }
        }
        return mineCount;
    }


    public void revealBoard(int row, int col) {
        //user input starts from 1
        row --;
        col --;

        if (playerBoard[row][col].isMine()) {
            System.out.println("It's a mine! Game over!");

        } else {
            revealTile(row, col);
            displayBoard();
        }

    }

    private void revealTile(int row, int col) {

        //If out of bounds
        if (row<0 || row>= boardSize || col<0 || col>=boardSize || playerBoard[row][col].isRevealed()) {
            return;
        }

        //Reveal Tile to player
        playerBoard[row][col].reveal();

        if (playerBoard[row][col].getAdjacentMines() == 0) {
            for (int i = -1; i<= 1; i++) {
                for (int j = -1; j<=1; j++) {
                    revealTile(row+i, col+j);
                }
            }
        }
    }


    public void displayBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (playerBoard[i][j].isRevealed()) {
                    if(playerBoard[i][j].isMine()) {
                        System.out.println("*");
                    } else {
                        System.out.println(playerBoard[i][j].getAdjacentMines() + " ");
                    }
                } else {
                    System.out.println("=");
                }

                System.out.println();
            }
        }
    }



}









