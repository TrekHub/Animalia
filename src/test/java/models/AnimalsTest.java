package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {
    @Test
    public void animal_InstantuateCorrectly_true() {
        Animals testAnimal = new Animals("Lion", "young", "bad");
        assertEquals(true, testAnimal instanceof Animals);

    }

    @Test
    public void animal_InstantiateWithNAme_true() {
        Animals testAnimal = new Animals("Lion", "young", "bad");
        assertEquals("Lion", testAnimal.getName());


    }

    @Test
    public void animal_InstantiateWithAge_true() {
        Animals testAnimal = new Animals("Lion", "young", "bad");
        assertEquals("young", testAnimal.getAge());


    }  @Test
    public void animal_InstantiateWithHealth_true() {
        Animals testAnimal = new Animals("Lion", "young", "bad");
        assertEquals("bad", testAnimal.getHealth());


    }

}