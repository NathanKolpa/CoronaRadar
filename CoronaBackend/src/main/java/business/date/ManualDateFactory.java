package business.date;

import java.util.Date;

public class ManualDateFactory implements DateFactory
{
	private Date date;

	@Override
	public Date now()
	{
		return new Date(date.getTime());
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
}
