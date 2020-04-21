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
}
