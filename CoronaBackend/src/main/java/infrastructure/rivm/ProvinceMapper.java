package infrastructure.rivm;

import java.util.HashMap;
import java.util.Map;

public class ProvinceMapper
{
	private Map<String, String> map = new HashMap<String, String>();

	public ProvinceMapper()
	{
		map.put("Winterswijk", "gelderland");
	}

	public String getProvinceName(String councilCode)
	{
		return map.get(councilCode);
	}
}
