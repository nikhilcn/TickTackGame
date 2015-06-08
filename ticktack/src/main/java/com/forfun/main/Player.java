package com.forfun.main;

import com.forfun.service.TickTackGameService;

/**
 * Created by nikhilnavakiran on 6/7/15.
 */
public class Player {
    private char symbol;
    private String playerId;
    private TickTackGameService gameController;

    public Player(String playerId, char symbol, TickTackGameService gameController) {
        this.playerId = playerId;
        this.symbol = symbol;
        this.gameController = gameController;
    }

    public boolean playerMarkBoard(int row, int col) {
        return gameController.markBoard(row, col, symbol);
    }

    public String getPlayerId() {
        return playerId;
    }

}
