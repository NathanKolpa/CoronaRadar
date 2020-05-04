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