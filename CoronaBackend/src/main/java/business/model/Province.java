package business.model;

import com.sun.istack.internal.Nullable;

public class Province
{
	private String name;
	private CovidStat deathCount;
	private CovidStat infectedCount;

	public Province(String name, @Nullable CovidStat deathCount, @Nullable CovidStat infectedCount)
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

	public @Nullable CovidStat getDeathCount()
	{
		return deathCount;
	}

	public void setDeathCount(@Nullable CovidStat deathCount)
	{
		this.deathCount = deathCount;
	}

	public @Nullable CovidStat getInfectedCount()
	{
		return infectedCount;
	}

	public void setInfectedCount(@Nullable CovidStat infectedCount)
	{
		this.infectedCount = infectedCount;
	}
}
