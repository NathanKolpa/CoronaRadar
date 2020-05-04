export class Http {

	constructor(private host: string) {
	}

	public async getRequest<T>(url: string): Promise<T> {
		let response = await fetch(this.host + url);
		let jsonFile = await response.json();
		return jsonFile as T;
	}
}
