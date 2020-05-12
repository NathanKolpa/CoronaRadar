import { CovidStat } from "./CovidStat";

class Council
{
    public constructor(private _name : string, private _infected: CovidStat | null, private _dead : CovidStat | null)
    {

    }

    public get name() : string
    {
        return this._name;
    }

    public get infected() : CovidStat | null
    {
        return this._infected;
    }

    public get dead() : CovidStat | null
    {
        return this._dead;
    }
}