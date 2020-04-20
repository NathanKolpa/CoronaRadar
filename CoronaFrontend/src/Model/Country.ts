
import { Province } from "./Province"
export class Country
{
    private provinceList : Array<Province> = new Array<Province>();

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

    public addProvince(province : Province) : void
    {
        this.provinceList.push(province);
    }
}