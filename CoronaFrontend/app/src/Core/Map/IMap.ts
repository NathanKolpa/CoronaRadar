import 'ol/ol.css';
import {Waypoint} from "./Waypoint";

export interface IMap
{
    addWaypoint(point: Waypoint);
    clearWaypoints();
}

