package Gol;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class GoLBoard {

    private int row;
    private int col;
    private char[][] board;
    private char dead = 'X';
    private char alive = 'O';

    // Constrcutor

    public GoLBoard() {
        this.row = row;
        this.col = col;
    }

    public void initiateBoard(int row, int col) {
        board = new char[row][col];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = dead;
            }
        }
    }

    public void populateBoard(int offX, int offY, ArrayList<String> popList) {

        for (int i = 0; i < popList.size(); i++) {
            String s = popList.get(i);
            for (int j = 0; j < s.length(); j++) {
                board[i + offY][j + offX] = s.charAt(j);

            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == ' ') {
                    board[r][c] = 'X';
                }
            }
        }

    }

    public void printInitialBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c]);
            }
            System.out.println();

        }
    }

    public int countAlive(int r, int c) {
        int count = 0;
        //Top Left
        try {
        if (board[r - 1][c - 1] == '*') {
        count++;
        }
        // Top middle
        if (board[r - 1][c] == '*') {
        count++;
        }
        // top right
        if (board[r - 1][c + 1] == '*') {
        count++;
        }
        // middle left
        if (board[r][c - 1] == '*') {
        count++;
        }
        // Middle do not need as it is the origin of comparison
        // middle right
        if (board[r][c + 1] == '*') {
        count++;
        }
        // lower left
        if (board[r+1][c - 1] == '*') {
        count++;
        }
        // lower middle
        if (board[r + 1][c] == '*') {
        count++;
        }
        // lower right
        if (board[r + 1][c + 1] == '*') {
        count++;
        }

        } catch (ArrayIndexOutOfBoundsException e) {

        }

        return count;

    }

    public void nextGeneration() {
        // Create a new board for next generation
        char[][] newBoard = new char[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int countAlive = this.countAlive(r, c);
                if (board[r][c] == '*' && (countAlive <2 || countAlive >3)) {
                    newBoard[r][c] = dead;
                } else if (board[r][c] == '*' || countAlive==3) {
                    // keep same
                    newBoard[r][c] = '*';
                } else  {
                    newBoard[r][c] = dead;
                }
            }
        }
        this.board = newBoard;
    }

    public void printNextGenBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }

    }

}
