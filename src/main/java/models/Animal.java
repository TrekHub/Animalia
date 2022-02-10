package models;

public class Animal {

    private String name;
    private  int id;



    public void setId(int id) {
        this.id = id;
    }

    public Animal(String name) {
        this.name = name;

    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


}
