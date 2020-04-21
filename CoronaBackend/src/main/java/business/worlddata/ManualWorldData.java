package business.worlddata;

import business.model.World;

public class ManualWorldData implements WorldDataSource
{
	private World world;

	public ManualWorldData(World world)
	{
		this.world = world;
	}

	@Override
	public World getWorld() throws Exception
	{
		return world;
	}

	public void setWorld(World world)
	{
		this.world = world;
	}

}
