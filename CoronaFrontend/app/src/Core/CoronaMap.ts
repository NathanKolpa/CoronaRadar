import {IMap} from "./Map/IMap";
import {IWorldGetter} from "./Model/IWorldGetter";
import {Waypoint} from "./Map/Waypoint";
import {World} from "~src/Core/Model/World";

export class CoronaMap {

	private _world: World | undefined;

	constructor(private _map: IMap, private _worldGetter: IWorldGetter) {
	}

	public async load(): Promise<void> {
		this._world = await this._worldGetter.getWorld();
		this.update()
	}

	public updateFilter(includeDeaths: boolean, includeInfected: boolean): void {
		if(!this._world)
			return;

		this._world.countries.forEach(((country) => {
			country.provinces.forEach((province) => {
				province.dontCountInfected = !includeInfected;
				province.dontCountDeaths = !includeDeaths;
			});
		}));

		this.update();
	}

	private update(): void {

		this._map.clearWaypoints();

		this._world.countries.forEach(((country, countryId) => {
			country.provinces.forEach((province, provinceId) => {
				this._map.addWaypoint(new Waypoint(province.name, province.location.lat, province.location.lon, province.radius));
			});
		}));
	}
}