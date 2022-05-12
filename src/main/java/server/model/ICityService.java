package server.model;

import server.model.entity.Place;
import server.model.entity.Result;

import java.util.List;

public interface ICityService {
    List<Place> getCities();
    Result<Place> add(Place place);
}
