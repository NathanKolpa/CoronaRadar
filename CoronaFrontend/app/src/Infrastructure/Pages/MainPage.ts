export interface IFilter {
	includeConfirmedCases: boolean;
	includeDeaths: boolean;
}

export class MainPage {

	private _fillerCallback: (IFilter) => void | undefined;
	private _confirmedCases: HTMLInputElement;
	private _deaths: HTMLInputElement;

	constructor() {

	}

	public load(): void {
		this._confirmedCases = document.getElementById("confirmdCases") as HTMLInputElement;
		this._deaths = document.getElementById("confirmdDeath") as HTMLInputElement;

		this._confirmedCases.addEventListener('change', (ev => {
			this.fireEvent()
		}));

		this._deaths.addEventListener('change', (ev => {
			this.fireEvent()
		}));

		this.fireEvent();
	}

	public onFilterChange(callback: (IFilter) => void): void {
		this._fillerCallback = callback;
	}

	private fireEvent(): void {
		if(this._fillerCallback) {
			this._fillerCallback({
				includeConfirmedCases: (this._confirmedCases as any).checked,
				includeDeaths: (this._deaths as any).checked
			})
		}
	}
}