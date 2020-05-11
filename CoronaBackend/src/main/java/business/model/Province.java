package business.model;

import java.util.HashMap;
import java.util.Map;

public class Province extends Area
{
	private CovidStat deathCount;
	private CovidStat infectedCount;
	private Location location;
	private HashMap <String,Council> councils = new HashMap<>();

	public Province(String name, CovidStat deathCount, CovidStat infectedCount, Location location)
	{
		super(name);
		this.deathCount = deathCount;
		this.infectedCount = infectedCount;
		this.location = location;
	}

	public CovidStat getDeathCount()
	{
		return deathCount;
	}

	public void setDeathCount(CovidStat deathCount)
	{
		this.deathCount = deathCount;
	}

	public CovidStat getInfectedCount()
	{
		return infectedCount;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setInfectedCount(CovidStat infectedCount)
	{
		this.infectedCount = infectedCount;
	}

	public Map<String, Council> getCouncils()
	{
		return councils;
	}
	/**
	 * Merge the province with this province
	 * */
	public void merge(Province province)
	{
		if (province.getDeathCount() != null && (getDeathCount() == null || getDeathCount().getLastUpdated()
				.before(province.getDeathCount().getLastUpdated())))
		{
			setDeathCount(province.getDeathCount());
		}

		if (province.getInfectedCount() != null && (getInfectedCount() == null || getInfectedCount().getLastUpdated()
				.before(province.getInfectedCount().getLastUpdated())))
		{
			setInfectedCount(province.getInfectedCount());
		}

		for (Map.Entry<String, Council> council : province.getCouncils().entrySet())
		{
			if (!getCouncils().containsKey(council.getKey()))
			{
				getCouncils().put(council.getKey(), council.getValue());
			}
			else
			{
				Council mergedcouncil = getCouncils().get(council.getKey());
				mergedcouncil.merge(council.getValue());
			}
		}
	}
}
