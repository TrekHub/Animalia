package dao;

import models.Animal;

import java.util.List;

public  interface  AnimalDao {
    void add(Animal animal);
    List<Animal> getAll();

}