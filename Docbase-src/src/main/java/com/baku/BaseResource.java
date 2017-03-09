package com.baku;

import com.mongodb.MongoClient;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("base")
public class BaseResource {

    @Inject
    DbClientProvider dbClientProvider;

    @GET
    public String method() {
        return dbClientProvider.getMongoClient().getConnectPoint();
    }
}
