export class Waypoint {
	constructor(private _descriptionName: string, private _description: string, private _cordX: number, private _cordY: number, private _radius: number, private _color: string) {
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

	//set-get radius circle
	public set radius(radius:number){
		this._radius = radius;
	}

	public get radius(): number {
		return this._radius;
	}

	public get description(): string {
		return this._description;
	}

	public get color(): string {
		return this._color;
	}
}

