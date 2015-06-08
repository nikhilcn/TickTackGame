package com.forfun.service;

import com.forfun.dao.PlayerTableDao;
import com.forfun.model.PlayerTable;

/**
 * Created by nikhilnavakiran on 6/7/15.
 */
public class PlayerService {

    private PlayerTableDao playerTableDao;

    public PlayerService() {
        playerTableDao = new PlayerTableDao();
    }

    public PlayerTable findPlayer(String primaryKey) {
        return playerTableDao.get(primaryKey);
    }
}
