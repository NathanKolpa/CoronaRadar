import {IMap} from "../Map/IMap";
import {Map, View} from "ol";
import TileLayer from "ol/layer/Tile";
import OSM from "ol/source/OSM";

export class OpenlayersMap implements IMap {

    private _map;

    constructor(target: string) {
        this._map = new Map({
            target: target,
            layers: [
                new TileLayer({source: new OSM()})
            ],

            view: new View(
                {
                    center: [0, 0],
                    zoom: 0
                })
        });
    }

}