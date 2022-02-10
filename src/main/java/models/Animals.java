package models;

public class Animals {
    public int id;
    public String name;
    public String age;
    public String health;

    public Animals(String name, String age, String health) {
        this.name = name;
        this.age = age;
        this.health = health;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }
}
