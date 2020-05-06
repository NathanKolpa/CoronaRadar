export class Waypoint {
	constructor(private _descriptionName: string, private _cordX: number, private _cordY: number, private _radius: number) {
	}

//===========================================================================================================
	//set-get descriptionName
	public set descriptionName(descriptionName: string) {
		this._descriptionName = descriptionName;
	}

	public get descriptionName(): string {
		return this._descriptionName;
	}

	//set-get cordX
	public set cordX(cordX: number) {
		this._cordX = cordX;
	}

	public get cordX(): number {
		return this._cordX;
	}

	//set-get cordY
	public set cordY(cordY: number) {
		this._cordY = cordY;
	}

	public get cordY(): number {
		return this._cordY;
	}

	public get radius(): number {
		return this._radius;
	}
}

