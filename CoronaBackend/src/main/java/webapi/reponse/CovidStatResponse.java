package webapi.reponse;

import business.model.CovidStat;
import business.model.DataOrigin;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CovidStatResponse
{
	private final CovidStat covidStat;

	public CovidStatResponse(CovidStat covidStat)
	{
		this.covidStat = covidStat;
	}

	@JsonProperty("value")
	public int getStatValue()
	{
		return covidStat.getStatValue();
	}

	@JsonProperty("data_origin")
	public DataOriginResponse getDataOrigin()
	{
		return new DataOriginResponse(covidStat.getDataOrigin());
	}

	@JsonProperty("last_updated")
	public Date getLastUpdated()
	{
		return covidStat.getLastUpdated();
	}
}
