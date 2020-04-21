import 'bootstrap'
import '@fortawesome/fontawesome-free/css/all.css'
import 'ol/ol.css';

import {Map, View} from 'ol';
import TileLayer from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import {fromLonLat} from 'ol/proj';

const map = new Map({
	target: 'map',
	layers: [
		new TileLayer({
			source: new OSM()
		})
	],
	view: new View({
		center: fromLonLat([5, 52.25]),
		zoom: 7.5
	})
});
