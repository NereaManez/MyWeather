package server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.model.ICityService;
import server.model.ImpCitiesService;
import server.model.JsonTransformer;
import server.model.entity.Place;
import server.model.entity.Result;
import spark.Request;
import spark.Response;

import java.util.List;

public class CityController {
    static Logger logger = LoggerFactory.getLogger(Place.class);
    private static JsonTransformer<Place> jsonTransformer = new JsonTransformer<>();
    private static ICityService service = new ImpCitiesService();

    public static List<Place> getCities(Request req, Response res) {
        logger.info("Searching all cities");

        return service.getCities();
    }

    public static Result addCity(Request req, Response res) {
        logger.info("Add new city");

        String body = req.body();
        Place p = jsonTransformer.getObject(body,Place.class);

        Result result = service.add(p);
        if (result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error) result;
            res.status(404);
        }

        return result;
    }
}
