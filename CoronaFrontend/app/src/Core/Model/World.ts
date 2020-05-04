import { Country } from "./Country";

export class World
{
    private _countries : Map<string, Country> = new Map();

    public get countries() : Map<string, Country>
    {
        return this._countries;
    }
}

