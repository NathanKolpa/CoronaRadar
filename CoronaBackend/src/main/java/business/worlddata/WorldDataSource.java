package business.worlddata;

import business.model.World;


public interface WorldDataSource
{
	World getWorld() throws Exception;
}
