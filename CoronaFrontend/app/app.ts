import 'bootstrap/dist/css/bootstrap.min.css'
import '@fortawesome/fontawesome-free/css/all.css'
import 'ol/ol.css';
import {IMap} from "./src/Core/Map/IMap";
import {OpenlayersMap} from "./src/Infrastructure/Openlayers/OpenlayersMap";
import {Http} from "./src/Infrastructure/Api/Http";
import {Waypoint} from "./src/Core/Map/Waypoint";

const map: IMap = new OpenlayersMap('map');
map.addWaypoint(new Waypoint("Groningen", 1, 1, 6.6, 53.2))
map.addWaypoint(new Waypoint("Friesland", 1, 1, 5.7, 53.2))
map.addWaypoint(new Waypoint("Drenthe", 1, 1, 6.6, 52.9))
map.addWaypoint(new Waypoint("Overijssel", 1, 1, 6.6, 52.4))
map.addWaypoint(new Waypoint("Gelderland", 1, 1, 6.1, 52))
map.addWaypoint(new Waypoint("Flevoland", 1, 1, 5.5, 52.4))
map.addWaypoint(new Waypoint("Noord-Holland", 1, 1, 4.8, 52.6))
map.addWaypoint(new Waypoint("Zuid-Holland", 1, 1, 4.4, 52.1))
map.addWaypoint(new Waypoint("Utrecht", 1, 1, 5.1, 52.1))
map.addWaypoint(new Waypoint("Noord-Brabant", 1, 1, 5.1, 51.7))
map.addWaypoint(new Waypoint("Limburg", 1, 1, 6, 51.3))
map.addWaypoint(new Waypoint("Zeeland", 1, 1, 4, 51.6))
