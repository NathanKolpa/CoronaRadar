import {DataOrigin} from "./DataOrigin"

export class CovidStat
{
    public constructor(private _dataOrigin : DataOrigin, private _lastUpdated : Date, private _statValue : number)
    {

    }

    public get dataOrigin() : DataOrigin
    {
        return this._dataOrigin;
    }

    public set dataOrigin(dataorigin : DataOrigin)
    {
        this._dataOrigin = dataorigin;
    }

    public get lastUpdate() : Date
    {
        return this._lastUpdated;
    }

    public set lastUpdate(lu : Date)
    {
        this._lastUpdated = lu;
    }

    public get statValue() : number
    {
        return this._statValue;
    }

    public set statValue(counter : number)
    {
        this._statValue = counter;
    }

}