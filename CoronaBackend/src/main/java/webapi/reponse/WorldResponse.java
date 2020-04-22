package webapi.reponse;

import business.model.Country;
import business.model.World;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WorldResponse
{
	private final World world;

	public WorldResponse(World world)
	{
		this.world = world;
	}

	@JsonProperty("countries")
	public Map<String, CountryResponse> getCountries()
	{
		return world.getCountries()
			.entrySet()
			.stream()
			.map(x -> new AbstractMap.SimpleEntry<String, CountryResponse>(x.getKey(), new CountryResponse(x.getValue())))
			.collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
	}
}
