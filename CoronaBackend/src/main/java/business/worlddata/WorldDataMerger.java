package business.worlddata;

import business.model.Country;
import business.model.Province;
import business.model.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorldDataMerger implements WorldDataSource
{
	private ArrayList<WorldDataSource> sources = new ArrayList<>();

	public ArrayList<WorldDataSource> getSources()
	{
		return sources;
	}

	@Override
	public World getWorld() throws Exception
	{
		World mergedWorld = new World();
		List<World> otherWorlds = getWorlds();


		for (World world : otherWorlds)
		{
			for (Map.Entry<String, Country> country : world.getCountries().entrySet())
			{
				if (!mergedWorld.getCountries().containsKey(country.getKey()))
				{
					mergedWorld.getCountries().put(country.getKey(), country.getValue());
				}
				else
				{
					Country mergedCountry = mergedWorld.getCountries().get(country.getKey());

					for (Map.Entry<String, Province> province : country.getValue().getProvinces().entrySet())
					{
						if (!mergedCountry.getProvinces().containsKey(province.getKey()))
						{
							mergedCountry.getProvinces().put(province.getKey(), province.getValue());
						}
						else
						{
							//merge covid stats
							Province mergedProvince = mergedCountry.getProvinces().get(province.getKey());

							if (mergedProvince.getDeathCount() == null || mergedProvince.getDeathCount()
									.getLastUpdated()
									.before(province.getValue().getDeathCount().getLastUpdated()))
							{
								mergedProvince.setDeathCount(province.getValue().getDeathCount());
							}

							if (mergedProvince.getInfectedCount() == null || mergedProvince.getInfectedCount()
									.getLastUpdated()
									.before(province.getValue().getInfectedCount().getLastUpdated()))
							{
								mergedProvince.setInfectedCount(province.getValue().getInfectedCount());
							}
						}
					}
				}
			}
		}

		return mergedWorld;
	}

	private List<World> getWorlds()
	{
		return sources.stream().flatMap(s ->
		{
			try
			{
				return Stream.of(s.getWorld());
			}
			catch (Exception e)
			{
				return Stream.empty();
			}
		}).collect(Collectors.toList());
	}
}
