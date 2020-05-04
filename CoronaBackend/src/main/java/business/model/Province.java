package business.model;

public class Province
{
	private String name;
	private CovidStat deathCount;
	private CovidStat infectedCount;
	private Location location;

	public Province(String name, CovidStat deathCount, CovidStat infectedCount, Location location)
	{
		this.name = name;
		this.deathCount = deathCount;
		this.infectedCount = infectedCount;
		this.location = location;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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

	public Location getLocation() {
		return location;
	}

	public void setInfectedCount(CovidStat infectedCount)
	{
		this.infectedCount = infectedCount;
	}
}
