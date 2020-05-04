package webapi.reponse;

import business.model.CovidStat;
import business.model.Province;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProvinceResponse
{
	private final Province province;

	public ProvinceResponse(Province province)
	{
		this.province = province;
	}

	@JsonProperty("name")
	public String getName()
	{
		return province.getName();
	}

	@JsonProperty("deaths")
	public CovidStatResponse getDeathCount()
	{
		return province.getDeathCount() != null ? new CovidStatResponse(province.getDeathCount()) : null;
	}

	@JsonProperty("infections")
	public CovidStatResponse getInfectedCount()
	{
		return province.getInfectedCount() != null ? new CovidStatResponse(province.getInfectedCount()) : null;
	}
	@JsonProperty("location")
	public LocationResponse getLocation()
	{
		return new LocationResponse(province.getLocation());
	}
}
