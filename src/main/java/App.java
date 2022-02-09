import dao.Sql20AnimalDao;
import dao.Sql20EndangeredDao;
import models.Animal;
import models.EndangeredAnimal;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {


    public static void main(String[] ars) {
        staticFileLocation("/public");
        String connectmetodatabase = "jdbc:postgresql://localhost:5432/animal";
        Sql2o sql2o = new Sql2o(connectmetodatabase, "postgres", "Cosmo1088%");
        Sql20AnimalDao sql20AnimalDao = new Sql20AnimalDao(sql2o);
        Sql20EndangeredDao sql20EndangeredDao = new Sql20EndangeredDao(sql2o);


        //Root Route
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("animals", sql20AnimalDao.getAll());
            model.put("endangered", sql20EndangeredDao.getAll());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        //add data to db route
        post("/addSighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");

            if (request.queryParams("endangeredInput") != null) {
                if (!(name.trim().isEmpty() || health.trim().isEmpty() || age.trim().isEmpty())) {
                    EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name, health, age);
                    sql20EndangeredDao.add(endangeredAnimal);
                } else {
                    System.out.println("Fill the Fields");
                }
            } else {
                if (!(name.trim().isEmpty())) {
                    Animal animal = new Animal(name);
                    sql20AnimalDao.add(animal);

                } else {
                    System.out.println("Fill all The Spaces");
                }
            }
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


    }

    ;
}
