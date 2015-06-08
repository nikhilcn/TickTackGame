package com.forfun.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.forfun.model.GameTable;
import com.forfun.model.PlayerTable;

import java.util.List;

/**
 * Created by nikhilnavakiran on 6/8/15.
 */
public class GameTableDao {
    private final DynamoDBMapper dynamoDBMapper;

    public GameTableDao() {
        AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient();
        dynamoDBMapper = new DynamoDBMapper(dynamoDB);
    }

    public void save(GameTable gameTable) {
        dynamoDBMapper.save(gameTable);
    }

    public List<GameTable> get(List<String>key) {
        List<GameTable> gameTables = dynamoDBMapper.scan(GameTable.class, new DynamoDBScanExpression());
        return gameTables;
    }

    public GameTable get(String key) {
        if(dynamoDBMapper.load(GameTable.class,key) != null) {
            return dynamoDBMapper.load(GameTable.class,key);
        }
        return null;
    }

    public void update(GameTable gameTable) {
        save(gameTable);
    }

    public void delete(GameTable gameTable) {
        dynamoDBMapper.delete(gameTable);
    }

}
