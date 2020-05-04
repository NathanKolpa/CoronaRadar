package business.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Country
{
	private String name;
	private HashMap<String, Province> provinces = new HashMap<>();

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

	public int getTotalInfected()
	{
		return provinces.entrySet().stream().mapToInt(value -> value.getValue().getInfectedCount() != null ? value.getValue().getInfectedCount().getStatValue():0).sum();
	}

	public int getTotalDead()
	{
		return provinces.entrySet().stream().mapToInt(value -> value.getValue().getDeathCount() != null ? value.getValue().getDeathCount().getStatValue():0).sum();
	}
	public Map<String, Province> getProvinces()
	{
		return provinces;
	}
}
