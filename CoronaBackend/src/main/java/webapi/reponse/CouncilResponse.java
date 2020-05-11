package webapi.reponse;

import business.model.Council;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CouncilResponse
{
    private final Council council;

    public CouncilResponse(Council council)
    {
        this.council = council;
    }

    @JsonProperty("name")
    public String getCouncilName()
    {
        return council.getName();
    }

    @JsonProperty("deaths")
    public CovidStatResponse getCouncilDeaths()
    {
        return council.getDeaths() != null ? new CovidStatResponse(council.getDeaths()) : null;
    }

    @JsonProperty("infections")
    public CovidStatResponse getCouncilInfected()
    {
        return council.getInfected() != null ? new CovidStatResponse(council.getInfected()) : null;
    }
    @JsonProperty("location")
    public LocationResponse getLocation()
    {
        return new LocationResponse(council.getLocation());
    }
}

