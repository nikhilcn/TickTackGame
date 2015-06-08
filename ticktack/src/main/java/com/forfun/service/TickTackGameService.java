package com.forfun.service;

import java.util.UUID;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by nikhilnavakiran on 5/20/15.
 */
public class TickTackGameService {
    private char[][] board;
    private boolean isInitialized = false;
    private static TickTackGameService instance;
    private String gameUUID;
    private static final Logger logger = Logger.getLogger(TickTackGameService.class.getName());

    public void validate() {

    }

    public void changePlayer() {

    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public static TickTackGameService getInstance() {
        if (instance == null) {
            instance = new TickTackGameService();
        }
        return instance;
    }

    protected TickTackGameService() {
        //prevent instantiation
    }

    public boolean markBoard(int row, int col, char currentSymbol) {
        if (isInitialized) {
            if (row < 3 && col < 3) {
                if (board[row][col] == '-') {
                    board[row][col] = currentSymbol;
                    //todo send data to redis
                    return true;
                }
            }
            return false;
        } else {
            logger.log(Level.ALL, "Game Board not initialized");
            return false;
        }
    }

    public void initializeBoard() {
        if (!isInitialized) {
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }
            isInitialized = true;
            //setGameId();
        }
        else {
            logger.log(Level.ALL, "Game Board already initialized");
        }
    }

    private void initializeLogger() {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
    }

    public void setGameId(String gameUUID) {
        this.gameUUID = gameUUID;
        logger.log(Level.ALL,gameUUID);
    }

    public String getGameID() {
        if (isInitialized) {
            return gameUUID;
        }
        return null;
    }

    public boolean checkForWin() {
        if (isInitialized) {
            return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
        } else {
            logger.log(Level.ALL, "Game Board not initialized");
            return false;
        }
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return (checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[2][2], board[1][1], board[0][0]));
    }

    private boolean checkRowCol(char pos1, char pos2, char pos3) {
        if (((pos1 != '-') && (pos2 == pos1) && (pos3 == pos1))) {
            return true;
        }
        return false;
    }

    public void printBoard() {
        if (isInitialized) {
            System.out.println("-------------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " | ");
                }
                System.out.println();
                System.out.println("-------------");
            }
        } else {
            logger.log(Level.ALL, "Game Board not initialized");
        }
    }

    public boolean isDraw() {
        if (isInitialized) {
            if (!checkForWin()) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == '-') {
                            return false;
                        }
                    }
                }
                return true;
            }
        } else {
            logger.log(Level.ALL, "Game Board not initialized");
        }
        return false;
    }

}
