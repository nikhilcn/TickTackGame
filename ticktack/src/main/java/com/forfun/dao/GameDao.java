package com.forfun.dao;


import redis.clients.jedis.Jedis;

/**
 * Created by nikhilnavakiran on 5/20/15.
 */
public class GameDao {
    private final Jedis jedis;

    public GameDao() {
        jedis = new Jedis("52.6.179.86");
    }

    public void save(String guid, String board) {
        jedis.set(guid,board);
    }

    public String get(String guid) {
        return jedis.get(guid);
    }

    public void delete(String guid) {
        jedis.del(guid);
    }
}
