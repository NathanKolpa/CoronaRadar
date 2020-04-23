import {IMap} from "../Map/IMap";
import OSM from "ol/source/OSM";
import {Tile as TileLayer, Vector as VectorLayer} from "ol/layer";
import Point from "ol/geom/Point";
import Feature from 'ol/Feature';
import Map from 'ol/Map';
import Overlay from 'ol/Overlay'
import View from 'ol/View';
import VectorSource from 'ol/source/Vector';
import {Icon, Style} from 'ol/style';
import "../Map/Waypoint";
import {Waypoint} from "../Map/Waypoint";


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
                new VectorLayer({source: this._vectorSource})
            ],
            view: new View
            ({
                center: [0, 0],
                zoom: 0
            })
        });
        var element = document.getElementById('popup');

        var popup = new Overlay
        ({
            element: element,
            //positioning: 'bottom-center',
            stopEvent: false,
            offset: [0, -50]
        });

        this._map.addOverlay(popup);

        // display popup on click
        this._map.on('click', function (evt) {
            var feature = this._map.forEachFeatureAtPixel(evt.pixel,
                function (feature) {
                    return feature;
                });
            if (feature) {
                var coordinates = feature.getGeometry().getCoordinates();
                popup.setPosition(coordinates);
                $(element).popover({
                    placement: 'top',
                    html: true,
                    content: feature.get('name')
                });
                $(element).popover('show');
            } else {
                $(element).popover('destroy');
            }
        });
    }

    addWaypoint(point: import("../Map/Waypoint").Waypoint)
    {
        throw new Error("Method not implemented.");

        var iconFeature = new Feature
        ({
            geometry: new Point([point.cordX, point.cordY]),

            name: point.descriptionName + " Number of Deaths: " + point.waypointDeath + " Number of infected: " + point.waypointInfected,
        });

        var iconStyle = new Style
        ({
            image: new Icon
            ({
                anchor: [0.5, 46],
                //anchorXUnits: 'fraction',
                //anchorYUnits: 'pixels',
                src: 'Icons.hazard.png'
            })
        });

        iconFeature.setStyle(iconStyle);

        this._vectorSource.addFeature(iconFeature);
    }

}