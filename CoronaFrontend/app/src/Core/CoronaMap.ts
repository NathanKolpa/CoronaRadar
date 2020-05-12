import {IMap} from "./Map/IMap";
import {IWorldGetter} from "./Model/IWorldGetter";
import {Waypoint} from "./Map/Waypoint";
import {World} from "~src/Core/Model/World";

export class CoronaMap {

	constructor(private _map: IMap, private _world: World) {
	}

	public updateFilter(includeDeaths: boolean, includeInfected: boolean): void {

		this._world.countries.forEach(((country) => {
			country.provinces.forEach((province) => {
				province.dontCountInfected = !includeInfected;
				province.dontCountDeaths = !includeDeaths;
			});
		}));

		this.update();
	}

	public update(): void {

		this._map.clearWaypoints();

		this._world.countries.forEach(((country, countryId) => {
			country.provinces.forEach((province, provinceId) => {

				province.councils.forEach((council, councilId) => {

					this._map.addWaypoint(new Waypoint(council.name, council.getHtml(), council.location.lat, council.location.lon, council.radius, 'blue'));
				});

				this._map.addWaypoint(new Waypoint(province.name, province.getHtml(), province.location.lat, province.location.lon, province.radius, 'red'));
			});
		}));
	}
}