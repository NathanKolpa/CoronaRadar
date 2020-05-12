package infrastructure.rivm;

import business.model.Location;

import java.util.HashMap;
import java.util.Map;

public class CouncilLocationMapper
{
	private Map<String, Location> map = new HashMap<>();

	public CouncilLocationMapper()
	{
		// Drenthe
		map.put("Aa en Hunze", "drenthe");
		map.put("Assen", "drenthe");
		map.put("Borger-Odoorn", "drenthe");
		map.put("Coevorden", "drenthe");
		map.put("Emmen", "drenthe");
		map.put("Hoogeveen", "drenthe");
		map.put("Meppel", "drenthe");
		map.put("Midden-Drenthe", "drenthe");
		map.put("Noordenveld", "drenthe");
		map.put("Tynaarlo", "drenthe");
		map.put("Westerveld", "drenthe");
		map.put("De Wolden", "drenthe");

		//flevoland
		map.put("Almere", "flevoland");
		map.put("Dronten", "flevoland");
		map.put("Lelystad", "flevoland");
		map.put("Noordoostpolder", "flevoland");
		map.put("Urk", "flevoland");
		map.put("Zeewolde", "flevoland");

		//Friesland
		map.put("Achtkarspelen", "fiesland");
		map.put("Ameland", "fiesland");
		map.put("Dantumadiel", "fiesland");
		map.put("De Fryske Marren", "fiesland");
		map.put("Harlingen", "fiesland");
		map.put("Heerenveen", "fiesland");
		map.put("Leeuwarden", "fiesland");
		map.put("Noardeast-FryslÃ¢n", "fiesland");
		map.put("Ooststellingwerf", "fiesland");
		map.put("Opsterland", "fiesland");
		map.put("Schiermonnikoog", "fiesland");
		map.put("Smallingerland", "fiesland");
		map.put("SÃºdwest-FryslÃ¢n", "fiesland");
		map.put("Terschelling", "fiesland");
		map.put("Tytsjerksteradiel", "fiesland");
		map.put("Vlieland", "fiesland");
		map.put("Waadhoeke", "fiesland");
		map.put("Weststellingwerf", "fiesland");

		//flevoland
		map.put("Almere", "flevoland");
		map.put("Dronten", "flevoland");
		map.put("Lelystad", "flevoland");
		map.put("Noordoostpolder", "flevoland");
		map.put("Urk", "flevoland");
		map.put("Zeewolde", "flevoland");

		//Friesland
		map.put("Achtkarspelen", "fiesland");
		map.put("Ameland", "fiesland");
		map.put("Dantumadeel", "fiesland");
		map.put("De friese meren", "fiesland");
		map.put("Harlingen", "fiesland");
		map.put("Heerenveen", "fiesland");
		map.put("Leeuwarden", "fiesland");
		map.put("Noardeast-Fryslând", "fiesland");
		map.put("Ooststellingwerf", "fiesland");
		map.put("Opsterland", "fiesland");
		map.put("Schiermonnikook", "fiesland");
		map.put("Smallingerland", "fiesland");
		map.put("Súdwest-Fryslân", "fiesland");
		map.put("Terschelling", "fiesland");
		map.put("Tietjerksteradeel", "fiesland");
		map.put("Vlieland", "fiesland");
		map.put("Waadhoeke", "fiesland");
		map.put("Weststellingwerf", "fiesland");

		// Gelderland
		map.put("Aalten", new Location(51.925, 6.580833));
		map.put("Apeldoorn", new Location(52.216667, 5.95));
		map.put("Arnhem", new Location(51.983333, 5.916667));
		map.put("Barneveld", new Location(52.133333, 5.583333));
		map.put("Berg en Dal", new Location(51.829167, 5.925833));
		map.put("Berkelland", new Location(52.116667, 6.516667));
		map.put("Beuningen", new Location(51.85, 5.75));
		map.put("Bronckhorst", new Location(52.05, 6.3));
		map.put("Brummen", new Location(52.1, 6.1));
		map.put("Buren", new Location(51.910556, 5.333333));
		map.put("Culemborg", new Location(51.95, 5.233333));
		map.put("Doesburg", new Location(52.016667, 6.133333));
		map.put("Doetinchem", new Location(51.966667, 6.283333));
		map.put("Druten", new Location(51.888889, 5.604444));
		map.put("Duiven", new Location(51.947222, 6.021111));
		map.put("Ede", new Location(52.05, 5.666667));
		map.put("Elburg", new Location(52.45, 5.85));
		map.put("Epe", new Location(52.333333, 5.916667));
		map.put("Ermelo", new Location(52.283333, 5.666667));
		map.put("Harderwijk", new Location(52.35, 5.616667));
		map.put("Hattem", new Location(52.483333, 6.066667));
		map.put("Heerde", new Location(52.4, 6.05));
		map.put("Heumen", new Location(51.765556, 5.843333));
		map.put("Lingewaard", new Location(51.9, 5.9));
		map.put("Lochem", new Location(52.160556, 6.4325));
		map.put("Maasdriel", new Location(51.766667, 5.333333));
		map.put("Montferland", new Location(51.933333, 6.15));
		map.put("Neder-Betuwe", new Location(51.933333, 5.633333));
		map.put("Nijkerk", new Location(52.2, 5.483333));
		map.put("Nijmegen", new Location(51.833333, 5.866667));
		map.put("Nunspeet", new Location(52.333333, 5.783333));
		map.put("Oldebroek", new Location(52.466667, 5.916667));
		map.put("Oost Gelre", new Location(51.983333, 6.583333));
		map.put("Oude IJsselstreek", new Location(51.866667, 6.383333));
		map.put("Overbetuwe", new Location(51.916667, 5.85));
		map.put("Putten", new Location(52.233333, 5.583333));
		map.put("Renkum", new Location(51.986572, 5.791169));
		map.put("Rheden", new Location(52, 6.033333));
		map.put("Rozendaal", new Location(52, 5.966667));
		map.put("Scherpenzeel", new Location(52.066667, 5.483333));
		map.put("Tiel", new Location(51.883333, 5.433333));
		map.put("Voorst", new Location(52.233333, 6.083333));
		map.put("Wageningen", new Location(51.966667, 5.666667));
		map.put("West Betuwe", new Location(51.883333, 5.283333));
		map.put("West Maas en Waal", new Location(51.850278, 5.486389));
		map.put("Westervoort", new Location(51.95, 5.966667));
		map.put("Wijchen", new Location(51.806667, 5.721111));
		map.put("Winterswijk", new Location(51.806667, 5.721111));
		map.put("Zaltbommel", new Location(51.816667, 5.25));
		map.put("Zevenaar", new Location(51.916667, 6.083333));
		map.put("Zutphen", new Location(52.133333, 6.2));

		//Zuid-Holland
		map.put("Alblasserdam","zuidholland");
		map.put("Albrandswaard","zuidholland");
		map.put("Alphen aan den Rijn","zuidholland");
		map.put("Barendrecht","zuidholland");
		map.put("Bodegraven-Reeuwijk","zuidholland");
		map.put("Brielle","zuidholland");
		map.put("Capelle aan den IJssel","zuidholland");
		map.put("Delft","zuidholland");
		map.put("Den Haag","zuidholland");
		map.put("Dordrecht","zuidholland");
		map.put("'s-Gravenhage","zuidholland");
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
		map.put("Zoetermeer","zuidholland");
		map.put("Zoeterwoude","zuidholland");
		map.put("Zuidplas","zuidholland");
		map.put("Zwijndrecht","zuidholland");

		//Groningen
		map.put("Appingedam", "groningen");
		map.put("Delfzijl", "groningen");
		map.put("Groningen", "groningen");
		map.put("Het Hogeland", "groningen");
		map.put("Loppersum", "groningen");
		map.put("Midden-Groningen", "groningen");
		map.put("Oldambt", "groningen");
		map.put("Pekela", "groningen");
		map.put("Stadskanaal", "groningen");
		map.put("Veendam", "groningen");
		map.put("Westerkwartier", "groningen");
		map.put("Westerwolde", "groningen");

		//Limburg
		map.put("Beek", new Location(50.939444, 5.796111));
		map.put("Beekdaelen", new Location(50.942889, 5.886611));
		map.put("Beesel", new Location(51.266944, 6.039167));
		map.put("Bergen (L.)", new Location(51.599167, 6.033611));
		map.put("Brunssum", new Location(50.949167, 5.97));
		map.put("Echt-Susteren", new Location(51.083333, 5.866667));
		map.put("Eijsden-Margraten", new Location(50.791667, 5.756111));
		map.put("Gennep", new Location(51.694167, 5.973333));
		map.put("Gulpen-Wittem", new Location(50.816111, 5.898333));
		map.put("Heerlen", new Location(50.886389, 5.9775));
		map.put("Horst aan de Maas", new Location(51.436944, 6.106111));
		map.put("Kerkrade", new Location(50.864722, 6.060556));
		map.put("Landgraaf", new Location(50.908333, 6.029722));
		map.put("Leudal", new Location(51.250742, 5.896911));
		map.put("Maasgouw", new Location(51.15, 5.883333));
		map.put("Maastricht", new Location(50.849722, 5.693056));
		map.put("Meerssen", new Location(50.885833, 5.751944));
		map.put("Mook en Middelaar", new Location(51.7525, 5.881667));
		map.put("Nederweert", new Location(51.282778, 5.747222));
		map.put("Peel en Maas", new Location(51.34005, 6.010894));
		map.put("Roerdalen", new Location(51.153056, 6.079167));
		map.put("Roermond", new Location(51.2, 5.983333));
		map.put("Simpelveld", new Location(50.835, 5.982222));
		map.put("Sittard-Geleen", new Location(51, 5.85));
		map.put("Stein", new Location(50.967903, 5.765208));
		map.put("Vaals", new Location(50.772778, 6.018056));
		map.put("Valkenburg aan de Geul", new Location(50.864444, 5.830556));
		map.put("Venlo", new Location(51.368611, 6.171111));
		map.put("Venray", new Location(51.525833, 5.974722));
		map.put("Voerendaal", new Location(50.883333, 5.916667));
		map.put("Weert", new Location(51.25375, 5.70465));

		//Noord-Brabant
		map.put("Alphen-Chaam", "noord-brabant");
		map.put("Altena", "noord-brabant");
		map.put("Asten", "noord-brabant");
		map.put("Baarle-Nassau", "noord-brabant");
		map.put("Bergeijk", "noord-brabant");
		map.put("Bergen op Zoom", "noord-brabant");
		map.put("Bernheze", "noord-brabant");
		map.put("Best", "noord-brabant");
		map.put("Bladel", "noord-brabant");
		map.put("Boekel", "noord-brabant");
		map.put("Boxmeer", "noord-brabant");
		map.put("Boxtel", "noord-brabant");
		map.put("Breda", "noord-brabant");
		map.put("Cranendonck", "noord-brabant");
		map.put("Cuijk", "noord-brabant");
		map.put("Deurne", "noord-brabant");
		map.put("Dongen", "noord-brabant");
		map.put("Drimmelen", "noord-brabant");
		map.put("Eersel", "noord-brabant");
		map.put("Eindhoven", "noord-brabant");
		map.put("Etten-Leur", "noord-brabant");
		map.put("Geertruidenberg", "noord-brabant");
		map.put("Geldrop-Mierlo", "noord-brabant");
		map.put("Gemert-Bakel", "noord-brabant");
		map.put("Gilze en Rijen", "noord-brabant");
		map.put("Goirle", "noord-brabant");
		map.put("Grave", "noord-brabant");
		map.put("Haaren", "noord-brabant");
		map.put("Halderberge", "noord-brabant");
		map.put("Heeze-Leende", "noord-brabant");
		map.put("Helmond", "noord-brabant");
		map.put("'s-Hertogenbosch", "noord-brabant");
		map.put("Heusden", "noord-brabant");
		map.put("Hilvarenbeek", "noord-brabant");
		map.put("Laarbeek", "noord-brabant");
		map.put("Landerd", "noord-brabant");
		map.put("Loon op Zand", "noord-brabant");
		map.put("Meierijstad", "noord-brabant");
		map.put("Mill en Sint Hubert", "noord-brabant");
		map.put("Moerdijk", "noord-brabant");
		map.put("Nuenen c.a.", "noord-brabant");
		map.put("Oirschot", "noord-brabant");
		map.put("Oisterwijk", "noord-brabant");
		map.put("Oosterhout", "noord-brabant");
		map.put("Oss", "noord-brabant");
		map.put("Reusel-De Mierden", "noord-brabant");
		map.put("Roosendaal", "noord-brabant");
		map.put("Rucphen", "noord-brabant");
		map.put("Sint Anthonis", "noord-brabant");
		map.put("Sint-Michielsgestel", "noord-brabant");
		map.put("Someren", "noord-brabant");
		map.put("Son en Breugel", "noord-brabant");
		map.put("Steenbergen", "noord-brabant");
		map.put("Tilburg", "noord-brabant");
		map.put("Uden", "noord-brabant");
		map.put("Valkenswaard", "noord-brabant");
		map.put("Veldhoven", "noord-brabant");
		map.put("Vught", "noord-brabant");
		map.put("Waalre", "noord-brabant");
		map.put("Waalwijk", "noord-brabant");
		map.put("Woensdrecht", "noord-brabant");
		map.put("Zundert", "noord-brabant");
		map.put("Nuenen, Gerwen en Nederwetten", "noord-brabant");

		//overijssel
		map.put("Almelo", "overijssel");
		map.put("Borne", "overijssel");
		map.put("Dalfsen", "overijssel");
		map.put("Deventer", "overijssel");
		map.put("Dinkelland", "overijssel");
		map.put("Enschede", "overijssel");
		map.put("Haaksbergen", "overijssel");
		map.put("Hardenberg", "overijssel");
		map.put("Hellendoorn", "overijssel");
		map.put("Hengelo", "overijssel");
		map.put("Hof van Twente", "overijssel");
		map.put("Kampen", "overijssel");
		map.put("Losser", "overijssel");
		map.put("Oldenzaal", "overijssel");
		map.put("Olst-Wijhe", "overijssel");
		map.put("Ommen", "overijssel");
		map.put("Raalte", "overijssel");
		map.put("Rijssen-Holten", "overijssel");
		map.put("Staphorst", "overijssel");
		map.put("Steenwijkerland", "overijssel");
		map.put("Tubbergen", "overijssel");
		map.put("Twenterand", "overijssel");
		map.put("Wierden", "overijssel");
		map.put("Zwartewaterland", "overijssel");
		map.put("Zwolle", "overijssel");

		//Zeeland
		map.put("Borsele", new Location(51.426111, 3.821667));
		map.put("Goes", new Location(51.514722, 3.825833));
		map.put("Hulst", new Location(51.315833, 4.053889));
		map.put("Kapelle", new Location(51.5, 3.95));
		map.put("Middelburg", new Location(51.5, 3.616667));
		map.put("Noord-Beveland", new Location(51.575278, 3.770833));
		map.put("Reimerswaal", new Location(51.433333, 4.116667));
		map.put("Schouwen-Duiveland", new Location(51.665278, 3.884167));
		map.put("Sluis", new Location(51.328889, 3.501667));
		map.put("Terneuzen", new Location(51.293056, 3.834444));
		map.put("Tholen", new Location(51.584722, 4.121111));
		map.put("Veere", new Location(51.546944, 3.540278));
		map.put("Vlissingen", new Location(51.45, 3.583333));


		// Noord-Holland
		map.put("Aalsmeer", "noordholland");
		map.put("Alkmaar", "noordholland");
		map.put("Amstelveen", "noordholland");
		map.put("Amsterdam", "noordholland");
		map.put("Beemster", "noordholland");
		map.put("Bergen (NH.)", "noordholland");
		map.put("Beverwijk", "noordholland");
		map.put("Blaricum", "noordholland");
		map.put("Bloemendaal", "noordholland");
		map.put("Castricum", "noordholland");
		map.put("Den Helder", "noordholland");
		map.put("Diemen", "noordholland");
		map.put("Drechterland", "noordholland");
		map.put("Edam-Volendam", "noordholland");
		map.put("Enkhuizen", "noordholland");
		map.put("Gooise Meren", "noordholland");
		map.put("Haarlem", "noordholland");
		map.put("Haarlemmermeer", "noordholland");
		map.put("Heemskerk", "noordholland");
		map.put("Heemstede", "noordholland");
		map.put("Heerhugowaard", "noordholland");
		map.put("Heiloo", "noordholland");
		map.put("Hilversum", "noordholland");
		map.put("Hollands Kroon", "noordholland");
		map.put("Hoorn", "noordholland");
		map.put("Huizen", "noordholland");
		map.put("Koggenland", "noordholland");
		map.put("Landsmeer", "noordholland");
		map.put("Langedijk", "noordholland");
		map.put("Laren", "noordholland");
		map.put("Medemblik", "noordholland");
		map.put("Oostzaan", "noordholland");
		map.put("Opmeer", "noordholland");
		map.put("Ouder-Amstel", "noordholland");
		map.put("Purmerend", "noordholland");
		map.put("Schagen", "noordholland");
		map.put("Stede Broec", "noordholland");
		map.put("Texel", "noordholland");
		map.put("Uitgeest", "noordholland");
		map.put("Uithoorn", "noordholland");
		map.put("Velsen", "noordholland");
		map.put("Waterland", "noordholland");
		map.put("Weesp", "noordholland");
		map.put("Wijdemeren", "noordholland");
		map.put("Wormerland", "noordholland");
		map.put("Zaanstad", "noordholland");
		map.put("Zandvoort", "noordholland");
		
		// Utrecht
		map.put("Amersfoort", "utrecht");
		map.put("Baarn", "utrecht");
		map.put("De Bilt", "utrecht");
		map.put("Bunnik", "utrecht");
		map.put("Bunschoten", "utrecht");
		map.put("Eemnes", "utrecht");
		map.put("Houten", "utrecht");
		map.put("IJsselstein", "utrecht");
		map.put("Leusden", "utrecht");
		map.put("Lopik", "utrecht");
		map.put("Montfoort", "utrecht");
		map.put("Nieuwegein", "utrecht");
		map.put("Oudewater", "utrecht");
		map.put("Renswoude", "utrecht");
		map.put("Rhenen", "utrecht");
		map.put("De Ronde Venen", "utrecht");
		map.put("Soest", "utrecht");
		map.put("Stichtse Vecht", "utrecht");
		map.put("Utrecht", "utrecht");
		map.put("Utrechtse Heuvelrug", "utrecht");
		map.put("Veenendaal", "utrecht");
		map.put("Vijfheerenlanden", "utrecht");
		map.put("Wijk bij Duurstede", "utrecht");
		map.put("Woerden", "utrecht");
		map.put("Woudenberg", "utrecht");
		map.put("Zeist", "utrecht");
	}

	public Location getCouncilLocation(String councilCode)
	{
		return map.get(councilCode);
	}
}
