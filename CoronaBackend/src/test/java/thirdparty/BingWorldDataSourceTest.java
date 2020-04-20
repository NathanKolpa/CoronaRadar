package thirdparty;

import business.model.World;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class BingWorldDataSourceTest
{

	@org.junit.jupiter.api.Test
	void getWorld() throws IOException, ParseException
	{
		BingWorldDataSource source = new BingWorldDataSource();

		World world = source.getWorld();

		assertNotNull(world);
		assertTrue(world.getCountries().size() > 0);
	}
}