import static spark.Spark.*;


public class App {


    public static void main(String[] ars) {

        //Root Route
        get("/", (request,response) -> {
            return "Hello World";

        });


    }

    ;
}
