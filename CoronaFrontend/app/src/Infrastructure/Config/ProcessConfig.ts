import {IConfig} from "~src/Core/Config/IConfig";

export class ProcessConfig implements IConfig {
	getApiOrigin(): string {
		// @ts-ignore
		return process.env.API;
	}

}