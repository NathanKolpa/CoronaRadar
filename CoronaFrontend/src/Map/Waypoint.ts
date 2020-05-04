import 'ol/ol.css';
import Feature from 'ol/Feature';
import Map from 'ol/Map';
import Overlay from 'ol/Overlay'
import View from 'ol/View';
import Point from 'ol/geom/Point';
import {Tile as TileLayer, Vector as VectorLayer} from 'ol/layer';
import TileJSON from 'ol/source/TileJSON';
import VectorSource from 'ol/source/Vector';
import {Icon, Style} from 'ol/style';

export class Waypoint
{
    constructor(private _descriptionName : string, private _waypointInfected: number, private _waypointDeath: number, private _cordX: number,private _cordY: number)
    {
    }


//===========================================================================================================
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

