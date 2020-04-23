import 'bootstrap/dist/css/bootstrap.min.css'
import '@fortawesome/fontawesome-free/css/all.css'
import 'ol/ol.css';
import {IMap} from "./Map/IMap";
import {OpenlayersMap} from "./Openlayers/OpenlayersMap";

const map: IMap = new OpenlayersMap('map');