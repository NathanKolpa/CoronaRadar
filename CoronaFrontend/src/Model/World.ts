import { Country } from "./Country";

export class World
{
    private _countries : Array<Country> = new Array<Country>();

    public get countries() : Array<Country>
    {
        return this._countries;
    }
}

