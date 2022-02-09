import dao.Sql20AnimalDao;
import models.Animal;
import models.EndangeredAnimal;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class App {


    public static void main(String[] ars) {
        staticFileLocation("/public");


        String connectmetodatabase = "jdbc:postgresql://localhost:5432/animal";
        Sql2o sql2o = new Sql2o(connectmetodatabase, "postgres", "Cosmo1088%");
        Sql20AnimalDao sql20AnimalDao = new Sql20AnimalDao(sql2o);



        //Root Route
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

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
                } else {
                    System.out.println("Fill the Fields");
                }
            }else{
                    if (!(name.trim().isEmpty())) {
                        Animal animal = new Animal(name);

                    } else {
                        System.out.println("Fill all The Spaces");
                    }
                }



            return null;
        }, new HandlebarsTemplateEngine());


    }

    ;
}
