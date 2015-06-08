package com.forfun.main;

import com.forfun.service.GameService;
import com.forfun.service.TickTackGameService;

/**
 * Created by nikhilnavakiran on 6/7/15.
 */
public class Game {
    private TickTackGameService gameController;
    private GameService gameService;

    public Game(TickTackGameService gameController) {
        this.gameController = gameController;
        gameService = new GameService();
    }

    public boolean checkForWin() {
        return gameController.checkForWin();
    }

    public boolean checkForDraw() {
        return gameController.isDraw();
    }

    public void printBoard() {
        gameController.printBoard();
    }

    public void initializeBoard() {
        gameController.initializeBoard();
    }

    public String getGameId() {
        return gameController.getGameID();
    }

    public void saveBoard() {
        gameService.saveBoard(getGameId(),gameController.getBoard());
    }

    public void getBoard() {
        char [][]savedBoard = gameService.getBoard(getGameId());
        gameController.setBoard(savedBoard);
    }
}
