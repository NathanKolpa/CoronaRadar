package business.model;

import java.util.HashMap;
import java.util.Map;

public class Country extends Area
{
	private HashMap<String, Province> provinces = new HashMap<>();

	public Country(String name)
	{
		super(name);
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

	/**
	 * Merge the country with this country
	 * */
	public void merge(Country country)
	{
		for (Map.Entry<String, Province> province : country.getProvinces().entrySet())
		{
			if (!getProvinces().containsKey(province.getKey()))
			{
				getProvinces().put(province.getKey(), province.getValue());
			}
			else
			{
				Province mergedProvince = getProvinces().get(province.getKey());
				mergedProvince.merge(province.getValue());
			}
		}
	}
}
