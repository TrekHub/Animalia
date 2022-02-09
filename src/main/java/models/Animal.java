package models;

public class Animal {

    private String name;
    private String age;

    public Animal(String name, String age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
