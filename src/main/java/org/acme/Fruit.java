package org.acme;


import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.sqlclient.Row;


public class Fruit {

    static final String SQL = " select * from public.fruit ";

    public Long id;
    public String name;

    public Fruit(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public static Multi<Fruit> listAll(io.vertx.mutiny.pgclient.PgPool client){
        return client.query(SQL).execute()
            .onItem().transformToMulti( set -> Multi.createFrom().iterable(set) )
            .onItem().transform(Fruit::from);
    }

    private static Fruit from(Row row){
        return new Fruit(row.getLong("id"), row.getString("name"));
    }
    
}
