import dao.Sql2oAnimalsDao;
import dao.Sql2oSightingsDao;
import models.Animals;
import models.Sightings;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {


    public static void main(String[] args) {
        staticFileLocation("/public");
        String connection = "jdbc:postgresql://localhost:5432/wildlife_tracker";
        Sql2o sql2o = new Sql2o(connection, "postgres", "Cosmo1088%");

        //Create an Instance of the Sql2oanimals class

        Sql2oAnimalsDao sql2oAnimalsDao = new Sql2oAnimalsDao(sql2o);
        Sql2oSightingsDao sql2oSightingsDao = new Sql2oSightingsDao(sql2o);



        //Root route
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals = sql2oAnimalsDao.getAll();
            List<Sightings> sightings = sql2oSightingsDao.getAll();

            model.put("animals", animals);
            model.put("sightings", sightings);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //Add new animal route

        post("/addAnimal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");

            if (request.queryParams("endangeredInput") != null) {
                if (!(name.trim().isEmpty() || age.trim().isEmpty() || health.trim().isEmpty())) {
                    Animals animals = new Animals(name, age, health);
                    sql2oAnimalsDao.add(animals);

                } else {
                    System.out.println("If Endangered, Fill in all The Extra Fields!!");
                }
            } else {
                Animals animals = new Animals(name, age, health);
                sql2oAnimalsDao.add(animals);
            }
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


        post("/addSighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals = sql2oAnimalsDao.getAll();

            String id =  request.queryParams("id");
            int newId = Integer.parseInt(id) - 1;
            String name = animals.get(newId).name;
            String age = animals.get(newId).age;
            String  health = animals.get(newId).health;
            String  location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            Sightings sightings = new Sightings(name, age, health, location , rangerName);
            sql2oSightingsDao.add(sightings);


            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
    }




}
