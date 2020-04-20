package business;

import business.model.World;
import com.sun.istack.internal.NotNull;


public interface WorldDataSource
{
	@NotNull
	World getWorld() throws Exception;
}
