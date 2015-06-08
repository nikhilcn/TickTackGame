package com.forfun.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created by nikhilnavakiran on 6/7/15.
 */
@DynamoDBTable(tableName = "GameTable")
public class GameTable {
    @DynamoDBHashKey(attributeName = "GameId")
    private String primaryKey;
    private String playerOneKey;
    private String playerTwoKey;

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getPlayerOneKey() {
        return playerOneKey;
    }

    public void setPlayerOneKey(String playerOneKey) {
        this.playerOneKey = playerOneKey;
    }

    public String getPlayerTwoKey() {
        return playerTwoKey;
    }

    public void setPlayerTwoKey(String playerTwoKey) {
        this.playerTwoKey = playerTwoKey;
    }
}
