package infrastructure.rivm;

import java.util.HashMap;
import java.util.Map;

public class ProvinceMapper
{
	private Map<String, String> map = new HashMap<String, String>();

	public ProvinceMapper()
	{
		// Drenthe
		map.put("Aa en Hunze", "drenthe");

		// Gelderland
		map.put("Winterswijk", "gelderland");

		//Zuid-Holland
		map.put("Alblasserdam","zuidholland");
		map.put("Albrandswaard","zuidholland");
		map.put("Alphen aan den Rijn","zuidholland");
		map.put("Barendrecht","zuidholland");
		map.put("Bodegraven-Reeuwijk","zuidholland");
		map.put("Brielle","zuidholland");
		map.put("Cappele aan den IJssel","zuidholland");
		map.put("Delft","zuidholland");
		map.put("Den Haag","zuidholland");
		map.put("Dordrecht","zuidholland");
		map.put("Goeree-Overflakkee","zuidholland");
		map.put("Gorinchem","zuidholland");
		map.put("Gouda","zuidholland");
		map.put("Hardinxveld-Giessendam", "zuidholland");
		map.put("Hellevoetsluis","zuidholland");
		map.put("Hendrik-Ido-Ambacht","zuidholland");
		map.put("Hillegom","zuidholland");
		map.put("Hoeksche Waard","zuidholland");
		map.put("Kaag en Braassem","zuidholland");
		map.put("Katwijk","zuidholland");
		map.put("Krimpen aan den IJssel","zuidholland");
		map.put("Krimpenerwaard","zuidholland");
		map.put("Lansingerland","zuidholland");
		map.put("Leiden","zuidholland");
		map.put("Leiderdorp","zuidholland");
		map.put("Leidschendam-Voorburg","zuidholland");
		map.put("Lisse","zuidholland");
		map.put("Maassluis","zuidholland");
		map.put("Midden-Delfland","zuidholland");
		map.put("Molenlanden","zuidholland");
		map.put("Nieuwkoop","zuidholland");
		map.put("Nissewaard","zuidholland");
		map.put("Noordwijk","zuidholland");
		map.put("Oegstgeest","zuidholland");
		map.put("Papendrecht","zuidholland");
		map.put("Pijnacker-Nootdorp","zuidholland");
		map.put("Ridderkerk","zuidholland");
		map.put("Rijswijk","zuidholland");
		map.put("Rotterdam","zuidholland");
		map.put("Schiedam","zuidholland");
		map.put("Sliedrecht","zuidholland");
		map.put("Teylingen","zuidholland");
		map.put("Vlaardingen","zuidholland");
		map.put("Voorschoten","zuidholland");
		map.put("Waddinxveen","zuidholland");
		map.put("Wassenaar","zuidholland");
		map.put("Westland","zuidholland");
		map.put("Westvoorne","zuidholland");
		map.put("Zoetemeer","zuidholland");
		map.put("Zoeterwoude","zuidholland");
		map.put("Zuidplas","zuidholland");
		map.put("Zwijndrecht","zuidholland");
	}

	public String getProvinceName(String councilCode)
	{
		return map.get(councilCode);
	}
}
