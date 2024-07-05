package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Minesweeper!");

        int boardSize = 10;
        int numMines = 10;
        Board board = new Board(boardSize, numMines);

        Scanner scan = new Scanner(System.in);
        int userSelectedCol = getValidNumber(scan,"Please enter an column number: ", boardSize);
        int userSelectedRow = getValidNumber(scan,"Please enter an row number: ", boardSize);

       // System.out.println(userSelectedCol + " " + userSelectedRow);
        board.revealBoard(userSelectedRow, userSelectedCol);

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