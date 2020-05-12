import {CovidStat} from "./CovidStat";
import {Location} from "~src/Core/Model/Location";
import {MapDataPoint} from "~src/Core/Model/MapDataPoint";

export class Council extends MapDataPoint {
	public constructor(private _name: string, location: Location, infected: CovidStat | null, death: CovidStat | null) {
	    super(location, infected, death);
	}

	public get name(): string {
		return this._name;
	}
}