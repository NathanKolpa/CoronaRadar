import {CovidStat} from "./CovidStat";
import {Location} from "./Location";
import {MapDataPoint} from "~src/Core/Model/MapDataPoint";
import {Council} from "~src/Core/Model/Council";

export class Province extends MapDataPoint {

    private _councilList : Map<string, Council> = new Map();


    public constructor(private _name: string, location: Location, infected: CovidStat | null, death: CovidStat | null) {
        super(location, infected, death);
    }

    public set name(name: string) {
        this._name = name;
    }

    public get name(): string {
        return this._name;
    }

    public get councils(): Map<string, Council> {
        return this._councilList;
    }

}