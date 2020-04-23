import 'bootstrap'
import '@fortawesome/fontawesome-free/css/all.css'
import 'ol/ol.css';
import {IMap} from "./Map/IMap";
import {OpenlayersMap} from "./Openlayers/OpenlayersMap";
import {Http} from "./Model/Http";


const map: IMap = new OpenlayersMap('map');

const http : Http = new Http();
http.getJson("https://opendata.ecdc.europa.eu/covid19/casedistribution/json/");