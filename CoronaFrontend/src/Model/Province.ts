export class Province
{
    public constructor(private _name : string, private _infected: number, private _death: number)
    {

    }

    public set name(name: string)
    {
        this._name = name;
    }

    public get name() : string
    {
        return this._name;
    }

    public set infected(infected: number)
    {
        this._infected = infected;
    }

    public get infected() : number
    {
        return this._infected;
    }

    public set death(death: number)
    {
        this._death = death;
    }

    public get death() : number
    {
        return this._death;
    }
}