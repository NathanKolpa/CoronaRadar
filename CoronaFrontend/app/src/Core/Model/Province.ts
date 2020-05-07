import {CovidStat} from "./CovidStat";
import {Location} from "./Location";

export class Province {
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

    public get radius(): number | null {

        let infected = 0;
        let deatds = 0;

        if (this.infected.statValue != null) {
            infected = this.infected.statValue;
        }
        if (this.death.statValue != null) {
            deatds = this.death.statValue;
        }
        return (deatds + infected);
    }
}