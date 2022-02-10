package dao;

import models.Animals;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAnimalsDao implements AnimalDao {

    private Sql2o sql2o;

    public Sql2oAnimalsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Animals animals) {
        String sql = "INSERT INTO animals (name, age, health) VALUES (:name, :age, :health)";

        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(animals)
                    .executeUpdate()
                    .getKey();
            animals.setId(id);
        }catch (Sql2oException err){
            System.out.println("Object not added into the database cause of the error " + err);
        }

    }


    @Override
    public List<Animals> getAll(){
        String sql = "SELECT * FROM animals";
        try(Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .executeAndFetch(Animals.class);

        }
    }
}
