package thirdparty;

import business.WorldDataSource;
import business.model.*;
import com.sun.istack.internal.NotNull;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class BingCountryDataSource implements WorldDataSource
{
	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	private static final DataOrigin origin = new DataOrigin("bing.com");

	@NotNull
	public World getWorld() throws IOException, ParseException
	{
		return parseObjects(getResponse());
	}

	private String getResponse() throws IOException
	{
		HttpGet req = new HttpGet("https://bing.com/covid/data");

		try (CloseableHttpResponse response = httpClient.execute(req))
		{
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		}
	}

	private World parseObjects(String json) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		JSONObject obj = new JSONObject(json);
		JSONArray areas = obj.getJSONArray("areas");

		World world = new World();

		for (int i = 0; i < areas.length(); i++)
		{
			JSONObject jsonCountry = areas.getJSONObject(i);
			JSONArray countryAreas = jsonCountry.getJSONArray("areas");
			Country country = new Country(jsonCountry.getString("displayName"));

			for (int x = 0; x < countryAreas.length(); x++)
			{
				JSONObject jsonProvince = countryAreas.getJSONObject(x);
				Date lastUpdated = format.parse(jsonProvince.getString("lastUpdated"));
				CovidStat deathCount = jsonProvince.isNull("totalDeaths") ? null : new CovidStat(origin, lastUpdated, jsonProvince
						.getInt("totalDeaths"));
				CovidStat infectedCount = jsonProvince.isNull("totalConfirmed") ? null : new CovidStat(origin, lastUpdated, jsonProvince
						.getInt("totalConfirmed"));

				country.getProvinces()
						.add(new Province(jsonProvince.getString("displayName"), deathCount, infectedCount));
			}

			world.getCountries().add(country);
		}

		return world;
	}
}
