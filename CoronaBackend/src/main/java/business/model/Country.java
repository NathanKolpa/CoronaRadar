package business.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Country
{
	private String name;
	private Map<String, Province> provinces = new HashMap<>();

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

	public Map<String, Province> getProvinces()
	{
		return provinces;
	}
}
