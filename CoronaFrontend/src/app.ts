import 'bootstrap'
import '@fortawesome/fontawesome-free/css/all.css'
import 'ol/ol.css';
import {IMap} from "./Map/IMap";
import {OpenlayersMap} from "./Openlayers/OpenlayersMap";
import {Http} from "./Model/Http";


const map: IMap = new OpenlayersMap('map');