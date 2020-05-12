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
import CircleStyle from "ol/style/Circle";
import Fill from "ol/style/Fill";
import Overlay from 'ol/Overlay';
import {toStringHDMS} from 'ol/coordinate';
import {toLonLat} from 'ol/proj';


export class OpenlayersMap implements IMap {
	private readonly _map: Map;
	private readonly _popupContent : HTMLElement;
	private readonly _popupTitle : HTMLElement;
	private readonly _vectorSource: VectorSource;

	constructor(target: string) {

		this._vectorSource = new VectorSource();

		let container = document.getElementById('popup');

		let overlay = new Overlay({
			element: container,
			autoPan: true,
			stopEvent: false,
			autoPanAnimation: {
				duration: 250
			}
		});


		this._map = new Map
		({

			target: target,
			layers: [
				new TileLayer({source: new OSM()}),
				new VectorLayer({
					source: this._vectorSource,
					updateWhileAnimating: true,
					updateWhileInteracting: true,
				}),
			],
			overlays: [overlay],
			view: new View
			({
				center: fromLonLat([6, 52.1326]),
				zoom: 7.5
			})
		});

		this._popupContent = document.getElementById('popup-content');
		this._popupTitle = document.getElementById('popup-title');
		let closer = document.getElementById('popup-closer');

		closer.onclick = function () {
			overlay.setPosition(undefined);
			closer.blur();
			return false;
		};

		this._map.on('singleclick', (evt) => {
			let feature = this._map.forEachFeatureAtPixel(evt.pixel, (feature => {
				return feature;
			}));

			if (feature) {
				overlay.setPosition((feature.getGeometry() as any).getCoordinates());

				let waypoint = feature.getProperties() as Waypoint;
				this._popupContent.innerHTML = waypoint.description;
				this._popupTitle.innerText = waypoint.descriptionName;
			}
		});
	}

	addWaypoint(point: Waypoint) {
		let iconFeature = new Feature
		({
			geometry: new Point(fromLonLat([point.cordX, point.cordY]))
		});

		iconFeature.setStyle((feature, resolution) => {
			return new Style({
				image: new CircleStyle({
					radius: point.radius / resolution,
					fill: new Fill({color: point.color}),
				}),
			})
		});

		iconFeature.setProperties(point);

		this._vectorSource.addFeature(iconFeature);
	}

	clearWaypoints() {
		this._vectorSource.clear();
	}
}