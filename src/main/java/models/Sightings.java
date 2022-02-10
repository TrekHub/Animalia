package models;

import java.util.List;

public class Sightings extends  Animals {

    private String rangerName;
    private String location;



    public Sightings(String name, String age, String health,  String location, String rangerName) {
        super(name, age, health);
        this.location = location;
        this.rangerName = rangerName;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
