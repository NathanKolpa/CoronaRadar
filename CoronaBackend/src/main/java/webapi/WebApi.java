package webapi;

import business.model.Country;
import business.model.World;
import business.worlddata.WorldDataCache;
import business.worlddata.WorldDataMerger;
import business.worlddata.WorldDataSource;
import infrastructure.BingGithubWorldDataSource;
import infrastructure.BingWorldDataSource;
import infrastructure.CurrentDateFactory;
import infrastructure.rivm.RivmWorldDataSource;
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
@CrossOrigin(origins = "*")
public class WebApi
{
	private WorldDataSource dataSource;
	private CacheControl cacheControl;

	public WebApi()
	{
		WorldDataMerger merger = new WorldDataMerger();
		merger.getSources().add(new BingGithubWorldDataSource());
		merger.getSources().add(new RivmWorldDataSource());
		dataSource = new WorldDataCache(merger, new CurrentDateFactory(), 60);

		cacheControl = CacheControl.maxAge(60, TimeUnit.SECONDS).noTransform().cachePublic();
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
			e.printStackTrace();
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
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
