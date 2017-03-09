package com.baku;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import com.mongodb.MongoClient;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class DbClientProvider {

    private MongoClient mongoClient = null;

    @Lock(LockType.READ)
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    @PostConstruct
    public void init() {
        String mongoIpAddress = "docbase_db_1";
        Integer mongoPort = 27017;
        mongoClient = new MongoClient(mongoIpAddress, mongoPort);
    }
}
