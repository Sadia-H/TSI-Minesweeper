package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Minesweeper!");

        int boardSize = 10;
        int numMines = 10;
        Board board = new Board(boardSize, numMines);

        Scanner scan = new Scanner(System.in);
        boolean gameOver = false;

        board.displayBoard();

        while (!gameOver) {
            int userSelectedCol = getValidNumber(scan, "Please enter a column number: ", boardSize);
            int userSelectedRow = getValidNumber(scan, "Please enter a row number: ", boardSize);

            if (!board.revealBoard(userSelectedRow, userSelectedCol)) {
                board.displayBoard();
                board.revealAllTiles();
                System.out.println("It's a mine! Game over...");
                System.out.println("Full board reveal:");
                board.displayBoard();
                gameOver = true;
            } else {
                board.displayBoard();
                if (board.checkWin()) {
                    board.revealAllTiles();
                    System.out.println("Congratulations! You've won!");
                    board.displayBoard();
                    gameOver = true;
                }
            }
        }

        scan.close();

//        while (!gameOver) {
//            int userSelectedCol = getValidNumber(scan,"Please enter an column number: ", boardSize);
//            int userSelectedRow = getValidNumber(scan,"Please enter an row number: ", boardSize);
//
//            board.revealBoard(userSelectedRow, userSelectedCol);
//            //gameOver = board.playerLoses(userSelectedRow-1, userSelectedCol-1);
//            gameOver = !board.revealBoard(userSelectedRow, userSelectedCol);
//        }
//
//        board.revealAllTiles();
//        board.displayBoard();
//
//        scan.close();


    }

    public static int getValidNumber (Scanner scan, String prompt, int boardSize) {
        int validInput = -1;
        while (validInput < 0) {
            System.out.println(prompt);
            if (scan.hasNextInt()) {
                int userInput = scan.nextInt();
                if (userInput > 0 && userInput <= boardSize) {
                    validInput = userInput;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1-" + boardSize + ".");
                }


            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next();
            }

        } return validInput;
    }
}