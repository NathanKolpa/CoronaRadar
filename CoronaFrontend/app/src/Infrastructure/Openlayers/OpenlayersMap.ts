import OSM from "ol/source/OSM";
import {Tile as TileLayer, Vector as VectorLayer} from "ol/layer";
import Point from "ol/geom/Point";
import Feature from 'ol/Feature';
import Map from 'ol/Map';
import View from 'ol/View';
import VectorSource from 'ol/source/Vector';
import {fromLonLat} from "ol/proj";
import {Waypoint} from "~src/Core/Map/Waypoint";
import {IMap} from "~src/Core/Map/IMap";
import {Stroke, Style} from "ol/style";
import {Circle} from "ol/geom";
import CircleStyle from "ol/style/Circle";
import Fill from "ol/style/Fill";


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

        iconFeature.setStyle(new Style({
            image: new CircleStyle({
                radius: point.radius,
                fill: new Fill({color: 'red'}),
                stroke: new Stroke({
                    color: [255,0,0], width: 2
                })
            })
        }));

        this._vectorSource.addFeature(iconFeature);
    }

}