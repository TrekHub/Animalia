package dao;

import models.EndangeredAnimal;

import java.util.List;

public interface EndangeredDao {
    void add(EndangeredAnimal endangeredAnimal);

    List<EndangeredAnimal> getAll();
}
