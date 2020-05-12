package infrastructure.rivm;

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
import java.util.Date;
import java.util.Scanner;

public class RivmWorldDataSource implements WorldDataSource
{
	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	private final DataOrigin dataOrigin = new DataOrigin("www.rivm.nl");

	@Override
	public World getWorld() throws Exception
	{
		return parseCsv(getResponse());
	}

	private String getResponse() throws IOException
	{
		HttpGet req = new HttpGet("https://www.rivm.nl/sites/default/files/2020-04/COVID-19_aantallen_gemeente_datum_1.csv");

		try (CloseableHttpResponse response = httpClient.execute(req))
		{
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		}
	}

	private World parseCsv(String csv) throws ParseException
	{
		ProvinceMapper mapper = new ProvinceMapper();
		CouncilLocationMapper locationMapper = new CouncilLocationMapper();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		World world = new World();
		Country netherlands = new Country("Nederland");

		world.getCountries().put("netherlands", netherlands);

		netherlands.getProvinces().put("gelderland", new Province("Gelderland", null, null, new Location(5.8987296, 51.9851034)));
		netherlands.getProvinces().put("drenthe", new Province("Drenthe", null, null, new Location(6.6230586, 52.9476012)));
		netherlands.getProvinces().put("flevoland", new Province("Flevoland", null, null, new Location(5.4235397, 52.4484375)));
		netherlands.getProvinces().put("fiesland", new Province("Fiesland", null, null, new Location(5.7817542, 53.1641642)));
		netherlands.getProvinces().put("groningen", new Province("Groningen", null, null, new Location(6.5665018, 53.2193835)));
		netherlands.getProvinces().put("limburg", new Province("Limburg", null, null, new Location(6.0608726,51.4427238)));
		netherlands.getProvinces().put("noord-brabant", new Province("Noord-Brabant", null, null, new Location( 5.2321687, 51.4826537)));
		netherlands.getProvinces().put("overijssel", new Province("Overijssel", null, null, new Location( 6.897314, 52.4076329)));
		netherlands.getProvinces().put("zeeland", new Province("Zeeland", null, null, new Location( 3.8496815, 51.4940309)));
		netherlands.getProvinces().put("noordholland", new Province("Noord-Holland", null, null, new Location(4.788474, 52.5205869)));
		netherlands.getProvinces().put("utrecht", new Province("Utrecht", null, null, new Location(5.1214201, 52.0907374)));
		netherlands.getProvinces().put("zuidholland", new Province("Zuid-Holland", null, null, new Location(4.4937836, 52.0207975)));

		Scanner scanner = new Scanner(csv);
		scanner.nextLine();

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] parts = line.split(";");

			if(parts.length != 9)
			{
				throw new IllegalArgumentException("failed to parse csv");
			}

			if(parts[2].equals(""))
				continue;

			Date date = format.parse(parts[0]);
			Province province = netherlands.getProvinces().get(mapper.getProvinceName(parts[2]));
			int infectedCount = Integer.parseInt(parts[5]);
			int deathCount = Integer.parseInt(parts[8]);

			Council council = new Council(parts[2], new CovidStat(dataOrigin, date, deathCount), new CovidStat(dataOrigin, date, infectedCount), locationMapper.getCouncilLocation(parts[2]));

			if(province.getInfectedCount() == null)
			{
				province.setInfectedCount(new CovidStat(dataOrigin, date, infectedCount));
			}
			else
			{
				province.getInfectedCount().setStatValue(province.getInfectedCount().getStatValue() + infectedCount);
			}


			if(province.getDeathCount() == null)
			{
				province.setDeathCount(new CovidStat(dataOrigin, date, deathCount));
			}
			else
			{
				province.getDeathCount().setStatValue(province.getDeathCount().getStatValue() + deathCount);
			}

			String councilId = parts[2].replaceAll("[^A-Za-z0-9\\[\\]]", "").toLowerCase();

			province.getCouncils().put(councilId, council);
		}

		scanner.close();

		netherlands.getProvinces().put("noord_brabant", netherlands.getProvinces().remove("noord-brabant"));
		netherlands.getProvinces().put("noord_holland", netherlands.getProvinces().remove("noordholland"));
		netherlands.getProvinces().put("zuid_holland", netherlands.getProvinces().remove("zuidholland"));
		netherlands.getProvinces().put("friesland", netherlands.getProvinces().remove("fiesland"));

		return world;
	}

}
