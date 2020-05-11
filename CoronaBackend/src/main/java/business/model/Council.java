package business.model;

import java.util.HashMap;

public class Council extends Area
{
    private CovidStat deaths,infected;
    private Location location;


    public Council(String name,CovidStat deaths, CovidStat infected, Location location)
    {
        super(name);
        this.deaths = deaths;
        this.infected = infected;
        this.location = location;

    }


    //get-set
    public CovidStat getDeaths()
    {
        return deaths;
    }

    public void setDeaths(CovidStat deaths)
    {
        this.deaths = deaths;
    }

    //get-set infected
    public CovidStat getInfected()
    {
        return infected;
    }

    public void setInfected(CovidStat infected)
    {
        this.infected = infected;
    }

    //get-set location
    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    //merge methode
    public void merge(Council council)
    {
        if (council.getDeaths() != null && (getDeaths() == null || getDeaths().getLastUpdated()
                .before(council.getDeaths().getLastUpdated())))
        {
            setDeaths(council.getDeaths());
        }

        if (council.getInfected() != null && (getInfected() == null || getInfected().getLastUpdated()
                .before(council.getInfected().getLastUpdated())))
        {
            setInfected(council.getInfected());
        }

    }
}
