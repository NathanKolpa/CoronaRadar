import {IMap} from "./Map/IMap";
import {IWorldGetter} from "./Model/IWorldGetter";
import {Waypoint} from "./Map/Waypoint";

export class CoronaMap {
	constructor(private _map: IMap, private _worldGetter: IWorldGetter) {
	}

	public async load(): Promise<void> {
		let world = await this._worldGetter.getWorld();

		world.countries.forEach(((country, countryId) => {
			country.provinces.forEach((province, provinceId) => {
				this._map.addWaypoint(new Waypoint(province.name, province.location.lat, province.location.lon, 7));
			});
		}));
	}
}