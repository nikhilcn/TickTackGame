package com.forfun.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created by nikhilnavakiran on 5/17/15.
 */
@DynamoDBTable(tableName = "TickTackPlayer")
public class PlayerTable {
    @DynamoDBHashKey(attributeName = "Imei")
    private String primaryKey;

    private String gameName;
    private String playerName;
    private Integer winCount = 0;
    private Integer lossCount = 0;
    private Integer drawnCount = 0;

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getWinCount() {
        return winCount;
    }

    public void setWinCount(Integer winCount) {
        this.winCount = winCount;
    }

    public Integer getLossCount() {
        return lossCount;
    }

    public void setLossCount(Integer lossCount) {
        this.lossCount = lossCount;
    }

    public Integer getDrawnCount() {
        return drawnCount;
    }

    public void setDrawnCount(Integer drawnCount) {
        this.drawnCount = drawnCount;
    }
}
