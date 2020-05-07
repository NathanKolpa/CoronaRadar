import {CovidStat} from "./CovidStat";
import {Location} from "./Location";

export class Province {

    private _dontCountDeaths: boolean = false;
    private _dontCountInfected: boolean = false;

    public constructor(private _name: string, private _location: Location, private _infected: CovidStat | null, private _death: CovidStat | null) {
    }

    public set name(name: string) {
        this._name = name;
    }

    public get name(): string {
        return this._name;
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

    public get radius(): number | null {

        let infected = 0;
        let deaths = 0;

        if (this.infected.statValue != null && !this._dontCountInfected) {
            infected = this.infected.statValue;
        }
        if (this.death.statValue != null && !this._dontCountDeaths) {
            deaths = this.death.statValue;
        }
        return (deaths * 5 + infected);
    }
}