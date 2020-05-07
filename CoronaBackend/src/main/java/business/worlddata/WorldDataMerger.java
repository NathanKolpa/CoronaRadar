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
			mergedWorld.merge(world);
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
