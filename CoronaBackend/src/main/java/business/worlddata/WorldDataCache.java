package business.worlddata;

import business.date.DateFactory;
import business.model.World;
import infrastructure.CurrentDateFactory;

import java.util.Date;

public class WorldDataCache implements WorldDataSource
{
	private final WorldDataSource worldDataSource;
	private final DateFactory dateFactory;
	private int minValid;
	private World world = null;
	private Date lastFetch;

	public WorldDataCache(WorldDataSource worldDataSource, DateFactory dateFactory, int minValid)
	{
		this.worldDataSource = worldDataSource;
		this.dateFactory = dateFactory;
		this.minValid = minValid;
	}

	@Override
	public World getWorld() throws Exception
	{
		if(world == null || hasExpired())
		{
			world = worldDataSource.getWorld();
			lastFetch = dateFactory.now();
		}

		return world;
	}

	private boolean hasExpired()
	{
		if(lastFetch == null)
			return true;

		Date now = dateFactory.now();
		now.setMinutes(now.getMinutes() - minValid);

		return now.after(lastFetch);
	}
}
