export class Location {

	constructor(private _lat: number, private _lon: number) {
	}

	public get lat(): number {
		return this._lat;
	}

	public get lon(): number {
		return this._lon;
	}
}