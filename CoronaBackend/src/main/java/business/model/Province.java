package business.model;

public class Province
{
	private String name;
	private CovidStat deathCount;
	private CovidStat infectedCount;

	public Province(String name, CovidStat deathCount, CovidStat infectedCount)
	{
		this.name = name;
		this.deathCount = deathCount;
		this.infectedCount = infectedCount;
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

	public void setInfectedCount(CovidStat infectedCount)
	{
		this.infectedCount = infectedCount;
	}
}
