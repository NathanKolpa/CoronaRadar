import 'ol/ol.css';

export class Waypoint
{
    constructor(private _descriptionName : string, private _waypointInfected: number, private _waypointDeath: number, private _cordX: number,private _cordY: number)
    {


    }

    //set-get descriptionName
    public set descriptionName(descriptionName: string)
    {
        this._descriptionName = descriptionName;
    }

    public get descriptionName() : string
    {
        return this._descriptionName;
    }

    //set-get infected
    public set waypointInfected(waypointInfected: number)
    {
        this._waypointInfected = waypointInfected;
    }

    public get waypointInfected() : number
    {
        return this._waypointInfected;
    }

    //set-get Deaths
    public set waypointDeath(waypointDeath: number)
    {
        this._waypointDeath = waypointDeath;
    }

    public get waypointDeath() : number
    {
        return this._waypointDeath;
    }

    //set-get cordX
    public set cordX(cordX: number)
    {
        this._cordX = cordX;
    }

    public get cordX() : number
    {
        return this._cordX;
    }

    //set-get cordY
    public set cordY(cordY: number)
    {
        this._cordY = cordY;
    }

    public get cordY() : number
    {
        return this._cordY;
    }
}

