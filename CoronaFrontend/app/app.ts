import 'bootstrap/dist/css/bootstrap.min.css'
import '@fortawesome/fontawesome-free/css/all.css'
import 'ol/ol.css';

import {IMap} from "./src/Core/Map/IMap";
import {OpenlayersMap} from "./src/Infrastructure/Openlayers/OpenlayersMap";

const map: IMap = new OpenlayersMap('map');

