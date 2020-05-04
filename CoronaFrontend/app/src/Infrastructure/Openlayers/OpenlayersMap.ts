import {IMap} from "~Core/Map/IMap";
import OSM from "ol/source/OSM";
import {Tile as TileLayer, Vector as VectorLayer} from "ol/layer";
import Point from "ol/geom/Point";
import Feature from 'ol/Feature';
import Map from 'ol/Map';
import View from 'ol/View';
import VectorSource from 'ol/source/Vector';
import {fromLonLat} from "ol/proj";
import {Waypoint} from "~Core/Map/Waypoint";


export class OpenlayersMap implements IMap {
    private readonly _map: Map;
    private readonly _vectorSource: VectorSource;

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

    addWaypoint(point: Waypoint)
    {
        let iconFeature = new Feature
        ({
            geometry:  new Point(fromLonLat([point.cordX, point.cordY]))
        });

        this._vectorSource.addFeature(iconFeature);
    }

}