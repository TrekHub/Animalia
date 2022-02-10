package dao;

import models.Animals;
import models.Sightings;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oSightingsDao implements SightingsDao {

    private Sql2o sql2o;

    public Sql2oSightingsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Sightings sightings) {
        String sql = "INSERT INTO sightings (name, age, health, location, rangerName) VALUES (:name, :age, :health, :location, :rangerName)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(sightings)
                    .executeUpdate()
                    .getKey();
            sightings.setId(id);
        }

    }



    @Override
    public List<Sightings> getAll() {
        String sql = "SELECT * FROM sightings";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Sightings.class);


        }
    }



}
