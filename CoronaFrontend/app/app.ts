import 'bootstrap/dist/css/bootstrap.min.css'
import '@fortawesome/fontawesome-free/css/all.css'
import 'ol/ol.css';

import {IMap} from "~src/Core/Map/IMap";
import {OpenlayersMap} from "~src/Infrastructure/Openlayers/OpenlayersMap";
import {IConfig} from "~src/Core/Config/IConfig";
import {ProcessConfig} from "~src/Infrastructure/Config/ProcessConfig";
import {CoronaMap} from "~src/Core/CoronaMap";
import {ApiWorldGetter} from "~src/Infrastructure/Api/ApiWorldGetter";
import {Http} from "~src/Infrastructure/Api/Http";
import {Charts} from "~src/Infrastructure/Charts/chart"
import {IFilter, MainPage} from "~src/Infrastructure/Pages/MainPage";

const config: IConfig = new ProcessConfig();

const map: IMap = new OpenlayersMap('map');
const httpClient = new Http(config.getApiOrigin());


const apiWorldGetter = new ApiWorldGetter(httpClient);

(async () => {

	const world = await apiWorldGetter.getWorld();
	const page = new MainPage();
	const coronaMap = new CoronaMap(map, apiWorldGetter);

	page.onFilterChange((filter: IFilter) => {
		coronaMap.updateFilter(filter.includeDeaths, filter.includeConfirmedCases);
	});

	await coronaMap.load();

	var chart = new Charts(((document.getElementById("graph") as HTMLCanvasElement).getContext("2d")));
	await chart.setWorld(world);
  
	page.load();
})();
