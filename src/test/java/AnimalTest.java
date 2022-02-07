import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public  void animalInstantiatesCorrectly_true(){
        Animal testAnimal = new Animal("Lion");
        assertEquals(true, testAnimal instanceof  Animal);
    }

    @Test
    public  void getName_animalInstantiatesWithName_Lion(){
        Animal testAnimal = new Animal("Lion");
        assertEquals("Lion", testAnimal.getName());
    }


    //Database Tests
    @Test
    public  void save_insertsObjectIntoDatabase_animal(){
        Animal testAnimal = new Animal("Lion");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

}