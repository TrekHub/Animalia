package dao;

import models.EndangeredAnimal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql20EndangeredDao implements EndangeredDao {
    private Sql2o sql2o;

    public Sql20EndangeredDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void add(EndangeredAnimal endangeredAnimal){
        String sql = "INSERT INTO endangered (name, age, health) VALUES (:name, :age, :health)";
        try(Connection con = sql2o.open()){
           int id = (int) con.createQuery(sql, true)
                    .bind(endangeredAnimal)
                    .executeUpdate()
                    .getKey();
           endangeredAnimal.setId(id);
        }

    };

    public List<EndangeredAnimal> getAll(){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM endangered")
                    .executeAndFetch(EndangeredAnimal.class);
        }

    }


}
