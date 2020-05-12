import {World} from "~src/Core/Model/World";
import {IWorldGetter} from "~src/Core/Model/IWorldGetter";
import {Http} from "~src/Infrastructure/Api/Http";
import {ICouncil, ICountry, IProvince, IWorld} from "~src/Infrastructure/Api/Responses/ApiResponse";
import {Country} from "~src/Core/Model/Country";
import {CovidStat} from "~src/Core/Model/CovidStat";
import {DataOrigin} from "~src/Core/Model/DataOrigin";
import {Province} from "~src/Core/Model/Province";
import {Location} from "~src/Core/Model/Location";
import {Council} from "~src/Core/Model/Council";

export class ApiWorldGetter implements IWorldGetter {

	constructor(private _httpClient: Http) {
	}

	public async getWorld(): Promise<World> {
		let res = await this._httpClient.getRequest<IWorld>("/world");

		let world: World = new World();

		for (let countryId in res.countries) {
			let resCountry: ICountry = res.countries[countryId];
			let country = new Country(resCountry.name);

			for (let provinceId in resCountry.provinces) {
				let resProvince: IProvince = resCountry.provinces[provinceId];

				let deaths: CovidStat | null = null;
				let infected: CovidStat | null = null;

				if (resProvince.infections) {
					let origin = new DataOrigin(resProvince.infections.data_origin.name);
					infected = new CovidStat(origin, resProvince.infections.last_updated, resProvince.infections.value);
				}

				if (resProvince.deaths) {
					let origin = new DataOrigin(resProvince.deaths.data_origin.name);
					deaths = new CovidStat(origin, resProvince.deaths.last_updated, resProvince.deaths.value);
				}

				let province = new Province(resProvince.name, new Location(resProvince.location.lon, resProvince.location.lat), infected, deaths);

				country.provinces.set(provinceId, province);

				for (let councilId in resProvince.councils) {
					let resCouncil: ICouncil = resProvince.councils[councilId];

					let deaths: CovidStat | null = null;
					let infected: CovidStat | null = null;

					if (resCouncil.infections) {
						let origin = new DataOrigin(resCouncil.infections.data_origin.name);
						infected = new CovidStat(origin, resCouncil.infections.last_updated, resCouncil.infections.value);
					}

					if (resCouncil.deaths) {
						let origin = new DataOrigin(resCouncil.deaths.data_origin.name);
						deaths = new CovidStat(origin, resCouncil.deaths.last_updated, resCouncil.deaths.value);
					}

					province.councils.set(councilId, new Council(resCouncil.name, new Location(resCouncil.location.lon, resCouncil.location.lat), infected, deaths))
				}
			}

			world.countries.set(countryId, country);
		}

		return world;
	}

}