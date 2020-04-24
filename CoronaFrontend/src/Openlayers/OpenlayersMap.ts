import {IMap} from "../Map/IMap";
import OSM from "ol/source/OSM";
import {Tile as TileLayer, Vector as VectorLayer} from "ol/layer";
import TileJSON from 'ol/source/TileJSON';
import Point from "ol/geom/Point";
import Feature from 'ol/Feature';
import Map from 'ol/Map';
import Overlay from 'ol/Overlay'
import View from 'ol/View';
import VectorSource from 'ol/source/Vector';
import {Icon, Style} from 'ol/style';
import "../Map/Waypoint";
import {Waypoint} from "../Map/Waypoint";
import {fromLonLat} from "ol/proj";


export class OpenlayersMap implements IMap {
    private _map;
    private _vectorSource: VectorSource;


    constructor(target: string) {

        this._vectorSource = new VectorSource();

        this._map = new Map
        ({
            target: target,
            layers: [

                new TileLayer({source: new OSM()}),

                new VectorLayer({source: this._vectorSource}),
            ],
            view: new View
            ({
                center: [0, 0],
                zoom: 0
            })
        });

    }

    addWaypoint(point: import("../Map/Waypoint").Waypoint)
    {
        let iconFeature = new Feature
        ({
            geometry:  new Point(fromLonLat([point.cordX, point.cordY]))
        });

        this._vectorSource.addFeature(iconFeature);
    }

}