package business.model;

import java.util.ArrayList;

public class Country
{
	private String name;
	private ArrayList<Province> provinces = new ArrayList<Province>();

	public Country(String name)
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

	public ArrayList<Province> getProvinces()
	{
		return provinces;
	}
}
