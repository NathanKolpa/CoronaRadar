package business;

import business.date.ManualDateFactory;
import business.model.World;
import business.worlddata.ManualWorldData;
import business.worlddata.WorldDataCache;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class WorldDataCacheTest
{
	@Test
	void getWorld1() throws Exception
	{
		//arrange
		ManualDateFactory dateFactory = new ManualDateFactory();
		ManualWorldData manualWorldData = new ManualWorldData(new World());
		dateFactory.setDate(new Date(2020, Calendar.MAY, 21, 0, 0,0));
		WorldDataCache cache = new WorldDataCache(manualWorldData, dateFactory, 1);
		World oldWorld = cache.getWorld();

		//act
		dateFactory.setDate(new Date(2020, Calendar.MAY, 21, 0, 1,1));
		manualWorldData.setWorld(new World());

		//assert
		World newWorld = cache.getWorld();

		assertNotNull(newWorld);
		assertNotEquals(oldWorld, newWorld);
	}

	@Test
	void getWorld2() throws Exception
	{
		//arrange
		ManualDateFactory dateFactory = new ManualDateFactory();
		ManualWorldData manualWorldData = new ManualWorldData(new World());
		dateFactory.setDate(new Date(2020, Calendar.MAY, 21, 0, 0,0));
		WorldDataCache cache = new WorldDataCache(manualWorldData, dateFactory, 1);
		World oldWorld = cache.getWorld();

		//act
		dateFactory.setDate(new Date(2020, Calendar.MAY, 21, 0, 0,30));
		manualWorldData.setWorld(new World());

		//assert
		World newWorld = cache.getWorld();

		assertNotNull(newWorld);
		assertEquals(oldWorld, newWorld);
	}
}