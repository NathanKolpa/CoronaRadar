export interface IWorld {
	countries: { [key: string]: ICountry };
}

export interface ICountry {
	provinces: { [key: string]: IProvince };
	name: string;
}

export interface IProvince {
	infections: IStat | null;
	deaths: IStat | null;
	location: ILocation;
	name: string;

	councils: { [key: string]: ICouncil };
}

export interface ICouncil {
	infections: IStat | null;
	deaths: IStat | null;
	location: ILocation;
	name: string;
}

export interface IStat {
	last_updated: Date;
	data_origin: IDataOrigin;
	value: number;
}

export interface IDataOrigin {
	name: string;
}

export interface ILocation {
	lat: number;
	lon: number;
}