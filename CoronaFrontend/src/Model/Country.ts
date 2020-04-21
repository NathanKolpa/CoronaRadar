
import { Province } from "./Province"
export class Country
{
    private provinceList : Map<string, Province> = new Map();

    public constructor(private _name: string)
    {
       
    }

    public set name(name : string)
    {
        this._name = name;
    }

    public get name() : string
    {
        return this._name;
    }

    public get province() : Map<string, Province>
    {
        return this.provinceList;
    }
}