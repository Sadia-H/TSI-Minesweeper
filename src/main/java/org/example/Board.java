package org.example;
import java.util.Arrays;
import java.util.Random;

public class Board {

    private int [][] playerBoard;
    private boolean [][] revealedBoard;
    private int boardSize;
    private int numMines;

    public Board (int boardSize, int numMines) {
        this.boardSize = boardSize;
        this.numMines = numMines;
        this.playerBoard = new int[boardSize][boardSize];
        this.revealedBoard = new boolean[boardSize][boardSize];
        createBoard();
    }



    public void createBoard() {
        for (int i = 0; i<boardSize; i++) {
            for (int j = 0; j<boardSize; j++) {
                playerBoard[i][j] = 0;
                revealedBoard[i][j] = false;
            }
        }

        //placeRandomMines();
        displayBoard();

    }

    public void displayBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (revealedBoard[i][j]) {
                    int tileValue = playerBoard[i][j];
                    if (tileValue == -1) {
                        System.out.print('*');
                    } else if (tileValue == 0) {
                        System.out.print('0');
                    }

                } else {
                    System.out.println('-');
                }


                System.out.println();
            }
        }

//    public void displayBoard() {
//        for (int i = 0; i<boardSize; i++) {
//            for (int j = 0; j<boardSize; j++) {
//                if (playerBoard[i][j] == 0) {
//                    System.out.print('-');
//                }
//                if (playerBoard[i][j] == -1) {
//                    System.out.print('*');
//                }
//
//            }
//            System.out.println();
//        }
//    }


//        public void revealBoard(int userSelectedRow,int userSelectedCol) {
//
//        }

        public void revealBoard(int userSelectedRow, int userSelectedCol) {
            revealedBoard[userSelectedRow][userSelectedCol] = true;
            displayBoard();
        }


//    public void placeRandomMines() {
//        Random rand = new Random ();
////        int row = rand.nextInt(boardSize);
////        int col = rand.nextInt(boardSize);
////        System.out.println(row + " " + col);
//
//        int currentMines = 0;
//        while (currentMines < numMines) {
//            int row = rand.nextInt(boardSize);
//            int col = rand.nextInt(boardSize);
////            if (playerBoard[row][col] == 0) {
////                playerBoard[row][col] = -1;
////            }
//        }
//
//        for (int i =0; i<boardSize; i++) {
//
//        }
//
//    }


    }


}
