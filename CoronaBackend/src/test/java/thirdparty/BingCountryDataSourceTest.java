package thirdparty;

import business.model.Country;
import business.model.Province;
import business.model.World;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class BingCountryDataSourceTest
{

	@org.junit.jupiter.api.Test
	void getCountries() throws IOException, ParseException
	{
		BingCountryDataSource source = new BingCountryDataSource();

		World world = source.getCountries();

		assertNotNull(world);
		assertTrue(world.getCountries().size() > 0);
	}
}