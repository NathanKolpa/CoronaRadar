package webapi.reponse;

import business.model.DataOrigin;

public class DataOriginResponse
{

	private final DataOrigin dataOrigin;

	public DataOriginResponse(DataOrigin dataOrigin)
	{
		this.dataOrigin = dataOrigin;
	}

	public String getName()
	{
		return dataOrigin.getName();
	}
}
