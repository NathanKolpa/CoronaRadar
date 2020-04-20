package business.model;

import java.util.Date;

public class CovidStat
{
	private DataOrigin dataOrigin;
	private Date lastUpdated;
	private int statValue;

	public CovidStat(DataOrigin dataOrigin, Date lastUpdated, int statValue)
	{
		this.dataOrigin = dataOrigin;
		this.lastUpdated = lastUpdated;
		this.statValue = statValue;
	}

	public int getStatValue()
	{
		return statValue;
	}

	public void setStatValue(int statValue)
	{
		this.statValue = statValue;
	}

	public DataOrigin getDataOrigin()
	{
		return dataOrigin;
	}

	public void setDataOrigin(DataOrigin dataOrigin)
	{
		this.dataOrigin = dataOrigin;
	}

	public Date getLastUpdated()
	{
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated)
	{
		this.lastUpdated = lastUpdated;
	}
}
