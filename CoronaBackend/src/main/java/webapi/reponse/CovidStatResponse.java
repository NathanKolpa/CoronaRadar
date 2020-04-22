package webapi.reponse;

import business.model.CovidStat;
import business.model.DataOrigin;

import java.util.Date;

public class CovidStatResponse
{
	private final CovidStat covidStat;

	public CovidStatResponse(CovidStat covidStat)
	{
		this.covidStat = covidStat;
	}

	public int getStatValue()
	{
		return covidStat.getStatValue();
	}

	public DataOriginResponse getDataOrigin()
	{
		return new DataOriginResponse(covidStat.getDataOrigin());
	}

	public Date getLastUpdated()
	{
		return covidStat.getLastUpdated();
	}
}
