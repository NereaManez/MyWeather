package server;

import server.controller.CityController;
import server.model.JsonTransformer;

import static spark.Spark.*;

public class APP {
    public static void main(String[] args) {
        get(API.Routes.CITY_ALL, CityController::getCities, new JsonTransformer<>());
        post(API.Routes.ADD_CITY, CityController::addCity, new JsonTransformer<>());
    }
}
