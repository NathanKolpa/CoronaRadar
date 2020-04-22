package webapi;

import business.model.Country;
import business.model.World;
import business.worlddata.WorldDataCache;
import business.worlddata.WorldDataSource;
import infrastructure.BingWorldDataSource;
import infrastructure.CurrentDateFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webapi.reponse.CountryResponse;
import webapi.reponse.WorldResponse;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
public class WebApi
{
	private WorldDataSource dataSource;
	private CacheControl cacheControl;

	public WebApi()
	{
		dataSource = new WorldDataCache(new BingWorldDataSource(), new CurrentDateFactory(), 60);

		cacheControl = CacheControl.maxAge(60, TimeUnit.SECONDS).noTransform().mustRevalidate();
	}

	@RequestMapping(value = "/world/{countryId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<CountryResponse> getCountry(@PathVariable(value = "countryId") String countryId)
	{
		try
		{
			World world = dataSource.getWorld();

			if (!world.getCountries().containsKey(countryId))
				return ResponseEntity.notFound().build();

			Country country = world.getCountries().get(countryId);

			return ResponseEntity.ok().cacheControl(cacheControl).body(new CountryResponse(country));
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@RequestMapping(value = "/world", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<WorldResponse> getWorld()
	{
		try
		{
			World world = dataSource.getWorld();

			return ResponseEntity.ok().cacheControl(cacheControl).body(new WorldResponse(world));
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
