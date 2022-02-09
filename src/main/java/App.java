import dao.Sql20AnimalDao;
import models.Animal;
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

//        String connectmetodatabase = "jdbc:h2:~/animal.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";

        String connectmetodatabase = "jdbc:postgresql://localhost:5432/animal";
        Sql2o sql2o = new Sql2o(connectmetodatabase, "postgres", "Cosmo1088%");
        Sql20AnimalDao sql20AnimalDao = new Sql20AnimalDao(sql2o);


        //Root Route
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = sql20AnimalDao.getAll();
            model.put("animals", animals);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());



//        get("/animals", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            List<Animal> animals = sql20AnimalDao.getAll();
//            model.put("animals", animals);
//            return new ModelAndView(model, "layout.hbs");
//        }, new HandlebarsTemplateEngine());


        //add data to db route
        post("/addSighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            Animal newAnimal = new Animal(name, age);
            sql20AnimalDao.add(newAnimal);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


    }

    ;
}
