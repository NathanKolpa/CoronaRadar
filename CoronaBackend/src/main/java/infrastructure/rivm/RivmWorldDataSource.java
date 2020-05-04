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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		World world = new World();
		Country netherlands = new Country("Nederland");

		world.getCountries().put("netherlands", netherlands);

		netherlands.getProvinces().put("gelderland", new Province("Gelderland", null, null));
		netherlands.getProvinces().put("drenthe", new Province("Drenthe", null, null));
		netherlands.getProvinces().put("flevoland", new Province("Flevoland", null, null));
		netherlands.getProvinces().put("fiesland", new Province("Fiesland", null, null));
		netherlands.getProvinces().put("groningen", new Province("Groningen", null, null));
		netherlands.getProvinces().put("limburg", new Province("Limburg", null, null));
		netherlands.getProvinces().put("noord-brabant", new Province("Noord-Brabant", null, null));
		netherlands.getProvinces().put("overijssel", new Province("Overijssel", null, null));
		netherlands.getProvinces().put("zeeland", new Province("Zeeland", null, null));
		netherlands.getProvinces().put("noordholland", new Province("Noord-Holland", null, null));
		netherlands.getProvinces().put("utrecht", new Province("Utrecht", null, null));
		netherlands.getProvinces().put("zuidholland", new Province("Zuidholland", null, null));

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
		}


		scanner.close();

		return world;
	}

}
