package dao;

import models.Animals;

import java.util.List;


public interface AnimalDao {

    void add(Animals animals);
    List<Animals> getAll();


}
