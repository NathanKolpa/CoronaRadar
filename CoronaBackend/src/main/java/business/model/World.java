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

	public Country getNetherlands() throws NullPointerException
	{
		if(!countries.containsKey("netherlands"))
			throw new NullPointerException();

		return countries.get("netherlands");
	}

	public int getTotalInfected()
	{
		return countries.entrySet().stream().mapToInt(value -> value.getValue().getTotalInfected()).sum();
	}

	public int getTotalDead()
	{
		return countries.entrySet().stream().mapToInt(value -> value.getValue().getTotalDead()).sum();
	}
}
