package com.forfun.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.forfun.model.PlayerTable;

import java.util.List;

/**
 * Created by nikhilnavakiran on 5/9/15.
 */
public class PlayerTableDao {
    private static final String TABLE_NAME = "TickTackPlayer";
    private final DynamoDBMapper dynamoDBMapper;

    public PlayerTableDao() {
        AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient();
        dynamoDBMapper = new DynamoDBMapper(dynamoDB);
    }

    public void save(PlayerTable playerTable) {
        dynamoDBMapper.save(playerTable);
    }

    public List<PlayerTable> get(List<String>key) {
        List<PlayerTable> playerTables = dynamoDBMapper.scan(PlayerTable.class, new DynamoDBScanExpression());
        return playerTables;
    }

    public PlayerTable get(String key) {
        if(dynamoDBMapper.load(PlayerTable.class,key) != null) {
            return dynamoDBMapper.load(PlayerTable.class,key);
        }
        return null;
    }

    public void update(PlayerTable playerTable) {
        save(playerTable);
    }

    public void delete(PlayerTable playerTable) {
        dynamoDBMapper.delete(playerTable);
    }

}
