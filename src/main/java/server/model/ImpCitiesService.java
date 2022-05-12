package server.model;

import model.MyDataSource;
import server.model.entity.Place;
import server.model.entity.Result;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImpCitiesService implements ICityService {
    @Override
    public List<Place> getCities() {
        DataSource ds = MyDataSource.getMyMariaDBDataSource();
        String name;
        float lon;
        float lat;
        String img;
        List<Place> cities = new ArrayList<>();
        String sql = "SELECT * FROM city";

        try (Connection con = ds.getConnection();
             Statement s = con.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                name = rs.getString("c_name");
                lon = rs.getFloat("lon");
                lat = rs.getFloat("lat");
                img = rs.getString("img");

                cities.add(new Place(name,lon,lat,img));
            }

            return cities;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Result<Place> add(Place place) {
        DataSource ds = MyDataSource.getMyMariaDBDataSource();
        int count;

        try (Connection con = ds.getConnection();
             Statement statement = con.createStatement();) {
            String sql = "INSERT INTO city VALUES ('" + place.getName() + "', " + place.getLon()
                    + ", " + place.getLat() + ", '"+ place.getImg() + "')";
            count = statement.executeUpdate(sql);

            if (count == 1)
                return new Result.Success<Place>(place);
            else
                return new Result.Error(400, "City no added");
        } catch (SQLException throwables) {
            return new Result.Error(throwables.getErrorCode(),throwables.getMessage());
        }
    }
}
