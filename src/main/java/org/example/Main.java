package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Minesweeper!");
        System.out.println();

        int boardSize = 10;
        int numMines = 10;
        Board board = new Board(boardSize, numMines);

        Scanner scan = new Scanner(System.in);
        boolean gameOver = false;

        board.displayBoard();

        while (!gameOver) {
            int userSelectedCol = getValidNumber(scan, "Please enter a column number between 1 - " +boardSize+ ":", boardSize);
            int userSelectedRow = getValidNumber(scan, "Please enter a row number between 1 - " +boardSize+ ":", boardSize);

            if (board.playerBoard[userSelectedRow - 1][userSelectedCol - 1].isRevealed()) {
                System.out.println("This tile has already been revealed. Please select another tile.");
            } else {
                //Calls reveal board method which checks if user hits mine
                if (!board.revealBoard(userSelectedRow, userSelectedCol)) {
                    board.displayBoard();
                    board.revealAllTiles();
                    System.out.println("Game over! You hit a mine!");
                    System.out.println("Full board reveal:");
                    board.displayBoard();
                    gameOver = true;
                } else {
                    board.displayBoard();
                    if (board.checkWin()) {
                        board.revealAllTiles();
                        System.out.println("You win!");
                        board.displayBoard();
                        gameOver = true;
                    }
                }
            }
        }

        scan.close();
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
                    //System.out.println("Invalid input. Please enter a number between 1-" + boardSize + ".");
                    System.out.println("Invalid input.");

                }


            } else {
                //System.out.println("Invalid input. Please enter a number.");
                System.out.println("Invalid input.");
                scan.next();
            }

        } return validInput;
    }
}