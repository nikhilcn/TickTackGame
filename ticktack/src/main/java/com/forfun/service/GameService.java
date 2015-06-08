package com.forfun.service;


import com.forfun.dao.GameDao;
import com.google.gson.Gson;

/**
 * Created by nikhilnavakiran on 6/7/15.
 */
public class GameService {

    private GameDao gameDao;
    private Gson gson;

    public GameService() {
        gameDao = new GameDao();
        gson = new Gson();
    }

    public void saveBoard(String gameID, char board[][]) {
        gameDao.save(gameID, gson.toJson(board));
    }

    public char[][] getBoard(String gameID) {
        String board = gameDao.get(gameID);
        System.out.println(board);
        return gson.fromJson(board,char[][].class);
    }
}
