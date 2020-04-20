package business.model;

public class Province
{
	private String name;
	private int deathCount;
	private int infectedCount;

	public Province(String name, int deathCount, int infectedCount)
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

	public int getDeathCount()
	{
		return deathCount;
	}

	public void setDeathCount(int deathCount)
	{
		this.deathCount = deathCount;
	}

	public int getInfectedCount()
	{
		return infectedCount;
	}

	public void setInfectedCount(int infectedCount)
	{
		this.infectedCount = infectedCount;
	}
}
