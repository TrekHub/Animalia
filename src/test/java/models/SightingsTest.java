package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {



    @Test
    public void getRangerName() {
        Sightings testRecord = new Sightings("Lion", "young", "poor", "Rongai", "Teddy");
        assertEquals("Teddy", testRecord.getRangerName());
    }

    @Test
    public void getLocation() {
        Sightings testRecord = new Sightings("Lion", "young", "poor", "Rongai", "Teddy");
        assertEquals("Rongai", testRecord.getLocation());
    }
}