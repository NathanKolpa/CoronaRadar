package webapi;

import business.model.Country;
import business.model.World;
import business.worlddata.WorldDataCache;
import business.worlddata.WorldDataSource;
import infrastructure.BingWorldDataSource;
import infrastructure.CurrentDateFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import webapi.reponse.CountryResponse;
import webapi.reponse.WorldResponse;

@SpringBootApplication
@RestController
public class WebApi
{
	private WorldDataSource dataSource;

	public WebApi()
	{
		dataSource = new WorldDataCache(new BingWorldDataSource(), new CurrentDateFactory(), 60);
	}

	@RequestMapping(value = "/world/netherlands", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<CountryResponse> getNetherlands()
	{
		try
		{
			World world = dataSource.getWorld();
			Country netherlands = world.getNetherlands();

			return ResponseEntity.ok().body(new CountryResponse(netherlands));
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

			return ResponseEntity.ok().body(new WorldResponse(world));
		}
		catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
