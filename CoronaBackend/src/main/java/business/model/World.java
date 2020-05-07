package business.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class World
{
	private Map<String, Country> countries = new HashMap<>();

	public Map<String, Country> getCountries()
	{
		return countries;
	}

	public int getTotalInfected()
	{
		return countries.values().stream().mapToInt(Country::getTotalInfected).sum();
	}

	public int getTotalDead()
	{
		return countries.values().stream().mapToInt(Country::getTotalDead).sum();
	}

	/**
	 * Merge data with this world
	 * */
	public void merge(World world)
	{
		for (Map.Entry<String, Country> country : world.getCountries().entrySet())
		{
			if (!getCountries().containsKey(country.getKey()))
			{
				getCountries().put(country.getKey(), country.getValue());
			}
			else
			{
				Country mergedCountry = getCountries().get(country.getKey());
				mergedCountry.merge(country.getValue());
			}
		}
	}
}
