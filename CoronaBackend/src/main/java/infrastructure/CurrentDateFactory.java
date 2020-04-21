package infrastructure;

import business.date.DateFactory;

import java.util.Date;

public class CurrentDateFactory implements DateFactory
{
	@Override
	public Date now()
	{
		return new Date();
	}
}
