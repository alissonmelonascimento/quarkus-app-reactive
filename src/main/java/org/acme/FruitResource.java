package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.pgclient.PgPool;

@Path("/fruits")
public class FruitResource {

    @Inject
    PgPool client;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Fruit> hello() {
        return Fruit.listAll(client);
    }
}