package infrastructure;

import business.model.*;
import business.worlddata.WorldDataSource;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class BingGithubWorldDataSource implements WorldDataSource
{
	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	private static final DataOrigin origin = new DataOrigin("bing.com");

	@Override
	public World getWorld() throws Exception
	{
		return parseCsv(getResponse());
	}

	public String getResponse() throws IOException
	{
		HttpGet req = new HttpGet("https://raw.githubusercontent.com/microsoft/Bing-COVID-19-Data/master/data/Bing-COVID19-Data.csv");

		try (CloseableHttpResponse response = httpClient.execute(req))
		{
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		}
	}

	public World parseCsv(String csv) throws ParseException
	{
		HashMap<String, String> provinceMap = new HashMap<>();
		provinceMap.put("South Holland", "Zuid Holland");
		provinceMap.put("North Holland", "Noord Holland");
		provinceMap.put("North Brabant", "Noord Brabant");

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String[] lines = csv.split("\n");

		World world = new World();

		boolean isFirst = true;

		for (String line : lines)
		{
			if(isFirst)
			{
				isFirst = false;
				continue;
			}

			ArrayList<String> parts = new ArrayList<>(Arrays.asList(line.split(",", -1)));

			if (parts.size() != 15)
			{
				continue;
			}

			String idStr = parts.get(0);
			String updatedStr = parts.get(1);
			String confirmedStr = parts.get(2);
			String confirmedChangeStr = parts.get(3);
			String deathsStr = parts.get(4);
			String deathsChangeStr = parts.get(5);
			String recoveredStr = parts.get(6);
			String recoveredChangeStr = parts.get(7);
			String latStr = parts.get(8);
			String lonStr = parts.get(9);
			String iso2 = parts.get(10);
			String iso3 = parts.get(11);//countryCode
			String countryRegion = parts.get(12);//country
			String adminRegion1 = parts.get(13);//province
			String adminRegion2 = parts.get(14);//council

			String countryId = countryRegion.toLowerCase().replaceAll("\\s+", "_");
			Country country;

			if(countryId.equals("worldwide") || adminRegion1.equals("") || !countryRegion.equals("Netherlands"))
				continue;

			if (!world.getCountries().containsKey(countryId))
			{
				country = new Country(countryRegion);
				world.getCountries().put(countryId, country);
			}
			else
			{
				country = world.getCountries().get(countryId);
			}

			if(adminRegion2.equals(""))
			{
				String preferredName = provinceMap.get(adminRegion1);

				if(preferredName != null)
				{
					adminRegion1 = preferredName;
				}

				String provinceId = adminRegion1.toLowerCase().replaceAll("\\s+", "_");

				CovidStat deaths = null;
				CovidStat infections = null;
				Location location = new Location(Double.parseDouble(latStr), Double.parseDouble(lonStr));
				Date date = format.parse(updatedStr);

				if(!confirmedStr.equals(""))
				{
					infections = new CovidStat(origin, date, Integer.parseInt(confirmedStr));
				}

				if(!deathsStr.equals(""))
				{
					deaths = new CovidStat(origin, date, Integer.parseInt(deathsStr));
				}

				Province province = new Province(adminRegion1, deaths, infections, location);

				if(country.getProvinces().containsKey(provinceId))
				{
					Province otherProvince = country.getProvinces().get(provinceId);

					if(deaths != null)
					{
						if(otherProvince.getDeathCount() == null)
						{
							otherProvince.setDeathCount(deaths);
						}
						else if(otherProvince.getDeathCount().getLastUpdated().before(date))
						{
							otherProvince.setDeathCount(deaths);
						}
					}

					if(infections != null)
					{
						if(otherProvince.getInfectedCount() == null)
						{
							otherProvince.setInfectedCount(infections);
						}
						else if(otherProvince.getInfectedCount().getLastUpdated().before(date))
						{
							otherProvince.setInfectedCount(infections);
						}
					}
				}
				else
				{
					country.getProvinces().put(provinceId, province);
				}
			}
		}

		return world;
	}
}
