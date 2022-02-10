package dao;

import models.Sightings;

import java.util.List;

public interface SightingsDao {
    void add(Sightings sightings);
    List<Sightings> getAll();

}
