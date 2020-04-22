package webapi.reponse;

import business.model.CovidStat;
import business.model.Province;

public class ProvinceResponse
{
	private final Province province;

	public ProvinceResponse(Province province)
	{
		this.province = province;
	}

	public String getName()
	{
		return province.getName();
	}

	public CovidStatResponse getDeathCount()
	{
		return province.getDeathCount() != null ? new CovidStatResponse(province.getDeathCount()) : null;
	}

	public CovidStatResponse getInfectedCount()
	{
		return province.getInfectedCount() != null ? new CovidStatResponse(province.getInfectedCount()) : null;
	}
}
