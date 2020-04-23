package webapi.reponse;

import business.model.DataOrigin;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataOriginResponse
{

	private final DataOrigin dataOrigin;

	public DataOriginResponse(DataOrigin dataOrigin)
	{
		this.dataOrigin = dataOrigin;
	}

	@JsonProperty("name")
	public String getName()
	{
		return dataOrigin.getName();
	}
}
