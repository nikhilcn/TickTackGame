package com.forfun.main;

import com.forfun.dao.GameTableDao;
import com.forfun.model.GameTable;
import com.forfun.model.PlayerTable;
import com.forfun.service.PlayerRegisterService;
import com.forfun.service.PlayerService;
import com.forfun.service.TickTackGameService;

import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;

import java.util.UUID;

/**
 * Created by nikhilnavakiran on 6/7/15.
 */
public class GamePlayInterface {
    private PlayerService playerService;
    private Player playerOne;
    private Player playerTwo;
    private PlayerTable playerTableOne;
    private PlayerTable playerTableTwo;
    private Game game;
    private String gameId;
    private PlayerRegisterService playerRegisterService;
    private NameGenerator generator = new NameGenerator();

    public GamePlayInterface(String playerOnePrimaryKey, String playerTwoPrimaryKey) {
        playerService = new PlayerService();
        playerRegisterService = new PlayerRegisterService();
        createGameId();
        prepGame(playerOnePrimaryKey, playerTwoPrimaryKey);
        createGame();
    }

    private void createGameId() {
        gameId = UUID.randomUUID().toString();
    }

    private PlayerTable findPlayer(String primaryKey) {
        if (playerService.findPlayer(primaryKey) == null) {
            return playerRegisterService.createPlayer(generator.generateName().getFirstName(), primaryKey);
        } else {
            return playerService.findPlayer(primaryKey);
        }
    }

    private void prepGame(String playerOne, String playerTwo) {
        playerTableOne = findPlayer(playerOne);
        playerTableTwo = findPlayer(playerTwo);
        GameTable gameTable = new GameTable();
        gameTable.setPrimaryKey(gameId);
        gameTable.setPlayerOneKey(playerTableOne.getPrimaryKey());
        gameTable.setPlayerTwoKey(playerTableTwo.getPrimaryKey());
        new GameTableDao().save(gameTable);
    }

    private void createGame() {
        TickTackGameService tickTackGameService = TickTackGameService.getInstance();
        tickTackGameService.setGameId(gameId);
        playerOne = new Player(playerTableOne.getPrimaryKey(), 'X', tickTackGameService);
        playerTwo = new Player(playerTableTwo.getPrimaryKey(), 'O', tickTackGameService);
        game = new Game(tickTackGameService);
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Game getGame() {
        return game;
    }

    public void updateMetadata() {
        //todo update playerTable with win loss draw record for both players
    }
}
