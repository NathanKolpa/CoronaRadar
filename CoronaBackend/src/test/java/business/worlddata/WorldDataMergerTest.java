package business.worlddata;

import business.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

class WorldDataMergerTest
{
	@Test
	void getWorld1() throws Exception
	{
		DataOrigin dataOrigin = new DataOrigin("test");
		Date now = new Date(2020, Calendar.MAY, 21, 0, 0, 0);

		//arrange
		World world1 = new World();
		World world2 = new World();

		world1.getCountries().put("netherlands", new Country("Netherlands"));
		world2.getCountries().put("netherlands", new Country("Netherlands"));

		world1.getCountries()
				.get("netherlands")
				.getProvinces()
				.put("gelderland", new Province("Gelderland", new CovidStat(dataOrigin, now, 10), null));

		world2.getCountries()
				.get("netherlands")
				.getProvinces()
				.put("gelderland", new Province("Gelderland", null, new CovidStat(dataOrigin, now, 10)));

		WorldDataMerger dataMerger = new WorldDataMerger();
		dataMerger.getSources().add(new ManualWorldData(world1));
		dataMerger.getSources().add(new ManualWorldData(world2));

		//act
		World merged = dataMerger.getWorld();

		//assert
		assertNotNull(merged.getCountries().get("netherlands").getProvinces().get("gelderland").getDeathCount());
		assertNotNull(merged.getCountries().get("netherlands").getProvinces().get("gelderland").getInfectedCount());
	}

	@Test
	void getWorld2() throws Exception
	{
		DataOrigin dataOrigin = new DataOrigin("test");
		Date old = new Date(2020, Calendar.MAY, 21, 0, 0, 0);
		Date later = new Date(2020, Calendar.MAY, 21, 0, 0, 1);

		//arrange
		World world1 = new World();
		World world2 = new World();

		world1.getCountries().put("netherlands", new Country("Netherlands"));
		world2.getCountries().put("netherlands", new Country("Netherlands"));

		world1.getCountries()
				.get("netherlands")
				.getProvinces()
				.put("gelderland", new Province("Gelderland", new CovidStat(dataOrigin, old, 10),  new CovidStat(dataOrigin, old, 10)));

		world2.getCountries()
				.get("netherlands")
				.getProvinces()
				.put("gelderland", new Province("Gelderland", new CovidStat(dataOrigin, later, 20), new CovidStat(dataOrigin, later, 20)));

		WorldDataMerger dataMerger = new WorldDataMerger();
		dataMerger.getSources().add(new ManualWorldData(world2));
		dataMerger.getSources().add(new ManualWorldData(world1));

		//act
		World merged = dataMerger.getWorld();

		//assert
		assertNotNull(merged.getCountries().get("netherlands").getProvinces().get("gelderland").getDeathCount());
		assertNotNull(merged.getCountries().get("netherlands").getProvinces().get("gelderland").getInfectedCount());

		assertEquals(20, merged.getCountries().get("netherlands").getProvinces().get("gelderland").getInfectedCount().getStatValue());
		assertEquals(20, merged.getCountries().get("netherlands").getProvinces().get("gelderland").getDeathCount().getStatValue());
	}
}