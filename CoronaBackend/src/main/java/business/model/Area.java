package business.model;

public abstract class Area
{
	private String name;

	public Area(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
