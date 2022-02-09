package dao;
import models.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql20AnimalDao implements AnimalDao {
    private Sql2o sql2o;

    public  Sql20AnimalDao (Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public  void add(Animal animal){
        String newAnimalSighting = "INSERT INTO animals (name) VALUES (:name)";
         try(Connection con = sql2o.open()){
             int id = (int) con.createQuery(newAnimalSighting, true)
                     .bind(animal)
                     .executeUpdate()
                     .getKey();
             animal.setId(id);

         }catch (Sql2oException err){
             System.out.println("Error Exists!!  " + err);
         }
    }

    @Override
    public List<Animal> getAll(){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals")
                    .executeAndFetch(Animal.class);
        }



    }
}