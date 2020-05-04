package webapi.reponse;

import business.model.Location;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationResponse {
    private final Location location;

    public LocationResponse(Location location)
    {
        this.location = location;
    }

    @JsonProperty("lat")
    public double getLatValue()
    {
        return location.getLat();
    }

    @JsonProperty("lon")
    public double getLonValue()
    {
        return location.getLon();
    }
}
