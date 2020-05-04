import 'bootstrap/dist/css/bootstrap.min.css'
import '@fortawesome/fontawesome-free/css/all.css'
import 'ol/ol.css';

import {IMap} from "./src/Core/Map/IMap";
import {OpenlayersMap} from "./src/Infrastructure/Openlayers/OpenlayersMap";
import {IConfig} from "./src/Core/Config/IConfig";
import {ProcessConfig} from "./src/Infrastructure/Config/ProcessConfig";
import {CoronaMap} from "./src/Core/CoronaMap";
import {ApiWorldGetter} from "./src/Infrastructure/Api/ApiWorldGetter";
import {Http} from "./src/Infrastructure/Api/Http";

const config: IConfig = new ProcessConfig();

const map: IMap = new OpenlayersMap('map');
const httpClient = new Http(config.getApiOrigin());

const apiWorldGetter = new ApiWorldGetter(httpClient);

(async () => {

	const coronaMap = new CoronaMap(map, apiWorldGetter);

	await coronaMap.load();
})();

