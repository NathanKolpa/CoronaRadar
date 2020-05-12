import {CovidStat} from "~src/Core/Model/CovidStat";
import {Location} from "~src/Core/Model/Location";

export class MapDataPoint {

	private _dontCountDeaths: boolean = false;
	private _dontCountInfected: boolean = false;

	public constructor(private _location: Location, private _infected: CovidStat | null, private _death: CovidStat | null) {
	}


	public get infected(): CovidStat | null {
		return this._infected;
	}


	public get death(): CovidStat | null {
		return this._death;
	}

	public get location(): Location {
		return this._location;
	}

	public set dontCountInfected(value: boolean) {
		this._dontCountInfected = value;
	}

	public set dontCountDeaths(value: boolean) {
		this._dontCountDeaths = value;
	}

	public get dontCountInfected(): boolean {
		return this._dontCountInfected;
	}

	public get dontCountDeaths(): boolean {
		return this._dontCountDeaths;
	}

	public getHtml(): string {
		let deaths = !this.death ? '<span>Deaths: Unknown</span>' :
			`<span title="source: ${this.death.dataOrigin.name} | last updated ${this.death.lastUpdate}">Deaths: ${this.death.statValue}</span>`;
		let infected = !this.infected ? '<p>Infected: Unknown</p>' :
			`<span title="source: ${this.infected.dataOrigin.name} | last updated ${this.infected.lastUpdate}">Infected: ${this.infected.statValue}</span>`;
		return  deaths + '<br>' + infected;
	}

	public get radius(): number | null {

		let infected = 0;
		let deaths = 0;

		if (this.infected.statValue != null && !this._dontCountInfected) {
			infected = this.infected.statValue;
		}
		if (this.death.statValue != null && !this._dontCountDeaths) {
			deaths = this.death.statValue;
		}
		return (deaths * 5 + infected) + 500;
	}
}