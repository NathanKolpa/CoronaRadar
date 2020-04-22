package webapi.reponse;

import business.model.Country;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryResponse
{
	private final Country country;

	public CountryResponse(Country country)
	{
		this.country = country;
	}

	public String getName()
	{
		return country.getName();
	}

	public Map<String, ProvinceResponse> getProvinces()
	{
		return country.getProvinces()
				.entrySet()
				.stream()
				.map(x -> new AbstractMap.SimpleEntry<String, ProvinceResponse>(x.getKey(), new ProvinceResponse(x.getValue())))
				.collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
	}
}
