package com.forfun.service;

import com.forfun.dao.PlayerTableDao;
import com.forfun.model.PlayerTable;

import java.util.UUID;

/**
 * Created by nikhilnavakiran on 6/7/15.
 */
public class PlayerRegisterService {
    private PlayerTableDao playerTableDao;
    private PlayerTable playerTable;

    public PlayerRegisterService() {
        playerTableDao = new PlayerTableDao();
        playerTable = new PlayerTable();
    }

    public PlayerTable createPlayer(String name, String primaryKey) {
        playerTable.setPlayerName(name);
        playerTable.setPrimaryKey(primaryKey);
        playerTableDao.save(playerTable);
        return playerTable;
    }
}
