package com.forfun.main;

import com.forfun.service.TickTackGameService;

import java.util.UUID;

public class PlayTest {

    public static void main (String args[]) {

        GamePlayInterface gamePlayInterface = new GamePlayInterface(UUID.randomUUID().toString(),UUID.randomUUID().toString());
//        TickTackGameService gameController = TickTackGameService.getInstance();
//        Game game = new Game(gameController);
//        game.initializeBoard();
//        Player player1 = new Player(UUID.randomUUID().toString(),'X',gameController);
//        Player player2 = new Player(UUID.randomUUID().toString(),'O',gameController);

        Game game = gamePlayInterface.getGame();
        game.initializeBoard();
        Player player1 = gamePlayInterface.getPlayerOne();
        Player player2 = gamePlayInterface.getPlayerTwo();

        while (!game.checkForWin()) {
            player1.playerMarkBoard(1, 1);
            player1.playerMarkBoard(2,2);
            player1.playerMarkBoard(0,0);
            player2.playerMarkBoard(1,0);
            player2.playerMarkBoard(2,0);
            game.printBoard();
        }
        System.out.println("done" + game.getGameId());
        game.saveBoard();
        game.getBoard();
        game.printBoard();

    }
}
